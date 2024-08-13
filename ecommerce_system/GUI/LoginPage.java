package ecommerce_system.GUI;

import ecommerce_system.ProjectComponents.*;
import ecommerce_system.departmentSelection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginPage extends JFrame {

    // The GUI Component for this page
    private final JTextField txtusername, txtuserID, txtuserAddress;
    private final JLabel lblusername, lbluserID, lbluserAddress, lblBackGround;
    private final JButton btnsingin, btncancel;
    private final ImageIcon backgroundImage, icon;
    // The user info
    private Customer customer;
    private Cart cart;
    private Order order;

    public LoginPage(Cart cart, Customer customer, Order order) {

        this.customer = customer;
        this.cart = cart;
        this.order=order;

        //Create JFrame
        setTitle("Market Login: Shop Smarter!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(null);


        // Set backGround in a label contain the backGround
        backgroundImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/logInBackGround.png")));
        lblBackGround = new JLabel(backgroundImage);
        lblBackGround.setBounds(0, 0, getWidth(), getHeight());
        setContentPane(lblBackGround);

        // Set the icon image for the JFrame
        icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/duck.png")));
        setIconImage(icon.getImage());


        // create the fields
        lblusername = new JLabel("Name :");
        txtusername = new JTextField();
        lblusername.setBounds(630, 125, 75, 25);
        txtusername.setBounds(700, 125, 205, 25);
        add(lblusername);
        add(txtusername);

        lbluserID = new JLabel("ID :");
        txtuserID = new JTextField();
        lbluserID.setBounds(630, 175, 75, 25);
        txtuserID.setBounds(700, 175, 205, 25);
        add(lbluserID);
        add(txtuserID);

        lbluserAddress = new JLabel("Address :");
        txtuserAddress = new JTextField();
        lbluserAddress.setBounds(630, 225, 75, 25);
        txtuserAddress.setBounds(700, 225, 205, 25);
        add(lbluserAddress);
        add(txtuserAddress);

        // Create continue button
        btnsingin = new JButton("Continue");
        btnsingin.setFocusPainted(false);
        btnsingin.setBounds(705, 275, 95, 25);
        add(btnsingin);

        // Create cancel button
        btncancel = new JButton("Cancel");
        btncancel.setFocusPainted(false);
        btncancel.setBounds(805, 275, 95, 25);
        add(btncancel);

        //Set JFrame visibility
        setVisible(true);

        // buttons action
        // Using anonymises inner classes
        btnsingin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtusername.getText().isEmpty() || txtuserID.getText().isEmpty() || txtuserAddress.getText().isEmpty()) {
                    JOptionPane optionPane = new JOptionPane("Please fill in all fields.", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, icon, new Object[]{}, null);
                    JDialog dialog = optionPane.createDialog("Warning");

                    // Remove focus border from the default OK button
                    for (Component component : optionPane.getComponents()) {
                        if (component instanceof JButton) {
                            ((JButton) component).setFocusPainted(false);
                        }
                    }
                    dialog.setVisible(true);

                    clearFields(); // Clear text fields if something wrong
                } else if (!txtuserID.getText().matches("^\\d{8}$")) {
                    showErrorDialog();   // call the method
                    clearFields();   // Clear text fields if something wrong
                } else {  // if there is no problem continue and save the date in customerObj

                    Customer customer = new Customer(txtusername.getText(), Integer.parseInt(txtuserID.getText()), txtuserAddress.getText());
                    dispose();
                    new departmentSelection(cart, customer, order);
                }

            }   // the end of the actionPerformed
        });  // the end of the actionListener


        // to cancel the program
        btncancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }   // the end of the actionPerformed
        });  // the end of the actionListener

    }  // the end of the constructor


    // Send an error if wrong id
    private void showErrorDialog() {
        JOptionPane optionPane = new JOptionPane("Wrong ID", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, icon, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Warning");

        // Remove focus border from the default OK button
        for (Component component : optionPane.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).setFocusPainted(false);
            }
        }

        dialog.setVisible(true);
    } // the end of id error method


    // clearFields if there is wrong input
    private void clearFields() {
        txtusername.setText("");
        txtuserID.setText("");
        txtuserAddress.setText("");
    } // the end of clear method


    // A function that return the customerObj that collect the data from the user inputs
    public Customer getCustomer() {
        return new Customer(txtusername.getText(), Integer.parseInt(txtuserID.getText()), txtuserAddress.getText());
    } // the end of the getCustomer function

} // the end of the class


