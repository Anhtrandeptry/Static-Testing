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
import model.Category;
import model.Feature;
import model.Product;
import model.SubCategory;
import model.User;

public class AddControl extends BaseAthorizationController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, User user, List<Feature> features) throws ServletException, IOException {
        ProductDBContext p = new ProductDBContext();
        List<Category> data2 = p.getCategory();
        List<SubCategory> data = p.getSubCategory2();
        req.setAttribute("data2", data2);
        req.setAttribute("data", data);
        req.getRequestDispatcher("addProduct.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, User user, List<Feature> features) throws ServletException, IOException {
        String name = req.getParameter("productName");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        String image = req.getParameter("image");
        String stock = req.getParameter("stock");
        String categoryID = req.getParameter("categoryID");
        String subcategoryID = req.getParameter("subcategoryID");
        String originID = req.getParameter("originID");
        ProductDBContext p = new ProductDBContext();
        if (name == "") {
            
            List<Category> data2 = p.getCategory();
            List<SubCategory> data = p.getSubCategory2();
            req.setAttribute("data2", data2);
            req.setAttribute("data", data);
            req.setAttribute("mess", "hehe");
            req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
        } else {
            p.addProduct(name, description, price, image, stock, categoryID, subcategoryID, originID);
            resp.sendRedirect("manager");
        }


    }
}
