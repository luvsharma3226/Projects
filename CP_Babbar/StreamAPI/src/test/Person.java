package test;

import java.util.ArrayList;
import java.util.List;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	public String name;
	public int age;
	public Sex gndr;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getGndr() {
		return gndr;
	}

	public void setGndr(Sex gndr) {
		this.gndr = gndr;
	}

	
	
	public Person(String name, int age, Sex gndr) {
		super();
		this.name = name;
		this.age = age;
		this.gndr = gndr;
	}
	
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gndr=" + gndr + "]";
	}

	public void printPerson() {
		System.out.println(this.toString());
	}

	
	public static List<Person> generateDefaultList() {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Kishan", 22, Sex.MALE));
		people.add(new Person("Luv", 24, Sex.MALE));
		people.add(new Person("Amit", 28, Sex.MALE));
		people.add(new Person("Pooja", 28, Sex.FEMALE));
		return people;

	}

}
