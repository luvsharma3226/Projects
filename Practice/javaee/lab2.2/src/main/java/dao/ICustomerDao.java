package dao;
import pojos.Customer;
public interface ICustomerDao {
	// add a method for customer validatison
	
	Customer authenticateCustomer(String email, String password) throws Exception;
	
	
}
