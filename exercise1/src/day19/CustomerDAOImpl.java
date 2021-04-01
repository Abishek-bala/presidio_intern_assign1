package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day18.DBUtility;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public CustomerDTO findByID(Integer customerid) {
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from Customer where customerid=?;");
			ps.setInt(1, customerid);
			ResultSet rs = ps.executeQuery();
			
			CustomerDTO customer = CustomerDTO.getCustomerDTO();
			
			while(rs.next()) {
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerAddress(rs.getString(3));
				customer.setCustomerPhonenumber(rs.getInt(4));
				customer.setCustomerAccountDetails(rs.getString(5));
				customer.setCustomergstnumber(rs.getInt(6));
				
			}
			DBUtility.closeConnection(null, null);
			return customer;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return null;
		}
		 
	}

	@Override
	public List<CustomerDTO> findAll() {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from Customer");
			CustomerDTO customer = CustomerDTO.getCustomerDTO();
			List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
			while(rs.next()) {
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerAddress(rs.getString(3));
				customer.setCustomerPhonenumber(rs.getInt(4));
				customer.setCustomerAccountDetails(rs.getString(5));
				customer.setCustomergstnumber(rs.getInt(6));
				customerList.add(customer);
		}
			DBUtility.closeConnection(null, null);
			return customerList;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public int insertCustomer(CustomerDTO customerdto) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?,?);");
			ps.setInt(1, customerdto.getCustomerId());
			ps.setString(2,customerdto.getCustomerName());
			ps.setString(3,customerdto.getCustomerAddress());
			ps.setInt(4, customerdto.getCustomerPhonenumber());
			ps.setString(5,customerdto.getCustomerAccountDetails());
			ps.setInt(6, customerdto.getCustomergstnumber());
			ps.execute();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return 0;
		}
	}

	@Override
	public int updateCustomer(CustomerDTO customerdto) {
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update Customer set  customerName =?, customerAddress=?, customerCellphone=?, customerAccountDetails=?, customergstnumber=? where customerid=?;");
			ps.setInt(6, customerdto.getCustomerId());
			ps.setString(1,customerdto.getCustomerName());
			ps.setString(2,customerdto.getCustomerAddress());
			ps.setInt(3, customerdto.getCustomerPhonenumber());
			ps.setString(4,customerdto.getCustomerAccountDetails());
			ps.setInt(5, customerdto.getCustomergstnumber());
			ps.execute();
			
			DBUtility.closeConnection(null, null);
			
			return 1;
			
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return 0;
		}
		 
	}

	@Override
	public int deleteCustomerByID(Integer customerid) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			
//			St = con.createStatement();
			PreparedStatement ps = con.prepareStatement("delete from customer where customerid = ?;");
			ps.setInt(1, customerid);
			ps.execute();
			
			DBUtility.closeConnection(null, null);
			
			return 1;
			
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return 0;
		}
	}

	@Override
	public int deleteCustomerByDTO(CustomerDTO customerdto) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			
//			St = con.createStatement();
			PreparedStatement ps = con.prepareStatement("delete from customer where customerid = ?;");
			ps.setInt(1, customerdto.getCustomerId());
			ps.execute();
			
			DBUtility.closeConnection(null, null);
			
			return 1;
			
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return 0;
		}
	}

}
