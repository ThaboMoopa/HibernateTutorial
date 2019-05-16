/**
 * 
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import domain.Customer; 

@Entity
@Table(name="BANK_DETAILS")
public class BankDetails {
	/**
	 *
	 * The class includes the property attributes for the bank details 
	 *
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "BANK_ID")
	private int id;
	
	@Column(name="ACCOUNT_NUMBER")
	private long accountNumber; 
	
	@Column(name = "BRANCH_CODE")
	private long branchCode;
	
	@Column(name="NAME")
	private String name; 
	
	
	//Reference Type
	@ManyToOne
	private Customer customer; 
	
	public void setCustomer(Customer customer)
	{
		this.customer = customer; 
	}
	
	public Customer getcustomer()
	{
		return customer; 
	}
	/**
	 * 
	 * Setters and getters for the bank details attributes
	 * @return accountNumber 
	 */
	
	
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBranchCode(long branchCode)
	{
		this.branchCode = branchCode; 
	}
	
	public long getBranchCode()
	{
		return branchCode; 
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
		BankDetails other = (BankDetails) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BankDetails [accountNumber=" + accountNumber + ", branchCode=" + branchCode + ", name="
				+ name + "]";
	}
	

	
}
