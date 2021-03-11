package application;

import domain.Person;

public class Program {

	public static void main(String[] args) {
		Person p1 = new Person(1, "Carl Johnson", "cj@grovest.com");
		Person p2 = new Person(2, "Sean Johnson", "sj@grovest.com");
		Person p3 = new Person(3, "Kendl Johnson", "kj@grovest.com");

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

}
