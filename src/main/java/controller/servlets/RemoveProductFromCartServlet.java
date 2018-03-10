package controller.servlets;

import controller.product.CartController;
import controller.product.ProductController;
import controller.user.LoginController;
import model.beans.Product;
import model.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.Vector;

@WebServlet(urlPatterns = "/removepq")
public class RemoveProductFromCartServlet extends HttpServlet {

    CartController cartController;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("./404.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        cartController = new CartController();
        int productID = request.getParameter("productID") != null ? Integer.parseInt(request.getParameter("productID")) : -1;

        HttpSession httpSession = request.getSession(false);

        if (httpSession != null && productID != -1) {
            User user = (User) httpSession.getAttribute(LoginController.USER_DATA);
            Vector<Product> products = (Vector<Product>) httpSession.getAttribute(CartController.CART_PRODUCT_LIST);
            if (products != null) {
                for (Product product : products) {
                    if (product.getProductID() == productID) {
                        products.remove(product);
                        break;
                    }
                }
            }

            if (user != null) {
                cartController.removeFromCart(user.getEmail(), productID);

            }
//            response.sendRedirect("./basket.jsp");
        }
    }
}
