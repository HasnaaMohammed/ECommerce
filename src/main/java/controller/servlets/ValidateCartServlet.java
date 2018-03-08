package controller.servlets;

import controller.product.CartController;
import controller.product.ProductController;
import controller.user.LoginController;
import model.beans.Product;

import javax.enterprise.context.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet(urlPatterns = "/validatecart")
public class ValidateCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("./404.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request , HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        ProductController productController = new ProductController();
        HttpSession httpSession = request.getSession(true);
        boolean flag = true;
        Vector<String> strings = new Vector<>();
        if(httpSession.getAttribute(CartController.CART_PRODUCT_LIST) != null)
        {
            Vector<Product> productVector =
                    (Vector<Product>)httpSession.getAttribute(CartController.CART_PRODUCT_LIST);
            for(Product product : productVector)
            {
                if (!productController.isProductAvailable(product.getSku() , product.getQuantiity()))
                {
                    flag = false;
                    product.setAvailableForCart(false);
                }
                else
                {
                    product.setAvailableForCart(true);
                }
            }
            out.write(flag ? "ok" : "out");
        }

    }
}
