/**
 * Riley Dodge - tjrace
 * CIS175 - Fall 2023
 * Feb 21, 2024
 */

package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "TripDetails")
public class TripDetails {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "TRIPNAME")
	private String tripName;
	@Column(name = "TRIPDATE")
	private LocalDate tripDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Driver driver;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<ListItem> carsDriven;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public List<ListItem> getCarsDriven() {
		return carsDriven;
	}

	public void setCarsDriven(List<ListItem> carsDriven) {
		this.carsDriven = carsDriven;
	}

	public TripDetails() {
	}

	public TripDetails(int id, String tripName, LocalDate tripDate, Driver driver, List<ListItem> carsDriven) {

		this.id = id;
		this.tripName = tripName;
		this.tripDate = tripDate;
		this.driver = driver;
		this.carsDriven = carsDriven;
	}

	public TripDetails(String tripName, LocalDate tripDate, Driver driver, List<ListItem> carsDriven) {

		this.tripName = tripName;
		this.tripDate = tripDate;
		this.driver = driver;
		this.carsDriven = carsDriven;
	}

	public TripDetails(String tripName, LocalDate tripDate, Driver driver) {
		this.tripName = tripName;
		this.tripDate = tripDate;
		this.driver = driver;
	}

	
	public String toString() {
		return "id=" + this.id + ", tripName=" + this.tripName + ", tripDate=" + this.tripDate + ", driver="
				+ this.driver.toString() + ", carsDriven=" + this.carsDriven.toString();
	}

}
