package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {

	private Connection conn;
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String hostname = System.getProperty("sqlshostname");
			String serverport = System.getProperty("sqlserverport");
			String database = System.getProperty("sqldatabasename");
			String username = System.getProperty("sqlusername");
			String password = System.getProperty("sqlpassword");
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://"+hostname+":"+serverport+"/"+database,username,password);
			
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public int saveGame(Game game) {
//		Statement stmt=null;
//		int count=0;
//		try {
//			stmt = conn.createStatement();
//			count=stmt.executeUpdate("insert into gametable(breed, weight) values('"+game.getBreed()+"', "+game.getWeight()+")");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return count;
//	}
//	public ArrayList<Option> readAllOption() {
//		ArrayList<Option> list=new ArrayList<>();
//		Statement stmt=null;
//		int count=0;
//		try {
//			stmt = conn.createStatement();
//			ResultSet rs=stmt.executeQuery("select * from vaihtoehdot");
//			while (rs.next()) {
//				Game game=new Game();
//				game.setId(rs.getInt("id"));
//				game.setBreed(rs.getString("breed"));
//				game.setWeight(rs.getFloat("weight"));
//				list.add(game);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}
}
