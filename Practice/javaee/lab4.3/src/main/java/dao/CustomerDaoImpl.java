package dao;

import pojos.Customer;
import java.sql.*;
import static utils.DBUtils.fetchConnection;

public class CustomerDaoImpl implements ICustomerDao {

	//data members
	private Connection cn;
	private PreparedStatement pst1;
	
	//constr : arg less constr
	
	@Override
	public Customer authenticateCustomer(String email, String password) throws Exception {
		//set IN Param
		pst1.setString(1, email);
		pst1.setString(2, password);
		try(ResultSet rst = pst1.executeQuery()){
			if(rst.next()) {
				return new Customer(rst.getInt(1), email, password, rst.getDouble(4), rst.getDate(5));
				
			}
		}
		return null;
	}

	public CustomerDaoImpl(String drvr,String url ,String name,String pwd) throws Exception{
		//getConnection
		cn = fetchConnection(drvr, url, name, pwd);
		pst1 = cn.prepareStatement("select * from my_customers where email=? and password=?");
		//create pre parsed n pre compiled stmt to hold validation query
//		pst1 = cn.prepareStatement(");
		System.out.println("Customer Dao Created");
	}

//	cleaning up of database resources
	public void cleanUp() throws SQLException {
		if(pst1 != null)
			pst1.close();
		if(cn != null)
			cn.close();
		System.out.println("customer dao cleanup");
	}
	
}
 