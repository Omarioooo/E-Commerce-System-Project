package ecommerce_system;

import ecommerce_system.GUI.SlashPage;
import ecommerce_system.ProjectComponents.*;

public class Main {
    public static void main(String[] args) {
         new SlashPage(new Cart(),new Customer(),new Order());
    }
}