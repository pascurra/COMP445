import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class Service {

	public Service() {
		super();
	}

	Boolean terminate = false;

	ServerSocket server = null;
	Socket socket; // Client Socket
	int serverPort = 6789;

	PrintWriter out;
	BufferedReader in;
	Scanner input = new Scanner(System.in);

	public void Execute() throws SQLException {

		try {
			// Create a Socket and bind it to a port
			server = new ServerSocket(serverPort);
			System.out.println("Server is up and running...");

			// Accept a connection from the client and associate a Socket to
			// this connection
			socket = server.accept();
			// Create the stream of data to be communicated between this server
			// and the client
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String line;

			int i = 1;

			// Read the request from the client
			String xml = "";

			while ((line = in.readLine()) != null) {
				System.out.println("Server has received \"" + line
						+ "\" from the client");
				// Reverse the message and send it back to the client,
				out.println(new StringBuilder(line).toString());
				xml = line;
				if (line.equals("exit"))
					break;
			}

			Document doc = null;

			// Demarshall

			try {
				doc = loadXML(xml);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String command = doc.getElementsByTagName("command").item(0)
					.getTextContent();

			System.out.println("The command to execute is: " + command);

			// create query object

			// String Command="Deregister";

			// Menu 1.1

			if (command.equals("Register")) {

				databaseConnection registerQuery = new databaseConnection("");

				// Grab the alias entered previously
				String alias = doc.getElementsByTagName("alias").item(0)
						.getTextContent();

				String email = doc.getElementsByTagName("email").item(0)
						.getTextContent();

				// Create a timestamp
				Calendar calendar = Calendar.getInstance();
				java.sql.Timestamp registrationDate = new java.sql.Timestamp(
						calendar.getTime().getTime());

				// Write to database

				registerQuery.query = "INSERT INTO ascurra_445.clients(alias,email,registrationDate) VALUES ('"
						+ alias
						+ "', '"
						+ email
						+ "', ' "
						+ registrationDate
						+ "')";
				registerQuery.ExecuteUpdate();

				// Ending message
				System.out.println("New user registered...........");

				// Paolo says: Needs to be updated like 3.3
				// databaseConnection registerQuery=new
				// databaseConnection("INSERT INTO...");
				// ResultSet result=registerQuery.Query();

			}

			// Menu 3 , 3 by Paolo - WORKING OK - use something similar in your
			// tasks
			if (command.equals("Deregister")) {

				String alias = doc.getElementsByTagName("alias").item(0)
						.getTextContent();
				System.out.println("The alias to delete is: " + alias);
				databaseConnection deregisterQuery = new databaseConnection(
						"DELETE FROM ascurra_445.clients WHERE alias=" + "\""
								+ alias + "\"" + ";");

				// query db to delete
				// deregisterQuery.query = "";
				deregisterQuery.ExecuteUpdate();

			}

			// Menu 3.4 subscribe by Paolo
			if (command.equals("Subscribe")) {

				String alias = doc.getElementsByTagName("alias").item(0)
						.getTextContent();
				String SubscribeTo = doc.getElementsByTagName("SubscribeTo")
						.item(0).getTextContent();
				// System.out.println("The alias to delete is: " + alias);

				// query db to delete
				// registerQuery.query =
				// "DELETE FROM ascurra_445.clients WHERE alias="
				// + "\"" + alias + "\"" + ";";
				// registerQuery.ExecuteUpdate();
				databaseConnection subscribeQuery = new databaseConnection(
						"select idusers FROM ascurra_445.clients where alias='"
								+ SubscribeTo + "';");

				// registerQuery.query="";
				ResultSet resultSetSubscribe = subscribeQuery
						.executeSelectStatement();

				int subscribeToId = 0;

				try {
					while (resultSetSubscribe.next()) {

						subscribeToId = resultSetSubscribe.getInt("idusers");

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				subscribeQuery.query = "INSERT INTO ascurra_445.subscribers(client_alias,following_client_id) VALUES ('"
						+ alias + "', '" + subscribeToId + "' )";
				subscribeQuery.ExecuteUpdate();

			}

			// Create Twibble
			if (command.equals("Create Twibble")) {

				String twibbleContent = doc
						.getElementsByTagName("twibbleContent").item(0)
						.getTextContent();
				String alias = doc.getElementsByTagName("alias").item(0)
						.getTextContent();
				System.out.println("Current Alias: " + alias);
				// Getting current ID
				databaseConnection getAliasId = new databaseConnection("");
				getAliasId.query = "select idusers FROM ascurra_445.clients where alias='"
						+ alias + "' ";
				ResultSet id = getAliasId.executeSelectStatement();

				int userId = 0;
				try {
					while (id.next()) {
						userId = id.getInt("idusers");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("The current id is: " + userId);

				// Get Current User Email
				databaseConnection getUserEmail = new databaseConnection("");
				getUserEmail.query = "select email FROM ascurra_445.clients where alias='"
						+ alias + "' ";
				ResultSet email = getUserEmail.executeSelectStatement();

				String currentEmail = "";
				try {
					while (email.next()) {
						currentEmail = email.getString("email");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("The current email is: " + currentEmail);

				// Get Subscribers List
				// Get aliases of followers
				databaseConnection getSubscribers = new databaseConnection("");
				getSubscribers.query = "select client_alias FROM ascurra_445.subscribers where following_client_id='"
						+ userId + "' ";
				ResultSet subscribersSet = getSubscribers
						.executeSelectStatement();

				ArrayList<String> subscriberAliases = new ArrayList();
				try {

					while (subscribersSet.next()) {
						subscriberAliases.add(subscribersSet
								.getString("client_alias"));

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("The number of followers is: "
						+ subscriberAliases.size());
				System.out.println("Array of aliases: " + subscriberAliases);

				// Get Email of Followers
				ArrayList<String> subscriberEmails = new ArrayList();
				databaseConnection getSubscriberEmail = new databaseConnection(
						"");
				for (String a : subscriberAliases) {
					getSubscriberEmail.query = "select email FROM ascurra_445.clients where alias='"
							+ a + "' ";
					ResultSet emailOfSubscriber = getSubscriberEmail
							.executeSelectStatement();
					try {
						while (emailOfSubscriber.next()) {
							subscriberEmails.add(emailOfSubscriber
									.getString("email"));

						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				;

				InternetAddress[] cc = new InternetAddress[subscriberEmails
						.size()];
				for (int b = 0; b < subscriberEmails.size(); b++) {
					cc[b] = new InternetAddress(subscriberEmails.get(b));
				}
				System.out.println(cc);
					
				databaseConnection createTwibbleQuery = new databaseConnection(
						"");
				createTwibbleQuery.query = "INSERT INTO ascurra_445.twibbles(twiblrcontent,usersIdForeign) VALUES ('"
						+ twibbleContent + "','" + userId + "')";
				createTwibbleQuery.ExecuteUpdate();
				System.out.println("New Twibble Posted: " + twibbleContent);

				// Send Notification
				// Recipient's email ID needs to be mentioned.
				// Sender's email ID needs to be mentioned
				String from = currentEmail;
				// Auth
				final String username = "myTwibble@gmail.com";// change
																// accordingly
				final String password = "##twibbleGmail##";// change accordingly
				// Assuming you are sending email from localhost
				String host = "smtp.gmail.com";
				// Get system properties
				Properties props = System.getProperties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				// Setup mail server
				props.setProperty("mail.smtp.host", host);
				//
				// Get the Session object.
				Session session = Session.getInstance(props,
						new javax.mail.Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(username,
										password);
							}
						});
				try {
					// Create a default MimeMessage object.
					MimeMessage message = new MimeMessage(session);
					// Set From: header field of the header.
					message.setFrom(new InternetAddress(from));
					// Set To: header field of the header.
					message.addRecipients(Message.RecipientType.BCC, cc);
					// Set Subject: header field
					message.setSubject(alias + " posted a new Twibble !");
					// Now set the actual message
					message.setText(twibbleContent);
					// Send message
					Transport.send(message);
					System.out.println("Sent message successfully....");
				} catch (MessagingException mex) {
					mex.printStackTrace();
				}
			}

			// End of Creating Twibble

			// Updating Profile
			if (command.equals("Update Profile")) {
				databaseConnection updateProfile = new databaseConnection("");
				String profile_alias = doc
						.getElementsByTagName("profile_alias").item(0)
						.getTextContent();
				String profile_location = doc
				.getElementsByTagName("profile_location").item(0)
				.getTextContent();
				String profile_interests = doc
						.getElementsByTagName("profile_interests").item(0)
						.getTextContent();
				String currentAlias = doc
						.getElementsByTagName("currentAlias").item(0)
						.getTextContent();
				updateProfile.query = "update profiles set alias="+profile_alias+", location="+profile_location+", interests="+profile_interests+"  where idForeignKey = (select idusers from clients where alias="+currentAlias+")";
				updateProfile.ExecuteUpdate();
				System.out.println("Profile Updated : New Alias: "+profile_alias+" New Location :"+profile_location+" New Interests : "+profile_interests);
			}
			// End Of Updating Profile

			// By Paolo
			if (command.equals("PostProfile")) {

				databaseConnection postProfile = new databaseConnection("");

				// Grab the alias entered previously
				String alias = doc.getElementsByTagName("alias").item(0)
						.getTextContent();

				String profileLocation = doc
						.getElementsByTagName("profileLocation").item(0)
						.getTextContent();

				String interests = doc.getElementsByTagName("interests")
						.item(0).getTextContent();



				// getting the date in which the client created his/her account
				databaseConnection accountCreationQuery = new databaseConnection(
						"select registrationDate FROM ascurra_445.clients where alias='"
								+ alias + "';");
				ResultSet resultSetaccountCreation = accountCreationQuery
						.executeSelectStatement();

				java.sql.Timestamp myDate = null;

				try {
					while (resultSetaccountCreation.next()) {

						myDate = resultSetaccountCreation
								.getTimestamp("registrationDate");

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(myDate);

				// getting the id of the user for the foreign key
				databaseConnection subscribeQuery = new databaseConnection(
						"select idusers FROM ascurra_445.clients where alias='"
								+ alias + "';");

				// registerQuery.query="";
				ResultSet resultSetSubscribe = subscribeQuery
						.executeSelectStatement();

				int subscribeToId = 0;

				try {
					while (resultSetSubscribe.next()) {

						subscribeToId = resultSetSubscribe.getInt("idusers");

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				postProfile.query = "INSERT INTO ascurra_445.profiles(alias,location,interests,dateOfJoining,dateOfPostingProfile,idForeignKey) VALUES ('"
						+ alias
						+ "', '"
						+ profileLocation
						+ "', ' "
						+ interests
						+ "', ' "
						+ dateString
						+ "', NOW(), ' "
						+ subscribeToId + "')";
				postProfile.ExecuteUpdate();

				// Ending message
				System.out.println("New user registered...........");

			}

			// Delete a Twibble: Ryan
			if (command.equals("Delete Twibble")) {

				String alias = doc.getElementsByTagName("alias").item(0)
						.getTextContent();
				String twibbleID = doc.getElementsByTagName("twibbleID").item(0).getTextContent();

				System.out.println("Current Alias: " + alias);
				System.out.println("Twibble ID to delete: " + twibbleID);

				
				databaseConnection deleteTwibbleQuery = new databaseConnection("");

				
				deleteTwibbleQuery.query = "DELETE FROM ascurra_445.twibbles WHERE idtwiblr= '"
						+ twibbleID + "' ";
				deleteTwibbleQuery.ExecuteUpdate();
				
				System.out.println("Twibble deleted!");

			}
			
			// Delete Profile: Ryan
			if (command.equals("Delete Profile")) {
				
				String alias = doc.getElementsByTagName("alias").item(0).getTextContent();
				System.out.println("Current Alias: " + alias);
				
				// Go get the idForeignKey to delete profile....
				databaseConnection getAliasId = new databaseConnection("");
				
				// Get the idusers from Client table
				getAliasId.query = "select idusers FROM ascurra_445.clients where alias='"
						+ alias + "' ";
				
				// Store result set to search for alias id
				ResultSet theForeignKey = getAliasId.executeSelectStatement();

				// Find the foreign key to know which profile to delete
				int fKeyId = 0;
				try {
					while (theForeignKey.next()) {

						fKeyId = theForeignKey.getInt("idusers");

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// Display which profile will be deleted based on the alias id
				System.out.println("The Foreign Key in Profiles table is: " + fKeyId);
				
				// Connect and delete profile in profiles table
				databaseConnection deleteProfileQuery = new databaseConnection("");
				deleteProfileQuery.query = "DELETE FROM ascurra_445.profiles WHERE idForeignKey= '" + fKeyId + "' ";
				deleteProfileQuery.ExecuteUpdate();
				
				
			}

			// Close all the input and output streams, as well as the sockets
			in.close();
			out.close();
			socket.close();
			server.close();

		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException:" + e.getMessage());
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Service ended execution.");

	}

	public static Document loadXML(String xml) throws Exception {
		DocumentBuilderFactory fctr = DocumentBuilderFactory.newInstance();
		DocumentBuilder bldr = fctr.newDocumentBuilder();
		InputSource insrc = new InputSource(new StringReader(xml));
		return bldr.parse(insrc);
	}

}
