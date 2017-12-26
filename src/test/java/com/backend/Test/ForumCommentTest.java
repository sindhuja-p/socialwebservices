/*package com.backend.Test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.ForumCommentDAO;

import com.backend.config.DbConfig;
import com.backend.model.ForumComment;


@ComponentScan("com.backend")
public class ForumCommentTest {
	
static ForumCommentDAO  forumcommentDAO;

@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.register(DbConfig.class);
	context.scan("com.backend");
	context.refresh();

	 forumcommentDAO =(ForumCommentDAO)context.getBean("forumcommentDAO");
}

@Test
public void addForumTest()
{
	ForumComment forum=new ForumComment();
	
	forum.setUsername("java");
	forum.setComment("Good site");
	forum.setCommentDate(new java.util.Date());
	

	assertTrue("Problem in Inserting forum comment", forumcommentDAO.addForumComment(forum));
}

}*/