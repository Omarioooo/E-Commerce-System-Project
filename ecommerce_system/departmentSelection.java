package ecommerce_system;

import ecommerce_system.Departments.*;
import ecommerce_system.ProjectComponents.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static ecommerce_system.ProjectComponents.Cart.CalculatePrice;

public class departmentSelection extends JFrame implements ActionListener {

    // GUI component
    private final JLabel lblBackGround, lblTitle;
    private final ImageIcon backGroundImage, icon;
    private final JButton btnElectronics, btnBooks, btnClothes, btnExit;
    private final Font titleFont;
    // User info
    private Customer customer;
    private Cart cart;
    private Order order;

    public departmentSelection(Cart cart, Customer customer, Order order) {

        this.customer = customer;
        this.cart = cart;
        this.order = order;

        // create the JFrame
        setTitle("Department Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        // Set the icon image for the JFrame
        icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/duck.png")));
        setIconImage(icon.getImage());

        // label choose department
        lblTitle = new JLabel("Choose the department you want to visit :)");
        lblTitle.setBounds(40, 30, 400, 50);  // Set bounds for positioning
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setForeground(Color.BLACK); // Set text color to white
        titleFont = new Font("Comic Sans MS", Font.ITALIC, 18); // Replace "Arial" with the font you want
        lblTitle.setFont(titleFont);
        add(lblTitle);

        // Set the background image
        backGroundImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/bluecart.jpg")));
        lblBackGround = new JLabel(backGroundImage);
        lblBackGround.setBounds(0, 0, 1000, 600);  // Set bounds for positioning
        add(lblBackGround);

        // Create buttons
        btnElectronics = new JButton("electronic");   // Electronic Button
        btnElectronics.addActionListener(this);
        btnElectronics.setFocusPainted(false);
        btnElectronics.setBounds(105, 150, 135, 135);
        btnElectronics.setBackground(Color.WHITE);
        add(btnElectronics);

        btnBooks = new JButton("Books");             // Books Button
        btnBooks.addActionListener(this);
        btnBooks.setFocusPainted(false);
        btnBooks.setBounds(245, 150, 135, 135);
        btnBooks.setBackground(Color.WHITE);
        add(btnBooks);

        btnClothes = new JButton("Clothes");      // Clothes Button
        btnClothes.addActionListener(this);
        btnClothes.setFocusPainted(false);
        btnClothes.setBounds(105, 290, 135, 135);
        btnClothes.setBackground(Color.WHITE);
        add(btnClothes);

        btnExit = new JButton("Exit");         // Ext Button
        btnExit.addActionListener(this);
        btnExit.setFocusPainted(false);
        btnExit.setBounds(245, 290, 135, 135);
        btnExit.setBackground(Color.WHITE);
        add(btnExit);

        // Make the JFrame(department selection page) visible
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        JButton source = (JButton) e.getSource();

        if (source == btnElectronics) {
            new electronecDepartment(cart, customer, order);
            this.setVisible(false);
            dispose();

        } else if (source == btnBooks) {
            new bookDepartment(cart, customer, order);
            this.setVisible(false);

        } else if (source == btnClothes) {
            new clothDepartment(cart, customer, order);
            this.setVisible(false);

        } else if (source == btnExit) {
            if (CalculatePrice() == 0) System.exit(0);

            else {
                int result = JOptionPane.showConfirmDialog(
                        this,
                        "Your total price is $" + CalculatePrice() + ". Would you like to place the order?",
                        "Confirm Order", JOptionPane.YES_NO_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, OrderInfo(cart),
                            "Order summary", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                }

                if (result != JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        }
    }

    // A method to display the order info
    public StringBuilder OrderInfo(Cart cart){

        StringBuilder orderInfo = new StringBuilder("Here is the order summary... \n------------------------------\n")
                .append(" Order ID : ").append(00102)
                .append("\n Customer ID : ").append(customer.GetId())
                .append("\n Products : \n");

        for (Product product : cart.getProducts()) {
            if (product != null) {
                orderInfo.append("Name: ").append(product.GetName()).append("\n")
                        .append("Product ID: ").append(product.GetId()).append("\n")
                        .append("Price: $").append(product.getPrice()).append("\n")
                        .append("--------------\n");
            }
        }

        orderInfo.append(" Total Price: $" + Cart.CalculatePrice());

        return orderInfo;
    }
}

