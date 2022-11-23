package fc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubscribeCard extends Card {
    String firstName;
    String lastName;
    Date dateOfBirth;
    String email;
    CreditCard creditCard;
    Subscriber subscriber;
    List<String> restrictions;
    List<String> preferences;
    List<Rental> rentals;
    float balance;

    public SubscribeCard(int cardNumber, String firstName, String lastName, Date dateOfBirth, String email, CreditCard creditCard, Subscriber subscriber) {
        super(cardNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.creditCard = creditCard;
        this.subscriber = subscriber;
        restrictions = new ArrayList<>();
        preferences = new ArrayList<>();
        rentals = new ArrayList<>();
        balance = 0;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public List<String> getRestrictions() {
        return restrictions;
    }

    public void addRestriction(String restriction) {
        this.restrictions.add(restriction);
    }

    public void removeRestriction(String restriction) {
        this.restrictions.remove(restriction);
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void addPreference(String preference) {
        this.preferences.add(preference);
    }

    public void removePreference(String preference) {
        this.restrictions.remove(preference);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public void removeRental(Rental rental) {
        this.rentals.remove(rental);
    }

    public int nbCurrentRentals() {
        return rentals.size();
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    void debit(float amount) {
        balance -= amount;
    }

    void credit(float amount) {
        balance += amount;
    }

    public boolean IsValidBalance() {
        return balance > 15;
    }

    @Override
    public String toString() {
        return cardNumber + " (" + firstName + " " + lastName + ") : " + balance;
    }
}
