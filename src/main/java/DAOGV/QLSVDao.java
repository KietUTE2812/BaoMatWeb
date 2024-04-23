package DAOGV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ModelGV.Nganh;
import ModelGV.Nhom;
import ModelGV.SinhVien;
import Util.HandleException;
import Util.JDBCUtil;

public class QLSVDao {

	
		// TODO Auto-generated constructor stub
		public List<Nhom> ShowTTNhom(String username)
		{
	        String SHOW_TT = "SELECT * From Nhom Where MaGV = (SELECT MaGV from GiangVien Where MaTK =(SELECT MaTK FROM TaiKhoan WHERE username = ?));";

	        List<Nhom> nhs = new ArrayList<>();
	        try (Connection connection = JDBCUtil.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
	            preparedStatement.setString(1, username);
	        	
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next())
	            {
	            	String MaNhom = rs.getString("MaNhom");
	            	String tenNhom = rs.getString("TenNhom");
	            	String MaGV = rs.getString("MaGV");
	            	
	            	Nhom nh = new Nhom(MaNhom, tenNhom, MaGV);
	            	nhs.add(nh);
	            }
	        } catch (SQLException e) {
	            // process sql exception
	            HandleException.printSQLException(e);
	        }
	        return nhs;
				
	

}
		public String ShowTenNhomForm(String MaNhom)
		{
	        String SHOW_TT = "SELECT TenNhom From Nhom where MaNhom = ?;";

	        String tennhom = "";
	        try (Connection connection = JDBCUtil.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
	            preparedStatement.setString(1, MaNhom);
	        	
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next())
	            {
	            	tennhom = rs.getString(1);
	            }
	        } catch (SQLException e) {
	            // process sql exception
	            HandleException.printSQLException(e);
	        }
	        return tennhom;
				
	

}
		public SinhVien ShowTTTVFrom(String MSSV)
		{
	        String SHOW_TT = "SELECT * From SinhVien where MSSV = ? AND Visible = 1;";

	        SinhVien sv = new SinhVien();
	        try (Connection connection = JDBCUtil.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
	            preparedStatement.setString(1, MSSV);
	        	
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next())
	            {
	            	MSSV = rs.getString("MSSV");
	            	String maNhom = rs.getString("MaNhom");
	            	String MaSV = rs.getString("MaSV");
	            	
	            	String HoTen = rs.getString("HoTen");
	            	LocalDate NgaySinh = rs.getDate("NgaySinh").toLocalDate();
	            	String Email = rs.getString("Email");
	            	String CCCD = rs.getString("CCCD");
	            	String SDT = rs.getString("SDT");
	            	String Lop = rs.getString("Lop");
	            	String NienKhoa = rs.getString("NienKhoa");
	            	String DiaChi = rs.getString("DiaChi");
	            	String MaNganh = rs.getString("MaNganh");
	            	
	            	
	            	sv = new SinhVien(MaSV, MSSV, HoTen, NgaySinh, Email, CCCD, SDT, Lop, NienKhoa, DiaChi, maNhom, MaNganh);
	            }
	        } catch (SQLException e) {
	            // process sql exception
	            HandleException.printSQLException(e);
	        }
	        return sv;
				
	

}
		public String ThemNhom(String TenNhom, String MaGV)
		{
	        String SHOW_TT = "CALL InsertNhom (?, ?);";
	        String err = null;
	        
	        try (Connection connection = JDBCUtil.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
	            preparedStatement.setString(1, TenNhom);
	            preparedStatement.setString(2, MaGV);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            // process sql exception
	        	err = e.getMessage();
	            HandleException.printSQLException(e);
	        }
	        return err;
		}
		public List<Nganh> ShowFormThemTV()
		{
	        String SHOW_TT = "Select * From Nganh;";
	        List<Nganh> nganhs = new ArrayList<>();
	        
	        try (Connection connection = JDBCUtil.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
	        	ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next())
	            {
	            	
	            	String MaNganh = rs.getString("MaNganh");
	            	String TenNganh = rs.getString("TenNganh");
	            	String MaKhoa = rs.getString("MaKhoa");
	            	
	            	Nganh ng = new Nganh(MaNganh, TenNganh, MaKhoa);
	            	
	            	nganhs.add(ng);
	            }
	            
	        } catch (SQLException e) {
	            // process sql exception
	        	
	            HandleException.printSQLException(e);
	        }
	        return nganhs;
		}
		public String ThemTV(SinhVien sv)
		{
	        String SHOW_TT = "CALL InsertSinhVien (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	        String err = null;
	        
	        try (Connection connection = JDBCUtil.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
	        	preparedStatement.setString(1, sv.getMSSV());
	        	preparedStatement.setString(2, sv.getHoTen());
	        	preparedStatement.setString(3, sv.getNgaySinh().toString());
	        	preparedStatement.setString(4, sv.getEmail());
	        	preparedStatement.setString(5, sv.getCCCD());
	        	preparedStatement.setString(6, sv.getSDT());
	        	preparedStatement.setString(7, sv.getNienKhoa());
	        	preparedStatement.setString(8, sv.getDiaChi());
	        	preparedStatement.setString(9, sv.getMaNhom());
	        	preparedStatement.setString(10, sv.getMaNganh());
	        	
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            // process sql exception
	        	err = e.getMessage();
	            HandleException.printSQLException(e);
	        }
	        return err;
		}
		public String EditTV(String MSSV, SinhVien sv)
		{
	        String SHOW_TT = "CALL EditSinhVien (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	        String err = null;
	        
	        try (Connection connection = JDBCUtil.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
	        	preparedStatement.setString(1, MSSV);
	        	preparedStatement.setString(2, sv.getHoTen());
	        	preparedStatement.setString(3, sv.getNgaySinh().toString());
	        	preparedStatement.setString(4, sv.getEmail());
	        	preparedStatement.setString(5, sv.getCCCD());
	        	preparedStatement.setString(6, sv.getSDT());
	        	preparedStatement.setString(7, sv.getNienKhoa());
	        	preparedStatement.setString(8, sv.getDiaChi());
	        	preparedStatement.setString(9, sv.getMaNhom());
	        	preparedStatement.setString(10, sv.getMaNganh());
	        	
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            // process sql exception
	        	err = e.getMessage();
	            HandleException.printSQLException(e);
	        }
	        return err;
		}
		public String XoaTV(String MSSV)
		{
	        String SHOW_TT = "UPDATE SinhVien Set Visible = 0 where MSSV = ?;";
	        String err = null;
	        
	        try (Connection connection = JDBCUtil.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
	        	
	        	preparedStatement.setString(1, MSSV);
	        	
	            System.out.println(preparedStatement + "aaaaaaaaaaaaaaaaaaaaaa");
	            // Step 3: Execute the query or update query
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            // process sql exception
	        	err = e.getMessage();
	            HandleException.printSQLException(e);
	        }
	        return err;
		}
		public List<SinhVien> ShowTTSV(String MaNhom)
		{
	        String SHOW_TT = "SELECT * From SinhVien Where MaNhom = ? AND Visible = 1;";

	        List<SinhVien> SVs = new ArrayList<>();
	        try (Connection connection = JDBCUtil.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
	            preparedStatement.setString(1, MaNhom);
	        	
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next())
	            {
	            	
	            	String maNhom = MaNhom;
	            	String MaSV = rs.getString("MaSV");
	            	String MSSV = rs.getString("MSSV");
	            	String HoTen = rs.getString("HoTen");
	            	LocalDate NgaySinh = rs.getDate("NgaySinh").toLocalDate();
	            	String Email = rs.getString("Email");
	            	String CCCD = rs.getString("CCCD");
	            	String SDT = rs.getString("SDT");
	            	String Lop = rs.getString("Lop");
	            	String NienKhoa = rs.getString("NienKhoa");
	            	String DiaChi = rs.getString("DiaChi");
	            	String MaNganh = rs.getString("MaNganh");
	            	
	            	
	            	SinhVien sv = new SinhVien(MaSV, MSSV, HoTen, NgaySinh, Email, CCCD, SDT, Lop, NienKhoa, DiaChi, maNhom, MaNganh);
	            	SVs.add(sv);
	            }
	        } catch (SQLException e) {
	            // process sql exception
	            HandleException.printSQLException(e);
	        }
	        return SVs;
		}
}
