/*package com.backend.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class BlogComments {
	
@Id
int id;

@ManyToOne(targetEntity=Blog.class)
@JoinColumn(name="blogId")
int blogId;

String comment;
Date commentDate;

@ManyToOne(targetEntity=UserDetail.class)
@JoinColumn(name="userId")
int userId;

String username;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public Date getCommentDate() {
	return commentDate;
}

public void setCommentDate(Date commentDate) {
	this.commentDate = commentDate;
}



public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}





}
*/