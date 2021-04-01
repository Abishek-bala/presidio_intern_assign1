package day19;

import java.util.List;

public interface UserDAO {
	public UserDTO findByID(Integer uid);
	public List<UserDTO> findAll();
	public int insertUser(UserDTO UserDTO);
	public int updateUser(UserDTO UserDTO);
	public int deleteUserByID(Integer uid);
	public int deleteUserByDTO(UserDTO UserDTO);
}
