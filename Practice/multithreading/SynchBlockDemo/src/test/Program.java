package test;

class Display extends Thread {
	int total = 0;

	public void run() {
		synchronized (this) {
			System.out.println("2. Child thread going for calculation");
			for (int i = 1; i <= 100; i++) {
				total = total + i;
			}
			System.out.println("3. Child thread goiving notification");
			this.notify();
		}
	}
}

public class Program {

	public static void main(String[] args) throws InterruptedException {
		Display d = new Display();
		d.start();
		synchronized (d) {
			System.out.println("1. Main thread calling wait method!!!");
			d.wait();
			System.out.println("4. main thread got the notification!!!!!!!!!!");
			System.out.println("5. "+d.total);
		}

	}

}
