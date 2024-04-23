package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.P_QuanLyModel;
import Model.P_ThongKeModel;
import Util.JDBCUtil;

public class P_ThongKeDAO {
	public static List<P_ThongKeModel> dsdetai(String madot) {
		List<P_ThongKeModel> DeTai = new ArrayList<>();
		String query = " call dsdetaithongke(?,?);";
		if (madot != null) {
			LocalDate nbd = null;
			try {
				nbd = getNgayBatDau(madot);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LocalDate nkt= null;
			try {
				nkt = getNgayKeThuc(madot);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date ngaybatdau1 = Date.valueOf(nbd);
			Date ngayketthuc1 = Date.valueOf(nkt);

			try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																				// connection object
					PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {
				preparedStatement.setDate(1, ngaybatdau1);
				preparedStatement.setDate(2, ngayketthuc1);
				ResultSet rs = preparedStatement.executeQuery();
				System.out.println(preparedStatement);
				// Step 4: Process the ResultSet object.
				while (rs.next()) {

					String MaDT = rs.getString(1);
					String TenDT = rs.getString(2);
					String GhiChu = rs.getString(3);
					java.sql.Date ngayThucHienSQL = rs.getDate(4);
					java.sql.Date ngayKetThucSQL = rs.getDate(5);
					double KinhPhi = rs.getDouble(6);
					String KetQua = rs.getString(7);
					String TrangThai = rs.getString(8);
					String LinkNopBai = rs.getString(9);
					java.sql.Date ngaynopbaisql = rs.getDate(10);

					LocalDate ngayThucHien = (ngayThucHienSQL != null) ? ngayThucHienSQL.toLocalDate() : null;
					LocalDate ngayKetThuc = (ngayKetThucSQL != null) ? ngayKetThucSQL.toLocalDate() : null;
					LocalDate ngaynopbai = (ngaynopbaisql != null) ? ngaynopbaisql.toLocalDate() : null;

					DeTai.add(new P_ThongKeModel(MaDT, TenDT, GhiChu, ngayThucHien, ngayKetThuc, KinhPhi, KetQua,
							TrangThai, LinkNopBai, ngaynopbai));

				}
			} catch (

			SQLException exception) {
				JDBCUtil.printSQLException(exception);
			}
		}
		return DeTai;
	}

	public static List<P_ThongKeModel> dsMaDot() {
		List<P_ThongKeModel> DeTai = new ArrayList<>();
		String query = "select MaDot from ThoiGian;";

		try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																			// connection object
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				String MaDot = rs.getString(1);

				DeTai.add(new P_ThongKeModel(MaDot));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return DeTai;
	}

	public static LocalDate getNgayBatDau(String madot) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "select NgayMoDangKy from ThoiGian where MaDot =?;";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setString(1, madot);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				LocalDate ngayMoDangKy = resultSet.getDate("NgayMoDangKy").toLocalDate();
				
				return ngayMoDangKy;
			} else {
				return null; 
			}
		} finally {
			// Ä�Ã³ng káº¿t ná»‘i vÃ  tÃ i nguyÃªn
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

	public static LocalDate getNgayKeThuc(String madot) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "select NgayDongDot from ThoiGian where MaDot =?;";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setString(1, madot);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				LocalDate NgayDongDot = resultSet.getDate("NgayDongDot").toLocalDate();
				System.out.println("nkt" + NgayDongDot);
				return NgayDongDot;
			} else {
				return null; 
			}
		} finally {
			
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
