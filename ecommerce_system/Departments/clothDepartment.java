package ecommerce_system.Departments;

import ecommerce_system.*;
import ecommerce_system.Products.*;
import ecommerce_system.ProjectComponents.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class clothDepartment extends JFrame implements ActionListener {

    // GUI component
    private final ImageIcon Jicon;
    private final JButton btnAdd, btnRemove, btnStepBack, btnExit;
    //Cart and User info
    private final ArrayList<Product> products;
    private ArrayList<Product> ClothesList;
    private final Customer customer;
    private final Cart cart;
    private final Order order;

    public clothDepartment(Cart cart, Customer customer, Order order) {

        this.cart = cart;
        this.customer = customer;
        this.order = order;


        // Cloth products
        ClothingProduct clothes1 = new ClothingProduct(44, "cotton", 47, "T-shirt", 380.50, "/Icons/cloth1.jpg");
        ClothingProduct clothes2 = new ClothingProduct(44, "cotton", 48, "shirt", 480.0, "/Icons/cloth2.jpg");
        ClothingProduct clothes3 = new ClothingProduct(46, "blastic", 49, "snekers", 420.50, "/Icons/cloth3.jpg");
        ClothingProduct clothes4 = new ClothingProduct(46, "blastic", 50, "Slipers", 120.00, "/Icons/cloth4.jpg");
        ClothingProduct clothes5 = new ClothingProduct(39, "genes", 51, "pantes", 550.0, "/Icons/cloth5.jpg");
        ClothingProduct clothes6 = new ClothingProduct(46, "blastic", 52, "Sweet pantes", 150.00, "/Icons/cloth6.jpg");
        ClothingProduct clothes7 = new ClothingProduct(40, "genes", 53, "Short", 190.0, "/Icons/cloth7.jpg");
        ClothingProduct clothes8 = new ClothingProduct(32, "genes", 54, "dress", 550.0, "/Icons/cloth8.jpg");
        ClothingProduct clothes9 = new ClothingProduct(29, "genes", 56, "Gloves", 65.0, "/Icons/cloth9.jpg");
        ClothingProduct clothes10 = new ClothingProduct(29, "genes", 55, "Cap", 85.0, "/Icons/cloth10.jpg");
        ClothingProduct clothes11 = new ClothingProduct(29, "genes", 57, "Skirt", 85.0, "/Icons/cloth11.jpg");
        ClothingProduct clothes12 = new ClothingProduct(29, "genes", 57, "Jacket", 85.0, "/Icons/cloth12.jpg");


        // to show the customer there products in this departement
        ArrayList<Product> clothesList = new ArrayList<>(Arrays.asList(clothes1, clothes2, clothes3, clothes4, clothes5, clothes6, clothes7, clothes8, clothes9, clothes10, clothes11, clothes12));

        this.products = clothesList;


        // Create Buttons
        btnAdd = new JButton("Add To Cart");
        btnRemove = new JButton("Remove From Cart");
        btnStepBack = new JButton("Step Back");
        btnExit = new JButton("Exit");
        btnAdd.setFocusPainted(false);
        btnRemove.setFocusPainted(false);
        btnStepBack.setFocusPainted(false);
        btnExit.setFocusPainted(false);

        setTitle("Electronics Department");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        // Set the icon image for the JFrame
        Jicon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/duck.png")));
        setIconImage(Jicon.getImage());

        displayProducts();

        // Add buttons panel to the frame at the bottom
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(btnAdd);
        btnPanel.add(btnRemove);
        btnPanel.add(btnStepBack);
        btnPanel.add(btnExit);

        // add action listener
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnStepBack.addActionListener(this);
        btnExit.addActionListener(this);


        setVisible(true);
        add(btnPanel, BorderLayout.SOUTH);

    }   // the end of the constructor

    private void displayProducts() {
        JPanel panel = new JPanel(new GridLayout(0, 3, 12, 12));
        Font font = new Font("Comic Sans MS", Font.ITALIC, 11);

        for (Product product : products) {
            JButton btnProduct = new JButton(product.GetName());
            btnProduct.setFont(font);

            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(product.getImagePath())));
            Image scaledImage = icon.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
            btnProduct.setIcon(new ImageIcon(scaledImage));

            btnProduct.setPreferredSize(new Dimension(140, 130));
            btnProduct.setVerticalTextPosition(JButton.BOTTOM);
            btnProduct.setHorizontalTextPosition(JButton.CENTER);
            btnProduct.setFocusPainted(false);

            String tooltipText = product.getPrice() + " $" + " ,,ID: " + product.GetId();
            btnProduct.setToolTipText(tooltipText);

            panel.add(btnProduct);
        }   // the end of the loop that creates the buttons 

        JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ToolTipManager.sharedInstance().setInitialDelay(0);
        ToolTipManager.sharedInstance().setDismissDelay(500);

        add(scrollPane, BorderLayout.EAST);
        revalidate();
        repaint();


    } // the end of the method

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            int Id = Integer.parseInt(JOptionPane.showInputDialog("Plz enter the ID of the product you want to add.. :)"));
            Cart.addToCart(Id, ClothesList);
        } else if (e.getSource() == btnRemove) {
            int Id = Integer.parseInt(JOptionPane.showInputDialog("Plz enter the ID of the product you want to add.. :)"));
            Cart.removeFromCart(Id, ClothesList);
        } else if (e.getSource() == btnStepBack) {
            new departmentSelection(cart, customer, order);
            dispose(); // Close the current window
        } else if (e.getSource() == btnExit) {
            if (Cart.CalculatePrice() == 0) {
                System.exit(0);
            }    // if the cart is empty

            else    // if the cart is not empty
            {
                int result = JOptionPane.showConfirmDialog(
                        this,
                        "Your total price is $" + Cart.CalculatePrice() + ". Would you like to place the order?",
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

    }  // the end of action listener

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

}  // the end of the class