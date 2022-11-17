package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainTopPanel extends JPanel{
    public MainTopPanel(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(960, 110));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(new Color(98, 98, 60));

        java.net.URL imgUrl = getClass().getResource("/images/listicon.png");
        assert imgUrl != null;
        ImageIcon icon = new ImageIcon(new ImageIcon(imgUrl).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JLabel label = new JLabel(icon);

        java.net.URL imgUrlUser = getClass().getResource("/images/user.png");
        assert imgUrlUser != null;
        ImageIcon iconUser = new ImageIcon(new ImageIcon(imgUrlUser).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JLabel labelUser = new JLabel(iconUser);


        JPanel searchPanel = new JPanel(new StackLayout());
        searchPanel. setBorder(new EmptyBorder(10, 10, 10, 10));
       searchPanel.setBackground(new Color(98, 98, 60));
        JTextField textField = new JTextField();
        textField.setPreferredSize( new Dimension( 200, 32 ) );

        searchPanel.add(new JLabel(" "));
        searchPanel.add(textField);
        searchPanel.add(new JLabel(" "));

        add(searchPanel,BorderLayout.CENTER);
        add(labelUser,BorderLayout.EAST);
        add(label,BorderLayout.WEST);
    }
}
