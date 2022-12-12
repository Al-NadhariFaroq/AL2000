package db.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "subscribers")
@Table(name = "subscribers", schema = "alnadhaf", catalog = "")
public class SubscriberPOJO implements POJO {
    @Id
    @Column(name = "subscriber_id")
    private int subscriberId;

    @Basic(optional = false)
    @Column(name = "subscription_card_number")
    private int subscriptionCardNumber;

    @Basic(optional = false)
    @Column(name = "credit_card_number")
    private int creditCardNumber;

    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;

    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @Column(name = "birth_date")
    private Date birthDate;

    @Basic(optional = false)
    @Column(name = "balance")
    private float balance;

    @OneToMany(mappedBy = "subscriber", cascade = CascadeType.ALL)
    private List<CtrlSubPOJO> controlledSubscribers;

    @OneToMany(mappedBy = "subscriber", cascade = CascadeType.ALL)
    private List<ScorePOJO> scores;

    @OneToMany(mappedBy = "subscriber", cascade = CascadeType.ALL)
    private List<PreferencePOJO> preferences;

    @OneToMany(mappedBy = "subscriber", cascade = CascadeType.ALL)
    private List<SubRentalPOJO> rentals;

    public SubscriberPOJO() {
        super();
    }

    public SubscriberPOJO(int subscriberId,
                          int subscriptionCardNumber,
                          int creditCardNumber,
                          String firstName,
                          String lastName,
                          String email,
                          Date birthDate,
                          float balance
    ) {
        super();
        this.subscriberId = subscriberId;
        this.subscriptionCardNumber = subscriptionCardNumber;
        this.creditCardNumber = creditCardNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.balance = balance;
    }

    public int getID() {
        return subscriberId;
    }

    public void setID(int subscriberId) {
        this.subscriberId = subscriberId;
    }

    public int getSubscriptionCardNumber() {
        return subscriptionCardNumber;
    }

    public void setSubscriptionCardNumber(int subscriptionCardNumber) {
        this.subscriptionCardNumber = subscriptionCardNumber;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<CtrlSubPOJO> getControlledSubscribers() {
        return controlledSubscribers;
    }

    public List<PreferencePOJO> getPreferences() {
        return preferences;
    }

    public List<SubRentalPOJO> getRentals() {
        return rentals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SubscriberPOJO)) {
            return false;
        }
        SubscriberPOJO that = (SubscriberPOJO) o;
        return subscriberId == that.subscriberId && subscriptionCardNumber == that.subscriptionCardNumber &&
               creditCardNumber == that.creditCardNumber && Float.compare(that.balance, balance) == 0 &&
               Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) &&
               Objects.equals(email, that.email) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriberId,
                            subscriptionCardNumber,
                            creditCardNumber,
                            firstName,
                            lastName,
                            email,
                            birthDate,
                            balance
        );
    }
}
