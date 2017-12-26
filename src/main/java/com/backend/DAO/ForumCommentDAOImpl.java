//package com.backend.DAO;
//
//
//
//import java.util.List;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.backend.model.ForumComment;
//
//@Repository("ForumCommentDAO")
//public class ForumCommentDAOImpl implements ForumCommentDAO {
//
//	@Autowired
//	SessionFactory sessionFactory;
//	
//	ForumCommentDAO forumcommentDAO;
//	
//	public ForumCommentDAOImpl(SessionFactory sessionFactory)
//	{
//		this.sessionFactory=sessionFactory;
//	}
//	
//	@Transactional
//	public boolean addForumComment(ForumComment comment) {
//		try
//		{
//		    sessionFactory.getCurrentSession().save(comment);
//			return true;
//			
//		}catch(Exception e){
//			System.out.println("Exception raised: "+e);
//			return false;
//		}
//	}
//
//	public boolean updateForumComment(ForumComment comment) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public boolean deleteForumComment(ForumComment comment) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public ForumComment getForumComment(int forumCommentId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<ForumComment> getAllForumComments(int forumId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//
//}