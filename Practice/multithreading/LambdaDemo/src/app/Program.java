package app;

public class Program {

	public static void main(String[] args) {
		
		// Create instance of Impl class
		/*
		 * IThreadDemo d = new ThreadImpl();
		 *  d.printIt();
		 */
		
		
//		Use Anonymous class
		/*
		 * IThreadDemo a = new ThreadImpl() { public void printIt() {
		 * System.out.println("Saying hello from anonymous class"); } };
		 * 
		 * a.printIt();
		 * 
		 * IThreadDemo b = new ThreadImpl() { public void printIt() {
		 * System.out.println("Hello Another instance se hello...."); } };
		 * 
		 * b.printIt();
		 */
		
		
//	 	Usinng Lmbda Expression
		
		/*
		 * IThreadDemo c = ()->System.out.println("Hello from Lambda"); c.printIt();
		 * IThreadDemo d = ()->System.out.println("Hello again from Lambda");
		 * d.printIt();
		 */
		
		
		ISumIF e = (a,b)->a+b;
		System.out.println(e.sum(12, 12));
		
		
		LengthInter f = (s)->s.length();
		
		System.out.println(	f.getLength("Good"));
	}

}
