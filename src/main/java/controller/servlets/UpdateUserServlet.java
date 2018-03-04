package controller.servlets;

import controller.user.LoginController;
import controller.user.UpdateUserController;
import model.beans.User;
import util.ValidationCheck;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet(urlPatterns = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    UpdateUserController updateUserController;
    HttpSession httpSession;
    @Override
    public void init() throws ServletException {
        super.init();
        updateUserController = new UpdateUserController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("./404.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processHandler(req, resp);
    }

    private void processHandler(HttpServletRequest request , HttpServletResponse response) throws IOException {

        httpSession = request.getSession(false);
        User loggedUser = (User)httpSession.getAttribute(LoginController.USER_DATA);
        PrintWriter out = response.getWriter();
        String name = request.getParameter("fullname");
        String password = request.getParameter("password");
        String birthdate = request.getParameter("birthdate");
        String address = request.getParameter("address");
        String job = request.getParameter("job");
        String limit = request.getParameter("limit");

        LocalDate dob ;
        int creditLimit ;

        try {
            dob = LocalDate.parse(birthdate);
            creditLimit = Integer.parseInt(limit);
        }catch (NumberFormatException nfe)
        {
            out.write("Invalid Credit Limit");
            return;
        }catch (DateTimeParseException dtpe)
        {
            out.write("Invalid Birth Date");
            return;
        }
        if(password == null || password.trim().equals(""))
        {

            password = loggedUser.getPassword();
        }

        User user = new User();
        user.setFullName(name);
        user.setEmail(loggedUser.getEmail());
        user.setPassword(password);
        user.setBirthDate(dob);
        user.setAddress(address);
        user.setJob(job);
        user.setCredit(creditLimit);

        updateUserController.setUser(user);

        boolean result = updateUserController.updateUserData();
        if(result)
        {
            out.write("success");

            httpSession.setAttribute(LoginController.USER_DATA , user);
        }
        else
        {
            out.write("Cannot Update User Data");
        }

    }



}
