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

import com.codingblackfemales.BasicCurrencyConverter;
import com.codingblackfemales.Currencies;
import com.codingblackfemales.CurrenciesAPI;
import com.codingblackfemales.CurrenciesGBP;

public class testUI extends JFrame {
    public static void main(String[] args) {
        // JFrame = container class that is treated as the main window -> all other
        // components are added to the frame e.g. labels, buttons etc.
        // JFrame() creates a new JFrame which is initally INVISIBLE, w/ given title
        JFrame frame = new JFrame("Currency Converter");
        // exit out of application when cloes button clicked, which is by default
        // HIDE_ON_CLOSE
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the size of the frame
        frame.setSize(400, 400);
        // prevent resizing of the frame
        frame.setResizable(false);

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
        // add an image to the frame
        panel.add(flagImageLabel);
        // changes the ICON of the frame (top left)
        frame.setIconImage(flagImageIcon.getImage());

        // button
        JButton button = new JButton("click me");
        panel.add(button);

        // textfield
        JTextField amountTextField = new JTextField("text field");
        panel.add(amountTextField);

        // create instances of my currency classes & get the currency codes
        // CurrenciesGBP currenciesGBP = new CurrenciesGBP();
        // BasicCurrencyConverter currencyConverter = new
        // BasicCurrencyConverter(currenciesGBP);
        // String[] currencies = currencyConverter.getCurrencyCodes();

        final String apiKey = "8d246aca316c5a6059a8bd96";
        CurrenciesAPI currenciesAPI = new CurrenciesAPI(apiKey);
        ArrayList<String> currenciesList = new ArrayList<String>(currenciesAPI.getCurrencyCodes());

        String[] currenciesArray = null;
        currenciesArray = currenciesList.toArray(new String[currenciesList.size()]);

        // JComboBox = used to show a popup menu of choices, where a user can select one
        // JComboBox(Object[] items) creates a new JComboBox containing the elements of
        // the given array
        JComboBox country = new JComboBox(currenciesArray);
        panel.add(country);

        frame.add(panel);
        // make the JFrame VISIBILE
        frame.setVisible(true);

        // change the color of the background
        // frame.setBackground(new Color(0, 0, 0));
        frame.getContentPane().setBackground(Color.GREEN);

        // LAYOUT AND FORMATTING
        // GroupLayout layout = new GroupLayout(frame.getContentPane());
        // frame.getContentPane().setLayout(layout);
        // layout.setHorizontalGroup();
    }

}
