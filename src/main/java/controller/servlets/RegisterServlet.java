package controller.servlets;

import controller.user.RegisterController;
import model.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/Register")
public class RegisterServlet extends HttpServlet {

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
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("birthdate"));
        String address = request.getParameter("address");
        String job = request.getParameter("job");
        int limit = Integer.parseInt(request.getParameter("limit"));

        User user = new User();
        user.setFullName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setBirthDate(dateOfBirth);
        user.setAddress(address);
        user.setJob(job);
        user.setCredit(limit);


        RegisterController registerController = new RegisterController();
        int regResult = registerController.registerUser(user);
        System.out.println(regResult);
        if(regResult == RegisterController.USER_EXIST)
        {
            out.write("User Already Exist");
        }
        else if(regResult == RegisterController.USER_REGISTERED)
        {
                out.write("success");
        }
        else if(regResult == RegisterController.INVALID_EMAIL)
        {
            out.write("Invalid Email");
        }


    }

}
