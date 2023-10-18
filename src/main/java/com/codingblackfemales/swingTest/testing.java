package com.codingblackfemales.swingTest;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class testing extends JFrame {
    testing() {
        // Jthis = container class that is treated as the main window -> all other
        // components are added to the this e.g. labels, buttons etc.
        // Jthis() creates a new Jthis which is initally INVISIBLE, w/ given title
        // Jthis this = new Jthis("Currency Converter");
        // exit out of application when cloes button clicked, which is by default
        // HIDE_ON_CLOSE
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the size of the this
        this.setSize(400, 400);
        // prevent resizing of the this
        this.setResizable(false);

        // JPanel = a container class -> other Swing components can be added to JPanel
        // JPanel() creates new default JPanel w/ a double buffer + flow layout
        JPanel panel = new JPanel();
        // JLabel is used to display a short messsage i.e. string or an image icon
        JLabel headinglabel = new JLabel("Currency Converter");
        panel.add(headinglabel);

        // create a new label for the flag image
        JLabel flagImageLabel = new JLabel();
        // create an ImageIcon
        ImageIcon flagImageIcon = new ImageIcon(
                "C:\\Users\\kabhu\\programming-projects\\Currency-Converter\\src\\main\\java\\com\\codingblackfemales\\swingTest\\img\\n"
                        + //
                        "igeriaFlagSMALL.png");
        // sets the icon to the label
        flagImageLabel.setIcon(flagImageIcon);
        // add an image to the this
        panel.add(flagImageLabel);
        // changes the ICON of the this (top left)
        this.setIconImage(flagImageIcon.getImage());

        // button
        JButton button = new JButton("click me");
        panel.add(button);

        // textfield
        JTextField amountTextField = new JTextField("text field");
        panel.add(amountTextField);

        // JComboBox = used to show a popup menu of choices, where a user can select one
        // JComboBox(Object[] items) creates a new JComboBox containing the elements of
        // the given array
        JComboBox country = new JComboBox(new String[] { "GBP", "JPY", "USD" });
        panel.add(country);

        this.add(panel);
        // make the Jthis VISIBILE
        this.setVisible(true);

        // change the color of the background
        // this.setBackground(new Color(0, 0, 0));
        this.getContentPane().setBackground(Color.green);

        // LAYOUT AND FORMATTING
        // GroupLayout layout = new GroupLayout(this.getContentPane());
        // this.getContentPane().setLayout(layout);
        // layout.setHorizontalGroup();
    }
}
