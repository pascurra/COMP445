import java.sql.ResultSet;


public class Setup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		databaseConnection registerQuery=new databaseConnection("INSERT INTO ascurra_445.clients VALUES (paolo1,paolo@email.com,2015-03-24)");
		ResultSet resultSet=registerQuery.Query();
		

	}

}
