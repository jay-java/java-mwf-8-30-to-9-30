package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("register")) {
//			PrintWriter out = response.getWriter();
//			out.print("");
			User u = new User();
			u.setName(request.getParameter("name"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			u.setAddress(request.getParameter("address"));
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			System.out.println(u);
			new UserDao().insertUser(u);
			request.setAttribute("msg", "data registerd");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("login")) {
			User u = new User();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			User u1 = new UserDao().userLogin(u);
			if(u1==null) {
				request.setAttribute("msg1", "password is incorrect");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("data", u1);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
		}
	}

}
