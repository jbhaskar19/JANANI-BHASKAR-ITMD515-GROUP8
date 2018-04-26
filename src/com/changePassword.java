package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.model.Admin;
import com.service.model.Customer;
import com.service.model.Dealer;

/**
 * Servlet implementation class changePassword
 */
@WebServlet("/changePassword")
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getSession().getAttribute("resetusertype"));
		if(request.getSession().getAttribute("resetusertype").toString().equalsIgnoreCase("customer")) {
		Customer customer =  (Customer)request.getSession().getAttribute("resetusername");
		System.out.println(customer.getUsername()+" "+customer.getPassword());
		customer.resetPassword(request.getParameter("rpwd"), customer);
		String MSG="PASSWORD SUCCESSFULLY RESET";
		request.setAttribute("resetmsg", MSG.toString());
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		if(request.getSession().getAttribute("resetusertype").toString().equalsIgnoreCase("admin")) {
		Admin admin = ( Admin)request.getSession().getAttribute("resetusername");
		System.out.println(admin.getUsername()+" "+admin.getPassword());
		admin.resetPassword(request.getParameter("rpwd"), admin);
		String MSG="PASSWORD SUCCESSFULLY RESET";
		request.setAttribute("resetmsg", MSG.toString());
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		if(request.getSession().getAttribute("resetusertype").toString().equalsIgnoreCase("dealer")) {
		Dealer dealer = (Dealer)request.getSession().getAttribute("resetusername");
		System.out.println(dealer.getUsername()+" "+dealer.getPassword());
		dealer.resetPassword(request.getParameter("rpwd"), dealer);
		String MSG="PASSWORD SUCCESSFULLY RESET";
		request.setAttribute("resetmsg", MSG.toString());
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
