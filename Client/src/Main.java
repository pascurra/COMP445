import java.util.Calendar;
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
		String alias;

		if (i == 1) {
			System.out.println("Please enter your username and press ENTER..");

			alias = input.next();

			System.out.println("You entered your login: " + alias);

			System.out.println("Please choose one option:");
			System.out.println("1.- Create Twible");
			System.out.println("2.- Delete Twible");
			System.out.println("3.- Deregister account");
			System.out.println("4.- Subscribe to other poster's Twibbles");
			System.out.println("5.- Update Profile");

			i = input.nextInt();
			
			//Post Twibble
			if (i == 1) {
				System.out.println("1.- Create Twible");
								
				String twibbleContent;
									
				System.out.println("Please enter a new Twibble Content: ");
				
				twibbleContent = input.next();	
								
				System.out.println("Twibble Posted :"+twibbleContent);
					
				String JSONCommand=
				"<ExecuteCommand><command>Create Twibble</command><twibbleContent>"+twibbleContent+"</twibbleContent><alias>"+alias+"</alias></ExecuteCommand>";

				Message message= new Message( "localhost" , 6789, JSONCommand);
				message.send();
				
			}
			
			//Delete Twibble	
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
					//String alias="paolo";

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

				String subscribeTo = input.next();

				System.out.println("Subscribing you to the user..........");

				// Create code to subscribe account : Paolo
								
				String JSONCommand=

						"<ExecuteCommand><command>Subscribe</command><alias>"+alias+"</alias><SubscribeTo>"+subscribeTo+"</SubscribeTo></ExecuteCommand>";
								
						Message message= new Message( "localhost" , 6789, JSONCommand);
						message.send();

						System.out.println("You have been subscribed to: "+subscribeTo);		

			}

		}
		
		// To Register new user

		if (i == 2) {

			System.out
					.println("Please enter your new username and press ENTER..");


			String user = input.next();

			System.out.println("You chose your new alias: " + user);
			
			
			//System.out.println("Registering user.........");

			// Create code to Register alias (user) : Ryan
			
			//Use this tool: http://bernhardhaeussner.de/odd/json-escape/
		

			String JSONCommandAlias=

			"<ExecuteCommand><command>Register</command><alias>"+user+"</alias></ExecuteCommand>";
					
			Message messageAlias= new Message( "localhost" , 6789, JSONCommandAlias);
			messageAlias.send();


		}

	}

}
