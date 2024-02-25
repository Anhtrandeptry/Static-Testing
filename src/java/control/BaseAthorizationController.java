/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.FeatureDBContext;
import model.Feature;
import model.User;
import control.BaseRequiredAuthentication;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author admin
 */
public abstract class BaseAthorizationController extends BaseRequiredAuthentication {

    public boolean isAuthorized(User user, String url) {
        FeatureDBContext fdbc = new FeatureDBContext();
        List<Feature> features = fdbc.getFeatureByUrl(url, user);
        return !features.isEmpty();
    }

    private List<Feature> getFeatures(String url, User user) {
        FeatureDBContext fdbc = new FeatureDBContext();
        return fdbc.getFeatureByUrl(url, user);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        if (isAuthorized(user, req.getServletPath())) {
            doGet(req, resp, user, getFeatures(req.getServletPath(), user));
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        if (isAuthorized(user, req.getServletPath())) {
            doPost(req, resp, user, getFeatures(req.getServletPath(), user));
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp, User user, List<Feature> features) throws ServletException, IOException;

    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp, User user, List<Feature> features) throws ServletException, IOException;
}
