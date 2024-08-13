package ecommerce_system.ProjectComponents;

import ecommerce_system.Info;

public final class Customer implements Info {
    
      private int CustomerId;
      private String CustomerName;
      private String address;

    public Customer() {}
    
     public Customer(String CustomerName, int CustomerId, String address) {
        this.CustomerId = CustomerId;
        this.CustomerName = CustomerName;
        this.address = address;
    }

    public Customer(int CustomerId, String CustomerName, String address) {
        this.CustomerId = Math.abs(CustomerId);
        this.CustomerName = CustomerName;
        this.address = address;
    }

    @Override
    public void SetId(int id) {
        this.CustomerId=Math.abs(id);
    }

    @Override
    public int GetId() {
       return this.CustomerId;
    }

    @Override
    public void SetName(String name) {
        this.CustomerName=name;
    }

    @Override
    public String GetName() {
       return this.CustomerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
   
}
