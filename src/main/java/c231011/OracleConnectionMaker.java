package c231011;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OracleConnectionMaker implements ConnectionMaker {
	@Override
	public Connection makeConnection() throws Exception{		
	Class.forName("oracle.jdbc.OracleDriver");
		
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/xe",
				"java",
				"qwer"
			);	
	}

}
