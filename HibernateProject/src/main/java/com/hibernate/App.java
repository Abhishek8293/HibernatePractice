package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       System.out.println("project started");
       
       SessionFactory sessionFactory = new Configuration().configure("com/hibernate/hibernate.cfg.xml").buildSessionFactory();
       System.out.println(sessionFactory);
       System.out.println(sessionFactory.isClosed());
       
    }
}
