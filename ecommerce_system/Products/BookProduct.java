package ecommerce_system.Products;

import ecommerce_system.ProjectComponents.Product;

public final class BookProduct extends Product {
    
    private String authore;
    private String publisher;

    public BookProduct() {}

    public BookProduct(String authore, String publisher, int ProductId, String ProdictName, double price) {
        super(ProductId, ProdictName, price );
        this.authore = authore;
        this.publisher = publisher;
    }

     public BookProduct(String authore, String publisher, int ProductId, String ProdictName, double price,String path) {
        super(ProductId, ProdictName, price , path);
        this.authore = authore;
        this.publisher = publisher;
    }
    
    // Setters and Getters
    public String getAuthore() {
        return authore;
    }

    public void setAuthore(String authore) {
        this.authore = authore;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    
}
