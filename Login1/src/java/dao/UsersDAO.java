/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Users;

/**
 *
 * @author Admin
 */
public class UsersDAO {
    public boolean insertUsers(Users u){
        Connection  connection = DBConnect.getConnection();
        String sql = "INSERT INTO users VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1,u.getUserID());
            ps.setString(2,u.getUserName());
            ps.setString(3, u.getUserPass());
            ps.setBoolean(4,u.isUserRole());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    

public Users login(String username, String password) {
	Connection con = DBConnect.getConnection();
	String sql = "select * from users where user_name='" + username + "' and user_pass='" + password + "'";
	PreparedStatement ps;
	try {
		ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
                    Users u = new Users();
                    u.setUserID(rs.getLong("user_id"));
                    u.setUserName(rs.getString("user_name"));
                    u.setUserPass(rs.getString("user_pass"));
                    u.setUserRole(rs.getBoolean("user_role"));
			con.close();
			return u;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

}