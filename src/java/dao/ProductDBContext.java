/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.SubCategory;

/**
 *
 * @author admin
 */
public class ProductDBContext extends DBContext {

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {

            String sql = "SELECT * FROM [Products]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT \n"
                + "    category_id,\n"
                + "    category_name\n"
                + "    from category ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
                Category c = new Category(rs.getInt(1),rs.getString(2),null, rs.getInt(3),rs.getString(4));
                list.add(c);
            }
        } catch (Exception e) {
        }

        return list;
    }

    public List<Category> getSubCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "    C.category_id,\n"
                + "    C.category_name,\n"
                + "    S.subcategory_id,\n"
                + "    S.subcategory_name\n"
                + "FROM\n"
                + "    Category AS C\n"
                + "INNER JOIN\n"
                + "    Subcategory AS S ON C.category_id = S.category_id;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2), null, rs.getInt(3), rs.getString(4)));
            }
        } catch (Exception e) {
        }

        return list;
    }
    

    public Product getProDuctByID(int productID) {


        String sql = "select *"
                + "from Products p\n"
                + "where p.product_id = ?;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, productID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                //Category cate = new Category(rs.getInt(8), null, null, rs.getInt(7), null);
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setPrice(rs.getDouble(4));
                p.setImage(rs.getString(5));
                p.setStock(rs.getInt(6));
                p.setSubcategoryID(rs.getInt(8));
                p.setCategoryID(rs.getInt(7));

                //p.setCategory(cate);
                return p;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void deleteProduct(String productID) {
        String sql = "delete from Products where product_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, productID);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("deleteProduct:" + e.getMessage());
        }
    }

    public void addProduct(String name, String description, String price, String image, String stock, String categoryID, String subcategoryID, String originID) {
        String sql = "INSERT INTO [dbo].[Products]\n" +
"           ([product_name]\n" +
"           ,[description]\n" +
"           ,[price]\n" +
"           ,[image]\n" +
"           ,[stock_quantity]\n" +
"           ,[category_id]\n" +
"           ,[subcategory_id]\n" +
"           ,[origin_id]\n" +
"            )\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n"  +              
"           )";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, description);
            st.setDouble(3, Double.parseDouble(price));
            st.setString(4, image);
            st.setInt(5, Integer.parseInt(stock));
            st.setInt(6, Integer.parseInt(categoryID));
            st.setInt(7, Integer.parseInt(subcategoryID));
            st.setInt(8, Integer.parseInt(originID));
            
            st.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("addProduct:" + e.getMessage());
            
        }
       
    }

    public void editProduct(String name, String price, String image, String stock, String categoryID, String subcategoryID, int id) {
        String sql = "UPDATE [dbo].[Products]\n" +
                    "   SET [product_name] = ?\n" +
                    "      ,[price] = ?\n" +
                    "      ,[image] = ?\n" +
                    "      ,[stock_quantity] = ?\n" +
                    "      ,[category_id] = ?\n" +
                    "      ,[subcategory_id] = ?\n" +
                    " WHERE product_id = ?;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setDouble(2, Double.parseDouble(price));
            st.setString(3, image);
            st.setString(4, stock);
            st.setInt(5, Integer.parseInt(categoryID));
            st.setInt(6, Integer.parseInt(subcategoryID));
            st.setInt(7, id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("editProduct:" + e.getMessage());
        }
    }

    public List<Product> getListByPage(List<Product> list,
            int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    //dang sua ->>
    public List<Product> getTopSellingProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 3\n"
                + "    P.product_id,\n"
                + "    P.category_id,\n"
                + "    P.product_name,\n"
                + "    P.image,\n"
                + "    P.price,\n"
                + "    P.stock_quantity,\n"
                + "    C.category_name,\n"
                + "    S.subcategory_id,\n"
                + "    S.subcategory_name\n"
                + "FROM\n"
                + "    Products AS P\n"
                + "JOIN\n"
                + "    Category AS C ON P.category_id = C.category_id\n"
                + "JOIN\n"
                + "    Subcategory AS S ON P.subcategory_id = S.subcategory_id\n"
                + "ORDER BY\n"
                + "    P.stock_quantity DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category cate = new Category(rs.getInt(2), rs.getString(7), null, rs.getInt(8), rs.getString(9));
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setCategory(cate);
                p.setName(rs.getString(3));
                p.setImage(rs.getString(4));
                p.setPrice(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                list.add(p);
            }
        } catch (Exception e) {
        }

        return list;
    }

    public List<Product> getProDuctBySubID(String cid) {
        List<Product> list = new ArrayList<>();
        String sql = "select *"
                + "from Products p\n"
                + "where p.category_id = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setPrice(rs.getDouble(4));
                p.setImage(rs.getString(5));
                p.setStock(rs.getInt(6));
                p.setSubcategoryID(rs.getInt(8));
                p.setCategoryID(rs.getInt(7));

                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
        public List<SubCategory> getSubCategory2() {
        List<SubCategory> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "    C.category_id,\n"
                + "    C.category_name,\n"
                + "    S.subcategory_id,\n"
                + "    S.subcategory_name\n"
                + "FROM\n"
                + "    Category AS C\n"
                + "INNER JOIN\n"
                + "    Subcategory AS S ON C.category_id = S.category_id;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SubCategory s = new SubCategory();
                s.setSubcategoryID(rs.getInt("subcategory_id"));
                s.setName(rs.getString("subcategory_name"));
                list.add(s);
            }
        } catch (Exception e) {
        }

        return list;
    }
        public List<Category> getCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "    category_id,\n"
                + "    category_name\n"               
                + "FROM\n"
                + "    Category ";
                
                
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              Category c = new Category();
              c.setCategoryID(rs.getInt("category_id"));
              c.setName(rs.getString("category_name"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        ProductDBContext pdbc = new ProductDBContext();
        System.out.println(pdbc.getCategory());
    }

}
