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


public final class bookDepartment extends JFrame implements ActionListener {


    // GUI
    private final ImageIcon Jicon;
    private final JButton btnAdd, btnRemove, btnStepBack, btnExit;
    private final ArrayList<Product> BooksList;
    // Cart and User info
    private final ArrayList<Product> products;
    private final Customer customer;
    private final Cart cart;
    private final Order order;

    public bookDepartment(Cart cart, Customer customer, Order order) {

        this.cart = cart;
        this.customer = customer;
        this.order = order;

        // Books products
        BookProduct book1 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 22, "Code Chef", 220.0, "/Icons/book1.jpg");
        BookProduct book2 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 23, "Byte by Byte", 275.0, "/Icons/book2.jpg");
        BookProduct book3 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 24, "Big java", 250.0, "/Icons/book3.jpg");
        BookProduct book4 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 25, "OOP", 235.0, "/Icons/book4.jpg");
        BookProduct book5 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 26, "How to programe", 2150.0, "/Icons/book5.jpg");
        BookProduct book6 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 27, "This is java", 275.0, "/Icons/book6.jpg");
        BookProduct book7 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 28, "Java SE", 255.0, "/Icons/book7.jpg");
        BookProduct book8 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 29, "Code wars", 205.0, "/Icons/book8.jpg");
        BookProduct book9 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 30, "Python Crash Course", 409.0, "/Icons/book9.jpg");
        BookProduct book10 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 31, "Dynamic programming", 276.0, "/Icons/book10.jpg");
        BookProduct book11 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 32, "Make java easy", 228.0, "/Icons/book11.jpg");
        BookProduct book12 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 33, "Introduction to c++", 460.0, "/Icons/book12.jpg");
        BookProduct book13 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 34, "Java Recipes for Success", 270.0, "/Icons/book13.jpg");
        BookProduct book14 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 35, "Code Complete", 210.0, "/Icons/book14.jpg");
        BookProduct book15 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 36, "Effective Java", 195.0, "/Icons/book15.jpg");
        BookProduct book16 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 37, "The Pragmatic Programme", 175.0, "/Icons/book16.jpg");
        BookProduct book17 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 38, "Learning programe", 260.0, "/Icons/book17.jpg");
        BookProduct book18 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 40, "play with paython", 280.0, "/Icons/book18.jpg");
        BookProduct book19 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 41, "Mr Code", 320.0, "/Icons/book19.jpg");
        BookProduct book20 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 42, "Fight with java", 275.0, "/Icons/book20.jpg");
        BookProduct book21 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 43, "Design Patterns", 390.0, "/Icons/book21.jpg");
        BookProduct book22 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 44, "Good programer", 200.0, "/Icons/book22.jpg");
        BookProduct book23 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 45, "Head First Java", 420.0, "/Icons/book23.jpg");
        BookProduct book24 = new BookProduct("Dr.Mohmoud Gamal", "Omaarioo for reading", 46, "advanced Java", 375.0, "/Icons/book24.jpg");

        // to show the customer there products in this department
        BooksList = new ArrayList<>(Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10, book11, book12, book13, book14, book15, book16, book17, book18, book19, book20, book21, book22, book23, book24));

        this.products = BooksList;

        // Create Buttons
        btnAdd = new JButton("Add To Cart");
        btnRemove = new JButton("Remove From Cart");
        btnStepBack = new JButton("Step Back");
        btnExit = new JButton("Exit");
        btnAdd.setFocusPainted(false);
        btnRemove.setFocusPainted(false);
        btnStepBack.setFocusPainted(false);
        btnExit.setFocusPainted(false);

        setTitle("Books Department");
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

        // JFrame setting
        add(btnPanel, BorderLayout.SOUTH);
        setVisible(true);

    }   // the end of the constructor

    // A method to display the products
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
            Cart.addToCart(Id, BooksList);
        } else if (e.getSource() == btnRemove) {
            int Id = Integer.parseInt(JOptionPane.showInputDialog("Plz enter the ID of the product you want to add.. :)"));
            Cart.removeFromCart(Id, BooksList);
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


    public StringBuilder OrderInfo(Cart cart) {

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