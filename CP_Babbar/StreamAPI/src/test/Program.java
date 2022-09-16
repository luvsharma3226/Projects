package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

interface Phone {
	void call();

	default void message() {
		System.out.println("Messaging...");
	}
}

interface Phone2 {
	void call();

	default void message() {
		System.out.println("Messaging...");
	}
}

class AndroidPhone implements Phone, Phone2 {

	@Override
	public void call() {
		System.out.println("Caling...");
	}

	@Override
	public void message() {
		System.out.println("Android...");
	}

}

public class Program {

	public static void printPersonWithAge(List<Person> people, int age) {
		for (Person p : people) {
			if (p.getAge() > age) {
				p.printPerson();
			}
		}
	}

	public static void printPersonWithinAgeRange(List<Person> people, int low, int high) {
		for (Person p : people) {
			if (p.getAge() > low && p.getAge() <= high) {
				p.printPerson();
			}
		}
	}

	interface CheckPerson {
		public boolean test(Person p);
	}

	static class CheckPersonImpl implements CheckPerson {

		@Override
		public boolean test(Person p) {

			return p.getAge() > 21 && p.getAge() < 29 && p.getGndr() == Person.Sex.MALE;
		}

	}

	public static void printPeople(List<Person> people, Predicate<Person> tester) {
		for (Person p : people) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void main1(String[] args) {
		List<Person> people = Person.generateDefaultList();

//		System.out.println(people);
//		printPersonWithAge(people, 23);

//		printPersonWithinAgeRange(people, 23, 27);

//		printPeople(people, new CheckPersonImpl());

		Predicate<Person> pred = p -> p.getAge() <= 28 && p.getAge() >= 21 && p.getGndr() == Person.Sex.MALE;
		printPeople(people,pred);
		Consumer<Person> cons;

	}

	public static void main2(String[] args) {
		AndroidPhone a = new AndroidPhone();
		a.call();
		a.message();
	}

	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("Pooja", "Rai", 78000.0, List.of("p7", "p8")));
		empList.add(new Employee("Ajay", "Patil", 20000.0, List.of("P1", "p2")));
		empList.add(new Employee("Kedar", "Apet", 30000.0, List.of("P3", "p5")));
		empList.add(new Employee("Luv", "Sharma", 40000.0, List.of("P5", "p7")));
		empList.add(new Employee("Kishan", "Chand", 60000.0, List.of("P4", "p8")));

		Stream.of(empList).forEach(t -> System.out.println(t));
		
	}

}
