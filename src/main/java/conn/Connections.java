package conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		config.setUsername(System.getProperty("sqlusername")); // see appengine-web.xml
		config.setPassword(System.getProperty("sqlpassword")); // see appengine-web.xml
		
 	    // Initialize the connection pool using the configuration object.
		datasource = new HikariDataSource(config);
		}	
		return datasource;
			
	}
	
	public static void main(String[] args)
    {
                   
    Connection connection = null;
            PreparedStatement pstmt = null;
            ResultSet resultSet = null;
            try
            {
                    DataSource dataSource = Connections.getDataSource();
                    connection = dataSource.getConnection();
                    pstmt = connection.prepareStatement("SELECT * FROM vaihtoehdot");
                     
                    System.out.println("The Connection Object is of Class: " + connection.getClass());
                     
                    resultSet = pstmt.executeQuery();
                    while (resultSet.next())
                    {
                            System.out.println(resultSet.getString(1) + "," + resultSet.getString(2));
                    }

            }
            catch (Exception e)
            {
                    try
                    {
                            connection.rollback();
                    }
                    catch (SQLException e1)
                    {
                            e1.printStackTrace();
                    }
                    e.printStackTrace();
            }
     
    }
}
