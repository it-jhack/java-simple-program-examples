package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class Program {

	public static void main(String[] args) {
		// id = null because database will create/increment value
//		Person p1 = new Person(null, "Carl Johnson", "cj@grovest.com");
//		Person p2 = new Person(null, "Sean Johnson", "sj@grovest.com");
//		Person p3 = new Person(null, "Kendl Johnson", "kj@grovest.com");
		
		// In persistence.xml: <persistence-unit name="jpa-example"
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
		EntityManager em = emf.createEntityManager();
		
//		em.getTransaction().begin();
//		
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		
//		em.getTransaction().commit();
		
		// Searching for specific person on db
		Person p = em.find(Person.class, 10);
		System.out.println(p);
		
		// To delete a obj from db, it needs to be "monitored" instead of "detached",
		// which means it needs to be an object you just inserted, or an object you 
		// searched and still did not close the Entity Manager.
		
		// This works
		//em.getTransaction().begin();
		//Person p = em.find(Person.class, 13);
		//em.remove(p);
		//em.getTransaction().commit();
		
		// This does NOT work
		//em.getTransaction().begin();
		//Person p = new Person(14, "John Doe", "jd@example.com")
		//em.remove(p);
		//em.getTransaction().commit();
		
		em.close();
		emf.close();

		System.out.println("Program finished");
	}

}
