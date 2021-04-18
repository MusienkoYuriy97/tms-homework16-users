package by.tms.servlet;

import by.tms.exeptions.UserException;
import by.tms.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/signIn")
public class SignInServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            userService.signIn(username,password);
            resp.getWriter().printf("%s are logged in system", username);
        } catch (UserException e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}
