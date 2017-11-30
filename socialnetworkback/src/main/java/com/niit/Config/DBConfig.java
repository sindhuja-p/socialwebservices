package com.niit.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.BlogDAO;
import com.niit.dao.BlogDAOImpl;
import com.niit.dao.ForumDAO;
import com.niit.dao.ForumDAOImpl;
import com.niit.dao.JobDAO;
import com.niit.dao.JobDAOImpl;
import com.niit.dao.UserDAO;
import com.niit.dao.UserDAOImpl;
import com.niit.model.Blog;
import com.niit.model.Forum;
import com.niit.model.Job;
import com.niit.model.UserDetail;




@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
@Component
public class DBConfig {

	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("SINDHU");
		dataSource.setPassword("5868168");

		System.out.println("DataBase is connected.........!");
		return dataSource;

	}

	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
		return properties;

	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(UserDetail.class);
		sessionBuilder.addAnnotatedClasses(Job.class);
		sessionBuilder.addAnnotatedClasses(Blog.class);
		sessionBuilder.addAnnotatedClasses(Forum.class);
		sessionBuilder.scanPackages("com.niit");
		System.out.println("Session is crated................!");

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction is created............!");
		return transactionManager;
	}
	
	@Autowired
	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO(SessionFactory sessionFactory)
	{
		System.out.println("Blog DAO object Created");
		return new BlogDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="forumDAO")
	public ForumDAO getForumDAO(SessionFactory sessionFactory)
	{
		System.out.println("ForumDAO object Created");
		return new ForumDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		System.out.println("User object Created");
		return new UserDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "jobDAO")
	public JobDAO getJobDAO(SessionFactory sessionFactory)
	{
		System.out.println("User object Created");
		return new JobDAOImpl(sessionFactory);
	}
	
}

  