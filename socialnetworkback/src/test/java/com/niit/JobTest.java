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
import com.niit.dao.JobDAO;

import com.niit.model.Forum;
import com.niit.model.Job;

@ComponentScan("com.niit")
public class JobTest 
{
	@Autowired
	private static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBConfig.class);
		context.scan("com.niit.*");
         context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	
	
	@Test
	public void addJobTest()
	{
		Job job=new Job();
		//job.setJobId(12);
		job.setJobProfile("Developer");
		job.setJobDesc("Java Developer");
		job.setQualification("B.TECH");
		job.setStatus("Eligible");
		job.setPostDate(new java.util.Date());
		
		assertTrue("Problems in Inserting Job",jobDAO.addJob(job));
	}
	
	@Ignore
	@Test
	public void getAllJobTest()
	{
		List<Job> jobList=(List<Job>)jobDAO.getAllJobs();
		assertNotNull("Job list not found ",jobList.get(0));
		for(Job job:jobList)
		{
		System.out.println("JobID:"+ job.getJobId() + "JobProfile:"+ job.getJobProfile());
		}
	}

	@Ignore
	@Test
	public void getJobTest()
	{
		Job job=(Job)jobDAO.getJob(8);
	
		System.out.println("JobProfile:" + job.getJobProfile());
		System.out.println("JobDescription:" + job.getJobDesc());
		assertNotNull("Job not found", job);
	}
	
}
