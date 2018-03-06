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

@WebServlet(name = "CategoryWithPriceServlet")
public class CategoryWithPriceServlet extends HttpServlet {
    private ProductController productController = new ProductController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("./404.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request , HttpServletResponse response) throws IOException {
        response.setContentType("Application/Json");
        PrintWriter out = response.getWriter();
        String categoryName=request.getParameter("category");
        double minPrice =(Double.parseDouble(request.getParameter("minPrice")));
        double maxPice =(Double.parseDouble(request.getParameter("maxPrice")));
        try {
            Gson gson = new GsonBuilder().create();
            out.write(gson.toJson(productController.getCategoryProductswithPrice(categoryName,minPrice,maxPice)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
