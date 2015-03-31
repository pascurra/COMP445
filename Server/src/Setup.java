import java.sql.ResultSet;


public class Setup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//create one object for the conection
		databaseConnection registerQuery=new databaseConnection("");

/**
		
		//Example to delete alias paolo2015
		registerQuery.query="DELETE FROM ascurra_445.clients WHERE alias=\"paolo2015\";";
		registerQuery.ExecuteUpdate();		
		//Example to add alias paolo2015
		registerQuery.query="INSERT INTO ascurra_445.clients(alias,email,registrationDate) VALUES (\"paolo2015\", \"paoloew\",NOW());";		
		registerQuery.ExecuteUpdate();
		
		
		registerQuery.query="DELETE FROM ascurra_445.clients WHERE alias=\"paolo2016\";";
		registerQuery.ExecuteUpdate();		
		//Example to add alias paolo2016
		registerQuery.query="INSERT INTO ascurra_445.clients(alias,email,registrationDate) VALUES (\"paolo2016\", \"paoloew1\",NOW());";		
		registerQuery.ExecuteUpdate();
		
		
		
		
		registerQuery.query="DELETE FROM ascurra_445.clients WHERE alias=\"batman\";";
		registerQuery.ExecuteUpdate();		
		//Example to add alias paolo2016
		registerQuery.query="INSERT INTO ascurra_445.clients(alias,email,registrationDate) VALUES (\"batman\", \"batman@batman.com\",NOW());";		
		registerQuery.ExecuteUpdate();
		
		
		registerQuery.query="DELETE FROM ascurra_445.clients WHERE alias=\"sancho\";";
		registerQuery.ExecuteUpdate();		
		//Example to add alias paolo2016
		registerQuery.query="INSERT INTO ascurra_445.clients(alias,email,registrationDate) VALUES (\"sancho\", \"sancho@sancho.com\",NOW());";		
		registerQuery.ExecuteUpdate();
		*/
		
		registerQuery.query="INSERT INTO ascurra_445.twibbles(twiblrcontent,users_idusers-ForeinKey) VALUES (\"Hello Robin!\", \"28\");";		
		registerQuery.ExecuteUpdate();
		
		
		

	}

}
