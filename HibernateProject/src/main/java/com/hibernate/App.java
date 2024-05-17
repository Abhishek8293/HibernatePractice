package com.hibernate;

import java.io.FileInputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Bank;
import com.hibernate.entity.Employee;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("project started");

		// Create a Session Factory Object using Configuration class
		SessionFactory sessionFactory = new Configuration().configure("com/hibernate/hibernate.cfg.xml")
				.buildSessionFactory();

		// Open session using session Factory object
		Session session = sessionFactory.openSession();

		// Reading the image file and converting into byte of stream
		FileInputStream fis = new FileInputStream("C:/Users/LENOVO/Downloads/GMZ8NDTXAAA4DC1.jpeg");
		// creating an byte [] to store the byte of stream
		// fis.available() is used to define the size of array equals to the byte of
		// stream.
		byte[] image = new byte[fis.available()];
		// Reading the byte stream to byte array named "image"
		fis.read(image);

		Bank bank1 = new Bank();
		bank1.setBankName("SBI");
		bank1.setBankLocation("Raipur");

		Bank bank2 = new Bank();
		bank2.setBankName("HDFC");
		bank2.setBankLocation("Pachpedi Naka");

		Employee emp1 = new Employee();
		emp1.setEmployeeName("name1");
		emp1.setEmployeeAddress("address 1 ");
		emp1.setImage(image);
		emp1.setBank(bank1);

		Employee emp2 = new Employee();
		emp2.setEmployeeName("name2");
		emp2.setEmployeeAddress("address 2 ");
		emp2.setImage(image);
		emp2.setBank(bank2);

		try {
			// Begin the transaction
			Transaction tx = session.beginTransaction();

			session.save(emp1);
			session.save(emp2);

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
