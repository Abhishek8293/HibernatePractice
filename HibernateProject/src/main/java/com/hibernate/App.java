package com.hibernate;

import java.io.FileInputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("project started");

		// Create a Session Factory Object using Configuration class
		SessionFactory sessionFactory = new Configuration().configure("com/hibernate/hibernate.cfg.xml")
				.buildSessionFactory();

		// Open session using session Factory object
		Session session = sessionFactory.openSession();

		// Create an object of Entity class
		Employee employee = new Employee();
		employee.setEmployeeName("John Doe");
		employee.setEmployeeAddress("Texas");
		employee.setX(1234);

		FileInputStream fis = new FileInputStream("C:/Users/LENOVO/Downloads/GMZ8NDTXAAA4DC1.jpeg");
		byte[] image = new byte[fis.available()];
		fis.read(image);
		employee.setImage(image);

		try {
			// Begin the transaction
			Transaction tx = session.beginTransaction();

			// save the object using the save() method of session object
			session.save(employee);

			// Commit all the changes
			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Closing the session after transaction completed
			session.close();
		}
	}
}
