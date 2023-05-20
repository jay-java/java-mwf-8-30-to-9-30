package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.UserBean;
import Dao.LoginDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("login")) {
			UserBean u = new UserBean();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			UserBean u1 = new LoginDao().doLogin(u);
			if(u1!=null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("id", u1.getUid());
				response.sendRedirect("HomeController?action=showdata&uid="+u1.getUid());
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("msg", "invalid email ");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

}
