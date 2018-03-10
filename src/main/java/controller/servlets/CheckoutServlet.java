package controller.servlets;


import controller.product.CartController;
import controller.product.OrderController;
import controller.product.ProductController;
import controller.user.LoginController;
import controller.user.UpdateUserController;
import model.beans.Cart;
import model.beans.Order;
import model.beans.Product;
import model.beans.User;
import model.database.UserOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet(urlPatterns = "/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request , HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        UpdateUserController updateUserController = new UpdateUserController();
        ProductController productController = new ProductController();
        HttpSession session = request.getSession(false);
        User user;

        if(session != null)
        {
            if(session.getAttribute(CartController.CART_PRODUCT_LIST) == null)
            {
                out.write("Cart is Empty");
                return;
            }
            if(session.getAttribute(LoginController.USER_DATA) != null)
            {
                user = (User)session.getAttribute(LoginController.USER_DATA);
                Double userLimit = updateUserController.getUserLimit(user.getEmail());
                int cartID = new CartController().hasCart(user.getEmail());
                Vector<Product> products = (Vector<Product>)session.getAttribute(CartController.CART_PRODUCT_LIST);
                double total = 0.0;
                for(Product product : products)
                {
                    total = total + (product.getPrice()*product.getQuantiity());
                }
                if(total > userLimit)
                {
                    out.write("Your Credit Limit is not sufficient For Cart Total Price");
                    return;
                }
                else
                {
                    for(Product product : products)
                    {
                        if(!productController.isProductAvailable(product.getSku() , product.getQuantiity()))
                        {
                            out.write("One or More Product in Your Cart Are Out Of Stock");
                            return;
                        }
                    }

                    for (Product product :products)
                    {
                        productController.decreaseQuantity(product.getProductID() , product.getQuantiity());
                    }
                    user.setCredit(userLimit-total);
                    updateUserController.setUser(user);
                    updateUserController.updateUserData();
                    new CartController().finalizeCart(cartID);
                    new OrderController().createNewOrder(cartID , total);
                    session.setAttribute(CartController.CART_PRODUCT_LIST , new Vector<Product>());
                    out.write("Order Placed Successfully , It will be Confirmed in 2 days");

                }
            }
        }


    }
}
