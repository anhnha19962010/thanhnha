/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Users;
import tools.MD5;

/**
 *
 * @author Admin
 */
public class UsersServlet extends HttpServlet {

    
    UsersDAO userdao = new UsersDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String command = request.getParameter("command");
       String url = "";
       HttpSession session = request.getSession();
       switch (command){
           case "insert":
               Users users = new Users();
               users.setUserID(new java.util.Date().getTime());
               users.setUserName(request.getParameter("username"));
               users.setUserPass(request.getParameter(("password")));
               users.setUserRole(false);
               userdao.insertUsers(users);
               session.setAttribute("user",users);
               url = "/index.jsp";
               break;
               
           case "login":
               users = userdao.login(request.getParameter("username"), request.getParameter("password"));
               if(users != null){
                   session.setAttribute("user", users);
                   url = "/index.jsp";
               }else{
                   request.setAttribute("error","error user or password" );
                    url = "/login.jsp";
               }
       }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

   
   
}
