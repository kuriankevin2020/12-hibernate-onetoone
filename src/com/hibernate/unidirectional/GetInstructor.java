package com.hibernate.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.unidirectional.entity.Instructor;
import com.hibernate.unidirectional.entity.InstructorDetail;

public class GetInstructor {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);

			System.out.println("Instructor: " + instructor);
			System.out.println("InstructorDetail: " + instructor.getInstructorDetail());

			session.getTransaction().commit();

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
