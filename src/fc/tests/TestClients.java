package fc.tests;

import java.util.Calendar;
import java.util.Date;

import fc.CreditCard;
import fc.MachineAL2000;
import fc.SubscribeCard;
import fc.Subscriber;

public class TestClients {
    public static void main(String args[]) {
        MachineAL2000 m = new MachineAL2000();
        System.out.println(m);

        CreditCard fatherCreditCard = new CreditCard(0);
        SubscribeCard fatherSubscribeCard = new SubscribeCard(0, "Pere", "Father", Calendar.getInstance().getTime(), "pere.father@gmail.com", fatherCreditCard, null);
        Subscriber father = new Subscriber(fatherCreditCard, fatherSubscribeCard);
        Date inscriptionDate = Calendar.getInstance().getTime();

        m.connection(fatherSubscribeCard);
        System.out.println(m);

        SubscribeCard sonSubscribeCard = m.subscription("Fils", "Son", inscriptionDate, "fils.son@gmail.com");
        System.out.println(m);

        m.rechargeSubscribeCard(20);
        System.out.println(m);

        m.rechargeSubSubscribeCard(sonSubscribeCard, 50);
        System.out.println(m);

        m.close();
    }
}
