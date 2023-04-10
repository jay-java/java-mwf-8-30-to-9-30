package Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.scan.AbstractInputStreamJar;

import Dao.SellerDao;
import Model.Seller;
import services.Service;

/**
 * Servlet implementation class SellerController
 */
@WebServlet("/SellerController")
public class SellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("register")) {
			long contact = Long.parseLong(request.getParameter("contact"));
			String email = request.getParameter("email");
			System.out.println(contact+email);
			Seller s = SellerDao.checkContactAndEmail(contact, email);
			System.out.println(s);
			if (contact == s.getContact() && email.equals(s.getEmail())) {
				request.setAttribute("msg", "Account registered already");
				request.getRequestDispatcher("seller-registration.jsp").forward(request, response);
			} else {
				Seller s1 = new Seller();
				s1.setName(request.getParameter("name"));
				s1.setContact(Long.parseLong(request.getParameter("contact")));
				s1.setAddress(request.getParameter("address"));
				s1.setEmail(request.getParameter("email"));
				s1.setPassword(request.getParameter("password"));
				SellerDao.insertSeller(s1);
				request.setAttribute("msg", "Account registered succesfully");
				request.getRequestDispatcher("seller-login.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("login")) {
			Seller s = new Seller();
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			Seller s1 = SellerDao.loginSeller(s);
			if (s1 == null) {
				request.setAttribute("msg1", "password is incorrect");
				request.getRequestDispatcher("seller-login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("data", s1);
				request.getRequestDispatcher("seller-home.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("update")) {
			Seller s = new Seller();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			SellerDao.updateProfile(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("seller-home.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("aupdate")) {
			Seller s = new Seller();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			SellerDao.updateProfile(s);
			response.sendRedirect("admin-sellers-list.jsp");
		} else if (action.equalsIgnoreCase("change password")) {
			Seller s = new Seller();
			int id = Integer.parseInt(request.getParameter("id"));
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = SellerDao.checkOldPassword(id, op);
			if (flag == true) {
				if (np.equals(cnp)) {
					SellerDao.changePasswrod(id, np);
					response.sendRedirect("seller-home.jsp");
				} else {
					request.setAttribute("msg1", "old password and new password not matched");
					request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "Old password incorrect");
				request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("GET OTP")) {
			String email = request.getParameter("email");
			boolean flag = SellerDao.checkEmail(email);
			if (flag == true) {
				Service s = new Service();
				Random r = new Random();
				int num = r.nextInt(999999);
				System.out.println(num);
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("seller-verify-otp.jsp").forward(request, response);
			} else {

			}
		} else if (action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if (otp1 == otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("seller-new-password.jsp").forward(request, response);
			} else {
				request.setAttribute("email", email);
				request.setAttribute("otp", otp1);
				request.setAttribute("msg", "otp not matched");
				request.getRequestDispatcher("seller-verify-otp.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("Update Password")) {
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if (np.equals(cnp)) {
				SellerDao.changeNewPasswrod(email, np);
				response.sendRedirect("seller-login.jsp");
			} else {
				request.setAttribute("msg", "np and cnp not matched");
				request.setAttribute("email", email);
				request.getRequestDispatcher("seller-new-password.jsp").forward(request, response);
			}
		}
	}
}
