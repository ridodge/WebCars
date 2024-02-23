/**
 * Riley Dodge - tjrace
 * CIS175 - Fall 2023
 * Feb 20, 2024
 */

package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "driver")
public class Driver {
	@Id
	@GeneratedValue
	private int id;
	private String driverName;

	public Driver() {
		super();
// TODO Auto-generated constructor stub
	}

	public Driver(int id, String driverName) {
		super();
		this.id = id;
		this.driverName = driverName;
	}

public Driver(String driverName) {
	super();
	this.driverName = driverName;
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", driverName=" + driverName + "]";
	}
}
