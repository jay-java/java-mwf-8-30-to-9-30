package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("register")) {
			User user = new User();
			user.setName(request.getParameter("name"));
			user.setContact(Long.parseLong(request.getParameter("contact")));
			user.setAddress(request.getParameter("address"));
			user.setEmail(request.getParameter("email"));
			user.setPasswordString(request.getParameter("password"));
			System.err.println(user);
			UserDao.insertUser(user);
			request.setAttribute("msg", "data inserted successfully");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("login")) {
			User user = new User();
			user.setEmail(request.getParameter("email"));
			String email = request.getParameter("email");
			user.setPasswordString(request.getParameter("password"));
			System.out.println(user);
			boolean flag = UserDao.checkEmail(email);
			System.out.println(flag);
			if(flag == true) {
				User user2 = UserDao.userLogin(user);
				HttpSession session = request.getSession();
				session.setAttribute("data", user2);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg1", "account not registered");
				request.getRequestDispatcher("login.jsp").forward(request, response);;
			}
		}
	}

}
