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

@WebServlet(name = "GetAllCategoryServlet" , urlPatterns = "/allcat")
public class GetAllCategoryServlet extends HttpServlet {

   private ProductController productController = new ProductController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("./404.html");
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request , HttpServletResponse response) throws IOException {
        response.setContentType("Application/Json");
        PrintWriter out = response.getWriter();
        try {

          Gson gson = new GsonBuilder().create();
          out.write(gson.toJson(productController.getAllCategories()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

