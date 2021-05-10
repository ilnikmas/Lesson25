package servlets;

import utils.DBUtils;
import utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/createTableUsers"})
public class CreateTableUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreateTableUsersServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        try {
            DBUtils.createTableUsers(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/");
    }
}
