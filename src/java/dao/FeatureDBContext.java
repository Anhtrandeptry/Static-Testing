/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Feature;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class FeatureDBContext extends DBContext {

    public List<Feature> getFeatureByUrl(String url,User user) {
        List<Feature> list = new ArrayList<>();
        String sql = "SELECT pf.[fid]\n"
                + "      ,[url]\n"
                + "  FROM [FeatureUrl] fu JOIN PermissionsFeatureUrl pf on fu.fid = pf.fid\n"
                + "					   JOIN [Permissions] p on pf.pid = p.permission_id\n"
                + "	WHERE [url] = ? AND p.permission_id = ?";
        try(PreparedStatement stm = connection.prepareStatement(sql)) {
            
            stm.setString(1, url);
            stm.setInt(2, user.getPermissionID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Feature f = new Feature();
                f.setPid(rs.getInt("fid"));
                f.setUrl(rs.getString("url"));
                list.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeatureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
