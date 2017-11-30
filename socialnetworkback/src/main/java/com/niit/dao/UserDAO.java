package com.niit.dao;

import java.util.List;


import com.niit.model.UserDetail;

public interface UserDAO 
{
	public boolean addUserDetail(UserDetail user);
	public boolean updateOnlineStatus(String status, UserDetail user);
/*	public UserDetail getUserDetail(String username);*/
	public List<UserDetail> getAllUserDetail();
	public UserDetail getUserDetail(String username);
}