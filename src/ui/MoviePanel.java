package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class MoviePanel extends JPanel {
    Image img;
    String title;
    MoviePanel(String title){
        this.title = title;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton button = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("/images/avatar.jpg"));
            img = img.getScaledInstance(160, 260, Image.SCALE_DEFAULT);
            button.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        add(button,BorderLayout.CENTER);

        JLabel titleLabel = new JLabel(title,SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial",Font.BOLD,14));
        add(titleLabel, BorderLayout.SOUTH);
        setPreferredSize(new Dimension(120,300));
    }

}
