import java.util.ArrayList;
import client.Snowboarder;
import system.core.CashDesk;

// For test purposes I need Main class

public class Main {
	
	public static void main(String [] args) throws InterruptedException {
		
		// Snowbboard guys are threads who have a certain life.
		//max.set(newValue);
		
		CashDesk currCashDesk = new CashDesk();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < 5000; ++i) {
			Snowboarder newClient = new Snowboarder("Snowboarder " + i, currCashDesk);
			Thread thread = new Thread(newClient);
			thread.start();
			threads.add(thread);
		}
		
		for (int i = 0; i < 5000; ++i) {
			try {
				threads.get(i).join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		currCashDesk.cashDetails();
	}
}
