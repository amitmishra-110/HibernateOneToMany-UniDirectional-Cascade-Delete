package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Course;
import com.jdbc.hibernate.entity.Instructor;
import com.jdbc.hibernate.entity.InstructorDetail;
import com.jdbc.hibernate.entity.Review;


public class GetCoursesReviewsDemo {

	public static void main(String[] args) 
	{
			
		//Create SessionFactory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		//Create Session
		Session  session=factory.getCurrentSession();
		
		try
		{
		
			//start a transaction
			session.beginTransaction();

			//get the course
			int getId=10;
			Course course=session.get(Course.class,getId);
			
			//print the course
			System.out.println("Enrolled Course is :" +course);
			
			System.out.println("Deleting the Course");
			
			//print the reviews
			System.out.println("Reviews for Enrolled Course :" +course.getReviews());
			
				
			//commit the transaction
			session.delete(course);
			
			session.getTransaction().commit();
			session.close(); //closing the session so that the value get into the memory after reading and to prevent memory leakage we can close it
		
			  
			 
			System.out.println("Done!!");
		}
		finally
		{
			session.close();
			factory.close();
		}
	}
	

	}
