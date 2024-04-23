package Admin_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


import Admin_Model.AD_Admin;
import Util.HandleException;
import Util.JDBCUtil;

public class AD_AdminDao {
	private static final String SELECT_ID_ADMIN = "CALL admintaikhoan(?)";
	private static final String Update_ID_ADIN="Update Admin set HoTen=?, Email=?,NgaySinh=?, Imagead=? where MaTK=?";
	public AD_Admin getAdminByMaTK(String username) {
        try {
            //connect mysql
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ID_ADMIN);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
         
            if (rs.next()) {
                String maAdmin = rs.getString("MaAdmin");
                String hoTen = rs.getString("HoTen");
                String email = rs.getString("Email");
                LocalDate ngaysinh = rs.getDate("NgaySinh").toLocalDate();
                String imagead = rs.getString("Imagead");
                String maTK = rs.getString("MaTK");
              
                return new AD_Admin(maAdmin, hoTen, email, ngaysinh, imagead, maTK);
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
       
        return null;
    }
	 public void updateAdminTaiKhoan(AD_Admin acc) throws SQLException 
	    {
	        try {
	            Connection connection = JDBCUtil.getConnection(); 
	            PreparedStatement statement = connection.prepareStatement(Update_ID_ADIN); 
	            statement.setString(1, acc.getHoTen());
	            statement.setString(2, acc.getEmail());
	            statement.setDate(3, JDBCUtil.getSQLDate(acc.getNgaySinh()));
	            statement.setString(4, acc.getImagead());
	            statement.setString(5,acc.getMaTK());
	            System.out.println("Executing SQL: " + statement.toString());
	            statement.executeUpdate(); 
	        }	 catch (SQLException e) {
	            HandleException.printSQLException(e);
	        }
	    }
}
