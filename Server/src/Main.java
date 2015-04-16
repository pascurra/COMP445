import java.io.*;
import java.net.*;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {

		final Service service1 = new Service(1);

		while (service1.terminate != true) {
			
			Thread t1 = new Thread() {
				public void run() {
					try {
						System.out.println("Starting Thread 1");
						service1.Execute();
						System.out.println("Ending Thread 1");

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};

			Thread t2 = new Thread() {
				public void run() {
					try {
						System.out.println("Starting Thread 2");

						service1.Execute();
						System.out.println("Ending Thread 2");

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};

			Thread t3 = new Thread() {
				public void run() {
					try {
						System.out.println("Starting Thread 3");

						service1.Execute();
						System.out.println("Ending Thread 3");

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};

			Thread t4 = new Thread() {
				public void run() {
					try {
						System.out.println("Starting Thread 4");

						service1.Execute();
						System.out.println("Ending Thread 4");

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};

			Thread t5 = new Thread() {
				public void run() {
					try {
						System.out.println("Starting Thread 5");

						service1.Execute();
						
						System.out.println("Ending Thread 5");

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
						
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();			
			
			try {
				t1.join();
				t2.join();
				t3.join();
				t4.join();
				t5.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		}

	}

}
