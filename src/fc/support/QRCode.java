package fc.support;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;




public class QRCode {
    private static final int DEFAULT_QR_CODE_WIDTH = 200;
    private static final int DEFAULT_QR_CODE_HEIGHT = 200;
    private static final String PATH = System.getProperty("user.home") + "/QRCode.png";
    private static final String CHARSET = "UTF-8";

    String movieLink;
    Map<EncodeHintType, ErrorCorrectionLevel> hashMap;


    public QRCode(String movieLink){
        this.movieLink = movieLink;
        hashMap = new HashMap<>();
    }

    public void generateQRcode() {
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            BitMatrix matrix = new MultiFormatWriter().encode(new String(movieLink.getBytes(CHARSET), CHARSET), BarcodeFormat.QR_CODE, DEFAULT_QR_CODE_WIDTH, DEFAULT_QR_CODE_HEIGHT);
            MatrixToImageWriter.writeToStream(matrix, PATH.substring(PATH.lastIndexOf('.') + 1), fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void sendByEmail(String clientEmail){
        String username = "CyberVideoAL2000@gmx.fr";
        String password = "!AL2000!";

        String host = "mail.gmx.com";
        Properties prop = System.getProperties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", host);

        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        String subject = "AL2000";
        String txt = "<H1>Hello Dear Client</H1> <br> " +
                "Scan the QR code to watch the film <br>" +
                "Enjoy Watching the movie <br>" +
                "<img src=\"cid:image\"> <br>" +
                "Thanks for using AL2000";

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(clientEmail));
            message.setSubject(subject);

            // This mail has 2 part, the BODY and the embedded image
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart txtBodyPart = new MimeBodyPart();
            txtBodyPart.setContent(txt, "text/html");
            multipart.addBodyPart(txtBodyPart);

            // second part (the image)
            BodyPart imgBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource(PATH);
            imgBodyPart.setDataHandler(new DataHandler(fds));
            imgBodyPart.setHeader("Content-ID", "<image>");
            multipart.addBodyPart(imgBodyPart);

            // put everything together
            message.setContent(multipart);
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args){
        QRCode qr = new QRCode("https://myflixer.to/watch-movie/baby-driver-19604.5297575");
        qr.generateQRcode();
        qr.sendByEmail("farouq71548@gmail.com");
        System.out.println("Done");


    }
}
