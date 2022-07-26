package com.jdbc.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	//Define  our fields
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	//define constructors
	
	
	//Declaring List to contain reviews associated for one course
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	//Still need to understand why course_id 
	//foreign key is maintained in Course class instead of Review
	@JoinColumn(name="course_id") 
	private List<Review> reviews;
	
	
	
	//Adding a method to assocated reviews with courses
	
	public  void addReview(Review tmpReview)
	{
		if(reviews==null)
		{
			reviews=new ArrayList();
		}
		
		reviews.add(tmpReview);	
	}
	
	
	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	public Course()
	{
		
	}
	
	
	public Course(String title) {
		super();
		this.title = title;
	}


	

	//define getter and setter
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
	




}
