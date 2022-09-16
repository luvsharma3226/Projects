package test;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	public Employee() {
		this.firstName = "";
		this.lastName = "";
		this.salary = 0.0;
		this.projects = null;
	}

	private String firstName;
	private String lastName;
	private Double salary;
	private List<String> projects;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", projects="
				+ projects + "]";
	}

	public Employee(String firstName, String lastName, Double salary, List<String> projects) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.projects = projects;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<String> getProjects() {
		return projects;
	}

	public void setProjects(List<String> projects) {
		this.projects = projects;
	}
	
	public void printPerson() {
		System.out.println(this.toString());
	}
	
	public static List<Employee> generateEmployees(){
		List<Employee> people = new ArrayList<Employee>();
		
		people.add(new Employee("Kishan", "Arora", 600.0, List.of("p1", "p2")));
		people.add(new Employee("Luv", "Sharma", 800.0, List.of("p1", "p2")));
		people.add(new Employee("Kedar", "Apet", 620.0, List.of("p1", "p2")));
		return people;
				
	}

}
