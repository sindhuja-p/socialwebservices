package com.niit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.Config.DBConfig;
import com.niit.dao.UserDAO;

import com.niit.model.Forum;
//import com.nii.model.Job;
import com.niit.model.UserDetail;


@ComponentScan("com.niit")
public class UserTest 
{
	@Autowired
	private static UserDAO  userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBConfig.class);
		context.scan("com.niit");
		context.refresh();

		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	
	@Test
	public void addUserTest()
	{
		UserDetail user=new UserDetail();
		user.setUserId(14);
		user.setFirstName("Sindhuja");
		user.setLastName("ponnaganti");
		user.setEmailId("sindhujaponnaganti.com");
		user.setPassword("56789");
		user.setRole("User");
		user.setStatus("P");
		user.setIsOnline("O");
		assertTrue("Problem in Inserting user", userDAO.addUserDetail(user));

	}

	@Ignore
	@Test
	public void getAllUserTest()
	{
		List<UserDetail> userList=(List<UserDetail>)userDAO.getAllUserDetail();
		assertNotNull("Job list not found ",userList.get(0));
		for(UserDetail user:userList)
		{
			System.out.println("EmailID:"+ user.getEmailId() + "Status:"+ user.getStatus());
		}
	}
	
}
