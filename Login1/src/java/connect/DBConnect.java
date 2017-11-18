/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DBConnect {
    
    public static Connection getConnection(){
        Connection conn = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            String DBurl = "jdbc:mysql://localhost:3306/shopweb";
            conn = DriverManager.getConnection("jdbc:mysql://node15939-thanhnha.kilatiron.com/users","root","MRCvcg83797");
        } catch (Exception e) {
            e.printStackTrace();
        }
         return conn;
    }
    public static void main(String args[]){
        System.out.println(getConnection());
    }
}
