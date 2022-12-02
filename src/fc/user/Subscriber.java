package fc.user;

import fc.support.Rental;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Subscriber implements User {
    private final int subscriptionCardNumber;
    private int creditCardNumber;
    private String email;
    private String firstName;
    private String lastName;
    private Calendar birthDate;
    private float balance;
    private final Set<String> excludedThemes;
    private final Set<String> forbiddenThemes;
    private final Set<Subscriber> controlledSubscribers;
    private final Set<Rental> rentals;

    public Subscriber(int subscriptionCardNumber) {
        this.subscriptionCardNumber = subscriptionCardNumber;
        excludedThemes = new HashSet<>();
        forbiddenThemes = new HashSet<>();
        controlledSubscribers = new HashSet<>();
        rentals = new HashSet<>();
        // read all information in DB
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

    public Set<String> getForbiddenThemes() {
        return forbiddenThemes;
    }

    public boolean addForbiddenTheme(String theme) throws NullPointerException {
        if (theme == null) {
            throw new NullPointerException("variable theme might not have been initialized");
        }
        return forbiddenThemes.add(theme);
    }

    public boolean removeForbiddenTheme(String theme) {
        return forbiddenThemes.remove(theme);
    }

    public Set<String> getExcludedThemes() {
        return excludedThemes;
    }

    public boolean addExcludedTheme(String theme) throws NullPointerException {
        if (theme == null) {
            throw new NullPointerException("variable theme might not have been initialized");
        }
        return excludedThemes.add(theme);
    }

    public boolean removeExcludedTheme(String theme) {
        return excludedThemes.remove(theme);
    }

    public Set<Subscriber> getControlledSubscribers() {
        return controlledSubscribers;
    }

    public boolean addControlledSubscriber(Subscriber subscriber) throws NullPointerException {
        if (subscriber == null) {
            throw new NullPointerException("variable subscriber might not have been initialized");
        }
        return controlledSubscribers.add(subscriber);
    }

    public boolean removeControlledSubscriber(Subscriber subscriber) {
        return controlledSubscribers.remove(subscriber);
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

    public boolean addRental(Rental rental) throws NullPointerException {
        if (rental == null) {
            throw new NullPointerException("variable rental might not have been initialized");
        }
        return rentals.add(rental);
    }

    public boolean removeRental(Rental rental) {
        return rentals.remove(rental);
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
               Float.compare(that.balance, balance) == 0 && Objects.equals(email, that.email) &&
               Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) &&
               Objects.equals(birthDate, that.birthDate) && Objects.equals(forbiddenThemes, that.forbiddenThemes) &&
               Objects.equals(excludedThemes, that.excludedThemes) &&
               Objects.equals(controlledSubscribers, that.controlledSubscribers) &&
               Objects.equals(rentals, that.rentals);
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        txt.append(subscriptionCardNumber).append(" (").append(firstName).append(" ").append(lastName).append(")\n");
        for (Subscriber subscriber : controlledSubscribers) {
            txt.append("\t").append(subscriber.getSubscriptionCardNumber()).append("\n");
        }
        return txt.toString();
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
                            forbiddenThemes,
                            excludedThemes,
                            controlledSubscribers,
                            rentals
        );
    }
}
