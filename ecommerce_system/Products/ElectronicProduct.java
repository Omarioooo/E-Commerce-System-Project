package ecommerce_system.Products;

import ecommerce_system.ProjectComponents.Product;

public final class ElectronicProduct extends Product {
    
    private String brand;
    private int warrantyPeriodInMonth;

    public ElectronicProduct() {}

    public ElectronicProduct(String brand, int warrantyPeriodInMonth, int ProductId, String ProdictName, double price) {
        super(ProductId, ProdictName, price);
        this.brand = brand;
        this.warrantyPeriodInMonth = Math.abs(warrantyPeriodInMonth);
    }
    
     public ElectronicProduct(String brand, int warrantyPeriodInMonth, int ProductId, String ProdictName, double price,String path) {
        super(ProductId, ProdictName, price,path);
        this.brand = brand;
        this.warrantyPeriodInMonth = Math.abs(warrantyPeriodInMonth);
    }
    
    
    //Setters and Getters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriodInMonth() {
        return warrantyPeriodInMonth;
    }

    public void setWarrantyPeriodInMonth(int warrantyPeriodInMonth) {
        this.warrantyPeriodInMonth = Math.abs(warrantyPeriodInMonth);
    }
      
}
