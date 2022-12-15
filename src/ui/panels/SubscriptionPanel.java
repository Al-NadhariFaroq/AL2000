package ui.panels;

import ui.AL2000UI;
import ui.util.StackLayout;
import ui.interactions.PreferencesInteraction;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;

public class SubscriptionPanel extends JPanel {
    private final AL2000UI UI;

    JButton validBtn, btn1, btn2, btn3, btn4;
    JTextField firstNameText, lastNameText, mailText, birthDateText;
    DefaultListModel<String> favoriteModel, neutralModel, forbiddenModel;
    JList<String> favoriteList, neutralList, forbiddenList;

    public SubscriptionPanel(AL2000UI UI) {
        super(new BorderLayout());

        this.UI = UI;

        JPanel layer1 = new JPanel(new BorderLayout());
        JLabel firstNameLabel = new JLabel("Name : ");
        firstNameText = new JTextField();
        layer1.add(firstNameLabel, BorderLayout.WEST);
        layer1.add(firstNameText, BorderLayout.CENTER);

        JPanel layer2 = new JPanel(new BorderLayout());
        JLabel lastNameLabel = new JLabel("Last name : ");
        lastNameText = new JTextField();
        layer2.add(lastNameLabel, BorderLayout.WEST);
        layer2.add(lastNameText, BorderLayout.CENTER);

        JPanel layer3 = new JPanel(new BorderLayout());
        JLabel mailLabel = new JLabel("Mail : ");
        mailText = new JTextField();
        layer3.add(mailLabel, BorderLayout.WEST);
        layer3.add(mailText, BorderLayout.CENTER);

        JPanel layer4 = new JPanel(new BorderLayout());
        JLabel dateOfBirthLabel = new JLabel("Date of birth : ");
        birthDateText = new JTextField();
        layer4.add(dateOfBirthLabel, BorderLayout.WEST);
        layer4.add(birthDateText, BorderLayout.CENTER);

        validBtn = new JButton("valid");
        validBtn.addActionListener(e -> {
            Calendar birthDate = Calendar.getInstance();
            birthDate.setTime(Date.valueOf(birthDateText.getText()));

            UI.getFC()
              .subscription(firstNameText.getText(), lastNameText.getText(), mailText.getText(), birthDate, new HashMap<>());
            UI.getPanelManager().setCurrentPanel(Panel.HOME);
        });

        JPanel information = new JPanel(new StackLayout());
        information.add(layer1);
        information.add(layer2);
        information.add(layer3);
        information.add(layer4);
        information.add(createPreferencePanel());

        JPanel southPanel = new JPanel();
        southPanel.add(validBtn);

        add(information, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    JPanel createPreferencePanel() {
        JPanel preference = new JPanel(new BorderLayout());

        JLabel titlePreference = new JLabel("Theme preferences and restrictions");
        titlePreference.setBorder(new EmptyBorder(20, 0, 20, 0));
        preference.add(titlePreference, BorderLayout.NORTH);

        JLabel favoriteLabel = new JLabel("Favorites");
        JLabel neutralLabel = new JLabel("Neutrals");
        JLabel forbiddenLabel = new JLabel("Forbidden");

        favoriteModel = new DefaultListModel<>();
        neutralModel = new DefaultListModel<>();
        forbiddenModel = new DefaultListModel<>();
        favoriteModel.addElement("Drama");
        favoriteModel.addElement("Animation");
        neutralModel.addElement("Comedy");
        neutralModel.addElement("Western");
        forbiddenModel.addElement("Science fiction");
        forbiddenModel.addElement("Thriller");
        forbiddenModel.addElement("Policy");
        favoriteList = new JList<>(favoriteModel);
        neutralList = new JList<>(neutralModel);
        forbiddenList = new JList<>(forbiddenModel);

        Box buttons1 = Box.createVerticalBox();
        Box buttons2 = Box.createVerticalBox();
        btn1 = new JButton("⇐");
        btn2 = new JButton("⇒");
        btn3 = new JButton("⇐");
        btn4 = new JButton("⇒");
        btn1.setFont(btn1.getFont().deriveFont(20f));
        btn2.setFont(btn2.getFont().deriveFont(20f));
        btn3.setFont(btn3.getFont().deriveFont(20f));
        btn4.setFont(btn4.getFont().deriveFont(20f));
        btn1.addActionListener(new PreferencesInteraction(this));
        btn2.addActionListener(new PreferencesInteraction(this));
        btn3.addActionListener(new PreferencesInteraction(this));
        btn4.addActionListener(new PreferencesInteraction(this));
        buttons1.add(btn1);
        buttons1.add(btn2);
        buttons2.add(btn3);
        buttons2.add(btn4);

        Box favoriteBox = Box.createVerticalBox();
        Box neutralBox = Box.createVerticalBox();
        Box forbiddenBox = Box.createVerticalBox();
        favoriteBox.add(favoriteLabel);
        favoriteBox.add(favoriteList);
        neutralBox.add(neutralLabel);
        neutralBox.add(neutralList);
        forbiddenBox.add(forbiddenLabel);
        forbiddenBox.add(forbiddenList);

        Box box = Box.createHorizontalBox();
        box.add(Box.createHorizontalGlue());
        box.add(favoriteBox);
        box.add(buttons1);
        box.add(neutralBox);
        box.add(buttons2);
        box.add(forbiddenBox);
        box.add(Box.createHorizontalGlue());

        preference.add(box, BorderLayout.CENTER);
        return preference;
    }

    public JButton getValidBtn() {
        return validBtn;
    }

    public JButton getBtn1() {
        return btn1;
    }

    public JButton getBtn2() {
        return btn2;
    }

    public JButton getBtn3() {
        return btn3;
    }

    public JButton getBtn4() {
        return btn4;
    }

    public JTextField getFirstNameText() {
        return firstNameText;
    }

    public JTextField getLastNameText() {
        return lastNameText;
    }

    public JTextField getMailText() {
        return mailText;
    }

    public JTextField getBirthDateText() {
        return birthDateText;
    }

    public DefaultListModel<String> getFavoriteModel() {
        return favoriteModel;
    }

    public DefaultListModel<String> getNeutralModel() {
        return neutralModel;
    }

    public DefaultListModel<String> getForbiddenModel() {
        return forbiddenModel;
    }

    public JList<String> getFavoriteList() {
        return favoriteList;
    }

    public JList<String> getNeutralList() {
        return neutralList;
    }

    public JList<String> getForbiddenList() {
        return forbiddenList;
    }
}
