/**
 * 
 * @Thabo Moopa
 * @version 1.00, 13 May 2019
 * 
 */

package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This class includes the properties of the customer of the application
 */
@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	/**
	 * Attributes associated with the customer
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="CUSTOMER_ID")
	private int id;
	
	@Column(name="CONTACT")
	private String contact; 
	
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="SURNAME")
	private String surname; 
	
	//creating bank ID for the Collection of the ArrayList using annotations
	@OneToMany(cascade=CascadeType.ALL)
	private List<BankDetails> bankDetails; 
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Address> address;
	
	/**
	 * 
	 * Setters and getters for the attributes of the customer class
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	//Collections type 
	public List<BankDetails> getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(List<BankDetails> bankDetails) {
		this.bankDetails = bankDetails;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
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
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", contact=" + contact + ", email=" + email + ", name=" + name + ", password="
				+ password + ", surname=" + surname + ", bankDetails=" + bankDetails + ", address=" + address + "]";
	}
}
