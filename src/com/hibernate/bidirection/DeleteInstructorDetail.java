package com.hibernate.bidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.bidirection.entity.Instructor;
import com.hibernate.bidirection.entity.InstructorDetail;

public class DeleteInstructorDetail {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			InstructorDetail instructorDetail1 = session.get(InstructorDetail.class, 1);
			InstructorDetail instructorDetail2 = session.get(InstructorDetail.class, 2);

			session.delete(instructorDetail1);
			session.delete(instructorDetail2);

			session.getTransaction().commit();

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
