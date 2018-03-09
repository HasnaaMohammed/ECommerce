package controller.servlets;

import controller.product.ProductController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "GetAllProductServlet" ,urlPatterns = "/allProduct")
public class GetAllProductServlet extends HttpServlet {

    private ProductController productController = new ProductController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request , HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        try {
           //  Gson gson = new GsonBuilder().create();
            // out.write(gson.toJson(productController.getAllProduct()));
           request.setAttribute("allproduct", productController.getAllProduct());
            request.getRequestDispatcher("/category.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
