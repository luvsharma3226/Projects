package work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Methods {

	public static void main(String[] args) {
		//filter
		
		//map
		
		List<String> names = new ArrayList<String>();
		names.add("Pooja");
		names.add("Ajay");
		names.add("Kedar");
		names.add("Luv");
		names.add("Kishan");
		names.add("Shivam");
		names.add("Akhila");
		names.add("Snehal");
		
//		Stream<String> stream = names.stream();
		List<String> strStartingWithA = names.stream().filter(e->e.startsWith("A")).collect(Collectors.toList());
//		System.out.println(strStartingWithA);
		
		
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(9);
		l2.add(4);
		l2.add(5);
		l2.add(7);
		l2.add(34);
		
		List<Integer> res = l2.stream().map(i -> i * i).collect(Collectors.toList());
//		System.out.println(res);
		
		
		//forEach
		
		l2.stream().forEach(e-> {
//			System.out.println(e);
		});
		
//		l2.stream().forEach(System.out::println);
		
		//Sorted
		
		l2.stream().sorted().forEach(System.out::println);
	
//		 compareTo
		Integer integer = l2.stream().min((a,b)->a.compareTo(b)).get();
		System.out.println("Min = "+integer);
		
		
		Integer max = l2.stream().max((a,b)->a.compareTo(b)).get();
		System.out.println("Max = "+max);
		
		
	}

}
