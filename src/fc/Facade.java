package fc;

public class Facade {

    public Facade() {

    }

    /* facade avec le bras mecanique */
    void insertBluRay(int position) {

    }

    void extractBluRay(int position) {

    }

    /* facade avec le lecteur de disque */
    BluRay readBluRay(int position) {
        return null;
    }

    /* facade avec les lecteurs de cartes :
       renvoie le cardNumber ou -1 s'il n'y a pas de carte dans le lecteur */
    int readCreditCard() {
        return 0;
    }

    int readSubscribeCard() {
        return 0;
    }

    /* facade avec la banque */
    boolean isValidPayment(CreditCard creditCard, int amount) {
        return true;
    }
}
