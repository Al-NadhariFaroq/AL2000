package db.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "SUBSCRIBERS", schema = "ALNADHAF", catalog = "")
public class SubscriberPOJO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SUBSCRIBER_ID")
    private int subscriberId;
    @Basic
    @Column(name = "SUBSCRIPTION_CARD_NUMBER")
    private int subscriptionCardNumber;
    @Basic
    @Column(name = "CREDIT_CARD_NUMBER")
    private int creditCardNumber;
    @Basic
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Basic
    @Column(name = "BALANCE")
    private float balance;

    public SubscriberPOJO() {

    }

    public SubscriberPOJO(int subscriptionCardNumber,
                          int creditCardNumber,
                          String firstName,
                          String lastName,
                          String email,
                          Date birthDate,
                          float balance
    ) {
        this.subscriptionCardNumber = subscriptionCardNumber;
        this.creditCardNumber = creditCardNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.balance = balance;
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
