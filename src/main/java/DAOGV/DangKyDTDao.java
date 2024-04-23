package DAOGV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ModelGV.DeTai;
import ModelGV.Nhom;
import ModelGV.Time;
import Util.HandleException;
import Util.JDBCUtil;

public class DangKyDTDao {

	
	public List<DeTai> ShowTTDeTai()
	{
        String SHOW_TT = "SELECT MaDeTai, TenDeTai, GhiChu, KinhPhiDuKien, TrangThai From DeTai WHERE TrangThai = \"Chưa Đăng Ký\" AND visible = 1;";

        List<DeTai> DeTais = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
            
        	
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
            	String MaDeTai = rs.getString("MaDeTai");
            	String tenDeTai = rs.getString("TenDeTai");
            	String GhiChu = rs.getString("GhiChu");
            	String KinhPhi = rs.getString("KinhPhiDuKien");
            	String TrangThai = rs.getString("TrangThai");
            	
            	DeTai detai = new DeTai(MaDeTai, tenDeTai, GhiChu, KinhPhi, TrangThai);
            	DeTais.add(detai);
            }
        } catch (SQLException e) {
            // process sql exception
            HandleException.printSQLException(e);
        }
        return DeTais;
			


	}
	public String DangKyDeTai(String MaGV, String MaDT, String MaNhom)
	{
        String SHOW_TT = "CALL dkdt (?, ?, ?);";

        String err = null;
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
        	preparedStatement.setString(1, MaGV);
        	preparedStatement.setString(2, MaDT);
        	preparedStatement.setString(3, MaNhom);
        	System.out.println(preparedStatement);
        	preparedStatement.executeUpdate();
        	
            
            // Step 3: Execute the query or update query
            
        } catch (SQLException e) {
            // process sql exception
        	err = e.getMessage();
            HandleException.printSQLException(e);
        }
        return err;
			


	}
	public boolean KiemTraTgDK()
	{
        String SHOW_TT = "SELECT NgayMoDangKy, NgayDongDangKy, NgayMoBaoCao, NgayDongBaoCao From ThoiGian WHERE TrangThai = 'Đang mở'";
        Time time = new Time();
        boolean isTrue = false;
        
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
        	
        	System.out.println(preparedStatement);
        	
        	ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
            	LocalDate MDK  = (rs.getDate("NgayMoDangKy") != null) ? rs.getDate("NgayMoDangKy").toLocalDate():null;
            	LocalDate DDK  =(rs.getDate("NgayDongDangKy") != null) ? rs.getDate("NgayDongDangKy").toLocalDate():null;
            	LocalDate MBC = (rs.getDate("NgayMoBaoCao") != null) ? rs.getDate("NgayMoBaoCao").toLocalDate():null;
            	LocalDate DBC  =(rs.getDate("NgayDongBaoCao") != null) ? rs.getDate("NgayDongBaoCao").toLocalDate():null;
            	time = new Time(MDK, DDK, MBC, DBC);
            	isTrue = time.inNgayDK();
            }
            
            // Step 3: Execute the query or update query
            
        } catch (SQLException e) {
            // process sql exception
        	
            HandleException.printSQLException(e);
        }
        return isTrue;
			


	}
	public Time ShowTG()
	{
        String SHOW_TT = "SELECT NgayMoDangKy, NgayDongDangKy, NgayMoBaoCao, NgayDongBaoCao From ThoiGian WHERE TrangThai = 'Đang mở'";
        Time time = new Time();
        
        
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
        	
        	System.out.println(preparedStatement);
        	
        	ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
            	LocalDate MDK  = (rs.getDate("NgayMoDangKy") != null) ? rs.getDate("NgayMoDangKy").toLocalDate():null;
            	LocalDate DDK  =(rs.getDate("NgayDongDangKy") != null) ? rs.getDate("NgayDongDangKy").toLocalDate():null;
            	LocalDate MBC = (rs.getDate("NgayMoBaoCao") != null) ? rs.getDate("NgayMoBaoCao").toLocalDate():null;
            	LocalDate DBC  =(rs.getDate("NgayDongBaoCao") != null) ? rs.getDate("NgayDongBaoCao").toLocalDate():null;
            	time = new Time(MDK, DDK, MBC, DBC);
            	
            }
            
            // Step 3: Execute the query or update query
            
        } catch (SQLException e) {
            // process sql exception
        	
            HandleException.printSQLException(e);
        }
        return time;
			


	}
	public boolean KiemTraTgNop()
	{
        String SHOW_TT = "SELECT NgayMoDangKy, NgayDongDangKy, NgayMoBaoCao, NgayDongBaoCao From ThoiGian WHERE TrangThai = 'Đang mở'";
        Time time = new Time();
        boolean isTrue = false;
        
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
        	
        	System.out.println(preparedStatement);
        	
        	ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
            	LocalDate MDK  = (rs.getDate("NgayMoDangKy") != null) ? rs.getDate("NgayMoDangKy").toLocalDate():null;
            	LocalDate DDK  =(rs.getDate("NgayDongDangKy") != null) ? rs.getDate("NgayDongDangKy").toLocalDate():null;
            	LocalDate MBC = (rs.getDate("NgayMoBaoCao") != null) ? rs.getDate("NgayMoBaoCao").toLocalDate():null;
            	LocalDate DBC  =(rs.getDate("NgayDongBaoCao") != null) ? rs.getDate("NgayDongBaoCao").toLocalDate():null;
            	time = new Time(MDK, DDK, MBC, DBC);
            	isTrue = time.inNgayNop();
            }
            
            // Step 3: Execute the query or update query
            
        } catch (SQLException e) {
            // process sql exception
        	
            HandleException.printSQLException(e);
        }
        return isTrue;
			


	}
	public String DeXuatDeTai(String MaGV, String TenDT, String MoTa, String KinhPhi, String Link)
	{
        String SHOW_TT = "CALL dxdt (?, ?, ?, ?, ?);";

        String err = null;
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
        	preparedStatement.setString(1, MaGV);
        	preparedStatement.setString(2, TenDT);
        	preparedStatement.setString(3, MoTa);
        	preparedStatement.setString(4, KinhPhi);
        	preparedStatement.setString(5, Link);
        	System.out.println(preparedStatement);
        	preparedStatement.executeUpdate();
        	
            
            // Step 3: Execute the query or update query
            
        } catch (SQLException e) {
            // process sql exception
        	err = e.getMessage();
            HandleException.printSQLException(e);
        }
        return err;
			


	}
	public DeTai showctdt(String MaDT)
	{
		String SHOW_TT = "SELECT * From DeTai where MaDeTai = ?;";
		DeTai detai = new DeTai();
        
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
        	preparedStatement.setString(1, MaDT);
        	preparedStatement.executeQuery();
        	
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
            	String MaDeTai = rs.getString("MaDeTai");
            	String tenDeTai = rs.getString("TenDeTai");
            	String GhiChu = rs.getString("GhiChu");
            	String KinhPhi = rs.getString("KinhPhiDuKien");
            	String TrangThai = rs.getString("TrangThai");
            	
            	detai = new DeTai(MaDeTai, tenDeTai, GhiChu, KinhPhi, TrangThai);
            	
            }
            // Step 3: Execute the query or update query
            
        } catch (SQLException e) {
            // process sql exception
        	
            HandleException.printSQLException(e);
        }
        return detai;
	}

}
