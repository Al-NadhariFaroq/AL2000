package fc;

public class QRCode extends Dispositif{
    String link;
    public QRCode(){}

    @Override
    void deliverDispositif(){}

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
