import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the Twiblr Client System!");
		System.out.println("Please choose one option:");
		System.out.println("1.- Login");
		System.out.println("2.- Register");

		Scanner input = new Scanner(System.in);

		int i = input.nextInt();
		// String s = input.next();
		String string;

		if (i == 1) {
			System.out.println("Please enter your username and press ENTER..");

			string = input.next();

			System.out.println("You entered your login: " + string);

			System.out.println("Please choose one option:");
			System.out.println("1.- Create Twible");
			System.out.println("2.- Delete Twible");
			System.out.println("3.- Deregister account");
			System.out.println("4.- Subscribe to other poster's Twibbles");

			i = input.nextInt();

			if (i == 1) {
				System.out.println("1.- Create Twible");

			}

			if (i == 2) {
				System.out.println("2.- Delete Twible");

			}

			if (i == 3) {
				System.out.println("3.- Deregister account");
				System.out
						.println("Are you sure you want to deregister your account?");
				System.out.println("1.- Yes");
				System.out.println("2.- No");

				i = input.nextInt();

				if (i == 1) {
					System.out.println("Deleting Account...........");

					// Create code to delete account : Paolo
					
					//Use this tool: http://bernhardhaeussner.de/odd/json-escape/
					String alias="paolo";

					String JSONCommand=

					"<ExecuteCommand><command>Deregister</command><alias>"+alias+"</alias></ExecuteCommand>";
							
					Message message= new Message( "localhost" , 6789, JSONCommand);
					message.send();
					

					System.out.println("Account Deleted...........");
				}

				if (i == 2) {
					System.out.println("Nothing to do.");

				}

			}

			if (i == 4) {
				System.out.println("4.- Subscribe to other poster's Twibbles");
				System.out
						.println("Please enter the user you want to subscribe to and press ENTER...");

				string = input.next();

				System.out.println("Subscribing you to the user..........");

				// Create code to subscribe account : Paolo

				System.out.println("You have been subscribed...........");

			}

		}
		
		// To Register new user

		if (i == 2) {

			System.out
					.println("Please enter your new username and press ENTER..");

			string = input.next();

			System.out.println("You chose your new alias: " + string);
			
			System.out.println("Registering user.........");

			// Create code to Register alias (user) : Ryan
			
			//Use this tool: http://bernhardhaeussner.de/odd/json-escape/
			String alias=string;

			String JSONCommand=

			"<ExecuteCommand><command>Register</command><alias>"+alias+"</alias></ExecuteCommand>";
					
			Message message= new Message( "localhost" , 6789, JSONCommand);
			message.send();
			

			System.out.println("New user registered...........");

		}

	}

}
