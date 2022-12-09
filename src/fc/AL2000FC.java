package fc;

import db.dao.DAOFactory;
import db.pojo.SubscriberPOJO;
import fc.movie.Movie;
import fc.support.BluRay;
import fc.user.*;

import java.sql.Date;
import java.util.*;

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
        user = new NonSubscriber(1254882, null);
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
            user = null; //new Subscriber(subscriptionCardNumber);
        } else if (creditCardNumber >= 0) {
            user = null; //new NonSubscriber(creditCardNumber);
        }
    }

    public void close() {
        user = null;
    }

    public void subscription(String email, String firstName, String lastName, Calendar birthDate, Map<String, Integer> preferences) {
        Subscriber subscriber = new Subscriber(0, ((Client) user).getCreditCardNumber(), email, firstName, lastName, birthDate, 0, false, new HashMap<>(), preferences, new HashSet<>());
        DatabaseManagement.createSubscriber(subscriber);
    }

    @Override
    public String toString() {
        if (userType == UserType.NONE || user == null) {
            return "no one connected\n";
        }
        return userType + ": " + user;
    }
}
