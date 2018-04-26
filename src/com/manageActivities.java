package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.DAO.LoginDAO;
import com.service.model.Admin;
import com.service.model.Customer;
import com.service.model.Dealer;
import com.service.model.Login;



/**
 * Servlet implementation class manageActivities
 */
@WebServlet("/manageActivities")
public class manageActivities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageActivities() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username=request.getParameter("rusername");
		System.out.println(request.getParameter("rusername"));
		String usertypereset= request.getParameter("userType");
		System.out.println(">>"+usertypereset);
		try{
			if(usertypereset.equalsIgnoreCase("customer")) {
				Login validateUser = new Login();
				validateUser.setUsername(request.getParameter("rusername"));
				validateUser.setUserRole("customer");
				LoginDAO dao = new LoginDAO();
				Customer customer=(Customer)dao.validateUser(validateUser);
				if(customer!=null)
					{
					System.out.println(customer.getPassword());
					request.setAttribute("userExists", "true");
					request.getSession().setAttribute("resetusertype", "customer");
					request.getSession().setAttribute("resetusername",customer);
					request.getRequestDispatcher("/resetProfile.jsp").forward(request, response);

					
					}
				else {
					String errormsg="invalid username";
					request.setAttribute("nouserEr", errormsg.toString());
					request.getRequestDispatcher("/resetProfile.jsp").forward(request, response);
				}
			}
			if(usertypereset.equalsIgnoreCase("admin")) {
				Login validateUser = new Login();
				validateUser.setUsername(request.getParameter("rusername"));
				validateUser.setUserRole("admin");
				LoginDAO dao = new LoginDAO();
				Admin details =(Admin)dao.validateUser(validateUser);
				if(details!=null)
					{System.out.println(details.getPassword());
					request.setAttribute("userExists", "true");
					request.getSession().setAttribute("resetusertype", "admin");
					request.getSession().setAttribute("resetusername",details);
					request.getRequestDispatcher("/resetProfile.jsp").forward(request, response);
					}
				else {
					String errormsg="invalid username";
					request.setAttribute("nouserEr", errormsg.toString());
					request.getRequestDispatcher("/resetProfile.jsp").forward(request, response);
				}	
			}
			if(usertypereset.equalsIgnoreCase("dealer")) {
				Login validateUser = new Login();
				validateUser.setUsername(request.getParameter("rusername"));
				validateUser.setUserRole("dealer");
				LoginDAO dao = new LoginDAO();
				Dealer details =(Dealer)dao.validateUser(validateUser);
				if(details!=null)
					{System.out.println(details.getPassword());
					request.setAttribute("userExists", "true");
					request.getSession().setAttribute("resetusertype", "dealer");
					request.getSession().setAttribute("resetusername",details);
					request.getRequestDispatcher("/resetProfile.jsp").forward(request, response);}
				else {
					String errormsg="invalid username";
					request.setAttribute("nouserEr", errormsg.toString());
					request.getRequestDispatcher("/resetProfile.jsp").forward(request, response);
				}	
			
			}
				
		}catch(Exception e){
			e.printStackTrace();
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
