package conn;

import java.sql.SQLException;
import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Connections {

	private static DataSource datasource;
	
	public static DataSource getDataSource() throws SQLException {
		if (datasource == null) {
			
		// The configuration object specifies behaviors for the connection pool.
		HikariConfig config = new HikariConfig();
		 // Configure which instance and what database user to connect with.
		config.setDriverClassName(System.getProperty("drivername")); // see appengine-web.xml
		config.setJdbcUrl("jdbc:mysql://"+System.getProperty("sqlhostname")+":"+System.getProperty("sqlserverport")+"/"+System.getProperty("sqldatabasename")); // see appengine-web.xml
		config.setJdbcUrl("jdbc:mysql://localhost:3306/Databasename"); // see appengine-web.xml
		config.setUsername(System.getProperty("sqlusername")); // see appengine-web.xml
		config.setPassword(System.getProperty("sqlpassword")); // see appengine-web.xml
		
 	    // Initialize the connection pool using the configuration object.
		datasource = new HikariDataSource(config);
		}	
		return datasource;
			
	}
}
