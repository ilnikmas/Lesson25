package servlets;

import pojo.Mobile;
import utils.DBUtils;
import utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = { "/editProduct" })
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        Integer id = Integer.parseInt(request.getParameter("id"));
        Mobile mobile = null;
        String errorString = null;
        try {
            mobile = DBUtils.findProduct(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString != null && mobile == null) {
            response.sendRedirect(request.getServletPath() + "/productList");
            return;
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("mobile", mobile);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        Integer id = Integer.parseInt(request.getParameter("id"));
        String model = request.getParameter("model");
        Integer price = Integer.parseInt(request.getParameter("price"));
        String manufacturer = request.getParameter("manufacturer");
        Mobile mobile = new Mobile(id, model, price, manufacturer);
        String errorString = null;
        try {
            DBUtils.updateProduct(conn, mobile);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("mobile", mobile);
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }

}
