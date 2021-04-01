package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import day18.DBUtility;
/*
 * invid
 * invdate
 * customerid
 */
public class InvoiceMasterDAOImpl implements InvoiceMasterDAO {

	@Override
	public InvoiceMasterDTO findByID(Integer invoiceid) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from InvoiceMaster where invid=?;");
			ps.setInt(1, invoiceid);
			ResultSet rs = ps.executeQuery();
			InvoiceMasterDTO invoicemaster = InvoiceMasterDTO.getInvoiceMasterDTO();
			while(rs.next()) {
				invoicemaster.setInvoiceid(rs.getInt(1));
				invoicemaster.setInvdate(rs.getDate(2));
				invoicemaster.setCustomerid(rs.getInt(3));
			}
			DBUtility.closeConnection(null, null);
			return invoicemaster;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public List<InvoiceMasterDTO> findAll() {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from InvoiceMaster;");
			ResultSet rs = ps.executeQuery();
			InvoiceMasterDTO invoicemaster = InvoiceMasterDTO.getInvoiceMasterDTO();
			List<InvoiceMasterDTO> invoicemasterList = new ArrayList<InvoiceMasterDTO>();
			while(rs.next()) {
				invoicemaster.setInvoiceid(rs.getInt(1));
				invoicemaster.setInvdate(rs.getDate(2));
				invoicemaster.setCustomerid(rs.getInt(3));
				invoicemasterList.add(invoicemaster);
			}
			DBUtility.closeConnection(null, null);
			return invoicemasterList;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public int insertInvoiceMaster(InvoiceMasterDTO InvoiceMasterDTO) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into InvoiceMaster values(?,?,?);");
			ps.setInt(1, InvoiceMasterDTO.getInvoiceid());
			ps.setDate(2,InvoiceMasterDTO.getInvdate());
			ps.setInt(3,InvoiceMasterDTO.getCustomerid());
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
	public int updateInvoiceMaster(InvoiceMasterDTO InvoiceMasterDTO) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update InvoiceMaster set  invdate=?, customerid=? where invid=?;");
			ps.setInt(3, InvoiceMasterDTO.getInvoiceid());
			ps.setDate(1,InvoiceMasterDTO.getInvdate());
			ps.setInt(2,InvoiceMasterDTO.getCustomerid());
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
	public int deleteInvoiceMasterByID(Integer invoiceid) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			
//			St = con.createStatement();
			PreparedStatement ps = con.prepareStatement("delete from InvoiceMaster where invid = ?;");
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
	public int deleteInvoiceMasterByDTO(InvoiceMasterDTO invoiceMasterDTO) {
		try {
			Connection con = DBUtility.getConnection();
			
//			St = con.createStatement();
			PreparedStatement ps = con.prepareStatement("delete from InvoiceMaster where invid = ?;");
			ps.setInt(1, invoiceMasterDTO.getInvoiceid());
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
