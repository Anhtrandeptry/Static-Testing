/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Category {
    int categoryID;
    String name;
    String description;
    int subcategoryID;
    String subname;

    public Category() {
    }

    public Category(int categoryID, String name, String description, int subcategoryID, String subname) {
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.subcategoryID = subcategoryID;
        this.subname = subname;
    }

    public Category(String name, String subname) {
        this.name = name;
        this.subname = subname;
    }
    

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
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

    public int getSubcategoryID() {
        return subcategoryID;
    }

    public void setSubcategoryID(int subcategoryID) {
        this.subcategoryID = subcategoryID;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryID=" + categoryID + ", categoryName=" + name + ", cid=" + subcategoryID + ", describe=" + subname + '}';
    }

 
   

    
    
    
    
}
