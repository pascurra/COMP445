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
import java.util.Calendar;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;
import javax.activation.*;

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

	public void Execute() {

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

			int  i = 1;

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

			if (command.equals("Register")){
				
				databaseConnection registerQuery = new databaseConnection("");

				
				// Grab the alias entered previously
				String alias = doc.getElementsByTagName("alias").item(0).getTextContent();
				
				// Prompt for email address
				System.out.println("Please enter your email address and press ENTER: ");

				String email = input.next();
				
				// Create a timestamp
				Calendar calendar = Calendar.getInstance();
				java.sql.Timestamp registrationDate = new java.sql.Timestamp(calendar.getTime().getTime());


				//Write to database
				

				registerQuery.query="INSERT INTO ascurra_445.clients(alias,email,registrationDate) VALUES ('" + alias + "', '" + email + "', ' " + registrationDate + "')";
				registerQuery.ExecuteUpdate();
				
				// Ending message
				System.out.println("New user registered...........");

				//Paolo says: Needs to be updated like 3.3
		//		databaseConnection registerQuery=new databaseConnection("INSERT INTO...");
		//		ResultSet result=registerQuery.Query();

								
		 }
			
			
			// Menu 3 , 3 by Paolo  - WORKING OK - use something similar in your tasks
			if (command.equals("Deregister")) {
				

				String alias = doc.getElementsByTagName("alias").item(0)
						.getTextContent();
				System.out.println("The alias to delete is: " + alias);
				databaseConnection deregisterQuery = new databaseConnection("DELETE FROM ascurra_445.clients WHERE alias="
						+ "\"" + alias + "\"" + ";");

				// query db to delete	
				//deregisterQuery.query = "";
				deregisterQuery.ExecuteUpdate();

			}
			
			
			//Menu 3.4 subscribe by Paolo
			if (command.equals("Subscribe")) {
						
				
				String alias = doc.getElementsByTagName("alias").item(0)
						.getTextContent();
				String SubscribeTo = doc.getElementsByTagName("SubscribeTo").item(0)
						.getTextContent();
				//System.out.println("The alias to delete is: " + alias);

				// query db to delete	
		//		registerQuery.query = "DELETE FROM ascurra_445.clients WHERE alias="
		//				+ "\"" + alias + "\"" + ";";
		//		registerQuery.ExecuteUpdate();
				databaseConnection subscribeQuery = new databaseConnection("select idusers FROM ascurra_445.clients where alias='"+ SubscribeTo+"';");

				//registerQuery.query="";
				ResultSet resultSetSubscribe=subscribeQuery.executeSelectStatement();
				
				int subscribeToId=0;
				
				try {
					while (resultSetSubscribe.next()) {

						subscribeToId=resultSetSubscribe.getInt("idusers");

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
							
				subscribeQuery.query="INSERT INTO ascurra_445.subscribers(client_alias,following_client_id) VALUES ('" + alias + "', '" + subscribeToId +"' )";
				subscribeQuery.ExecuteUpdate();
								
			}
			
			if(command.equals("Create Twibble")){
							
				//Analyze data received from client				
				String twibbleContent = doc.getElementsByTagName("twibbleContent").item(0).getTextContent();
				String alias = doc.getElementsByTagName("alias").item(0).getTextContent();
												
				//Getting appropriate email
				databaseConnection getEmail = new databaseConnection("");
				getEmail.query =  "select email FROM ascurra_445.clients where alias='"+ alias+"' ";
				ResultSet theEmail = getEmail.executeSelectStatement();
				String currentEmail="";
				try {
					while (theEmail.next()) {

						 currentEmail=theEmail.getString("email");

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("CurrentEmail: "+currentEmail);
				
				//Getting subscribers list
				databaseConnection getId = new databaseConnection("");
				getId.query = "select idusers FROM ascurra_445.clients where alias='"+ alias+"' ";
				ResultSet ids = getId.executeSelectStatement();
				int a =0;
				try {
					while (ids.next()) {

						 a=ids.getInt("idusers");

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Current ID: "+a);
				
				//Get Subscribers Alias
				
				// Getting the appropriate id 
				databaseConnection getAliasId = new databaseConnection(""); 
				getAliasId.query = "select idusers FROM ascurra_445.clients where alias='"+ alias+"' ";
				ResultSet theForeignKey = getAliasId.executeSelectStatement();
				int userId = 0; 
				try {
					while (theForeignKey.next()) {

						 userId=theForeignKey.getInt("idusers");

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("The Foreign Key is: "+userId);
				
								
				//Posting Twibble 
				databaseConnection createTwibbleQuery = new databaseConnection("");
				createTwibbleQuery.query="INSERT INTO ascurra_445.twibbles(twiblrcontent,usersIdForeign) VALUES ('" + twibbleContent + "','" + userId + "')";
		        createTwibbleQuery.ExecuteUpdate();                
                System.out.println("New Twibble Posted: "+twibbleContent);
                
                //////Check if subscriber and email notification//////
                // Recipient's email ID needs to be mentioned.
                String to = "mehdi.m.jamai@gmail.com";

                // Sender's email ID needs to be mentioned
                String from = currentEmail;

                // Assuming you are sending email from localhost
                String host = "localhost";

                // Get system properties
                Properties properties = System.getProperties();

                // Setup mail server
                properties.setProperty("mail.smtp.host", host);

                // Get the default Session object.
                Session session = Session.getDefaultInstance(properties);

                try{
                   // Create a default MimeMessage object.
                   MimeMessage message = new MimeMessage(session);

                   // Set From: header field of the header.
                   message.setFrom(new InternetAddress(from));

                   // Set To: header field of the header.
                   message.addRecipient(Message.RecipientType.TO,
                           new InternetAddress(to));
                  
                   // Set Subject: header field
                   message.setSubject("Notification");

                   // Now set the actual message
                   message.setText("This is actual message");

                   // Send message
                   Transport.send(message);
                   System.out.println("Sent message successfully....");
                }catch (MessagingException mex) {
                   mex.printStackTrace();
                }
                ///////End of Email Stuff//////
				
			 }
			 //Update Profile
			 if(command.equals("Update Profile")){
				
			 	
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
