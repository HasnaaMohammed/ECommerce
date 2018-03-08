/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;
import com.google.gson.Gson;
import controller.user.AdminViewCustomersController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.beans.User;



/**
 *
 * @author Asmaa
 */
@WebServlet(name = "ViewCustomersServlet", urlPatterns = {"/ViewCustomersServlet"})
public class ViewCustomersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        AdminViewCustomersController adminViewCustomersController=new AdminViewCustomersController();
        Vector<User> users=adminViewCustomersController.getCustomerList();
        resp.setContentType("application/json");
        Gson msgGson = new Gson();
        //System.out.println("asmaa yarab "+users.size());
        PrintWriter out = resp.getWriter();
        out.write(msgGson.toJson(users));
    }

   
}
