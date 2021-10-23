package com.hibernate.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.unidirectional.entity.Instructor;
import com.hibernate.unidirectional.entity.InstructorDetail;

public class CreateInstructor {

	public static void main(String[] args) {

		Instructor instructor1 = new Instructor("Kurian", "Kevin", "kuriankevin@gmail.com");
		InstructorDetail instructorDetail1 = new InstructorDetail("https://www.kuriankevin.com/youtube",
				"Luv 2 Code!!!");
		instructor1.setInstructorDetail(instructorDetail1);

		Instructor instructor2 = new Instructor("Vineeth", "Neelan", "vineethneelan@gmail.com");
		InstructorDetail instructorDetail2 = new InstructorDetail("https://www.vineethneelan.com/youtube",
				"Luv 2 Code!!!");
		instructor2.setInstructorDetail(instructorDetail2);

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			session.save(instructor1);
			session.save(instructor2);
			session.getTransaction().commit();

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
