package controller.servlets;

import controller.product.CartController;
import controller.user.LoginController;
import model.beans.Cart;
import model.beans.Product;
import model.beans.User;
import util.ValidationCheck;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

@WebServlet(urlPatterns = "/Login")
public class LoginServlet extends HttpServlet{

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
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        System.out.println(email);
        System.out.println(password);

        ValidationCheck validationCheck = new ValidationCheck();
        if(!validationCheck.isEmail(email) || !validationCheck.isValidPassword(password))
        {
            System.out.println("Error In Validation");
            out.write("fail");
        }
        else
        {
            LoginController loginController = new LoginController();
            Boolean result = loginController.getUserValidation(email , password);
            User user = loginController.getUserObject();
            if(result)
            {
                HttpSession newUserSession = request.getSession(true);
                newUserSession.setAttribute(LoginController.USER_DATA , loginController.getUserObject());
                updateUserSessionCart(newUserSession , user.getEmail());
                if(user.getRole() == 1)
                    out.write("success-admin");
                else if(user.getRole() == 0)
                {
                    out.write("success-user");
                }
            }
            else
            {
                System.out.println("Error In Verification");
                out.write("fail");
            }
        }
    }


    private void updateUserSessionCart(HttpSession httpSession , String email)
    {
        System.out.println("in Update");
        CartController cartController = new CartController();
        int cartID = cartController.hasCart(email);
        Vector<Product> products = (Vector<Product>)httpSession.getAttribute(CartController.CART_PRODUCT_LIST);
        Vector<Product> productVector  = cartController.refreshLoggedUserCart(email).getCartProducts();
        if(products != null)
        {
            Iterator<Product> productIterator = productVector.iterator();

            System.out.println("in Update2");

            while(productIterator.hasNext())
            {
                Product product = productIterator.next();
                for(Product sessionProducts :  products)
                {
                    if(sessionProducts.getSku() == product.getSku())
                    {
                        sessionProducts.setQuantiity(sessionProducts.getQuantiity()+product.getQuantiity());
                        productVector.remove(product);
                    }
                }
                System.out.println("in Update3");

            }

            products.addAll(productVector);
            new CartController().refreshCartDB(cartID , products);
        }
        else
        {
            httpSession.setAttribute(CartController.CART_PRODUCT_LIST , productVector);
        }



    }



}
