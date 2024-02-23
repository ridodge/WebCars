/**
 * Riley Dodge - tjrace
 * CIS175 - Fall 2023
 * Feb 21, 2024
 */

import java.util.List;

import controller.DriverHelper;
import model.Driver;
	
/**
 * 
 */
public class DriverTester {
	public static void main(String[] args) {
		Driver riley = new Driver("Riley");
		Driver morgan = new Driver("Morgan");
		DriverHelper dh = new DriverHelper();
		dh.insertDriver(riley);
		dh.insertDriver(morgan);
		List<Driver> allDrivers = dh.showAllDrivers();
		for (Driver a : allDrivers) {
			System.out.println(a.toString());
		}
	}
}