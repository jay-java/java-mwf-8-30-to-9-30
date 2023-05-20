package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.UserBean;
import Dao.HomeDao;
import Dao.UserDao;
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("showdata")) {
			int id = Integer.parseInt(request.getParameter("uid"));
			UserBean u = new HomeDao().doLogin(id);
			request.setAttribute("u", u);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		if(action.equalsIgnoreCase("editdata")) {
			int id = Integer.parseInt(request.getParameter("uid"));
			UserBean u = new HomeDao().doLogin(id);
			request.setAttribute("u1", u);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		if(action.equalsIgnoreCase("deletedata")) {
			int id = Integer.parseInt(request.getParameter("uid"));
			new HomeDao().deleteUser(id);
			request.setAttribute("msg", "record deleted");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean u = new UserBean();
		u.setUid(Integer.parseInt(req.getParameter("uid")));
		u.setFname(req.getParameter("fname"));
		u.setLname(req.getParameter("lname"));
		u.setEmail(req.getParameter("email"));
		u.setPassword(req.getParameter("password"));
		new HomeDao().updateUser(u);
		req.setAttribute("msg", "record updated");
		resp.sendRedirect("HomeController?action=showdata&uid="+u.getUid());
	}
	

}
