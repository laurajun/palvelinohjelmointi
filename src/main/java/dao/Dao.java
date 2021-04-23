package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conn.Connections;
import data.Claim;
import data.Vaihtoehto;


public class Dao {
    private Connection conn;
    private Statement statement = null;
    private ResultSet resultSet = null;
   
    
    public Dao() {
		try {
			conn=Connections.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void TallennaVaittama(String vaittama) {
    	// TODO Auto-generated method stub
    	  String sql="insert into vaittamat(vaittama) values(?)";
    		try {
    			PreparedStatement pstmt=conn.prepareStatement(sql);
    			pstmt.setString(1,  vaittama);
     			pstmt.executeUpdate();
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }
    
    public void PaivitaVaittama(String vaittama, int id) {
    	// TODO Auto-generated method stub
    	  String sql="update table vaittamat set vaittama=? where id=?";
    		try {
    			PreparedStatement pstmt=conn.prepareStatement(sql);
    			pstmt.setString(1,  vaittama);
    			pstmt.setInt(2,  id);
     			pstmt.executeUpdate();
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }
	
	public ArrayList<Vaihtoehto> readAllOption() {
		ArrayList<Vaihtoehto> list=new ArrayList<>();
		Statement statement=null;
		try {
			statement = conn.createStatement();
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
	
	public ArrayList<Claim> listAllClaims() {
		ArrayList<Claim> list=new ArrayList<>();
		Statement statement=null;
		try {
			statement = conn.createStatement();
			ResultSet rs=statement.executeQuery("select * from vaittamat");
			while (rs.next()) {
		 		Claim claim =new Claim();
				claim.setId(rs.getInt("id"));
				claim.setClaim(rs.getString("vaittama"));
				list.add(claim);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Claim> ShowSingleClaim(int rid) {
		ArrayList<Claim> list=new ArrayList<>();
				
		try {
			String sql="select * from vaittamat where id=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, rid);
			ResultSet rs=statement.executeQuery(sql);
			
			while (rs.next()) {
		 		Claim claim =new Claim();
				claim.setId(rs.getInt("id"));
				claim.setClaim(rs.getString("vaittama"));
				list.add(claim);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean CheckLogin(String username, String password) throws SQLException,
    ClassNotFoundException {
			boolean ok = false;
		
			String sql = "SELECT * FROM logins WHERE username = ? and password = ?";
			try {
    			PreparedStatement pstmt=conn.prepareStatement(sql);
    			pstmt.setString(1,  username);
    			pstmt.setString(2,  password);
    			ResultSet result = pstmt.executeQuery();
    			ok = result.next();

    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			return ok;
		
	}
	
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {

        }
    }

}


