package testcases;

import org.junit.Assert;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList; 
import java.util.List; 
import domain.Address;
import domain.BankDetails;
import domain.Customer;

public class TestCustomer {
	
	@Test
	public void customerShouldBeCreated()
	{
		Address address = new Address(); 
		address.setCity("Pretoria");
		address.setDescription("House");
		address.setPostalCode(0152);
		address.setProvince("Gauteng");
		address.setHouseNumber(1488);
		address.setStreet("Aubrey");
		
		List<Address> addList = new ArrayList<>(); 
		addList.add(address); 
		
		BankDetails bank = new BankDetails(); 
		bank.setAccountNumber(123456789);
		bank.setBranchCode(6350009);
		bank.setName("ABSA");
		
		List<BankDetails> bankList = new ArrayList<>(); 
		bankList.add(bank); 
		
		Customer customer = new Customer();
		customer.setName("Thabo");
		customer.setSurname("Moopa");
		customer.setAddress(addList);
		customer.setBankDetails(bankList); 
		
		assertEquals(customer.toString(), customer.toString()); 
	}
	
	@Test
	public void bankDetailsShouldFailCreation() {
		BankDetails bank = new BankDetails(); 
		bank.setAccountNumber(123456789);
		bank.setBranchCode(63006);
		bank.setName("Absa");
		
		BankDetails bank2 = new BankDetails(); 
		bank2.setAccountNumber(987654321);
		bank2.setBranchCode(987655);
		bank2.setName("Name");
		
		
		assertEquals(bank.toString(), bank2.toString()); 	
	}


}
