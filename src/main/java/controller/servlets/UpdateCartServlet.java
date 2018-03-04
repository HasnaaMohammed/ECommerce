package controller.servlets;

import controller.product.CartController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/updatecart")
public class UpdateCartServlet extends HttpServlet {

    private CartController cartController;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("./404.html");
    }

    private void processRequest(HttpServletRequest request , HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        cartController = new CartController();
        HttpSession httpSession = request.getSession(false);
        int productSku = Integer.parseInt(request.getParameter(CartController.productRequest));
        int result = cartController.addToCart(httpSession , productSku);
        switch (result)
        {
            case CartController.DONE :
                out.write("Product Added to Cart Successfully");
                break;
            case CartController.OUT_OF_STOCK:
                out.write("Product Out of Stock");
                break;
            case CartController.OPERATION_FAILED:
                out.write("Error Happened cannot add Product ot Cart");
                break;
        }
    }
}
