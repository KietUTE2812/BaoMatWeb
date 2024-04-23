package Admin_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Admin_Model.AD_Account;

import Util.HandleException;
import Util.JDBCUtil;

public class AD_AccountDao {
private static final String Delete_TaiKhoan="update TaiKhoan set Status= ? where MaTK=?;";
  private static final String SELECT_ALL_TaiKhoan = "select * from TaiKhoan";
  private static final String SELECT_ID_TaiKhoan = "SELECT * FROM TaiKhoan where MaTK=?";
  private static final String INSERT_TaiKhoan = "INSERT INTO TaiKhoan" +
	        " (username, password, role,MaTK) VALUES " + " (?, ?, ?, ?);";
  private static final String UPDATE_TaiKhoan = "update TaiKhoan set username = ?, password = ?, role = ?  where MaTK = ?";
  


	  public List<AD_Account> selectAllAccount()
	    {
	    	List<AD_Account> listAC = new ArrayList<>();
	    	try
	    	{
	    		
	    		Connection conn = JDBCUtil.getConnection();
	    		PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_TaiKhoan);
	    		ResultSet rs = preparedStatement.executeQuery();
	    		
	    		while(rs.next())
	    		{
	    			 String MaTK = rs.getString("MaTK"); 
	    			 String username =rs.getString("username"); 
	    			 String password = rs.getString("password"); 
	    			 String role = rs.getString("role"); 
	    			 listAC.add(new AD_Account(username,password,role,MaTK));    		}
	    	}
	    	catch(SQLException e) 
	    	 {
	    		HandleException.printSQLException(e);
	    	}
	    	return listAC;
	    }
	  public void insertTaiKhoan(AD_Account ac) throws SQLException {
	     
	        // try-with-resource statement will auto close the connection.
	        try {
	        	Connection connection = JDBCUtil.getConnection(); 
	        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TaiKhoan);
	        	
	            preparedStatement.setString(1, ac.getUsername());
	            preparedStatement.setString(2, ac.getPassword());
	            preparedStatement.setString(3, ac.getRole());
	            preparedStatement.setString(4, ac.getMaTK());
	            

	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	        	HandleException.printSQLException(e);
	        }
	    }
	  public void updateTaiKhoan(AD_Account acc) throws SQLException 
	    {
	        try {
	            Connection connection = JDBCUtil.getConnection(); 
	            PreparedStatement statement = connection.prepareStatement(UPDATE_TaiKhoan); 
	            statement.setString(1, acc.getUsername());
	            statement.setString(2, acc.getPassword());
	            statement.setString(3, acc.getRole());
	            statement.setString(4, acc.getMaTK());
	            
	            System.out.println("Executing SQL: " + statement.toString());
	            statement.executeUpdate(); 
	        }	 catch (SQLException e) {
	            HandleException.printSQLException(e);
	        }
	    }
	  
	  public AD_Account getTaiKhoanByMaTK(String MaTK) {
	        try {
	            
	            Connection conn = JDBCUtil.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ID_TaiKhoan);
	            preparedStatement.setString(1, MaTK);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	            	String username = rs.getString("username");
	            	String password = rs.getString("password");
	            	String role = rs.getString("role");
	                String maTK = rs.getString("MaTK");
	                return new AD_Account(username,password,role,maTK);
	            }
	        } catch (SQLException e) {
	            HandleException.printSQLException(e);
	        }
	    
	        return null;
	    }
	  public void updatestatus(AD_Account ac) throws SQLException 
	    {
	        try {
	            Connection connection = JDBCUtil.getConnection(); 
	            PreparedStatement statement = connection.prepareStatement(Delete_TaiKhoan ); 
	            statement.setInt(1, ac.getStatus());
	            statement.setString(2, ac.getMaTK());
	            System.out.println("Executing SQL: " + statement.toString());
	            statement.executeUpdate(); 
	        } catch (SQLException e) {
	            HandleException.printSQLException(e);
	        }
	    }

	  
}
