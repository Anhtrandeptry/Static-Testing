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
import java.util.List;
import model.Feature;
import model.User;

/**
 *
 * @author admin
 */
public class DeleteControl extends BaseAthorizationController {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp, User user, List<Feature> features) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        ProductDBContext p = new ProductDBContext();
        p.deleteProduct(pid);
        resp.sendRedirect("manager");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp, User user, List<Feature> features) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
