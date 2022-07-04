package demo;

import java.util.LinkedList;
import java.util.List;

public class Program {
	
	public static boolean palindromeOrNot(List<Character> list) {
		int j ;
		for (int i = 0; i < list.size(); i++) {
			
			j = list.size()-1;
			
			if(list.get(i) == list.get(j)) {
				System.out.println(list.get(i));
				System.out.println(list.get(j));
				j--;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	 public static void main(String[] args) {
		
		
		 List<Character> list = new LinkedList<>();
		 list.add('a');
		 list.add('b');
		 list.add('a');
		 list.add('c');
		 list.add('a');
		 list.add('b');
		 list.add('a');
		 
//		 System.out.println(list.size());
		 
		 
		 boolean res = palindromeOrNot(list);
		 System.out.println(res);
		 
		 
	}
}

// SELECT SAL FROM EMPLOYEE DESC LIMIT BY(4);

