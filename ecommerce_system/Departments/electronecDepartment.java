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

public class electronecDepartment extends JFrame implements ActionListener {

    // GUI component
    private final ImageIcon Jicon;
    private final JButton btnAdd, btnRemove, btnStepBack, btnExit;
    // Cart and User info
    private final ArrayList<Product> products;
    private final ArrayList<Product> ElectronecList;
    private final Customer customer;
    private final Cart cart;
    private final Order order;

    public electronecDepartment(Cart cart, Customer customer, Order order) {

        this.customer = customer;
        this.order = order;
        this.cart = cart;

        // Create Electronic products ..
        ElectronicProduct smartphone1 = new ElectronicProduct("Samsung", 18, 1, "A30s ", 7500.0, "/Icons/phone.jpg");
        ElectronicProduct smartphone2 = new ElectronicProduct("Apple", 12, 2, "Iphone X ", 19000.0, "/Icons/phone2.jpg");
        ElectronicProduct smartphone3 = new ElectronicProduct("Oppo", 6, 3, "Oppo Reno12", 9500.0, "/Icons/phone3.jpg");
        ElectronicProduct laptop1 = new ElectronicProduct("Lenovo", 12, 4, "IdeapadGaming3 ", 45000.0, "/Icons/lap1.jpg");
        ElectronicProduct laptop2 = new ElectronicProduct("Lenovo", 12, 5, "Ideapad3 ", 36000.0, "/Icons/lap2.jpg");
        ElectronicProduct laptop3 = new ElectronicProduct("Lenovo", 24, 6, "Mac pro 14 ", 125000.0, "/Icons/lap3.jpg");
        ElectronicProduct Airbods1 = new ElectronicProduct("Apple", 6, 7, "Airbods pro", 4500.0, "/Icons/air1.jpg");
        ElectronicProduct Airbods2 = new ElectronicProduct("Reco", 6, 8, "SoundPEATS Air3 ", 700.0, "/Icons/air2.jpg");
        ElectronicProduct Airbods3 = new ElectronicProduct("Haiford", 6, 9, "Tozo A3 ", 850.0, "/Icons/air3.jpg");
        ElectronicProduct SmartWatch1 = new ElectronicProduct("Apple", 18, 10, "Apple WatchAltra ", 9500.0, "/Icons/watch1.jpg");
        ElectronicProduct SmartWatch2 = new ElectronicProduct("Samsung", 12, 11, "Galaxy WhatchPro ", 11500.0, "/Icons/watch2.jpg");
        ElectronicProduct SmartWatch3 = new ElectronicProduct("Tozo", 12, 12, "TOZO pro ", 5500.0, "/Icons/watch3.jpg");
        ElectronicProduct SmartTV1 = new ElectronicProduct("Amazon", 18, 13, "Amazon fire ", 55000.0, "/Icons/tv1.jpg");
        ElectronicProduct SmartTV2 = new ElectronicProduct("Samsung", 12, 14, "Class Quard ", 45000.0, "/Icons/tv2.jpg");
        ElectronicProduct SmartTV3 = new ElectronicProduct("LG", 12, 15, "LG evo pro ", 39500.0, "/Icons/tv3.jpg");
        ElectronicProduct Pc1 = new ElectronicProduct("Dell", 18, 16, "dell 9 pro", 45000.0, "/Icons/pc1.jpg");
        ElectronicProduct Pc2 = new ElectronicProduct("ِApple", 12, 17, "APPLE MAC", 120000.0, "/Icons/pc2.jpg");
        ElectronicProduct Pc3 = new ElectronicProduct("Microsoft", 12, 18, "microsoft dos", 50000.0, "/Icons/pc3.jpg");

        // arraylist with the info of each Obj(electronic)
        ElectronecList = new ArrayList<>(Arrays.asList(
                smartphone1, smartphone2, smartphone3, laptop1, laptop2, laptop3,
                Airbods1, Airbods2, Airbods3, SmartWatch1, SmartWatch2, SmartWatch3,
                SmartTV1, SmartTV2, SmartTV3, Pc1, Pc2, Pc3
        ));

        this.products = ElectronecList;

        // Create Buttons
        btnAdd = new JButton("Add To Cart");
        btnRemove = new JButton("Remove From Cart");
        btnStepBack = new JButton("Step Back");
        btnExit = new JButton("Eixt");
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

    }  // the end of the constructor


    private void displayProducts() {
        JPanel panel = new JPanel(new GridLayout(0, 3, 12, 12));
        Font font = new Font("Comic Sans MS", Font.ITALIC, 11);

        for (Product product : products) {
            JToggleButton btnProduct = new JToggleButton(product.GetName());
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
            int Id = Integer.valueOf(JOptionPane.showInputDialog("Plz enter the ID of the product you want to add.. :)"));
            Cart.addToCart(Id, ElectronecList);
        } else if (e.getSource() == btnRemove) {
            int Id = Integer.valueOf(JOptionPane.showInputDialog("Plz enter the ID of the product you want to add.. :)"));
            Cart.removeFromCart(Id, ElectronecList);
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

    }  // the end of action lisentner


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