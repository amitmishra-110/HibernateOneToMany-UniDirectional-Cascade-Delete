package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Course;
import com.jdbc.hibernate.entity.Instructor;
import com.jdbc.hibernate.entity.InstructorDetail;
import com.jdbc.hibernate.entity.Review;


public class CreateCoursesReviewsDemo {

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

			//OneToMany Unidirectional Example
			//create course
			Course tmpCourse=new Course("cricket");
			
			
			//create review 
			Review tmpReview=new Review("Best");
			Review footballReview =new Review("Excellent");
			Review tennisReview=new Review("Average");
			
			//add review to course
			tmpCourse.addReview(tmpReview);
			tmpCourse.addReview(footballReview);
			tmpCourse.addReview(tennisReview);
			
			
			//save the course and review with help of cascade type all
			session.save(tmpCourse);
			
			
			
			
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
		}
		finally
		{
			session.close();
			factory.close();
		}
	}
	

	}
