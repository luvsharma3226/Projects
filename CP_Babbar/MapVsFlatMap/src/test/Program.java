package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Program {

	public static void main(String[] args) {
		
		
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("Amit", "CDAC", 21100.0, List.of("Hyderabad","Ahmedabad","Gurugram")));
		empList.add(new Employee("Atul", "gsn games", 21100.0, List.of("Pune","Hapur","Surat")));
		empList.add(new Employee("Nishtha", "Microsoft", 21100.0, List.of("Moradabad","Ahmedabad","Gurugram")));
		empList.add(new Employee("Sanchit", "Google", 21100.0, List.of("Pune","Delhi","Bangalore")));
		
		System.out.println(empList);
		
		//Map = takes a stream and perform a function on each element of stream and returns a stream.
		 List<List<String>> citiesMap = empList.stream().map(e->e.getCitiesWorkedIn()).collect(Collectors.toList());
		System.out.println(citiesMap);
		
//		FlatMAP == takes a stream and perform a function on each element of stream and returns a stream after flatenning
		// converts two level to one level

		Set<String> cities = empList.stream().flatMap(e->e.getCitiesWorkedIn().stream()).collect(Collectors.toSet());
		System.out.println(cities);
		
		
		//and if you want to remove duplicate values then use Set to store the data returned.
		
	}

}
