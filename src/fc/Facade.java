package fc;

public interface Facade {

    /* facade avec le bras mecanique */
    void insertBluRay(int position);

    void extractBluRay(int position);

    /* facade avec le lecteur de disque */
    BluRay readBluRay(int position);
    
    /* facade avec les lecteurs de cartes */
    CreditCard readCreditCard();

    SubscribeCard readSubscribeCard();

    void writeSubscribeCard(SubscribeCard subscribeCard);

    /* facade avec la banque */
    boolean isValidPayment(CreditCard creditCard, int amount);
}
