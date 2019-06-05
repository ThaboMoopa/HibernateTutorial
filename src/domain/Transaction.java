package domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="Transaction")
public class Transaction {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANSACTION_ID")
	private long id; 
	
	private LocalDate transactionDate; 
	
	@ManyToOne
	private Customer customer;
	
	public Transaction() {
		
	}
	
	public void setId(long id)
	{
		this.id = id; 
	}
	
	public long getId()
	{
		return id; 
	}
	
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate; 
	}
	
	public void setCustomer(Customer customer)
	{
		this.customer = customer; 
	}
	
	public LocalDate getTransactionDate()
	{
		return transactionDate; 
	}
	
	public Customer getCustomer()
	{
		return customer; 
	}
	
}
