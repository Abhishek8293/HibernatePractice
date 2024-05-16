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
//		employee.setEmployeeName("Jena Ortega");
//		employee.setEmployeeAddress("California");
//		employee.setX(1234);
		employee.setEmployeeId(1);
		

		//Reading the image file and converting into byte of stream
		FileInputStream fis = new FileInputStream("C:/Users/LENOVO/Downloads/GMZ8NDTXAAA4DC1.jpeg");
		//creating an byte [] to store the byte of stream
		//fis.available() is used to define the size of array equals to the byte of stream.
 		byte[] image = new byte[fis.available()];
 		//Reading the byte stream to byte array named "image"
		fis.read(image);
		employee.setImage(image);

		try {
			// Begin the transaction
			Transaction tx = session.beginTransaction();

			// save the object using the save() method of session object
			//session.save(employee);
			//session.delete(employee);
		 Employee result = 	session.get(Employee.class, 4); //To get the object from database
		 result.setEmployeeName("updated");
		 session.update(result);
		 
		

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
