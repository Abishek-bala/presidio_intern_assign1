package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/*
 * userid
 * username
 * password
 * flag
 */

import day18.DBUtility;

public class UserDAOImpl implements UserDAO{

	@Override
	public UserDTO findByID(Integer uid) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from User where userid=?;");
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			UserDTO user = UserDTO.getUserDTO();
			while(rs.next()) {
				user.setUid(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFlag(rs.getInt(4));
			}
			DBUtility.closeConnection(null, null);
			return user;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public List<UserDTO> findAll() {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from User;");
			ResultSet rs = ps.executeQuery();
			List<UserDTO>	userList = new ArrayList<UserDTO>();

			UserDTO user = UserDTO.getUserDTO();
			while(rs.next()) {
				user.setUid(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFlag(rs.getInt(4));
				userList.add(user);
			}
			DBUtility.closeConnection(null, null);
			return userList;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public int insertUser(UserDTO userDTO) {
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into User values(?,?,?,?);");
			ps.setInt(1, userDTO.getUid());
			ps.setString(2,userDTO.getUname());
			ps.setString(3,userDTO.getPassword());
			ps.setInt(4, userDTO.getFlag());
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
	public int updateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update User set  username=?, password=?, flag=? where userid=?;");
			ps.setInt(4, userDTO.getUid());
			ps.setString(1,userDTO.getUname());
			ps.setString(2,userDTO.getPassword());
			ps.setInt(3, userDTO.getFlag());
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
	public int deleteUserByID(Integer uid) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			
//			St = con.createStatement();
			PreparedStatement ps = con.prepareStatement("delete from User where userid = ?;");
			ps.setInt(1, uid);
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
	public int deleteUserByDTO(UserDTO userDTO) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			
//			St = con.createStatement();
			PreparedStatement ps = con.prepareStatement("delete from User where userid = ?;");
			ps.setInt(1, userDTO.getUid());
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
