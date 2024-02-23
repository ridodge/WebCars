
/**
 * Riley Dodge - tjrace
 * CIS175 - Fall 2023
 * Feb 21, 2024
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.DriverHelper;
import controller.ListItemHelper;
import controller.TripDetailsHelper;
import model.Driver;
import model.ListItem;
import model.TripDetails;

/**
 * 
 */
public class TripDetailsTester {

	public static void main(String[] args) {
		Driver riley = new Driver("Riley");
		DriverHelper dh = new DriverHelper();
		dh.insertDriver(riley);

		ListItem ford = new ListItem("Ford", "Bronco");
		ListItem nissan = new ListItem("Nissan", "Altima");
		ListItemHelper lih = new ListItemHelper();
//		lih.insertItem(ford);
//		lih.insertItem(nissan);

		List<ListItem> rileysItems = new ArrayList<ListItem>();
		rileysItems.add(nissan);
		rileysItems.add(ford);
		
		
		TripDetailsHelper ldh = new TripDetailsHelper();
		TripDetails rileyTrip = new TripDetails("Des Moines", LocalDate.now(), riley, rileysItems);
		ldh.insertNewTripDetails(rileyTrip);

		List<TripDetails> allTrips = ldh.getTrips();
		for (TripDetails a : allTrips) {
			System.out.println(a.toString());
		}
	}

}
