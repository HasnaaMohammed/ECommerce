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

    private void processRequest(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        String categoryName = request.getParameter("category");
        int index ;
        if(request.getParameter("page") != null && request.getParameter("page").chars().allMatch( Character::isDigit ))
        {
            index = Integer.parseInt(request.getParameter("page"));
            index = index < 0 ? 0 : index;
        }
        else
            index = 0;
        System.out.println(index);
        if(categoryName == null || categoryName.isEmpty())
            request.getRequestDispatcher("/index.jsp").forward(request , response);
        else {
            request.setAttribute("categoryName", categoryName);
            request.setAttribute("pageNum" , index);
            try {
                //  Gson gson = new GsonBuilder().create();
                // out.write(gson.toJson(productController.getCategoryProducts(categoryName)));
                request.setAttribute("product", productController.getCategoryProducts(categoryName , index));
                request.getRequestDispatcher("/Product.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
