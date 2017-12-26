/*/package com.backend.Test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.BlogCommentDAO;

import com.backend.config.DbConfig;

import com.backend.model.BlogComments;

@ComponentScan("com.backend")
public class BlogCommentTest {
static BlogCommentDAO blogcommentDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("com.backend");
         context.refresh();
		
		blogcommentDAO=(BlogCommentDAO)context.getBean("blogcommentDAO");
	}
	

	@Test
	public void addBlogCommentTest()
	{
		BlogComments blogcomment=new BlogComments();
	blogcomment.setId(1);
	blogcomment.setComment("good blog");
	blogcomment.setCommentDate(new java.util.Date());
	blogcomment.setUsername("rahul");

	
	assertTrue("Problem in Inserting BlogComment",blogcommentDAO.addBlogComment(blogcomment));
}
}*/