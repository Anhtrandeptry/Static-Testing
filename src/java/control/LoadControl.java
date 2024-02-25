/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
public class LoadControl extends BaseAthorizationController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, User user, List<Feature> features) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String productID = req.getParameter("pid");
        System.out.println(productID);
        ProductDBContext pdbc = new ProductDBContext();
        Product p = pdbc.getProDuctByID(Integer.parseInt(productID));
        List<Category> listCC = pdbc.getCategory();
        req.setAttribute("detail", p);
        req.setAttribute("listCC", listCC);
        List<SubCategory> list = pdbc.getSubCategory2();
        req.setAttribute("listsub", list);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, User user, List<Feature> features) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
