package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("project started");

		SessionFactory sessionFactory = new Configuration().configure("com/hibernate/hibernate.cfg.xml")
				.buildSessionFactory();
		// System.out.println(sessionFactory);
		// System.out.println(sessionFactory.isClosed());

		Session session = sessionFactory.openSession();

		Employee employee = new Employee();
		employee.setEmployeeName("John Doe");
		employee.setEmployeeAddress("Texas");

		try {
			Transaction tx = session.beginTransaction();

			session.save(employee);

			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
