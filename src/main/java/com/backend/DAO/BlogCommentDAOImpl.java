/*package com.backend.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.model.BlogComments;

@Repository("BlogCommentsDAO")

public class BlogCommentDAOImpl implements BlogCommentDAO {


	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	BlogCommentDAO blogDAOComment;
	
	public   BlogCommentDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
@Transactional
	public boolean addBlogComment(BlogComments blogcomment) {
		try
		{
		sessionFactory.getCurrentSession().save(blogcomment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Problem in exception:" +e);
		return false;
		}	
	}

}
*/