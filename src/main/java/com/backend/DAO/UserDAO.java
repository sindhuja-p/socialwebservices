package com.backend.DAO;

import java.util.List;

import com.backend.model.Forum;
import com.backend.model.UsersDetails;

public interface UserDAO {
	
public boolean saveUser(UsersDetails user);
	
	public boolean updateUser(UsersDetails user);
	
	public boolean deleteUser(int id);
	
	public UsersDetails getUserById(int userId);
	
	public UsersDetails getUserByEmail(String email);
	
	public UsersDetails getUserByName(String name);
	
	public List<UsersDetails> getAllUsers();

	public boolean checkIfExistingUser(UsersDetails user);

	public boolean checkIfValidUser(String username, String password);

}
