/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.ProductDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Feature;
import model.SubCategory;
import model.User;

/**
 *
 * @author admin
 */
public class EditControl extends BaseAthorizationController{
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, User user, List<Feature> features) throws ServletException, IOException {
    }
@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, User user, List<Feature> features) throws ServletException, IOException {
        String name = req.getParameter("productName");
        String description =req.getParameter("description");
        String price = req.getParameter("price");
        String image = req.getParameter("image");        
        String stock = req.getParameter("stock");
        String categoryID = req.getParameter("categoryID"); 
        String subcategoryID= req.getParameter("subcategoryID");
        String originID= req.getParameter("originID");
        String id = req.getParameter("id");
        System.out.println(name + description + price + image + stock + categoryID + subcategoryID + originID + id);
        ProductDBContext p =new ProductDBContext();
        p.editProduct(name, price, image, stock, categoryID, subcategoryID, Integer.parseInt(id));
        resp.sendRedirect("manager");
    }
    
}
