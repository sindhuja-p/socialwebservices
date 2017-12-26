package com.backend.DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.model.Forum;
import com.backend.model.UsersDetails;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDAO userDAO;
	
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

@Transactional
	public boolean saveUser(UsersDetails user) {
		try{
			Session session = sessionFactory.getCurrentSession();
			user.setEnabled(true);
			user.setOnline(false);
			session.save(user);
			return true;
		}catch(Exception e){
			return false;
		}
	}

@Transactional
	public boolean updateUser(UsersDetails user) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.update(user);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Transactional
	public boolean deleteUser(int id) {
		try
		{
			Session session = sessionFactory.getCurrentSession();
			UsersDetails user = session.get(UsersDetails.class, id);
			session.delete(user);
			return true;
			
		}catch(Exception e){
			
			System.out.println("Exception raised: "+e);
			return false;
		}
	}

	@Transactional
	public UsersDetails getUserById(int userId) {
		String queryString = "from UsersDetails where c_user_id = :userId";
		UsersDetails userObj = (UsersDetails) sessionFactory.getCurrentSession().createQuery(queryString).setParameter("userId",userId).uniqueResult();
		return userObj;
	}

	@Transactional
	public UsersDetails getUserByEmail(String email) {
		String queryString = "from UsersDetails where email = :email";
		UsersDetails userObj = (UsersDetails) sessionFactory.getCurrentSession().createQuery(queryString).setParameter("email",email).uniqueResult();
		return userObj;
	}

	@Transactional
	public UsersDetails getUserByName(String name) {
		String queryString = "from UsersDetails where username = :name";
		UsersDetails userObj = (UsersDetails) sessionFactory.getCurrentSession().createQuery(queryString).setParameter("name",name).uniqueResult();
		return userObj;
	}

	@Transactional
	public List<UsersDetails> getAllUsers() {
		String queryString = "from UsersDetails";
		List<UsersDetails> userList = sessionFactory.getCurrentSession().createQuery(queryString).list();
		return userList;
	}

	@Transactional
	public boolean checkIfExistingUser(UsersDetails user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	public boolean checkIfValidUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}



}
