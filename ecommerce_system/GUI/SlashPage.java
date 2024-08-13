package ecommerce_system.GUI;

import ecommerce_system.ProjectComponents.*;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public final class SlashPage extends JFrame {
    // The GUI Component for this page
    private final JLabel lblBackGround, lblGif, lblWelcome;
    private final ImageIcon backGroundImage, gif, icon;
    private final JProgressBar bar;
    // The User
    private Customer customer;
    private Cart cart;
    private Order order;


    public SlashPage(Cart cart, Customer customer, Order order) {

        this.customer = customer;
        this.cart = cart;
        this.order = order;

        // Create JFrame 
        setTitle("Loading: Shop Smarter!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        // Set background
        backGroundImage = new ImageIcon(getClass().getResource("/Icons/pags.jpg"));
        lblBackGround = new JLabel(backGroundImage);
        lblBackGround.setBounds(0, 0, getWidth(), getHeight());
        setContentPane(lblBackGround);

        // Set the icon image for the JFrame
        icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/duck.png")));
        setIconImage(icon.getImage());

        // Set GIF
        gif = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/christmas-shopping.gif")));
        lblGif = new JLabel(gif);
        lblGif.setBounds(300, 80, 300, 225);  // Center the GIF and make it bigger
        add(lblGif);

        // Welcome message
        lblWelcome = new JLabel("Welcome to our Ecommerce_System..., Happy shopping!");
        lblWelcome.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 12));
        lblWelcome.setBounds(330, 400, 375, 25);  // Position above the GIF
        add(lblWelcome);

        // Progress bar
        bar = new JProgressBar();
        bar.setBounds(275, 450, 400, 30);  // Position below the GIF
        bar.setValue(0);
        bar.setStringPainted(true);
        bar.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        bar.setBackground(Color.WHITE);
        bar.setForeground(Color.blue);
        add(bar); // add to the frame

        setVisible(true);  // Set JFrame visibility
        fill();             // fill the progress bar
        dispose();          // close the page

        // Pass the user info to the login page
        new LoginPage(cart, customer, order);

    }  // the end of the constructor


    //A method to fill the progress bar
    public void fill() {
        int progress = 0;
        while (progress <= 100) {
            bar.setValue(progress);

            try {
                Thread.sleep(50);
            }
            catch (InterruptedException e) {
            }
            progress++;
        }
        bar.setString("Done... Let's continue :)");
    }  // the end of the fill method

} // the end of the class
