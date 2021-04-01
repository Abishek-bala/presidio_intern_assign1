package day19;

import java.util.List;

public interface CustomerDAO {
	public CustomerDTO findByID(Integer customerid);
	public List<CustomerDTO> findAll();
	public int insertCustomer(CustomerDTO customerdto);
	public int updateCustomer(CustomerDTO customerdto);
	public int deleteCustomerByID(Integer customerid);
	public int deleteCustomerByDTO(CustomerDTO customerdto);
}
