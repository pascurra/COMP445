import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class databaseConnection {
	
	public databaseConnection(String query) {
		super();
		this.query = query;

	}



	String query;
	ResultSet resultSet;
	
	
	//for data select statements

	public ResultSet executeSelectStatement() {

		Statement statement = null;

		Connection conn = null;

		try {
			
//Production or development(local) mode can be used.			
			
			//Production Mode						
			conn = DriverManager.getConnection(
					"jdbc:mysql://www.ascurra.com:3306/ascurra_445",
					"ascurra_445", "comp445");			
					
			
			//Development Mode	
			//Database Name to create: ascurra_445
			//User: ascurra_445
			//Password: comp445
/*			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ascurra_445",
					"ascurra_445", "comp445");			
*/
			
			
			
			

			System.out.println("Connection ok ");

			statement = conn.createStatement();

			resultSet = statement
					.executeQuery(query);



		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return resultSet;

	}
	
	
	//for data manipulation
	//http://www.coderanch.com/t/301594/JDBC/databases/Difference-execute-executeQuery-executeUpdate
	public void ExecuteUpdate() {

		Statement statement = null;

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://www.ascurra.com:3306/ascurra_445",
					"ascurra_445", "comp445");

			System.out.println("Connection ok ");

			statement = conn.createStatement();

			int queryresult = statement
					.executeUpdate(query);



		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		

	}
	
	

}
