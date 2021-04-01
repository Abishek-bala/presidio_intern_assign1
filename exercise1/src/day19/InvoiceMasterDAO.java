package day19;

import java.util.List;

public interface InvoiceMasterDAO {
	public InvoiceMasterDTO findByID(Integer invoiceid);
	public List<InvoiceMasterDTO> findAll();
	public int insertInvoiceMaster(InvoiceMasterDTO InvoiceMasterDTO);
	public int updateInvoiceMaster(InvoiceMasterDTO InvoiceMasterDTO);
	public int deleteInvoiceMasterByID(Integer invoiceid);
	public int deleteInvoiceMasterByDTO(InvoiceMasterDTO InvoiceMasterDTO);
}
