package ecommerce_system.ProjectComponents;

import ecommerce_system.Info;

public abstract class Product implements Info {
    
    protected int ProductId;
    protected String ProductName;
    protected double price;
    protected String imagePath;
   
    public Product() {}

    public Product(int ProductId, String ProdictName, double price) {
        this.ProductId = ProductId;
        this.ProductName = ProdictName;
        this.price = price;
    }
    
    public Product(int ProductId, String ProdictName, double price , String path) {
        this.ProductId = ProductId;
        this.ProductName = ProdictName;
        this.price = price;
        this.imagePath= path;
    }
    
    
    // Setters and getters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void SetId(int id){
        this.ProductId=Math.abs(id);
    }
    
    @Override
    public int GetId(){
       return ProductId; 
    }
    
     @Override
    public void SetName(String name){
        this.ProductName=name;
    }
    
    @Override
    public String GetName(){
       return ProductName; 
    }

    public String getImagePath() {
        return imagePath;
    }

}
