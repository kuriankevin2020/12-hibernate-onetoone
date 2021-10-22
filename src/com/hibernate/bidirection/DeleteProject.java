package com.hibernate.bidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.bidirection.entity.Instructor;
import com.hibernate.bidirection.entity.InstructorDetail;


public class DeleteProject {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		try {
			
			session.beginTransaction();

			int theId = 1;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

			if (instructorDetail != null) {
				session.delete(instructorDetail);
			}

			session.getTransaction().commit();

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
