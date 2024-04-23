package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;
import java.sql.PreparedStatement;
import Model.P_DuyetModel;
import Model.P_QuanLyModel;
import Util.HandleException;
import Util.JDBCUtil;

public class P_DuyetDAO {
	public static List<P_DuyetModel> DonXinGiaHan() {
		List<P_DuyetModel> DonXin = new ArrayList<>();
		String query = " SELECT * FROM QLKH.DonXinGiaHan order by TrangThai;";

		try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																			// connection object
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				String madon = rs.getString(1);
				java.sql.Date ngaygiahan1 = rs.getDate(2);
				java.sql.Date ngayhoanthanh1 = rs.getDate(3);
				String linkdonxin = rs.getString(4);
				String lydo = rs.getString(5);
				String lydohuy = rs.getString(6);
				String trangthai = rs.getString(7);
				String madetai = rs.getString(8);
				String magv = rs.getString(9);
				String mapql = rs.getString(10);

				LocalDate ngaygiahan = (ngaygiahan1 != null) ? ngaygiahan1.toLocalDate() : null;
				LocalDate ngayhoanthanh = (ngayhoanthanh1 != null) ? ngayhoanthanh1.toLocalDate() : null;

				DonXin.add(new P_DuyetModel(madon, ngaygiahan, ngayhoanthanh, linkdonxin, lydo, lydohuy, trangthai,
						madetai, magv, mapql));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return DonXin;
	}

	public static String duyetdonxin(String madon, String mapql, String madt, LocalDate ngayht) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;
		Date ngayhoanthanh = Date.valueOf(ngayht);
		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "call duyetDonXinGiaHan(?,?,?,?)";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, mapql);
			preparedStatement.setString(2, madon);
			preparedStatement.setDate(3, ngayhoanthanh);
			preparedStatement.setString(4, madt);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			err = e.getMessage();
			HandleException.printSQLException(e);

		} finally {
			// Ä�Ã³ng káº¿t ná»‘i vÃ  tÃ i nguyÃªn
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return err;
	}

	public static String huydonxin(String madon, String mapql, String lydohuy) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "update QLKH.DonXinGiaHan set LyDoHuy=?, TrangThai = 'Đã hủy', MaPQL =? where MaDon =?;";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, lydohuy);
			preparedStatement.setString(2, mapql);
			preparedStatement.setString(3, madon);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			err = e.getMessage();
			HandleException.printSQLException(e);

		} finally {
			// Ä�Ã³ng káº¿t ná»‘i vÃ  tÃ i nguyÃªn
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return err;
	}

	public static List<P_DuyetModel> DeTaiDK() {
		List<P_DuyetModel> DTDK = new ArrayList<>();
		String query = " SELECT * FROM QLKH.DangKyDeTai order by TrangThai DESC;";

		try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																			// connection object
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				String magv = rs.getString(1);
				String madetai = rs.getString(2);
				java.sql.Date ngaygiahan1 = rs.getDate(3);
				String ghichu = rs.getString(4);
				String trangthai = rs.getString(5);
				String manhom = rs.getString(6);

				LocalDate ngaydangky = (ngaygiahan1 != null) ? ngaygiahan1.toLocalDate() : null;

				DTDK.add(new P_DuyetModel(magv, madetai, ngaydangky, ghichu, trangthai, manhom));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return DTDK;
	}

	public static String duyetDTDK(String magv, String madetai, String noiDung) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;
		System.out.println("Duyet dtdk");
		System.out.println("magv: " + magv);
		System.out.println("madetai: " + madetai);
		LocalDate currentDate1 = LocalDate.now();

		String ngayhientai1 = currentDate1.toString();
		System.out.println("ngayhientai: " + ngayhientai1);


		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "call DuyetDeTaiDK(?,?,?,?, ?)";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			LocalDate currentDate = LocalDate.now();

			String ngayhientai = currentDate.toString();
			Date sqlDate = Date.valueOf(currentDate);

			LocalDate ngayHoanThanh = currentDate.plusMonths(6);
			String ngahoanthanh = ngayHoanThanh.toString();
			Date sqlDateht = Date.valueOf(ngayHoanThanh);

			// Chuyá»ƒn Ä‘á»•i thÃ nh kiá»ƒu Date

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, magv);
			preparedStatement.setString(2, madetai);
			preparedStatement.setDate(3, sqlDate);
			preparedStatement.setDate(4, sqlDateht);
			preparedStatement.setString(5, noiDung);

			preparedStatement.executeUpdate();
			System.out.println("magv: " + magv);
			System.out.println("madetai: " + madetai);
			System.out.println("ngayhientai: " + ngayhientai);
			System.out.println("ngahoanthanh: " + ngahoanthanh);

			System.out.println("Duyet dtdk: " + preparedStatement);

		} catch (SQLException e) {
			// process sql exception
			err = e.getMessage();
			HandleException.printSQLException(e);

		} finally {
			// Ä�Ã³ng káº¿t ná»‘i vÃ  tÃ i nguyÃªn
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return err;
	}

	public static String huyDTDK(String magv, String madetai, String noiDung) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "update QLKH.DangKyDeTai set TrangThai = 'Đã hủy', GhiChu = ? where MaGV= ?  and MaDeTai = ?;";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, noiDung);
			preparedStatement.setString(2, magv);
			preparedStatement.setString(3, madetai);

			preparedStatement.executeUpdate();
			System.out.println("Huy dtdk: " + preparedStatement);
		} catch (SQLException e) {
			// process sql exception
			err = e.getMessage();
			HandleException.printSQLException(e);

		} finally {
			// Ä�Ã³ng káº¿t ná»‘i vÃ  tÃ i nguyÃªn
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return err;
	}
	
	//---------------------------
	public static List<P_DuyetModel> ThoiGian() {
		List<P_DuyetModel> tg = new ArrayList<>();
		String query = "SELECT * FROM QLKH.ThoiGian order by TrangThai DESC;";

		try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																			// connection object
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				String madot = rs.getString(1);
				String trangthai = rs.getString(2);
				java.sql.Date ngaymodk1 = rs.getDate(3);
				java.sql.Date ngaydongdk1 = rs.getDate(4);
				java.sql.Date ngaymoth1 = rs.getDate(5);
				java.sql.Date ngaydongth1 = rs.getDate(6);
				java.sql.Date ngaymobc1 = rs.getDate(7);
				java.sql.Date ngaydongbc1 = rs.getDate(8);
				java.sql.Date ngaymont1 = rs.getDate(9);
				java.sql.Date ngaydongnt1 = rs.getDate(10);
				java.sql.Date ngaydongdot1 = rs.getDate(11);
			

				LocalDate ngaymodk = (ngaymodk1 != null) ? ngaymodk1.toLocalDate() : null;
				LocalDate ngaydongdk = (ngaydongdk1 != null) ? ngaydongdk1.toLocalDate() : null;
				LocalDate ngaymoth = (ngaymoth1 != null) ? ngaymoth1.toLocalDate() : null;
				LocalDate ngaydongth = (ngaydongth1 != null) ? ngaydongth1.toLocalDate() : null;
				LocalDate ngaymobc = (ngaymobc1 != null) ? ngaymobc1.toLocalDate() : null;
				LocalDate ngaydongbc = (ngaydongbc1 != null) ? ngaydongbc1.toLocalDate() : null;
				LocalDate ngaymont = (ngaymont1 != null) ? ngaymont1.toLocalDate() : null;
				LocalDate ngaydongnt = (ngaydongnt1 != null) ? ngaydongnt1.toLocalDate() : null;
				LocalDate ngaydongdot = (ngaydongdot1 != null) ? ngaydongdot1.toLocalDate() : null;
				

				tg.add(new P_DuyetModel(madot, trangthai, ngaymodk, ngaydongdk, ngaymoth, ngaydongth,ngaymobc ,ngaydongbc ,ngaymont ,ngaydongnt ,ngaydongdot ));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return tg;
	}
	public static String thaydoidot(String madot, String trangthai, Date ngaymodk,Date ngaydongdk,Date ngaymoth,Date ngaydongth,Date ngaymobc,Date ngaydongbc,Date ngaymont,Date ngaydongnt,Date ngaydongdot) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "Call UpdateThoiGian (?,?,?,?,?,?,?,?,?,?,?);";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, madot);
			preparedStatement.setString(2, trangthai);
			preparedStatement.setDate(3, ngaymodk);
			preparedStatement.setDate(4, ngaydongdk);
			preparedStatement.setDate(5, ngaymoth);
			preparedStatement.setDate(6, ngaydongth);
			preparedStatement.setDate(7, ngaymobc);
			preparedStatement.setDate(8, ngaydongbc);
			preparedStatement.setDate(9, ngaymont);
			preparedStatement.setDate(10, ngaydongnt);
			preparedStatement.setDate(11, ngaydongdot);
			

			preparedStatement.executeUpdate();
			System.out.println("Huy dtdk: " + preparedStatement);
		} catch (SQLException e) {
			// process sql exception
			err = e.getMessage();
			HandleException.printSQLException(e);
			

		} finally {
			// Ä�Ã³ng káº¿t ná»‘i vÃ  tÃ i nguyÃªn
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return err;
	}
	
	public static String taodot(String madot, String trangthai, Date ngaymodk,Date ngaymoth,Date ngaymobc,Date ngaymont,Date ngaydongdot) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "call InsertThoiGian(?,?,?,?,?,?,?);";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, madot);
			preparedStatement.setString(2, trangthai);
			preparedStatement.setDate(3, ngaymodk);
			
			preparedStatement.setDate(4, ngaymoth);
	
			preparedStatement.setDate(5, ngaymobc);
		
			preparedStatement.setDate(6, ngaymont);
	
			preparedStatement.setDate(7, ngaydongdot);
			

			preparedStatement.executeUpdate();
			System.out.println("Huy dtdk: " + preparedStatement);
		} catch (SQLException e) {
			// process sql exception
			err = e.getMessage();
			HandleException.printSQLException(e);

		} finally {
			// Ä�Ã³ng káº¿t ná»‘i vÃ  tÃ i nguyÃªn
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return err;
	}
	
	public static int SoLuongTT() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "SELECT COUNT(*) AS ttDangMo FROM ThoiGian WHERE TrangThai = 'Đang mở';";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int SL = resultSet.getInt("ttDangMo");
				System.out.println("nkt" + SL);
				return SL;
			} else {
				return 0; 
			}
		} finally {
			// Đóng kết nối và tài nguyên
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
}

