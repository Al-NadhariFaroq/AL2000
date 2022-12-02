package fc;

import db.dao.DAOFactory;
import db.pojo.SubscribeCardPOJO;
import db.pojo.SubscriberPOJO;
import fc.movie.Movie;
import fc.support.BluRay;
import fc.user.Client;
import fc.user.Subscriber;
import fc.user.Technician;
import fc.user.User;
import fc.user.UserType;

import java.sql.Date;
import java.util.Calendar;

public class AL2000FC {
    private final MachineFacade machineFacade;
    private final Themes themes;
    private final Movies movies;
    private final BluRays bluRays;
    private UserType userType;
    private User user;

    public AL2000FC() {
        machineFacade = MachineFacade.getInstance();
        themes = new Themes();
        movies = new Movies();
        bluRays = new BluRays();
        userType = UserType.NONE;
        user = null;
    }

    public void rentBluRay(Movie movie) {
        // maj BD : rentals + bluRays
        BluRay bluRay = bluRays.getBluRayFromMovie(movie);
        bluRays.rentBluRay(bluRay);
        machineFacade.extractDiscFromPosition(bluRays.getPosition(bluRay));
        machineFacade.ejectDisc();
    }

    public void rechargeSubscriptionCard(int amount) {
        assert (user.getClass() == Subscriber.class);
        Subscriber subscriber = (Subscriber) user;
        if (machineFacade.isValidPayment(subscriber.getCreditCardNumber(), amount)) {
            subscriber.credit(amount);
        } else {
            throw new RuntimeException("Impossible payment!");
        }
    }

    public void rechargeSubSubscriptionCard(Subscriber subscriber, int amount) {
        if (machineFacade.isValidPayment(subscriber.getCreditCardNumber(), amount)) {
            subscriber.credit(amount);
        } else {
            throw new RuntimeException("Impossible payment!");
        }
    }

    public void connection() {
        int creditCardNumber = MachineFacade.getInstance().readCreditCard();
        int subscriptionCardNumber = MachineFacade.getInstance().readSubscriptionCard();

        if (subscriptionCardNumber == 0) {
            user = new Technician();
        } else if (subscriptionCardNumber > 0) {
            user = new Subscriber(subscriptionCardNumber);
        } else if (creditCardNumber >= 0) {
            user = new Client(creditCardNumber);
        }
    }

    public void close() {
        user = null;
    }

    public void subscription(String email, String firstName, String lastName, Calendar birthDate) {
        SubscribeCardPOJO subscribeCardPOJO = new SubscribeCardPOJO();
        subscribeCardPOJO.setSubscriberCardId(0);
        subscribeCardPOJO.setSubscriber(true);
        subscribeCardPOJO.setCardholderFirstName(firstName);
        subscribeCardPOJO.setCardholderLastName(lastName);
        subscribeCardPOJO.setBirthDate(new Date(birthDate.getTimeInMillis()));
        subscribeCardPOJO.setCardBalance(0);
        DAOFactory.getSubscribeCardDAO().create(subscribeCardPOJO);

        SubscriberPOJO subscriberPOJO = new SubscriberPOJO();
        subscriberPOJO.setSubscriberId(666);
        subscriberPOJO.setEmail(email);
        subscriberPOJO.setCardNumber(0);
        DAOFactory.getSubscriberDAO().create(subscriberPOJO);
    }

    @Override
    public String toString() {
        if (userType == UserType.NONE || user == null) {
            return "no one connected\n";
        }
        return userType + ": " + user;
    }
}
