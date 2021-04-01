package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/*
 * invid
 * itemid
 * qty
 */

import day18.DBUtility;

public class InvoiceTransDAOImpl implements InvoiceTranceDAO{

	@Override
	public InvoiceTransDTO findByID(Integer invoiceid) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from Invoicetrans where invid=?;");
			ps.setInt(1, invoiceid);
			ResultSet rs = ps.executeQuery();
			InvoiceTransDTO invoicetrans = InvoiceTransDTO.getInvoiceTransDTO();
			while(rs.next()) {
				invoicetrans.setInvoiceid(rs.getInt(1));
				invoicetrans.setItemid(rs.getInt(2));
				invoicetrans.setInvoiceid(rs.getInt(3));
			}
			DBUtility.closeConnection(null, null);
			return invoicetrans;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public List<InvoiceTransDTO> findAll() {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from Invoicetrans;");
			ResultSet rs = ps.executeQuery();
			InvoiceTransDTO invoicetrans = InvoiceTransDTO.getInvoiceTransDTO();
			List<InvoiceTransDTO> invoicetransList = new ArrayList<InvoiceTransDTO>();
			while(rs.next()) {
				invoicetrans.setInvoiceid(rs.getInt(1));
				invoicetrans.setItemid(rs.getInt(2));
				invoicetrans.setInvoiceid(rs.getInt(3));
				invoicetransList.add(invoicetrans);
			}
			DBUtility.closeConnection(null, null);
			return invoicetransList;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public int insertInvoiceTrans(InvoiceTransDTO InvoiceTransDTO) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into InvoiceTrans values(?,?,?);");
			ps.setInt(1, InvoiceTransDTO.getInvoiceid());
			ps.setInt(2,InvoiceTransDTO.getItemid());
			ps.setInt(3,InvoiceTransDTO.getQty());
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
	public int updateInvoiceTrans(InvoiceTransDTO InvoiceTransDTO) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update InvoiceTrans set  itemid=?, qty=? where invid=?;");
			ps.setInt(3, InvoiceTransDTO.getInvoiceid());
			ps.setInt(1,InvoiceTransDTO.getItemid());
			ps.setInt(2,InvoiceTransDTO.getQty());
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
	public int deleteInvoiceTransByID(Integer invoiceid) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			
//			St = con.createStatement();
			PreparedStatement ps = con.prepareStatement("delete from InvoiceTrans where invid = ?;");
			ps.setInt(1, invoiceid);
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
	public int deleteInvoiceTransByDTO(InvoiceTransDTO invoiceTransDTO) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			
//			St = con.createStatement();
			PreparedStatement ps = con.prepareStatement("delete from InvoiceTrans where invid = ?;");
			ps.setInt(1, invoiceTransDTO.getInvoiceid());
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
