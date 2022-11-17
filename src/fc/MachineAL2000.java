package fc;

public class MachineAL2000 {
    enum State {};
    private Client client;
    private BluRayTable blurays;

    public MachineAL2000(){
        blurays = new BluRayTable();
    }

    public QRCode printQRCode(Movie movie){
        // mettre à jour BD
        return new QRCode(movie);
    }

    public BluRay deliverBluRay(Movie movie){
        return blurays.getBluRay(movie);
    }

    boolean isValidBluRay(BluRay bluRay){
        return false;
    }

    boolean isValidCard(){
        return false;
    }

    public boolean isValidSubscribeCard(){
        return false;
    }

    public boolean isValidCreditCard(){
        return false;
    }
}
