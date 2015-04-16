import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfProfiles {

	public String getListOfProfiles() {

		// getting list of profiles into arraylists
		databaseConnection ListOfProfiles = new databaseConnection("");

		ListOfProfiles.query = "SELECT * FROM ascurra_445.profiles";
		ResultSet resultSet = ListOfProfiles.executeSelectStatement();

		ArrayList idProfiles = new ArrayList();
		ArrayList alias = new ArrayList();
		ArrayList location = new ArrayList();
		ArrayList interests = new ArrayList();
		ArrayList dateOfJoining = new ArrayList();
		ArrayList dateOfPostingProfile = new ArrayList();

		try {
			while (resultSet.next()) {

				idProfiles.add(resultSet.getInt("idprofiles"));
				alias.add(resultSet.getString("alias"));
				location.add(resultSet.getString("location"));
				interests.add(resultSet.getString("interests"));
				dateOfJoining.add(resultSet.getString("dateOfJoining"));
				dateOfPostingProfile.add(resultSet
						.getString("dateOfPostingProfile"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// getting list of clients

		databaseConnection ListOfClients = new databaseConnection("");

		ListOfClients.query = "SELECT * FROM ascurra_445.clients";
		ResultSet resultSetClients = ListOfClients.executeSelectStatement();

		ArrayList idusers = new ArrayList();
		ArrayList aliasClients = new ArrayList();
		ArrayList email = new ArrayList();
		ArrayList registrationDate = new ArrayList();

		try {
			while (resultSetClients.next()) {
				idusers.add(resultSetClients.getInt("idusers"));
				aliasClients.add(resultSetClients.getString("alias"));
				email.add(resultSetClients.getString("email"));
				registrationDate.add(resultSetClients
						.getString("registrationDate"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String listOfclients = "";

		for (int i = aliasClients.size() - 1; i >= 0; i--) {
			listOfclients = listOfclients.concat("<div><div>" + "----------"
					+ "</div>");

			listOfclients = listOfclients.concat("<div><div>" + "Client:"
					+ "</div>");

			listOfclients = listOfclients.concat("<div><div>Client's id: "
					+ idusers.get(i).toString() + "</div>");
			// listOfclients=listOfclients.concat("<div>Client's alias: "+
			// (String) aliasClients.get(i)+"</div>");

			listOfclients = listOfclients
					.concat("<div>Client's alias: <a href=\""
							+ (String) aliasClients.get(i) + "-Twibbles/\">"
							+ (String) aliasClients.get(i) + "</a> </div>");

			listOfclients = listOfclients.concat("<div>Clients' email: "
					+ (String) email.get(i) + "</div>");
			listOfclients = listOfclients.concat("<div>Registration Date"
					+ (String) registrationDate.get(i) + "</div></div>");

			String listOfProfiles = "";

			if (alias.contains(aliasClients.get(i))) {
				listOfProfiles = listOfProfiles.concat("<div><div>"
						+ "Client has a Profile: YES" + "</div>");

				int id = alias.indexOf(aliasClients.get(i));
				listOfProfiles = listOfProfiles.concat("<div><div>"
						+ "- Profile:" + "</div>");

				listOfProfiles = listOfProfiles.concat("<div><div>Id: "
						+ idProfiles.get(id).toString() + "</div>");
				// set url
				listOfProfiles = listOfProfiles.concat("<div>Alias: "
						+ (String) alias.get(id) + "</div>");
				listOfProfiles = listOfProfiles.concat("<div>Location: "
						+ (String) location.get(id) + "</div>");
				listOfProfiles = listOfProfiles.concat("<div>Interest: "
						+ (String) interests.get(id) + "</div>");
				listOfProfiles = listOfProfiles
						.concat("<div>Date Of Joining Twibbler: "
								+ (String) dateOfJoining.get(id)
								+ "</div></div>");

				listOfProfiles = listOfProfiles
						.concat("<div>Date Of Profile Creation: "
								+ (String) dateOfPostingProfile.get(id)
								+ "</div></div>");
				// listOfProfiles=listOfProfiles.concat("<div><div>"+"------------------"+"</div>");

			}

			else {

				listOfProfiles = listOfProfiles.concat("<div><div>"
						+ "Client has a Profile: NO" + "</div>");

			}
			listOfProfiles = listOfProfiles.concat("<div><div>" + "</br>"
					+ "</div>");

			listOfclients = listOfclients.concat(listOfProfiles);

		}

		return listOfclients;

	}

}
