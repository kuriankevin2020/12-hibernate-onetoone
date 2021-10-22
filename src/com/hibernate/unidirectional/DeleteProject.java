package com.hibernate.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.unidirectional.entity.Instructor;
import com.hibernate.unidirectional.entity.InstructorDetail;

public class DeleteProject {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		try {

			Session session = factory.getCurrentSession();
			session.beginTransaction();

			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);

			if (instructor != null) {
				session.delete(instructor);
			}

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
