package com.hibermapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibermapping.entity.Bank;
import com.hibermapping.entity.User;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("com/hibermapping/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Bank bank1 = new Bank();
		bank1.setBankId(101);
		bank1.setBankName("SBI");

		Bank bank2 = new Bank();
		bank2.setBankId(102);
		bank2.setBankName("HDFC");

		User user1 = new User();
		user1.setUserId(1);
		user1.setUserName("JOhn Doe");
		user1.setBank(bank1);

		User user2 = new User();
		user2.setUserId(2);
		user2.setUserName("Bob");
		user2.setBank(bank2);

		Transaction transaction = session.beginTransaction();
		session.save(bank1);
		session.save(bank2);
		session.save(user1);
		session.save(user2);

		transaction.commit();
		session.close();
	}
}
