import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class databaseConnection {

	public static void connect() {

		Statement statement = null;

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://www.ascurra.com:3306/ascurra_445",
					"ascurra_445", "comp445");

			System.out.println("Connection ok ");

			statement = conn.createStatement();

			ResultSet resultSet = statement
					.executeQuery("select * from ascurra_445.users");

			while (resultSet.next()) {
				String user = resultSet.getString("alias");
				System.out.println("User: " + user);

			}

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
