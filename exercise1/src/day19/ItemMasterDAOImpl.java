package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day18.DBUtility;

public class ItemMasterDAOImpl implements ItemMasterDAO{
	/*
	 * itemid
	 * name
	 * unit
	 * price
	 */
	@Override
	public ItemDTO findByID(Integer itemid) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from ItemMaster where itemid=?;");
			ps.setInt(1, itemid);
			ResultSet rs = ps.executeQuery();
			ItemDTO item = ItemDTO.getItemDTO();
			while (rs.next()) {
				item.setItemid(rs.getInt(1));
				item.setItem_name(rs.getString(2));
				item.setItem_unit(rs.getInt(3));
				item.setPrice(rs.getInt(4));
			}
			DBUtility.closeConnection(null, null);
			return item;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return null;
		}
			
	}

	@Override
	public List<ItemDTO> findAll() {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from ItemMaster");
			ItemDTO item = ItemDTO.getItemDTO();
			List<ItemDTO>	itemList = new ArrayList<ItemDTO>();
			while(rs.next()) {
				item.setItemid(rs.getInt(1));
				item.setItem_name(rs.getString(2));
				item.setItem_unit(rs.getInt(3));
				item.setPrice(rs.getInt(4));
				itemList.add(item);
			}
			DBUtility.closeConnection(null, null);
			return itemList;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public int insertItem(ItemDTO itemDTO) {
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into ItemMaster values(?,?,?,?);");
			ps.setInt(1, itemDTO.getItemid());
			ps.setString(2,itemDTO.getItem_name());
			ps.setInt(3,itemDTO.getItem_unit());
			ps.setFloat(4, itemDTO.getPrice());
			ps.execute();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return 0;
		}
	}

	@Override
	public int updateItem(ItemDTO itemDTO) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update ItemMaster set  itemname=?, itemunit=?, itemprice=? where itemid=?;");
			
			ps.setInt(4, itemDTO.getItemid());
			ps.setString(1,itemDTO.getItem_name());
			ps.setInt(2,itemDTO.getItem_unit());
			ps.setFloat(3, itemDTO.getPrice());
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
	public int deleteItemByID(Integer itemid) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			
//			St = con.createStatement();
			PreparedStatement ps = con.prepareStatement("delete from ItemMaster where Itemid = ?;");
			ps.setInt(1, itemid);
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
	public int deleteItemByDTO(ItemDTO itemDTO) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			
//			St = con.createStatement();
			PreparedStatement ps = con.prepareStatement("delete from ItemMaster where Itemid = ?;");
			ps.setInt(1, itemDTO.getItemid());
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
