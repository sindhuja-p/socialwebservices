package com.backend.restcontroller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.DAO.BlogDAO;
import com.backend.model.Blog;

@RestController
public class BlogController {

	@Autowired 
	BlogDAO blogDAO;
	/*@Autowired
	BlogService blogService;
	
	@RequestMapping(value="/createBlog",method=RequestMethod.POST)
	public ResponseEntity<?> createBlog(@RequestBody Blog blog,HttpSession session){
		
		Integer userId = (Integer) session.getAttribute("userId");
		 if(userId==null)
		    {
		    	return new ResponseEntity<String>("User session details not found",HttpStatus.UNAUTHORIZED);

			}	   
		    else	
		    {
				UsersDetails user = userService.getUserById(userId);
				
				if(user.isOnline()){
					blog.setUserId(user.getUserId());
					blog.setUserName(user.getUserName());
					blog.setStatus("PENDING");
					blog.setCreateDate(new Date());
					blog.setLikes(0);
					if(blogService.addBlog(blog)){
						return new ResponseEntity<Blog>(blog, HttpStatus.OK);
					}else{
						return new ResponseEntity<String>(new String (null, 11,userId, "Blog Creation failed"), HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}
				return new ResponseEntity<String>("User must be logged in to create blog",HttpStatus.CONFLICT);
			}
	
	@RequestMapping(value="/viewBlogs",method=RequestMethod.GET)
	public ResponseEntity<?> viewBlogs(){
		List<Blog> blogList = blogService.getAllApprovedBlog();
		if(blogList!=null){
				return new ResponseEntity<List<Blog>>(blogList, HttpStatus.OK);
		}
		else
		{
				return new ResponseEntity<String>("Retrieving Blog details failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
	@PostMapping(value="/insertBlog")
	public ResponseEntity<String> insertBlog(@RequestBody Blog blog)
	{
		if(blogDAO.addBlog(blog))
		{
			return new ResponseEntity<String>("Blog Added",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
		}
	
	@PostMapping(value="/updateBlog")
	public ResponseEntity<String> updateBlog(@RequestBody Blog blog)
	{
		if(blogDAO.updateBlog(blog))
		{
			return new ResponseEntity<String>("Blog updated",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
		}
	
	
	@PostMapping(value="/deleteBlog")
	public ResponseEntity<String> deleteBlog(@RequestBody Blog blog)
	{
		Blog tempblog=blogDAO.getBlog(blog.getBlogId());
		
		if(blogDAO.deleteBlog(tempblog))
		{
			return new ResponseEntity<String>("Blog deleted",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Blog deletion",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@GetMapping(value="/getAllBlogs")
	public ResponseEntity<ArrayList<Blog>> getAllBlogs()
	{
		ArrayList listBlogs=(ArrayList)blogDAO.getAllBlogs();
		return new ResponseEntity<ArrayList<Blog>>(listBlogs,HttpStatus.SERVICE_UNAVAILABLE);
	}
	}
	

