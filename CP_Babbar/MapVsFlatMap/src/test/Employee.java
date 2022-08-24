package test;

import java.util.List;

public class Employee {
	public String name;
	public String company;
	public double salary;
	public List<String> citiesWorkedIn;
	@Override
	public String toString() {
		return "Employee [name=" + name + ", company=" + company + ", salary=" + salary + ", citiesWorkedIn="
				+ citiesWorkedIn + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public List<String> getCitiesWorkedIn() {
		return citiesWorkedIn;
	}
	public void setCitiesWorkedIn(List<String> citiesWorkedIn) {
		this.citiesWorkedIn = citiesWorkedIn;
	}
	public Employee(String name, String company, double salary, List<String> citiesWorkedIn) {
		super();
		this.name = name;
		this.company = company;
		this.salary = salary;
		this.citiesWorkedIn = citiesWorkedIn;
	}
	public Employee() {
		super();
	}
	
}
