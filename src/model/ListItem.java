/**
 * Riley Dodge - tjrace
 * CIS175 - Fall 2023
 * Jan 29, 2024
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autos")
public class ListItem {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "MAKE")
	private String make;
	@Column(name = "MODEL")
	private String model;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public ListItem(String make, String model) {
		this.make = make;
		this.model = model;
	}

	public ListItem() {
	}

	public String returnItemDetails() {
		return this.make + ": " + this.model;
	}

}
