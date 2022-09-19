package work;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GFGDemo {

	public static void main(String[] args) {
		List<Integer> number = Arrays.asList(2,3,4,5);
		
		List<Integer> res1 = number.stream().map(x->x%10).collect(Collectors.toList());
		System.out.println("Res - "+res1);
		
		number.stream().map(x->x*x).forEach(System.out::println);
		
	}

}
