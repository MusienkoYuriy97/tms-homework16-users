package by.tms.servlet;

import by.tms.entity.User;
import by.tms.exeptions.UserException;
import by.tms.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();

        try {
            resp.getWriter().println("List all Users: ");
            for (User user : userService.getUsers()) {
                resp.getWriter().println(user);
            }
        } catch (UserException e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}
