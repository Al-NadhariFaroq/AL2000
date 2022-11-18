package ui;

import javax.swing.*;
import java.awt.*;

public class MoviePanel extends JPanel {
    Image img;
    String title;

    MoviePanel(String title) {
        this.title = title;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JButton button = new JButton();

        try {
            Image img = new ImageIcon("./rsc/images/avatar.jpg").getImage();
            //int width = button.getPreferredSize().width;
            //int height = img.getHeight(null) * width / img.getWidth(null);
            ImageIcon icon = new ImageIcon(img.getScaledInstance(160, 260, Image.SCALE_DEFAULT));
            button.setIcon(icon);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        add(button, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(titleLabel, BorderLayout.SOUTH);
        //setPreferredSize(new Dimension(120, 300));
    }
}
