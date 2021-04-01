package day19;

import java.io.Serializable;

public class CustomerDTO implements Serializable,Cloneable {
	private int customerId;
	private String CustomerName;
	private String CustomerAddress;
	private int customerPhonenumber;
	private String customerAccountDetails;
	private int customergstnumber;

	private CustomerDTO() {
		// TODO Auto-generated constructor stub
	}

	public static CustomerDTO customerdto;
	
	public static CustomerDTO getCustomerDTO() {
		if(customerdto==null) {
			customerdto = new CustomerDTO();
		}
		return customerdto.cloneCustomerDTO();
	}
	
	private CustomerDTO cloneCustomerDTO() {
		try {
			return (CustomerDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", CustomerName=" + CustomerName + ", CustomerAddress="
				+ CustomerAddress + ", customerPhonenumber=" + customerPhonenumber + ", customerAccountDetails="
				+ customerAccountDetails + ", customergstnumber=" + customergstnumber + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerAddress() {
		return CustomerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}

	public int getCustomerPhonenumber() {
		return customerPhonenumber;
	}

	public void setCustomerPhonenumber(int customerPhonenumber) {
		this.customerPhonenumber = customerPhonenumber;
	}

	public String getCustomerAccountDetails() {
		return customerAccountDetails;
	}

	public void setCustomerAccountDetails(String customerAccountDetails) {
		this.customerAccountDetails = customerAccountDetails;
	}

	public int getCustomergstnumber() {
		return customergstnumber;
	}

	public void setCustomergstnumber(int customergstnumber) {
		this.customergstnumber = customergstnumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CustomerAddress == null) ? 0 : CustomerAddress.hashCode());
		result = prime * result + ((CustomerName == null) ? 0 : CustomerName.hashCode());
		result = prime * result + ((customerAccountDetails == null) ? 0 : customerAccountDetails.hashCode());
		result = prime * result + customerId;
		result = prime * result + customerPhonenumber;
		result = prime * result + customergstnumber;
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
		CustomerDTO other = (CustomerDTO) obj;
		if (CustomerAddress == null) {
			if (other.CustomerAddress != null)
				return false;
		} else if (!CustomerAddress.equals(other.CustomerAddress))
			return false;
		if (CustomerName == null) {
			if (other.CustomerName != null)
				return false;
		} else if (!CustomerName.equals(other.CustomerName))
			return false;
		if (customerAccountDetails == null) {
			if (other.customerAccountDetails != null)
				return false;
		} else if (!customerAccountDetails.equals(other.customerAccountDetails))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerPhonenumber != other.customerPhonenumber)
			return false;
		if (customergstnumber != other.customergstnumber)
			return false;
		return true;
	}
	
	
	
}
