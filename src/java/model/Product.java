/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Product {
    int productID;
    String name, description;
    Double price;
    String image;
    int stock, categoryID, subcategoryID, originID;
   

    
    private Category category;

    public Product() {
    }

    public Product(int productID, String name, String description, Double price, String image, int stock, int categoryID, int subcategoryID, int originID, Category category) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.stock = stock;
        this.categoryID = categoryID;
        this.subcategoryID = subcategoryID;
        this.originID = originID;
        this.category = category;
    }

    public Product(int productID, String name, String description, Double price, String image, int stock, int categoryID, int subcategoryID, int originID) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.stock = stock;
        this.categoryID = categoryID;
        this.subcategoryID = subcategoryID;
        this.originID = originID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getSubcategoryID() {
        return subcategoryID;
    }

    public void setSubcategoryID(int subcategoryID) {
        this.subcategoryID = subcategoryID;
    }

    public int getOriginID() {
        return originID;
    }

    public void setOriginID(int originID) {
        this.originID = originID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", categoryID=" + categoryID + ", productName=" + name + ", image=" + image + ", price=" + price + ", quantity=" + stock + ", categories=" + category + '}';
    }

    
    
    
    
    
}
