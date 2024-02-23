package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Driver;
import model.ListItem;
import model.TripDetails;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditListDetailsServlet() {
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
		// TODO Auto-generated method stub
		TripDetailsHelper dao = new TripDetailsHelper();
		ListItemHelper lih = new ListItemHelper();
		DriverHelper sh = new DriverHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		TripDetails listToUpdate = dao.searchForListDetailsById(tempId);
		String newListName = request.getParameter("tripName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String driverName = request.getParameter("driverName");
		// find our add the new shopper
		Driver newShopper = sh.findDriver(driverName);
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		try {
			// items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<ListItem> selectedItemsInList = new ArrayList<ListItem>();
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ListItem c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setCarsDriven(selectedItemsInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<ListItem> selectedItemsInList = new ArrayList<ListItem>();
			listToUpdate.setCarsDriven(selectedItemsInList);
		}
		listToUpdate.setTripName(newListName);
		listToUpdate.setTripDate(ld);
		listToUpdate.setDriver(newShopper);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllTripsServlet").forward(request, response);
	}

}
