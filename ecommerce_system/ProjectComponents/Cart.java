package ecommerce_system.ProjectComponents;

import java.util.ArrayList;
import java.util.Scanner;

public final class Cart {

    Scanner input = new Scanner(System.in);

    private int CustomerId;
    private static ArrayList<Product> myproducts = new ArrayList();

    public Cart() {
    }

    public Cart(Customer customer) {
        this.CustomerId = customer.GetId();
    }


    // Setter and Getter
    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public static ArrayList<Product> getProducts() {
        return myproducts;
    }

    public void setProducts(ArrayList<Product> setproducts) {
        this.myproducts = setproducts;
    }


    public static void addToCart(int productId, ArrayList<Product> p) {
        Product addThisProduct = null;    // to set the product we need to remove if not found
        boolean found = false;
        for (Product product : p) {
            if (product.GetId() == productId) {
                found = true;
                addThisProduct = product;
                break;
            }
        }
        if (found == false) {
            System.out.println("The product not found..!");
        }
        if (found == true) {
            myproducts.add(addThisProduct);
        }

    }


    public static void removeFromCart(int productId, ArrayList<Product> p) {

        Product removeThisProduct = null;    // to set the product we need to remove if not found
        boolean found = false;
        for (Product product : p) {
            if (product.GetId() == productId) {
                found = true;
                removeThisProduct = product;
                break;
            }
        }
        if (found == false) {
            System.out.println("The product not found..!");
        }
        if (found == true) {
            myproducts.remove(removeThisProduct);
        }

    }

    public static double CalculatePrice() {

        double total = 0;  //TotalPrice


        for (Product pr : myproducts) {
            total += pr.getPrice();
        }

        return total;
    }
}

//    public static boolean PlaceOrder(){
//          
//        System.out.print(" Your total price is $"+CalculatePrice()+" .Would you like to place the order ? 1-Yes 2-No  Enter 1 to continue ");
//        
//         int order;
//        do{
//         order=input.nextInt();
//        
//        if(order!=1 && order!=2) {System.out.print("not acceptable...try again : ");}
//        else if (order==2) {
//            System.out.println("Thanks for your visit sir see you soon");
//            return false;
//        }
//        else {return true;}
//        
//        }while(order!=1 || order!=2);
//        return true;
//    }
//    
                              

       
    


