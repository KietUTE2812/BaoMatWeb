package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import Model.P_DuyetModel;
import Model.P_TaiKhoanModel;
import Util.HandleException;
import Util.JDBCUtil;

public class P_TaiKhoanDAO {
	public static List<P_TaiKhoanModel> taikhoan(String maPQL) {
		List<P_TaiKhoanModel> tk = new ArrayList<>();
		String query = "call thongtintaikhoan(?);";

		try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																			// connection object
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {
			preparedStatement.setString(1, maPQL);
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				String matk = rs.getString(1);
				String username = rs.getString(2);
				String matkhau = rs.getString(3);
				String role = rs.getString(4);
				String trangthai = rs.getString(5);
				String mapql = rs.getString(6);
				String nguoidaidien = rs.getString(7);
				String sdt = rs.getString(8);
				String email = rs.getString(9);
				String diachi = rs.getString(10);

				tk.add(new P_TaiKhoanModel(matk, username, matkhau, role, trangthai, mapql, nguoidaidien, sdt, email,
						diachi));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return tk;
	}
	public static String updatetk(String mapql, String matk, String nguoidaidien, String sdt, String email, String diachi, String pass) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;
		System.out.println("update " + preparedStatement);
		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "call updateTTTKPQL(?,?,?,?,?,?,?);";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giá trị cho các tham số
			preparedStatement.setString(2, mapql);
			preparedStatement.setString(1, matk);
			preparedStatement.setString(3, nguoidaidien);
			preparedStatement.setString(4, sdt);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, diachi);
			preparedStatement.setString(7, pass);
			

			preparedStatement.executeUpdate();
			System.out.println("update " + preparedStatement);
		} catch (SQLException e) {
			// process sql exception
			err = e.getMessage();
			HandleException.printSQLException(e);

		} finally {
			// Đóng kết nối và tài nguyên
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return err;
	}
}
