package fc;

import java.util.Calendar;

public class UserTest {
    public static void main(String[] args) {
        Calendar subscriptionDate = Calendar.getInstance();

        AL2000FC al2000 = new AL2000FC();
        System.out.println(al2000);

        al2000.connection();
        System.out.println(al2000);

        al2000.subscription("adresse.mail@gmail.com", "firstName", "lastName", subscriptionDate, null);
        System.out.println(al2000);

        al2000.rechargeSubscriptionCard(20);
        System.out.println(al2000);

        al2000.close();
    }
}
