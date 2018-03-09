package controller.servlets;

import controller.product.AddProductController;
import model.beans.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/AddProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("./404.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int sku = Integer.parseInt(request.getParameter("sku"));

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantiity(quantity);
        product.setProduct_category(category);
        product.setProduct_img(image);
        product.setSku(sku);


        AddProductController addProductController = new AddProductController();
        int addProductResult = addProductController.addProduct(product);
        System.out.println(addProductResult);
        if(addProductResult == AddProductController.PRODUCT_EXIST)
        {
            out.write("Product Already Exist");
        }
        else if(addProductResult == AddProductController.PRODUCT_ADDED)
        {
                out.write("success");
        }
        else if(addProductResult == AddProductController.INVALID_NAME)
        {
            out.write("Invalid Product Name");
        }


    }

}
