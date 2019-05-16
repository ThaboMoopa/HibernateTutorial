/**
 * 
 * @Description The class is used to test the data to see if it persists to the database
 * @Thabo Moopa
 * @version 1.00, 13 May 2019
 * 
 */
package TestData;
import domain.Customer; 
import domain.BankDetails; 
import domain.Address;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList; 

@SuppressWarnings("deprecation")
public class CustomerTest {

	public static void main(String[] args) {
		
		
		//Configuration file form the XML conf
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession(); 
		
		try {
			BankDetails bankDetails = new BankDetails();
			bankDetails.setName("First National Bank");
			bankDetails.setAccountNumber(4080650678l);
			bankDetails.setBranchCode(6300534); 
			
			List<BankDetails> bankList = new ArrayList<>(); 
			bankList.add(bankDetails); 
			

			Address address = new Address();
			address.setStreet("Xami");
			address.setPostalCode(0152);
			address.setHouseNumber(6);
			address.setProvince("Northen Cape");
			address.setCity("Kurumane");
			address.setDescription("Flat"); 
			
			List<Address> addressList = new ArrayList<>(); 
			addressList.add(address); 
			
			Customer customer = new Customer(); 
			customer.setName("Thembi"); 
			customer.setSurname("Thembi");
			customer.setPassword("mysql");
			customer.setEmail("thembi.moopa@gmail.com");
			customer.setContact("0849262266");
			customer.setAddress(addressList);
			customer.setBankDetails(bankList);

			//new transaction is created 
			session.beginTransaction(); 
			
			//Writing queries in hibernate (HQL - Hibernate query language)
			Query query = session.createQuery("from Customer WHERE name LIKE 'John%' AND id=4");
			
			//executing the query, returns a list of customers in the database 
			List<Customer> customers = query.list(); 
			
			//Print out the size of the list coming from the database
			System.out.println("\n\nSize of the list: " + customers.size() + "\n\n"); 
			
			//Use an enhanced for loop to retrieve the customer details
			System.out.println("********Customer Details********"); 
			for(Customer cust: customers)
			{
				System.out.println(cust.getId());
				System.out.println(cust.getName());
				System.out.println(cust.getSurname()); 
				System.out.println(cust.getPassword());
				System.out.println(cust.getAddress());
				System.out.println(cust.getBankDetails()); 
			}
			
			System.out.println("********End of Report***********\n\n"); 
			
//			//saving the object
			session.persist(customer);
			
			Customer customer2 = session.get(Customer.class, 7); 
			session.delete(customer2);  
//			session.save(address); 
//			
			
			//Commit the transaction to POSTGRES		
			session.getTransaction().commit();
			
			//Use the same factory class to start a new instance of the object
			session = sessionFactory.openSession(); 
			
			//Start a new transactions
			session.beginTransaction(); 
			
			//Using joins to query two tables in Hibernate
			Query query2 = session.createQuery("FROM Customer c JOIN Address a ON c.id = a.id"); 
			
			List<Customer> customs = query2.list(); 
			
			for(Customer custom: customs)
			{
				System.out.println("***********NEW TRANSACTION"  + customs.toString()); 
			}
			
			
			//Commit the transaction to the DB
			session.getTransaction().commit(); 
			
			
			
			
			
			//new transaction is created 
			session.beginTransaction(); 
			
			//set the objects to null
			customer = null;
			bankDetails = null; 
			address = null; 
			
			//Fetching the data from the database using the customer ID = 1  
			customer = (Customer) session.get(Customer.class, 4); 
			
			//Fetch the user name from the database
			String name = customer.getName(); 
			String surname = customer.getSurname(); 
			
			System.out.println("\n\nThe name received from the database is " + name + ""); 
			System.out.println("The surname received from the database is " + surname + "\n\n");
			
			//Fetching the data from the database using the address ID = 8
			address = (Address) session.get(Address.class, 8); 
			
			String description = address.getDescritpion(); 
			String city = address.getCity(); 
			System.out.println("\n\nThe description from the database: " + description + ""); 
			System.out.println("The city from the database: " + city + "\n\n"); 
			
			//Output the data in the console 
			System.out.println(customer.toString());
			

		}
		catch(Exception e)
		{
			//flush the the session before rolling back the transaction
			session.flush(); 
			
			//Rollback transaction if an error occurs
			session.getTransaction().rollback();
		}
		finally
		{
			//closing the session, normally put inside the finally block
			session.close(); 
		}
		
		
		
		
		
		
		
		
		


	}

}
