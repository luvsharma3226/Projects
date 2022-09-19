package work;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObj {

	public static void main(String[] args) {
		
//		Stream API - collection process
//		Collection / Group of objects
		
		// 1. black stream
		Stream<Object> empty = Stream.empty();
		
//		2 - array , object , collection
		String names[] = {"Anuj", "Mintu", "Shekhar", "Deepu","Divya"};
		Stream<String> st = Stream.of(names);
		st.forEach(e->{
			System.out.println(e);
		});
		
//		3 
		Stream<Object> builder = Stream.builder().build();

//		4
		IntStream stream = Arrays.stream(new int[] {1,2,3,5,645,342,545,646,45356,4,45});
		stream.forEach(e->{
			System.out.println(e);
		});
		
		
//		5
		List<Integer> list = new ArrayList<>();
		list.add(212);
		list.add(25);
		list.add(28);
		list.add(25);
		list.add(22);
		list.add(43);
		
		Stream<Integer> stream2 = list.stream();
		stream2.forEach(e-> {
			System.out.println(e);
		});
		
		stream2.forEach(System.out::println);
	}
 
}
