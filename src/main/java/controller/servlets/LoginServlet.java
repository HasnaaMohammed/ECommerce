package controller.servlets;

import controller.user.LoginController;
import util.ValidationCheck;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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
            if(result)
            {
                HttpSession newUserSession = request.getSession(true);
                newUserSession.setAttribute(LoginController.USER_DATA , loginController.getUserObject());
                out.write("success");
                System.out.println(loginController.getUserObject().getPassword());

            }
            else
            {
                System.out.println("Error In Verification");
                out.write("fail");
            }
        }









    }



}
