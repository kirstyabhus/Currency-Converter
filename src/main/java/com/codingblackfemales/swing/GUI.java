package com.codingblackfemales.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.border.EmptyBorder;

import com.codingblackfemales.CurrenciesAPI;

public class GUI {

    public GUI() {
        // create a new JFrame with window title
        JFrame frame = new JFrame("Currency Converter");
        // exit out of application when close button clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the size of the frame
        frame.setSize(504, 490);
        // prevent resizing of the frame
        frame.setResizable(false);

        // create a new JPanel to which Swing components can be added to
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.setBorder(new EmptyBorder(20, 80, 20, 80));

        // create heading label
        JLabel headinglabel = new JLabel("Currency Converter");
        headinglabel.setFont(new Font("Verdena", Font.BOLD, 25));

        JLabel logoImageLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon(
                "C:\\Users\\kabhu\\programming-projects\\Currency-Converter\\src\\main\\java\\com\\codingblackfemales\\swing\\img\\logo3.png");
        logoImageLabel.setIcon(logoIcon);
        panel.add(logoImageLabel);

        // change the ICON of the frame/window (top left)
        ImageIcon flagImage = new ImageIcon(
                "C:\\Users\\kabhu\\programming-projects\\Currency-Converter\\src\\main\\java\\com\\codingblackfemales\\swing\\img\\pound_icon.png");
        frame.setIconImage(flagImage.getImage());

        // label for the amount field
        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        // label for the source field
        JLabel fromLabel = new JLabel("From");
        fromLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        // label for the destination field
        JLabel toLabel = new JLabel("To");
        toLabel.setFont(new Font("Verdana", Font.BOLD, 15));

        // Create a JPanel with FlowLayout to left-align the amountLabel
        JPanel amountLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        amountLabelPanel.add(amountLabel);

        // textfield for user amount
        JTextField amountTextField = new JTextField();

        // a space to display error messages
        JLabel errorMessageLabel = new JLabel();

        final String apiKey = "8d246aca316c5a6059a8bd96";

        // bring the available currency codes from the API to this class
        CurrenciesAPI currenciesAPI = new CurrenciesAPI(apiKey);
        ArrayList<String> currenciesList = new ArrayList<String>(currenciesAPI.getCurrencyCodes());
        // convert the ArrayList into an array for the comboBox
        String[] currenciesArray = currenciesList.toArray(new String[currenciesList.size()]);

        // use the currencies array in the JComboBox for SOURCE currencies
        JComboBox<String> sourceComboBox = new JComboBox<>(currenciesArray);
        sourceComboBox.setFont(new Font("Verdana", Font.PLAIN, 15));
        sourceComboBox.setBackground(Color.white);
        // use the currencies array in the JComboBox for DESTINATION currencies
        JComboBox<String> destinationComboBox = new JComboBox<>(currenciesArray);
        destinationComboBox.setFont(new Font("Verdana", Font.PLAIN, 15));
        destinationComboBox.setBackground(Color.white);

        // create a button to switch the currency selections
        ImageIcon switchIcon = new ImageIcon(
                "C:\\Users\\kabhu\\programming-projects\\Currency-Converter\\src\\main\\java\\com\\codingblackfemales\\swing\\img\\switch.png");
        JButton switchButton = new JButton(switchIcon);
        // switch the selected combo box selections, when user clicks the switch button
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

        // create a texfield for output
        JTextField outputField = new JTextField();
        // disable editing of the output field
        outputField.setEditable(false);

        // create a conversion button
        JButton convertButton = new JButton("Convert");
        convertButton.setFont(new Font("Verdana", Font.PLAIN, 13));
        // convert the currency, when the user clicks the convert button
        convertButton.addActionListener(new ActionListener() {

            // clicking the button will take the amount input, source & destination
            // currencies and then push them into the API method to get the converted amount
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // set the errorMessage space to empty
                    errorMessageLabel.setText("");

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
                    errorMessageLabel.setText("Please enter a valid amount.");
                }
            }

        });

        // left align the amount label
        Box leftAmountBox = Box.createHorizontalBox();
        leftAmountBox.add(Box.createHorizontalGlue());
        leftAmountBox.add(amountLabel);
        leftAmountBox.add(Box.createHorizontalGlue());

        // left align the from label
        Box leftFromBox = Box.createHorizontalBox();
        leftFromBox.add(Box.createHorizontalGlue());
        leftFromBox.add(fromLabel);
        leftFromBox.add(Box.createHorizontalGlue());

        // left align the to label
        Box leftToBox = Box.createHorizontalBox();
        leftToBox.add(Box.createHorizontalGlue());
        leftToBox.add(toLabel);
        leftToBox.add(Box.createHorizontalGlue());

        // make all other components centered
        Box logoImageBox = Box.createHorizontalBox();
        logoImageBox.add(Box.createHorizontalGlue());
        logoImageBox.add(logoImageLabel);
        logoImageBox.add(Box.createHorizontalGlue());

        Box switchButtonBox = Box.createHorizontalBox();
        switchButtonBox.add(Box.createHorizontalGlue());
        switchButtonBox.add(switchButton);
        switchButtonBox.add(Box.createHorizontalGlue());

        Box convertButtonBox = Box.createHorizontalBox();
        convertButtonBox.add(Box.createHorizontalGlue());
        convertButtonBox.add(convertButton);
        convertButtonBox.add(Box.createHorizontalGlue());

        // add all the components
        panel.add(logoImageBox);
        // create space between componenets by adding an invisible component
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(leftAmountBox);
        panel.add(amountTextField);
        panel.add(Box.createRigidArea(new Dimension(5, 10)));
        panel.add(errorMessageLabel);
        panel.add(leftFromBox);
        panel.add(sourceComboBox);
        panel.add(Box.createRigidArea(new Dimension(5, 15)));
        panel.add(switchButtonBox);
        panel.add(Box.createRigidArea(new Dimension(5, 10)));
        panel.add(leftToBox);
        panel.add(destinationComboBox);
        panel.add(Box.createRigidArea(new Dimension(5, 20)));
        panel.add(outputField);
        panel.add(Box.createRigidArea(new Dimension(5, 15)));
        panel.add(convertButtonBox);
        panel.add(Box.createRigidArea(new Dimension(5, 10)));
        frame.add(panel);
        panel.add(Box.createRigidArea(new Dimension(5, 20)));

        // make the JFrame VISIBILE
        frame.setVisible(true);

        // change the color of the background (NOT WORKING?)
        // panel.setBackground(new Color(255, 255, 255));
        // frame.getContentPane().setBackground(Color.GREEN);
    }

    public static void main(String[] args) {
        new GUI();
    }

}
