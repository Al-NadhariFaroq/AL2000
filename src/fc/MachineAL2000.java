package fc;

public class MachineAL2000 {
    enum State{}
    enum User{ABONNE, CLIENT, TECHNICIEN}
    private CreditCard creditCard;
    private SubscribeCard subscribeCard;

    public MachineAL2000(){ }

    void deliverBlueRay(){}

    void printQRCode(){}

    boolean isValidBlueRay(){
        return false;
    }

    boolean isValidCard(){
        return false;
    }

    public void setCreditCard(CreditCard c){
        creditCard = c;
    }

    public void setSubscribeCard(SubscribeCard c){
        subscribeCard = c;
    }

    public boolean isValidSubscribeCard(){
        return false;
    }

    public boolean isValidCreditCard(){
        return false;
    }
}
