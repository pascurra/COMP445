import java.util.Calendar;
import java.util.Scanner;

public class Main {

	static boolean keepRunning = true;
	static Scanner input = new Scanner(System.in);
	static String ServerIP = "localhost";
	static Scanner userInput = new Scanner(System.in); // Added to test having spaces in register. It works so far.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to the Twiblr Client System!");
		System.out.println("Please enter the IP of the server X.X.X.X");

		ServerIP = input.next();

		while (keepRunning == true) {
			showMenu();
		}

	}

	public static void showMenu() {

		System.out.println("Please choose one option:");
		System.out.println("1.- Login");
		System.out.println("2.- Register");
		System.out.println("3.- Terminate");

		int mainMemuOption = input.nextInt();
		int subMemuOption;
		// String s = input.next();
		String alias;
		String twibbleContent = "";

		if (mainMemuOption == 1) {
			
			System.out.println("Please enter your username and press ENTER..");

			alias = input.next();

			System.out.println("You entered your login: " + alias);
			while (mainMemuOption==1){
			

			System.out.println("Please choose one option:");
			System.out.println("1.- Create Twible");
			System.out.println("2.- Delete Twible");
			System.out.println("3.- Deregister account");
			System.out.println("4.- Subscribe to other poster's Twibbles");
			System.out.println("5.- Update Profile");
			System.out.println("6.- Post a Profile");
			System.out.println("7.- Delete Profile");
			System.out.println("9.- Exit");

			subMemuOption = input.nextInt();

			// Create Twibble option Twibble
			if (subMemuOption == 1) {
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
			if (subMemuOption == 2) {

				System.out
						.println("Are you sure you want to delete the Twible?");
				System.out.println("1.- Yes");
				System.out.println("2.- No");

				int deleteTwibbleOption = input.nextInt();

				if (deleteTwibbleOption == 1) {
					//System.out.println("Please enter Twibble ID to delete: ");
					//String twibbleID = input.next();
					
					String JSONCommand =

					//"<ExecuteCommand><command>Delete Twibble</command><twibbleID>"
							//+ twibbleID + "</twibbleID><alias>"
							//+ alias + "</alias></ExecuteCommand>";
					
					"<ExecuteCommand><command>Delete Twibble</command><alias>"
					+ alias + "</alias></ExecuteCommand>";

					// Need to change back to just send()
					Message message = new Message(ServerIP, 6789, JSONCommand);
					message.send();
					
					
					// Now that we return back from Service, we ask user to select twibble to delete
					System.out.println("Please enter Twibble ID to delete: ");
					String twibbleID = input.next();
					
					String JSONCommandTwibbleDelete =  "<ExecuteCommand><command>Twibble Delete</command><idtwiblr>"
							+ twibbleID + "</idtwiblr></ExecuteCommand>";
					Message messageToDelete = new Message(ServerIP, 6789, JSONCommandTwibbleDelete);
					messageToDelete.send();
					
					System.out.println("Twibble Deleted..............");
					
					
				}

				if (deleteTwibbleOption == 2) {
					System.out.println("Nothing to do.");

				}
			}

			if (subMemuOption == 3) {
				System.out.println("3.- Deregister account");
				System.out
						.println("Are you sure you want to deregister your account?");
				System.out.println("1.- Yes");
				System.out.println("2.- No");

				int deregisterAccountOption = input.nextInt();

				if (deregisterAccountOption == 1) {
					System.out.println("Deleting Account...........");

					// Create code to delete account : Paolo

					// Use this tool:
					// http://bernhardhaeussner.de/odd/json-escape/
					// String alias="paolo";

					String JSONCommand =

					"<ExecuteCommand><command>Deregister</command><alias>"
							+ alias + "</alias></ExecuteCommand>";

					Message message = new Message(ServerIP, 6789, JSONCommand);
					message.send();

					System.out.println("Account Deleted...........");
				}

				if (deregisterAccountOption == 2) {
					System.out.println("Nothing to do.");

				}

			}

			if (subMemuOption == 4) {
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

			if (subMemuOption == 5) {
				System.out.println("5.- Update Profile");
								
				String newAlias="";
				String newLocation="";
				String newInterests="";
				System.out.println("Please enter a new Location :");
				newLocation = input.next();
				System.out.println("Please enter a new Interests seperated by a comma :");
				newInterests= input.next();
				System.out.println("Profile Updated");
				String JSONCommand = "<ExecuteCommand><command>Update Profile</command><profile_alias>"
						+ newAlias + "</profile_alias>"
						+"<profile_location>"+newLocation+"</profile_location>"
						+"<profile_interests>"+newInterests+"</profile_interests>"
						+"<currentAlias>"+alias+"</currentAlias></ExecuteCommand>";
				Message message = new Message(ServerIP, 6789, JSONCommand);
				message.send();
				
			}

			if (subMemuOption == 6) {

				System.out.println("6.- Post a Profile");
				System.out.println("Please enter your location: ");
				String profileLocation = input.next();

				System.out
						.println("Please enter your interests separated by a comma: ");
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
			
			if (subMemuOption == 7) {
				System.out.println("7.- Delete Profile");
				System.out.println("Are you sure you want to delete the profile?");
				
				System.out.println("1.- Yes");
				System.out.println("2.- No");
				
				int deleteProfileOption = input.nextInt();

				if (deleteProfileOption == 1) {
					System.out.println("Deleting Profile...........");


					String JSONCommand =

					"<ExecuteCommand><command>Delete Profile</command><alias>"
							+ alias + "</alias></ExecuteCommand>";

					Message message = new Message(ServerIP, 6789, JSONCommand);
					message.send();

					System.out.println("Profile Deleted...........");
				}
				
				if (deleteProfileOption == 2) {
					System.out.println("Nothing to do.");

				}
				
				
			}

			if (subMemuOption == 9) {

				
				mainMemuOption=0;
				keepRunning = false;

			}
			
			}

		}

		// To Register new user
		if (mainMemuOption == 2) {

			System.out
					.println("Please enter your new username and press ENTER..");

			
			String user = userInput.next();
			
			System.out.println("You chose your new alias: " + user);
			
			System.out
			.println("Please enter your email address and press ENTER..");
			
			String email = userInput.next();
			
			
			System.out.println("Email address associated with your Twiblr account will be: " + email);
			
			
			String JSONCommandRegister=
					"<ExecuteCommand><command>Register</command><alias>"+user+"</alias><email>"+email+"</email></ExecuteCommand>";
	
			Message messageRegister= new Message( "localhost" , 6789, JSONCommandRegister);
			messageRegister.send();
			
			// Close the scanner object
			//userInput.close();
			
			//show menu for registered users
			mainMemuOption=1;
			
			System.out.println("You can login now...");

		}



		if (mainMemuOption == 3) {

			keepRunning = false;
			
			System.out.println("Program terminated. Bye!");
			System.out.println("___________________________________________");


		}

	}

}
