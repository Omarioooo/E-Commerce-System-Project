package ecommerce_system.ProjectComponents;

import java.util.ArrayList;
public class  Order {
    
        private int customerId;
        private int orderId=00102;
        private static ArrayList<Product> products = new ArrayList();
        private double totalPrice;
        
    public Order(){}
    
    public Order(int orderId) {
        this.orderId = orderId;
    }

    public Order(int customerId, int orderId, double totalPrice) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }
    
    
    
    
    
    public  void OrderInfo(Cart cart){
        
        System.out.println("Here is the order summary... \n------------------------------\n" 
                              +" Order ID : "+ orderId
                              +"\n Customer ID : "+ cart.getCustomerId()
                              +"\n Products : \n"); 
                     
        for (Product product : cart.getProducts()) {
            if (product != null) {
                
                System.out.println("Name: " + product.GetName());
                System.out.println("Product ID: " + product.GetId());
                System.out.println("Price: $" + product.getPrice());
                System.out.println("--------------");
            }
        }
        System.out.println(" Total Price: $" + cart.CalculatePrice());
    }  
}
