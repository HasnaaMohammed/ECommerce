package controller.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.product.ProductController;
import model.database.ProductOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;

@WebServlet(urlPatterns = "/allcategories")
public class HeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("./404.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      processRequest(req , resp);
    }

    private void processRequest(HttpServletRequest request , HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();

        ProductOperation productOperation = new ProductOperation();
        try {
            Vector<String> allCategories = productOperation.getAllCategories();
            Gson gson = new GsonBuilder().create();
            printWriter.write(gson.toJson(allCategories));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
