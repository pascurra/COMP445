import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfTwibbles {

	String client;

	public String getListOfTwibbles() {

		databaseConnection ListOfTwibbles = new databaseConnection("");

		// getting client id
		ListOfTwibbles.query = "SELECT * FROM ascurra_445.clients where alias='"
				+ client + "'";

		ResultSet resultSet = ListOfTwibbles.executeSelectStatement();
		ArrayList idClient = new ArrayList();
		try {
			while (resultSet.next()) {

				idClient.add(resultSet.getInt("idusers"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int idClientInt = (int) idClient.get(0);

		// getting twiblr list for that client
		ListOfTwibbles.query = "SELECT * FROM ascurra_445.twibbles where usersIdForeign='"
				+ idClientInt + "'";
		resultSet = ListOfTwibbles.executeSelectStatement();

		ArrayList idtwiblr = new ArrayList();
		ArrayList twiblrcontent = new ArrayList();
		ArrayList usersIdForeign = new ArrayList();
		ArrayList date = new ArrayList();

		try {
			while (resultSet.next()) {

				idtwiblr.add(resultSet.getInt("idtwiblr"));
				twiblrcontent.add(resultSet.getString("twiblrcontent"));
				usersIdForeign.add(resultSet.getString("usersIdForeign"));
				date.add(resultSet.getString("date"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String listOfTwibbles = "";

		for (int i = 0; i < idtwiblr.size(); i++) {

			listOfTwibbles = listOfTwibbles.concat("<div><div>" + "Twibble:"
					+ "</div>");

			listOfTwibbles = listOfTwibbles.concat("<div><div>Id: "
					+ idtwiblr.get(i).toString() + "</div>");
			listOfTwibbles = listOfTwibbles.concat("<div>Content: "
					+ (String) twiblrcontent.get(i) + "</div>");
			listOfTwibbles = listOfTwibbles.concat("<div>UserId: "
					+ usersIdForeign.get(i).toString() + "</div>");
			listOfTwibbles = listOfTwibbles.concat("<div>Date Of Creation"
					+ (String) date.get(i) + "</div>");
			listOfTwibbles = listOfTwibbles.concat("<div><div>"
					+ "------------------" + "</div>");

		}

		return listOfTwibbles;

	}

	public ListOfTwibbles(String client) {
		super();
		this.client = client;
	}

}
