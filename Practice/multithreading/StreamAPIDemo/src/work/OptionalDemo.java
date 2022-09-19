package work;

import java.util.Optional;

public class OptionalDemo {

	public static Optional<String> getName(){
		String name = null;
		return Optional.ofNullable(name);
	}
	public static void main(String[] args) {
		String str = null;
		
		Optional<String> strOptional = Optional.ofNullable(str);
		System.out.println(strOptional.isPresent());
//		System.out.println(strOptional.get());
//		System.out.println(strOptional.orElse("No element is there"));
		
		Optional<String> name = getName();
		System.out.println(name.orElse("Null is present"));
		
	}

}
