package fc.user;

import fc.DatabaseManagement;
import fc.Themes;
import fc.support.BluRayRental;

import java.util.Calendar;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Subscriber implements Client {
    public static final int MAX_RENTALS = 3;

    private final int subscriptionCardNumber;
    private int creditCardNumber;
    private String email;
    private String firstName;
    private String lastName;
    private Calendar birthDate;
    private float balance;
    private final boolean isControlled;
    private final Map<Subscriber, Boolean> controlledSubscribers;
    private final Map<String, Integer> themes;
    private final Set<BluRayRental> bluRayRentals;

    public Subscriber(int subscriptionCardNumber,
                      int creditCardNumber,
                      String email,
                      String firstName,
                      String lastName,
                      Calendar birthDate,
                      float balance,
                      boolean isControlled,
                      Map<Subscriber, Boolean> controlledSubscribers,
                      Map<String, Integer> themes,
                      Set<BluRayRental> bluRayRentals
    ) {
        this.subscriptionCardNumber = subscriptionCardNumber;
        this.creditCardNumber = creditCardNumber;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.balance = balance;
        this.isControlled = isControlled;
        this.controlledSubscribers = controlledSubscribers;
        this.themes = themes;
        this.bluRayRentals = bluRayRentals;
    }

    public int getSubscriptionCardNumber() {
        return subscriptionCardNumber;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public float getBalance() {
        return balance;
    }

    public boolean IsValidBalance() {
        return balance > 15;
    }

    public void debit(float amount) {
        balance -= amount;
    }

    public void credit(float amount) {
        balance += amount;
    }

    public boolean isControlled() {
        return isControlled;
    }

    public Set<String> getIncludedThemes() {
        return Themes.getSpecifiedThemes(themes, Themes.INCLUDED);
    }

    public Set<String> getExcludedThemes() {
        return Themes.getSpecifiedThemes(themes, Themes.EXCLUDED);
    }

    public Set<String> getForbiddenThemes() {
        return Themes.getSpecifiedThemes(themes, Themes.FORBIDDEN);
    }

    public void setThemeAvailability(String theme, int availability) throws IllegalArgumentException {
        if (!themes.containsKey(theme)) {
            throw new IllegalArgumentException("Invalid theme value");
        }
        if (availability < Themes.INCLUDED || availability > Themes.FORBIDDEN) {
            throw new IllegalArgumentException("Invalid availability value");
        }
        themes.replace(theme, availability);
    }

    public Set<Subscriber> getControlledSubscribers() {
        return controlledSubscribers.keySet();
    }

    public boolean addControlledSubscriber(Subscriber subscriber, boolean isControlled) throws NullPointerException {
        if (subscriber == null) {
            throw new NullPointerException("variable subscriber might not have been initialized");
        }
        return Boolean.TRUE.equals(controlledSubscribers.put(subscriber, isControlled));
    }

    public boolean removeControlledSubscriber(Subscriber subscriber) {
        return controlledSubscribers.remove(subscriber);
    }

    public Set<BluRayRental> getBluRayRentals() {
        return bluRayRentals;
    }

    public void addBluRayRental(BluRayRental bluRayRental)
            throws IllegalStateException, NullPointerException, IllegalArgumentException {
        if (bluRayRentals.size() == MAX_RENTALS) {
            throw new IllegalStateException("no more than " + MAX_RENTALS + " blu-ray rentals authorized");
        }
        if (bluRayRental == null) {
            throw new NullPointerException("variable bluRayRental might not have been initialized");
        }
        if (!bluRayRentals.add(bluRayRental)) {
            throw new IllegalArgumentException("invalid blu-ray rental value: already in list");
        }
        DatabaseManagement.createSubscriberRental(bluRayRental, this);
    }

    public void removeBluRayRental(BluRayRental bluRayRental) {
        if (!bluRayRentals.remove(bluRayRental)) {
            throw new IllegalArgumentException("invalid blu-ray rental value: not in list");
        }
        // DB
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        txt.append(subscriptionCardNumber).append(" (").append(firstName).append(" ").append(lastName).append(")\n");
        for (Subscriber subscriber : controlledSubscribers.keySet()) {
            txt.append("\t")
               .append(subscriber.getSubscriptionCardNumber())
               .append(" (")
               .append(subscriber.getFirstName())
               .append(" ")
               .append(subscriber.getLastName())
               .append("\n");
        }
        return txt.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Subscriber)) {
            return false;
        }
        Subscriber that = (Subscriber) o;
        return subscriptionCardNumber == that.subscriptionCardNumber && creditCardNumber == that.creditCardNumber &&
               Float.compare(that.balance, balance) == 0 && isControlled == that.isControlled &&
               Objects.equals(email, that.email) && Objects.equals(firstName, that.firstName) &&
               Objects.equals(lastName, that.lastName) && Objects.equals(birthDate, that.birthDate) &&
               Objects.equals(controlledSubscribers, that.controlledSubscribers) &&
               Objects.equals(themes, that.themes) && Objects.equals(bluRayRentals, that.bluRayRentals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionCardNumber,
                            creditCardNumber,
                            email,
                            firstName,
                            lastName,
                            birthDate,
                            balance,
                            isControlled,
                            controlledSubscribers,
                            themes,
                            bluRayRentals
        );
    }
}
