package ui.panels;

import fc.movie.Movie;
import fc.support.QRCode;
import ui.AL2000UI;
import ui.component.MovieInfo;
import ui.util.GBC;

import javax.swing.*;
import java.awt.*;

public class MovieInfoPanel extends JPanel {
    private final AL2000UI UI;

    private final MovieInfo movieInfo;
    private JButton rentBtn;

    public MovieInfoPanel(AL2000UI UI) {
        super(new GridBagLayout());
        setBackground(new Color(203, 208, 214));

        this.UI = UI;

        movieInfo = new MovieInfo();
        movieInfo.setBackground(new Color(53, 74, 95));
        movieInfo.setForeground(Color.WHITE);

        add(movieInfo, GBC.placeAt(0, 0).setInsets(50, 0).setWeight(1, 1).setFill(GBC.BOTH));
        add(createBottomBar(), GBC.placeAt(0, 1).setFill(GBC.BOTH));
    }

    public void updateMovie(Movie movie) {
        movieInfo.setMovie(movie);
    }

    private JPanel createBottomBar() {
        JPanel bottomBar = new JPanel();
        bottomBar.setBackground(new Color(53, 74, 95));

        rentBtn = new JButton("Rent");
        bottomBar.add(rentBtn);
        rentBtn.addActionListener(e -> {
            String[] options = {"BluRay", "QRCode"};
            String optionPane = (String) JOptionPane.showInputDialog(null,
                                                                     "Choisir le format",
                                                                     "Format",
                                                                     JOptionPane.OK_OPTION,
                                                                     null,
                                                                     options,
                                                                     options[0]
            );
            if (optionPane != null) {
                switch (optionPane) {
                    case "BluRay":
                        UI.getFC().rentBluRay(movieInfo.getMovie());
                        break;
                    case "QRCode":
                        new Thread(() -> {
                        QRCode qr = new QRCode(movieInfo.getMovie());
                        qr.generateQRcode();
                        qr.sendByEmail("randomemail@gmail.com");}).start();
                        break;
                    default:
                        break;
                }
            }
        });
        return bottomBar;
    }
}
