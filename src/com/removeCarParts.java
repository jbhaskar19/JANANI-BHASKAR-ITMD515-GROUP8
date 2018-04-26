package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.DAO.InventoryDAO;
import com.service.model.CarPartsInventory;
import com.service.model.Dealer;
import com.service.model.Dealership;

/**
 * Servlet implementation class removeCarParts
 */
@WebServlet("/removeCarParts")
public class removeCarParts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeCarParts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

System.out.println("Part id to be removed:"+request.getParameter("cpid"));
CarPartsInventory carPartsToRemove = new CarPartsInventory();
carPartsToRemove.setPid(request.getParameter("cpid"));
Dealer dealerDeleteParts = (Dealer)request.getSession().getAttribute("loogedindealer");
//dealerDeleteParts.removeCarPart(carPartsToRemove);
request.setAttribute("currentSessionUser",dealerDeleteParts.getName());
request.getSession().setAttribute("loogedintype", "dealer");
request.getRequestDispatcher("/MyHomePage.jsp").forward(request, response);
System.out.println("Capacity ="+request.getParameter("ccapacity"));
System.out.println("SelectedQuantity ="+request.getParameter("cpquantity"));
int Capacity =Integer.parseInt(request.getParameter("ccapacity"));
int SelectedQuantity =Integer.parseInt(request.getParameter("cpquantity"));
if(SelectedQuantity<Capacity) {
	System.out.println("Selected Quantity is less than capacity");
	InventoryDAO dao = new InventoryDAO();
	int updatedQuan = Capacity-SelectedQuantity;
	carPartsToRemove.setQuantity(Integer.toString(updatedQuan));
	dao.updateCarParts(carPartsToRemove);		}
else if(SelectedQuantity==Capacity) {
//remove part from inventory	
	System.out.println("remove parts from inventory when quantity and capacity is equal");
	InventoryDAO dao = new InventoryDAO();
dao.removeCarPartFromInventory(carPartsToRemove);	
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
