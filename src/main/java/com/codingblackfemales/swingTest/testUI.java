package com.codingblackfemales.swingTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        frame.setSize(600, 400);
        // prevent resizing of the frame
        frame.setResizable(false);

        // create a new JPanel to which Swing components can be added to
        JPanel panel = new JPanel();

        // create heading label & add it to the panel
        JLabel headinglabel = new JLabel("Currency Converter");
        panel.add(headinglabel);

        // change the ICON of the frame/window (top left)
        ImageIcon flagImage = new ImageIcon(
                "C:\\Users\\kabhu\\programming-projects\\Currency-Converter\\src\\main\\java\\com\\codingblackfemales\\swingTest\\img\\pound_icon.png");
        frame.setIconImage(flagImage.getImage());

        // textfield
        JTextField amountTextField = new JTextField("amount");
        panel.add(amountTextField);

        // adding our currency codes from the API (in other file) to this class
        final String apiKey = "8d246aca316c5a6059a8bd96";
        CurrenciesAPI currenciesAPI = new CurrenciesAPI(apiKey);
        ArrayList<String> currenciesList = new ArrayList<String>(currenciesAPI.getCurrencyCodes());
        // convert the ArrayList into an array
        String[] currenciesArray = null;
        currenciesArray = currenciesList.toArray(new String[currenciesList.size()]);
        // use the currencies array in the JComboBox
        JComboBox countryComboBox = new JComboBox(currenciesArray);

        countryComboBox.addActionListener(new ActionListener() {

            // this is the method that will be executed when someone clicks combo
            @Override
            public void actionPerformed(ActionEvent e) {
                // store the item the user selected as a string
                String option = countryComboBox.getSelectedItem().toString();
                // get the currency code only
                String code = option.substring(0, 3);
                System.out.println(code);

            }

        });

        panel.add(countryComboBox);

        frame.add(panel);
        // make the JFrame VISIBILE
        frame.setVisible(true);

        // change the color of the background (NOT WORKING?)
        // frame.setBackground(new Color(0, 0, 0));
        // frame.getContentPane().setBackground(Color.GREEN);
    }

}
