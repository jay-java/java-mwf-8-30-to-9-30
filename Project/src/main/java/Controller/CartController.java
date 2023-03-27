package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CartDao;
import Dao.ProductDao;
import Model.Cart;
import Model.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("addtocart")) {
			Cart c = new Cart();
			c.setCusid(Integer.parseInt(request.getParameter("cusid")));
			c.setPid(Integer.parseInt(request.getParameter("pid")));
			
			Product p = ProductDao.getProductByPid(Integer.parseInt(request.getParameter("pid")));
			c.setPname(p.getPname());
			c.setPprice(p.getPprice());
			c.setPqty(1);
			c.setPayment_status("pending");
			CartDao.insertCat(c);
			response.sendRedirect("customer-home.jsp");
		}
	}

}
