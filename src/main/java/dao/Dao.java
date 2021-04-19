package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import data.Vaihtoehto;

public class Dao {

	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    
	public void openDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup variables
            String sqlhostname = System.getProperty("sqlhostname");
			String serverport = System.getProperty("sqlserverport");
			String database = System.getProperty("sqldatabasename");
			String username = System.getProperty("sqlusername");
			String password = System.getProperty("sqlpassword");
			String url = "jdbc:mysql://"+sqlhostname+":"+serverport+"/"+database;
            // Setup the connection with the DB
            connect = java.sql.DriverManager.getConnection(url,username,password);

        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
        }

    }
	
	public ArrayList<Vaihtoehto> readAllOption() {
		ArrayList<Vaihtoehto> list=new ArrayList<>();
		Statement statement=null;
		try {
			statement = connect.createStatement();
			ResultSet rs=statement.executeQuery("select * from vaihtoehdot");
			while (rs.next()) {
		 		Vaihtoehto vaihtoehto =new Vaihtoehto();
				vaihtoehto.setId(rs.getInt("id"));
				vaihtoehto.setVaihtoehto(rs.getString("vaihtoehto"));
				list.add(vaihtoehto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
