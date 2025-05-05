package com.mario.main;
import com.mario.main.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
		
		Employee emp1 = new Employee();
    	emp1.setId(1);
    	emp1.setEname("Mario");
    	emp1.setEsal(50000);
    	emp1.setAddress("Kolkata");
    	
        Configuration cfg = new Configuration();
        cfg.configure("/com/mario/main/config/hibernate.cfg.xml");
        
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        // Create
//        try {
//        	session.save(emp1);
//            transaction.commit();
//            System.out.print("Employee added");
//        } catch(Exception e) {
//        	transaction.rollback();
//        	e.printStackTrace();
//        	System.out.print("Error occured Employee not added");
//        }
        
        
        // Read
//        try {
//        	Employee emp = session.get(Employee.class, 2L);
//        	
//        	if(emp != null) {
//        		System.out.println("Id: " + emp.getId());
//            	System.out.println("Name: " + emp.getEname());
//            	System.out.println("Salary: " + emp.getEsal());
//            	System.out.println("Address: " + emp.getAddress());
//        	} else {
//        		System.out.println("Employee not found");
//        	}
//        } catch(Exception e) {
//        	e.printStackTrace();
//        }
        
        // Update
//	    try {
//	    	Employee emp = session.get(Employee.class, 1L);
//	    	emp.setAddress("Pune");
//	    	emp.setEsal(90000);
//	    	session.update(emp);
//	        transaction.commit();
//	        System.out.print("Employee updated successfully");
//	    } catch(Exception e) {
//	    	transaction.rollback();
//	    	e.printStackTrace();
//	    	System.out.print("Error occured Employee not updated");
//	    }
        
        // Delete
	    try {
	    	Employee emp = new Employee();
	    	emp.setId(2L);
	    	session.delete(emp);
	        transaction.commit();
	        System.out.print("Employee deleted successfully");
	    } catch(Exception e) {
	    	transaction.rollback();
	    	e.printStackTrace();
	    	System.out.print("Error occured Employee not deleted");
	    }
	}

}
