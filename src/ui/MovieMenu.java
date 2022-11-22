package ui;

import fc.Movie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MovieMenu extends JPanel {
        JLabel titleLabel, dateLabel, noteLabel,synopsisLabel;
        JLabel directorsLabel, actorsLabel, themesLabel;
        JButton rentBtn, btnGoBack;

         public MovieMenu(Movie movie){
             setLayout(new BorderLayout());

             JPanel topPanel = creatTopPanel();
             add(topPanel,BorderLayout.NORTH);

             createComponent(movie);

             JPanel movieInfoPanel = creatMovieInfoPanel(movie);
             add(movieInfoPanel,BorderLayout.CENTER);
         }

         void createComponent(Movie movie){
             titleLabel = creatLabel(movie.getTitle() + "The Far Way ",30);
             dateLabel = creatLabel("<html><font color=black>Released</font> : " + " 12/08/2015      ",16);
             themesLabel = creatLabel("<html><font color=black>Genre</font> : "+"Action, Sci-Fi, Romance",16);
             synopsisLabel = creatLabel("<html><font color=black>Synopsis</font> :<br/> " + "movie.getSynopsis()",16);
             directorsLabel = creatLabel("<html><font color=black>Directors</font> : " + " Landry, Daana",16);
             actorsLabel = creatLabel("<html><font color=black>Main actors</font> : " + "Faroq, Yael, Sacha",16);
             noteLabel = creatLabel("<html><font color=black>Note</font>: " + " 5*",16);

             rentBtn = new JButton("Rent");
             rentBtn.addActionListener(e -> CyberVideo.changeState(CyberVideo.Panels.MAIN));
         }

         JPanel creatTopPanel(){
             JPanel topPanel = new JPanel(new FlowLayout());
             topPanel.setPreferredSize(new Dimension(960, 100));
             topPanel.setBackground(Color.gray);
             btnGoBack = new JButton("Go Back");
             btnGoBack.addActionListener(e -> CyberVideo.changeState(CyberVideo.Panels.MAIN));
             topPanel.add(btnGoBack,BorderLayout.WEST) ;
             return topPanel;
         }

         JPanel creatMovieInfoPanel(Movie movie){
             JPanel movieInfoPanel = new JPanel(new StackLayout());
             movieInfoPanel.setBackground(Color.cyan);
             movieInfoPanel.setBorder(new EmptyBorder(0,10,10,10));

            JPanel imageInfoPanel = new JPanel(new BorderLayout());

            JPanel imagePanel = new JPanel(new CardLayout()) ;

            java.net.URL imgUrl = getClass().getResource("/images/avatar.jpg");
            assert imgUrl != null;
            ImageIcon icon = new ImageIcon(new ImageIcon(imgUrl).getImage());//.getScaledInstance(300, 450, Image.SCALE_DEFAULT));
            JLabel label = new JLabel(icon);
            label.setBorder(new EmptyBorder(0,25,10,5));
            imagePanel.add(label);
            imageInfoPanel.add(imagePanel,BorderLayout.WEST);

            JPanel infoPanel = new JPanel(new GridLayout(6,0,1,1));
            infoPanel.setBackground(Color.blue);
            infoPanel.setBorder(new EmptyBorder(10,10,10,10));
            Box dateThemeBox = Box.createHorizontalBox();
            dateThemeBox.add(dateLabel);
            dateThemeBox.add(themesLabel);

            infoPanel.add(titleLabel);
            infoPanel.add(dateThemeBox);
            infoPanel.add(directorsLabel);
            infoPanel.add(actorsLabel);
            infoPanel.add(synopsisLabel);

            imageInfoPanel.add(infoPanel,BorderLayout.CENTER);

            movieInfoPanel.add(imageInfoPanel);
            /*********************************************/
            //JPanel lastPanel = new JPanel(new GridLayout(1,20));
            //lastPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
            imagePanel.add(rentBtn);
            //lastPanel.add(noteLabel);
            //infoPanel.add(lastPanel);

            return movieInfoPanel;
    }

    JLabel creatLabel(String text, int size) {
             JLabel label = new JLabel(text);
             label.setFont(new Font("Arial",Font.BOLD, size));
             return label;

    }
}
