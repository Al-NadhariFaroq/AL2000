package fc;

import db.dao.DAOFactory;
import db.pojo.SubscribeCardPOJO;
import db.pojo.SubscriberPOJO;
import fc.movie.Movie;
import fc.movie.MovieDatabase;
import fc.support.BluRay;
import fc.support.BluRayDatabase;

import java.sql.Date;

public class FunctionalCoreAL2000 {
    Facade facade;
    private Client client;
    private final ThemeDatabase themes;
    private final MovieDatabase movies;
    private final BluRayDatabase bluRays;

    public FunctionalCoreAL2000() {
        facade = new Facade();
        themes = new ThemeDatabase();
        movies = new MovieDatabase();
        bluRays = new BluRayDatabase();
    }

    public void rentBluRay(Movie movie) {
        // maj BD : rentals + bluRays
        BluRay bluRay = bluRays.getBluRayFromMovie(movie);
        bluRays.rentBluRay(bluRay);
        facade.extractBluRay(bluRays.getPosition(bluRay));
    }

    public CreditCard determineCreditCard(int cardNumber) {
        // lire BD : cards
        return null;
    }

    public SubscribeCard determineSubscribeCard(int CardNumber) {
        // lire BD : subscribeCards + subscribers
        return null;
    }

    public void rechargeSubscribeCard(int amount) {
        assert (client.getClass() == Subscriber.class);
        Subscriber subscriber = (Subscriber) client;
        if (facade.isValidPayment(subscriber.getCreditCard(), amount)) {
            subscriber.getSubscribeCard().credit(amount);
        } else {
            throw new RuntimeException("Impossible payment!");
        }
    }

    public void rechargeSubSubscribeCard(SubscribeCard card, int amount) {
        if (facade.isValidPayment(card.getCreditCard(), amount)) {
            card.credit(amount);
        } else {
            throw new RuntimeException("Impossible payment!");
        }
    }

    public void connection(Card card) {
        if (card.getClass() == SubscribeCard.class) {
            // lire BD
            SubscribeCard subscribeCard = (SubscribeCard) card;
            client = new Subscriber(subscribeCard.getCreditCard(), subscribeCard);
        } else {
            client = new Client((CreditCard) card);
        }
    }

    public void close() {
        client = null;
    }

    public SubscribeCard subscription(String firstName, String lastName, Date dateOfBirth, String email) {
        /*Subscriber subscriber = client.getClass() == Subscriber.class ? (Subscriber) client : null;
        Lecture BD : trouver plus petit card number dispo
        SubscribeCard newCard = new SubscribeCard(0, firstName, lastName, dateOfBirth, email,
                client.creditCard, subscriber
        );
        Subscriber newSubscriber = new Subscriber(client.getCreditCard(), newCard);
        if (subscriber != null) {
            subscriber.addSubscribeCard(newCard);
        }*/
        SubscribeCardPOJO subscribeCardPOJO = new SubscribeCardPOJO();
        subscribeCardPOJO.setSubscriberCardId(0);
        subscribeCardPOJO.setSubscriber(true);
        subscribeCardPOJO.setCardholderFirstName(firstName);
        subscribeCardPOJO.setCardholderLastName(lastName);
        subscribeCardPOJO.setBirthDate(dateOfBirth);
        subscribeCardPOJO.setCardBalance(0);
        DAOFactory.getSubscribeCardDAO().create(subscribeCardPOJO);

        SubscriberPOJO subscriberPOJO = new SubscriberPOJO();
        subscriberPOJO.setSubscriberId(666);
        subscriberPOJO.setEmail(email);
        subscriberPOJO.setCardNumber(0);
        DAOFactory.getSubscriberDAO().create(subscriberPOJO);
        return null;
    }

    @Override
    public String toString() {
        return client != null ? client.toString() : null;
    }
}
