package com.codingblackfemales.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.codingblackfemales.CurrenciesAPI;

// TODO separate this code into methods & make the layout cleaner
public class GUI {

    public GUI() {
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
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // create heading label & add it to the panel
        JLabel headinglabel = new JLabel("Currency Converter");
        headinglabel.setFont(new Font("Verdana", Font.BOLD, 20));
        panel.add(headinglabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        // change the ICON of the frame/window (top left)
        ImageIcon flagImage = new ImageIcon(
                "C:\\Users\\kabhu\\programming-projects\\Currency-Converter\\src\\main\\java\\com\\codingblackfemales\\swing\\img\\pound_icon.png");
        frame.setIconImage(flagImage.getImage());

        // label for the amount field
        JLabel amountLabel = new JLabel("Enter an amount:");
        amountLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        panel.add(amountLabel);
        // textfield for user amount
        JTextField amountTextField = new JTextField();
        panel.add(amountTextField);
        // a space to display error messages
        JLabel errorMessage = new JLabel();
        panel.add(errorMessage);

        // adding our currency codes from the API (in other file) to this class
        final String apiKey = "8d246aca316c5a6059a8bd96";
        CurrenciesAPI currenciesAPI = new CurrenciesAPI(apiKey);
        ArrayList<String> currenciesList = new ArrayList<String>(currenciesAPI.getCurrencyCodes());
        // convert the ArrayList into an array
        String[] currenciesArray = currenciesList.toArray(new String[currenciesList.size()]);

        // use the currencies array in the JComboBox for SOURCE currencies
        JComboBox<String> sourceComboBox = new JComboBox<>(currenciesArray);
        sourceComboBox.setFont(new Font("Verdana", Font.PLAIN, 15));
        // use the currencies array in the JComboBox for DESTINATION currencies
        JComboBox<String> destinationComboBox = new JComboBox<>(currenciesArray);
        destinationComboBox.setFont(new Font("Verdana", Font.PLAIN, 15));

        // add button to switch the currencies
        ImageIcon switchIcon = new ImageIcon(
                "C:\\Users\\kabhu\\programming-projects\\Currency-Converter\\src\\main\\java\\com\\codingblackfemales\\swing\\img\\switch.png");
        JButton switchButton = new JButton(switchIcon);
        // switch the selected combo box selections
        switchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // get the selections
                String sourceSelection = sourceComboBox.getSelectedItem().toString();
                String destinationSelection = destinationComboBox.getSelectedItem().toString();

                // swap the selected items
                sourceComboBox.setSelectedItem(destinationSelection);
                destinationComboBox.setSelectedItem(sourceSelection);
            }

        });

        // add the currency combo boxes, with the arrow between them
        panel.add(sourceComboBox);
        panel.add(switchButton);
        // panel.add(imageLabel);
        panel.add(destinationComboBox);

        // add a texfield for output
        JTextField outputField = new JTextField();
        // one way conversion via input fields
        outputField.setEditable(false);
        panel.add(outputField);

        // add a conversion button
        JButton convertButton = new JButton("convert");
        convertButton.addActionListener(new ActionListener() {

            // clicking the button will take the amount input, source & destination currency
            // conversion and then push them into the API method to get converted amount
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // set the errorMessage space to empty
                    errorMessage.setText("");

                    // get the amount, source code and destination code from the user
                    // selections/inputs
                    double amount = Double.valueOf(amountTextField.getText().toString());
                    String sourceCode = sourceComboBox.getSelectedItem().toString().substring(0, 3);
                    String destinationCode = destinationComboBox.getSelectedItem().toString().substring(0, 3);

                    // convert the amount using the API method with user selections/input
                    double convertedAmount = currenciesAPI.getCurrencyConversionA(sourceCode, destinationCode, amount);

                    // display the converted amount in the output field
                    outputField.setText(String.valueOf(convertedAmount));
                } catch (NumberFormatException ex) {
                    // if user input is not a number, display the message
                    errorMessage.setText("Invalid input. Please enter a valid amount.");
                }
            }

        });
        panel.add(convertButton);

        // Container contentPane = frame.getContentPane();

        frame.add(panel);
        // make the JFrame VISIBILE
        frame.setVisible(true);

        // change the color of the background (NOT WORKING?)
        // frame.setBackground(new Color(0, 0, 0));
        // frame.getContentPane().setBackground(Color.GREEN);
    }

    public static void main(String[] args) {
        new GUI();
    }

}
