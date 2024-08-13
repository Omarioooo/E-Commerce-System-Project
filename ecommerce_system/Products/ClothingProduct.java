package ecommerce_system.Products;

import ecommerce_system.ProjectComponents.Product;

public final class ClothingProduct extends Product {
    
    private int Size;
    private String fabric;

    public ClothingProduct() {}

    public ClothingProduct(int Size, String fabric, int ProductId, String ProdictName, double price) {
        super(ProductId, ProdictName, price);
        this.Size = Math.abs(Size);
        this.fabric = fabric;
    }

     public ClothingProduct(int Size, String fabric, int ProductId, String ProdictName, double price , String path) {
        super(ProductId, ProdictName, price , path);
        this.Size = Math.abs(Size);
        this.fabric = fabric;
    }

    
    //Settres and Getters
    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Math.abs(Size);
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }
  
    
}
