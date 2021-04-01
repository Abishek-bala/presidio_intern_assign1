package day19;

import java.io.Serializable;

public class InvoiceTransDTO implements Serializable,Cloneable  {
	private int invoiceid;
	private int itemid;
	private int qty;
	private static InvoiceTransDTO invoicetransdto;
	
	public static InvoiceTransDTO getInvoiceTransDTO() {
		if(invoicetransdto == null) {
			invoicetransdto = new InvoiceTransDTO();
		}
		return invoicetransdto;
	}
	
	private InvoiceTransDTO cloneInvoiceTransDTO() {
		try {
			return (InvoiceTransDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private InvoiceTransDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InvoiceTransDTO [invoiceid=" + invoiceid + ", itemid=" + itemid + ", qty=" + qty + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + invoiceid;
		result = prime * result + itemid;
		result = prime * result + qty;
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
		InvoiceTransDTO other = (InvoiceTransDTO) obj;
		if (invoiceid != other.invoiceid)
			return false;
		if (itemid != other.itemid)
			return false;
		if (qty != other.qty)
			return false;
		return true;
	}
	public int getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
}
