COMP445

Paolo Ascurra	5808758
Ryan Storm		6478158
Mehdi M. Jamai	9503625


There are 3 projects:


Eclipse Project 1: Server
To run the server, execute the Main.java inside the Server project

Eclipse Project 2: Client
To run the client, execute the Main.java inside the Client project

Eclipse Project 3: Web-Server
To run the web server, execute the Main.java inside the Web-Server project


DATABASE SETUP:

Production Mode:
- No need to Setup Database. The database is already up and running in a dedicated server.




Development Mode: Needs local database setup

Step 1:

Install mysql server, preferably with MySQL Workbench.

Create a database and username with the following information:

			//Development Mode	
			//Databade Name: ascurra_445
			//User: ascurra_445
			//Password: comp445
			
Give permissions to the user create to access and write the database.			
			
			
Step 2:

Import the database_content.sql file into the database. This can be don via terminal or using MySQL Workbench.
			
			
			
Step 3:

Comment the following lines:

			//Production Mode
			conn = DriverManager.getConnection(
					"jdbc:mysql://www.ascurra.com:3306/ascurra_445",
					"ascurra_445", "comp445");


And ..

Uncomment the following code:

/*			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ascurra_445",
					"ascurra_445", "comp445");			
*/


From the file databaseConnection.java that exists in the Server project and the Web-Server Project (2 files)






