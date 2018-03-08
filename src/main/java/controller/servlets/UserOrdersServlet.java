package controller.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.product.OrderController;
import controller.user.LoginController;
import model.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/vieworders")
public class UserOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("./404.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request , HttpServletResponse  response) throws IOException {

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        if(session.getAttribute(LoginController.USER_DATA) != null)
        {
            User user =(User)session.getAttribute(LoginController.USER_DATA);
            Gson gson = new GsonBuilder().create();
            out.write(gson.toJson(new OrderController().getAllOrders(user.getEmail())));
        }

    }
}
