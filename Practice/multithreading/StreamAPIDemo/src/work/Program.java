package work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
	 public static void main(String[] args) {
		// Create a list and filter a;ll even numbers:
		// 
		 
		  List<Integer> l1 = new ArrayList<>();
		  l1.add(1);
		  l1.add(2);
		  l1.add(33);
		  l1.add(45);
		  l1.add(54);
		  l1.add(67);
//		 System.out.println(l1);
		
		 
		 List<Integer> list = Arrays.asList(12,34,45,71,45,33,78);
		 System.out.println(list);
		 
		 
//		 list
//		 without stream
		 
		 List<Integer> evenList = new ArrayList<Integer>();
		 
		 for (Integer i : list) {
			if(i% 2 == 0) {
				evenList.add(i);
			}
		}
		  
		 System.out.println("Even List - "+ evenList);
		 
//		 using stream
		 
		 Stream<Integer> stream = list.stream();
		 List<Integer> newList = stream.filter(i->i%2 == 0).collect(Collectors.toList());
		 System.out.println("New List : "+newList);
		 
		 
		  
		 
	}
}
