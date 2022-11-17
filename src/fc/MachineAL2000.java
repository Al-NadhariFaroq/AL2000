package fc;

public class MachineAL2000 {
    enum State{}
    enum User{ABONNE, CLIENT, TECHNICIEN}
    private CreditCard creditCard;
    private SubscribeCard subscribeCard;
    private BluRayTable blurays;

    public MachineAL2000(){
        blurays = new BluRayTable();
    }

    public QRCode printQRCode(Movie movie){
        return new QRCode(movie);
    }

    public BluRay deliverBluRay(Movie movie){
        return blurays.getBluRay(movie);
    }

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

    public void addBluRay(){}

    public void BluRay(){}
}
