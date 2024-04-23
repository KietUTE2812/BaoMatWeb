package Admin_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Admin_Model.AD_GiangVien;
import Util.HandleException;
import Util.JDBCUtil;

public class AD_GiangVienDao {
	
    private static final String SELECT_ALL_GIANGVIEN = "SELECT * FROM GiangVien";
    private static final String SELECT_GIANGVIEN_ByMaTK = "SELECT * FROM GiangVien where MaTK=?";
    private static final String DELETE_GIANGVIEN_BY_ID = "update GiangVien set Visible= ? where MaTK=?;";
    private static final String UPDATE_GV = "update GiangVien set HoTen = ?, Email = ?, TrinhDo = ?, MaKhoa = ?, GioiTinh = ?, Image=? where MaTK = ?";
    private static final String INSERT_GiangVien = "INSERT INTO GiangVien" +
	        "(MaGV,HoTen,Email,TrinhDo,MaKhoa,MaTK,GioiTinh,Image) VALUES " + " (?, ?, ?, ?,?,?,?,?);";
    
    public List<AD_GiangVien> selectAllGiangVien()
    {
    	List<AD_GiangVien> listGV=new ArrayList<>();
    	try
    	{
    		//connect mysql
    		Connection conn = JDBCUtil.getConnection();
    		PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_GIANGVIEN);
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		while(rs.next())
    		{
    			 String maGV = rs.getString("MaGV"); 
    			 String hoTen =rs.getString("HoTen"); 
    			 String email = rs.getString("Email"); 
    			 String trinhDo = rs.getString("TrinhDo"); 
    			 String maKhoa = rs.getString("MaKhoa"); 
    			 String maTK=rs.getString("MaTK");
    			 String gioiTinh = rs.getString("GioiTinh");
    			 String image=rs.getString("Image");
    			 listGV.add(new AD_GiangVien(maGV, hoTen, email, trinhDo,maKhoa,maTK,gioiTinh,image));    		}
    	}
    	catch(SQLException e) 
    	 {
    		HandleException.printSQLException(e);
    	}
    	return listGV;
    }
    
    public AD_GiangVien getGiangVienByMaTK(String MaTK) {
        try {
            //connect mysql
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_GIANGVIEN_ByMaTK);
            preparedStatement.setString(1, MaTK);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String maGV = rs.getString("MaGV");
                String hoTen = rs.getString("HoTen");
                String email = rs.getString("Email");
                String trinhDo = rs.getString("TrinhDo");
                String maKhoa = rs.getString("MaKhoa");
                String maTK = rs.getString("MaTK");
                String gioiTinh = rs.getString("GioiTinh");
                String image=rs.getString("Image");
                System.out.println("Selected Image File Name : "+image);
                return new AD_GiangVien(maGV, hoTen, email, trinhDo, maKhoa, maTK, gioiTinh,image);
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
       
        return null;
    }
   

    public boolean deleteGiangVien(int id) throws SQLException {
        boolean rowDeleted=false;
        try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement statement = connection.prepareStatement(DELETE_GIANGVIEN_BY_ID);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        catch (SQLException e) {
        	HandleException.printSQLException(e);
        }
        return rowDeleted;
   
    }
    //public void updategv(String HoTen, String Email, String TrinhDo, String MaKhoa,String matkupdate,  String GioiTinh) 
    public void updategv(AD_GiangVien gv) throws SQLException 
    {
        try {
            Connection connection = JDBCUtil.getConnection(); 
            PreparedStatement statement = connection.prepareStatement(UPDATE_GV); 
            statement.setString(1, gv.getHoTen());
            statement.setString(2, gv.getEmail());
            statement.setString(3, gv.getTrinhDo());
            statement.setString(4, gv.getMaKhoa());
            statement.setString(5, gv.getGioiTinh());
            statement.setString(6, gv.getImage());
            statement.setString(7, gv.getMaTK());
            
            System.out.println("Executing SQL: " + statement.toString());
            statement.executeUpdate(); 
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
    }
    public void insertGiangVien(AD_GiangVien gv) throws SQLException {
	     
        // try-with-resource statement will auto close the connection.
        try {
        	Connection connection = JDBCUtil.getConnection(); 
            PreparedStatement statement = connection.prepareStatement(INSERT_GiangVien ); 
            statement.setString(1,gv.getMaGV());
            statement.setString(2, gv.getHoTen());
            statement.setString(3, gv.getEmail());
            statement.setString(4, gv.getTrinhDo());
            statement.setString(5, gv.getMaKhoa());
            statement.setString(6, gv.getMaTK());
            statement.setString(7, gv.getGioiTinh());
            statement.setString(8, gv.getImage());
            System.out.println("Executing SQL: " + statement.toString());
            statement.executeUpdate(); 
        } catch (SQLException e) {
        	HandleException.printSQLException(e);
        }
    }
    public void updatevisible(AD_GiangVien gv) throws SQLException 
    {
        try {
            Connection connection = JDBCUtil.getConnection(); 
            PreparedStatement statement = connection.prepareStatement(DELETE_GIANGVIEN_BY_ID ); 
            statement.setInt(1, gv.getVisible());
            statement.setString(2, gv.getMaTK());
            System.out.println("Executing SQL: " + statement.toString());
            statement.executeUpdate(); 
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
    }

	
}

