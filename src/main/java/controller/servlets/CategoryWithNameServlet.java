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

@WebServlet(name = "CategoryWithNameServlet"  , urlPatterns = "/catName")
public class CategoryWithNameServlet extends HttpServlet {

  private  ProductController productController = new ProductController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request , HttpServletResponse response) throws IOException {
        response.setContentType("Application/Json");
        PrintWriter out = response.getWriter();
        String categoryName = request.getParameter("category");
        try {
          //  Gson gson = new GsonBuilder().create();
           // out.write(gson.toJson(productController.getCategoryProducts(categoryName)));
            request.setAttribute("product", productController.getCategoryProducts(categoryName));
            request.getRequestDispatcher("/Product.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
