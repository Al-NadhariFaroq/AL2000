package fc;

import java.util.Random;

public class QRCode extends Support{
    String link;

    public QRCode(Movie movie){
        super(movie);
        Random rand = new Random();
        StringBuilder txt = new StringBuilder("");
        for(int i = 0 ; i < 100 ; i++){
            char c = (char)(rand.nextInt(93) + 33);
            txt.append(c);
        }
        link = txt.toString();
    }
}
