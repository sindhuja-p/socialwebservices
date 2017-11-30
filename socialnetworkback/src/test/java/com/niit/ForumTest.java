package com.niit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.Config.DBConfig;
import com.niit.dao.ForumDAO;
import com.niit.model.Forum;


@ComponentScan("com.niit")
public class ForumTest {
	
static ForumDAO  forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBConfig.class);
		context.scan("com.niit");
		context.refresh();

		 forumDAO=(ForumDAO)context.getBean("forumDAO");
	}

	
	@Test
	public void addTest()
	{
		Forum forum=new Forum();
		forum.setForumId(110);
		forum.setForumName("JNTUhforum");
		forum.setForumContent(" srivasaviCollege");
		forum.setUserName("jntuh");
		forum.setStatus("n");
		forum.setCreateDate(new java.util.Date());
		
		assertTrue("Problem in Inserting forum", forumDAO.addForum(forum));
	}
	@Ignore
	@Test
	public void updateForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(101);
		forum.setForumName("javaexception");
	    forum.setForumContent("Study forum");
		assertTrue("Problem in updating Forum",forumDAO.updateForum(forum));
	}
	@SuppressWarnings("restriction")
  @Ignore
	@Test
	public void getForumTest(){
		Forum forum=(Forum)forumDAO.getForum(103);
		
		System.out.println("Forum Name:" + forum.getForumName());
		System.out.println("ForumContent:" +forum.getForumContent());
		
		assertNotNull("Forum not found", forum);
	}
	
 @Ignore
	@Test
	public void deleteForumTest(){
		Forum forum=(Forum)forumDAO.getForum(104);
		assertTrue("Problem in deletion",forumDAO.deleteForum(forum));
	}
 @SuppressWarnings("restriction")
	@Ignore
	@Test
	public void approveForumTest(){
		Forum forum=(Forum)forumDAO.getForum(102);
		assertTrue("Problem in approving",forumDAO.approveForum(forum));
	}
	
	@Test
	public void getAllForumTest(){
		List<Forum> forumList=(List<Forum>)forumDAO.getAllForums();
		assertNotNull("Forum list not found ",forumList.get(0));
		for(Forum forum:forumList)
		{
			System.out.println("ForumID:"+forum.getForumId() + "ForumName:"+forum.getForumName());
		}
	}
		

		
	}

    