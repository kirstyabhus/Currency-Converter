package com.codingblackfemales.swingTest;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.codingblackfemales.CurrenciesAPI;

public class testUI extends JFrame {
    public static void main(String[] args) {
        // create a new JFrame with window title
        JFrame frame = new JFrame("Currency Converter");

        // exit out of application when close button clicked, which is by default
        // HIDE_ON_CLOSE
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the size of the frame
        frame.setSize(400, 400);
        // prevent resizing of the frame
        frame.setResizable(false);

        // create a new JPanel to which Swing components can be added to
        JPanel panel = new JPanel();

        // create heading label & add it to the panel
        JLabel headinglabel = new JLabel("Currency Converter");
        panel.add(headinglabel);

        /*
         * // adding an image
         * // create a new label for the flag image
         * JLabel flagImageLabel = new JLabel();
         * // create an ImageIcon
         * ImageIcon flagImageIcon = new ImageIcon(
         * "C:\\Users\\kabhu\\programming-projects\\Currency-Converter\\src\\main\\java\\com\\codingblackfemales\\swingTest\\img\\n"
         * + //
         * "igeriaFlagSMALL.png");
         * // set the icon to the label
         * flagImageLabel.setIcon(flagImageIcon);
         * // add the image to the frame
         * panel.add(flagImageLabel);
         */

        // change the ICON of the frame/window (top left)
        ImageIcon flagImage = new ImageIcon(
                "C:\\Users\\kabhu\\programming-projects\\Currency-Converter\\src\\main\\java\\com\\codingblackfemales\\swingTest\\img\\pound_icon.png");
        frame.setIconImage(flagImage.getImage());

        /*
         * create a button
         * JButton button = new JButton("click me");
         * panel.add(button);
         */

        // textfield
        JTextField amountTextField = new JTextField("text field");
        panel.add(amountTextField);

        // adding out currency codes from the API in other file
        final String apiKey = "8d246aca316c5a6059a8bd96";
        CurrenciesAPI currenciesAPI = new CurrenciesAPI(apiKey);
        ArrayList<String> currenciesList = new ArrayList<String>(currenciesAPI.getCurrencyCodes());

        // convert the ArrayList into an array
        String[] currenciesArray = null;
        currenciesArray = currenciesList.toArray(new String[currenciesList.size()]);

        // JComboBox = used to show a popup menu of choices, where a user can select one
        // JComboBox(Object[] items) creates a new JComboBox containing the elements of
        // the given array
        // use our array of currency codes for the ComboBox
        JComboBox country = new JComboBox(currenciesArray);
        panel.add(country);

        frame.add(panel);
        // make the JFrame VISIBILE
        frame.setVisible(true);

        // change the color of the background (NOT WORKING?)
        // frame.setBackground(new Color(0, 0, 0));
        // frame.getContentPane().setBackground(Color.GREEN);
    }

}
