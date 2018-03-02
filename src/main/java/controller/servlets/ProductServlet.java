package controller.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.beans.Category;
import model.database.ProductOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/Products")
public class ProductServlet extends HttpServlet {

    ProductOperation productOperation = new ProductOperation();
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

        Gson gson = new GsonBuilder().create();
        out.write(gson.toJson(productOperation.getAllCategoriesWithProducts()));
    }
}
