package day19;

import java.io.Serializable;
import java.sql.Date;

public class InvoiceMasterDTO implements Serializable,Cloneable{
	private int invoiceid;
	private Date invdate;
	private int customerid;
	
	private static InvoiceMasterDTO invoicemasterdto;
	
	public static InvoiceMasterDTO getInvoiceMasterDTO() {
		if(invoicemasterdto == null) {
			invoicemasterdto = new InvoiceMasterDTO();
		}
		return invoicemasterdto.cloneInvoiceMasterDto();
	}
	
	private InvoiceMasterDTO cloneInvoiceMasterDto() {
		try {
			return (InvoiceMasterDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private InvoiceMasterDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}

	public Date getInvdate() {
		return invdate;
	}

	public void setInvdate(Date date) {
		this.invdate = date;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	@Override
	public String toString() {
		return "InvoiceMasterDTO [invoiceid=" + invoiceid + ", invdate=" + invdate + ", customerid=" + customerid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerid;
		result = prime * result + ((invdate == null) ? 0 : invdate.hashCode());
		result = prime * result + invoiceid;
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
		InvoiceMasterDTO other = (InvoiceMasterDTO) obj;
		if (customerid != other.customerid)
			return false;
		if (invdate == null) {
			if (other.invdate != null)
				return false;
		} else if (!invdate.equals(other.invdate))
			return false;
		if (invoiceid != other.invoiceid)
			return false;
		return true;
	}
	
	
}
