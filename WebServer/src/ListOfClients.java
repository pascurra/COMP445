import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfClients {

	public String getListOfClients() {

		databaseConnection ListOfClients = new databaseConnection("");

		ListOfClients.query = "SELECT * FROM ascurra_445.clients";
		ResultSet resultSet = ListOfClients.executeSelectStatement();

		ArrayList idusers = new ArrayList();
		ArrayList alias = new ArrayList();
		ArrayList email = new ArrayList();
		ArrayList registrationDate = new ArrayList();

		try {
			while (resultSet.next()) {

				idusers.add(resultSet.getInt("idusers"));
				alias.add(resultSet.getString("alias"));
				email.add(resultSet.getString("email"));
				registrationDate.add(resultSet.getString("registrationDate"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String listOfclients = "";

		for (int i = 0; i < alias.size(); i++) {
			listOfclients = listOfclients.concat("<div><div>"
					+ idusers.get(i).toString() + "</div>");
			listOfclients = listOfclients.concat("<div>"
					+ (String) alias.get(i) + "</div>");
			listOfclients = listOfclients.concat("<div>"
					+ (String) email.get(i) + "</div>");
			listOfclients = listOfclients.concat("<div>"
					+ (String) registrationDate.get(i) + "</div></div>");

		}

		return listOfclients;

	}

}
