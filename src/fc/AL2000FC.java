package fc;

import fc.movie.Movie;
import fc.support.BluRay;
import fc.user.Client;
import fc.user.NonSubscriber;
import fc.user.Subscriber;
import fc.user.Technician;
import fc.user.User;
import fc.user.UserType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;

public class AL2000FC {
    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    private final MachineFacade machineFacade;
    private final ThemeManagement themeManagement;
    private final MovieManagement movieManagement;
    private final BluRayManagement bluRayManagement;
    private UserType userType;
    private User user;

    public AL2000FC() {
        new MachineInteraction(this);
        machineFacade = MachineFacade.getInstance();
        themeManagement = new ThemeManagement();
        movieManagement = new MovieManagement();
        bluRayManagement = new BluRayManagement();
        userType = UserType.NONE;
        user = null;

        movieManagement.setThemes(themeManagement.getIncludedThemes());
    }

    public PropertyChangeSupport getChanges() {
        return changes;
    }

    public ThemeManagement getThemes() {
        return themeManagement;
    }

    public MovieManagement getMovies() {
        return movieManagement;
    }

    public BluRayManagement getBluRays() {
        return bluRayManagement;
    }

    public Technician getTechnician() {
        if (userType != UserType.TECHNICIAN) {
            throw new IllegalStateException("no technician currently connected");
        }
        return (Technician) user;
    }

    public NonSubscriber getNonSubscriber() {
        if (userType != UserType.CLIENT) {
            throw new IllegalStateException("no client currently connected");
        }
        return (NonSubscriber) user;
    }

    public Subscriber getSubscriber() {
        if (userType != UserType.SUBSCRIBER) {
            throw new IllegalStateException("no subscriber currently connected");
        }
        return (Subscriber) user;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }

    public void rentBluRay(Movie movie) {
        // maj BD : rentals + bluRays
        BluRay bluRay = bluRayManagement.getBluRayFromMovie(movie);
        bluRayManagement.rentBluRay(bluRay);
        machineFacade.extractDiscFromPosition(bluRayManagement.getPosition(bluRay));
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

    public void connection(Integer creditCardNumber, Integer subscriptionCardNumber) {
        if (subscriptionCardNumber != null && subscriptionCardNumber == 0) {
            user = new Technician();
            userType = UserType.TECHNICIAN;
        } else if (subscriptionCardNumber != null && subscriptionCardNumber > 0) {
            user = DatabaseManagement.readSubscriber(subscriptionCardNumber);
            userType = UserType.SUBSCRIBER;
            themeManagement.updateAvailabilities(getSubscriber());
            movieManagement.setThemes(themeManagement.getIncludedThemes());
        } else if (creditCardNumber != null && creditCardNumber >= 0) {
            user = DatabaseManagement.readNonSubscriber(creditCardNumber);
            userType = UserType.CLIENT;
        }
    }

    public void close() {
        user = null;
        userType = UserType.NONE;
    }

    public void subscription(String email,
                             String firstName,
                             String lastName,
                             Calendar birthDate,
                             Map<String, Integer> preferences
    ) {
        Subscriber subscriber = new Subscriber(0,
                                               ((Client) user).getCreditCardNumber(),
                                               email,
                                               firstName,
                                               lastName,
                                               birthDate,
                                               0,
                                               false,
                                               new HashSet<>(),
                                               preferences,
                                               new HashSet<>()
        );
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
