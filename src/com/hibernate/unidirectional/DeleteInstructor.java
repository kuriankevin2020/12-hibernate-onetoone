package com.hibernate.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.unidirectional.entity.Instructor;
import com.hibernate.unidirectional.entity.InstructorDetail;

public class DeleteInstructor {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Instructor instructor1 = session.get(Instructor.class, 1);
			Instructor instructor2 = session.get(Instructor.class, 2);

			System.out.println(instructor1);

			session.delete(instructor1);
			session.delete(instructor2);

			session.getTransaction().commit();

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
