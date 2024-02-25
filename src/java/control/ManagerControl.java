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

/**
 *
 * @author admin
 */
//public class ManagerControl extends BaseAthorizationController{
public class ManagerControl extends BaseAthorizationController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, User user, List<Feature> features) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        ProductDBContext p = new ProductDBContext();
        List<Product> listP = p.getAll();
        List<Category> listC = p.getCategory();
        List<SubCategory> listSC = p.getSubCategory2();

        req.setAttribute("listP", listP);
        req.setAttribute("listC", listC);
        req.setAttribute("listCC", listSC);

        req.getRequestDispatcher("ManagerProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, User user, List<Feature> features) throws ServletException, IOException {
    }

}
