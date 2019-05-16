/**
 * Address class to hold attribute value of the customer address
 * @Thabo Moopa
 * @version 1.00, 13 May 2019
 * 
 */
package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import domain.Customer;

@Entity
@Table(name="ADDRESS")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="ADDRESS_ID")
	private int id; 
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="HOUSE_NUMBER")
	private int houseNumber; 
	
	@Column(name="POSTAL_CODE")
	private int postalCode; 
	
	@Column(name="PROVINCE")
	private String province;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="DESCRIPTION")
	
	
	//annotation describes a Large object description in the database
	@Lob 
	private String description; 
	
	@ManyToOne
	private Customer customer;
	
	
	/**
	 * Setters and getters for the address attributes
	 * @param
	 */
	public void setCustomer(Customer customer)
	{
		this.customer = customer; 
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	
	/**
	 * This method sets the data for the description of Address of the customer
	 * @param description used to input the description 
	 */
	public void setDescription(String description)
	{
		this.description = description; 
	}
	/**
	 * Method used to retrieve the description of the address 
	 * @return description value from the set method
	 */
	public String getDescritpion()
	{
		return description; 
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", houseNumber=" + houseNumber + ", postalCode=" + postalCode
				+ ", province=" + province + ", street=" + street + ", description=" + description + "]";
	} 
}
