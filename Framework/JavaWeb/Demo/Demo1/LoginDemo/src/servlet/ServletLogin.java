package servlet;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // UTF-8
        response.setCharacterEncoding("utf-8");

        // Receive parameters from view
        Map<String, String[]> parameterMap = request.getParameterMap();
        User loginUser = new User();

        // BeanUtils
        try {
            BeanUtils.populate(loginUser, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // Dao
        UserDao userDao = new UserDao();
        User user = userDao.loginUser(loginUser);

        if (user != null) {
            request.setAttribute("username", user.getUsername());
            request.getRequestDispatcher("/ServletSucceeded").forward(request, response);

        } else {
            request.getRequestDispatcher("/ServletFailed").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
