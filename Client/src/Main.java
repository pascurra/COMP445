import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String ServerIP="localhost";
		
		System.out.println("Welcome to the Twiblr Client System!");
		System.out.println("Please enter the IP of the server X.X.X.X");

		ServerIP = input.next();

		
		
		System.out.println("Please choose one option:");
		System.out.println("1.- Login");
		System.out.println("2.- Register");


		int i = input.nextInt();
		// String s = input.next();
		String alias;
		String twibbleContent = "";

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
			System.out.println("6.- Post a Profile");

			i = input.nextInt();

			// Create Twibble option Twibble
			if (i == 1) {
				System.out.println("1.- Create Twible");
				// String twibbleContent;
				System.out.println("Please enter a new Twibble Content: ");
				twibbleContent = input.next();
				System.out.println("Twibble Posted :" + twibbleContent);
				String JSONCommand = "<ExecuteCommand><command>Create Twibble</command><twibbleContent>"
						+ twibbleContent
						+ "</twibbleContent><alias>"
						+ alias
						+ "</alias></ExecuteCommand>";
				Message message = new Message(ServerIP, 6789, JSONCommand);
				message.send();
			}


			// Delete Twibble ToDo: Ryan
			if (i == 2) {

				System.out
						.println("Are you sure you want to delete the Twible?");
				System.out.println("1.- Yes");
				System.out.println("2.- No");

				i = input.nextInt();

				if (i == 1) {
					System.out.println("Deleting Twible...........");

					String JSONCommand =

					"<ExecuteCommand><command>Delete Twibble</command><twibbleContent>"
							+ twibbleContent + "</twibbleContent><alias>"
							+ alias + "</alias></ExecuteCommand>";

					Message message = new Message(ServerIP, 6789,
							JSONCommand);
					message.send();
				}

				if (i == 2) {
					System.out.println("Nothing to do.");

				}
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

					// Use this tool:
					// http://bernhardhaeussner.de/odd/json-escape/
					// String alias="paolo";

					String JSONCommand =

					"<ExecuteCommand><command>Deregister</command><alias>"
							+ alias + "</alias></ExecuteCommand>";

					Message message = new Message(ServerIP, 6789,
							JSONCommand);
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

				String JSONCommand =

				"<ExecuteCommand><command>Subscribe</command><alias>" + alias
						+ "</alias><SubscribeTo>" + subscribeTo
						+ "</SubscribeTo></ExecuteCommand>";

				Message message = new Message(ServerIP, 6789, JSONCommand);
				message.send();

				System.out.println("You have been subscribed to: "
						+ subscribeTo);

			}
			
			
			if (i == 5) {
				System.out.println("5.- Update Profile");
				System.out
						.println("Are you sure you want to update you profile ? (y/n)");
				char ans;
				ans = input.next().charAt(0);
				if (ans == 'y') {
					System.out.println("Updating profile...");
					String JSONCommand = "<ExecuteCommand><command>Update Profile</command><alias>"
							+ alias + "</alias></ExecuteCommand>";
					Message message = new Message(ServerIP, 6789,
							JSONCommand);
					message.send();

				}
				System.out.println("Bye " + alias);
			}
			
			
			
			if (i == 6) {
				
				
				System.out.println("6.- Post a Profile");
				System.out.println("Please enter your location: ");
				String profileLocation = input.next();
				
				System.out.println("Please enter your interests separated by a comma: ");
				String interests = input.next();
				
				
				System.out.println("Processing...");
				String JSONCommand = "<ExecuteCommand><command>PostProfile</command><alias>"
						+ alias
						+ "</alias><profileLocation>"
						+ profileLocation
						+ "</profileLocation><interests>"
						+ interests
						+ "</interests></ExecuteCommand>";
				Message message = new Message(ServerIP, 6789, JSONCommand);
				message.send();
				
				
				
				System.out.println("Bye " + alias);
			}
			
			
			
			
			
			
			
			
			

		}

		// To Register new user

		if (i == 2) {

			System.out
					.println("Please enter your new username and press ENTER..");

			String user = input.next();

			System.out.println("You chose your new alias: " + user);
<<<<<<< HEAD

			// System.out.println("Registering user.........");
=======
			
			System.out
			.println("Please enter your email address and press ENTER..");
			
			String email = input.next();
			
			System.out.println("Email address associated with your Twiblr account will be: " + email);
			
>>>>>>> Ryan

			// Create code to Register alias (user) : Ryan

<<<<<<< HEAD
			// Use this tool: http://bernhardhaeussner.de/odd/json-escape/

			String JSONCommandAlias =

			"<ExecuteCommand><command>Register</command><alias>" + user
					+ "</alias></ExecuteCommand>";

			Message messageAlias = new Message(ServerIP, 6789,
					JSONCommandAlias);
			messageAlias.send();

=======
			String JSONCommandRegister=
					"<ExecuteCommand><command>Register</command><alias>"+user+"</alias><email>"+email+"</email></ExecuteCommand>";
	
			Message messageRegister= new Message( "localhost" , 6789, JSONCommandRegister);
			messageRegister.send();
			
>>>>>>> Ryan
		}

	}

}
