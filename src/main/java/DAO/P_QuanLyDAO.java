package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.P_QuanLyModel;
import Model.P_QuanLyModel_Duyet;
import Model.P_ThongBaoModel;
import Util.HandleException;
import Util.JDBCUtil;

public class P_QuanLyDAO {
	public static List<P_QuanLyModel> getXemDeTai() {
		List<P_QuanLyModel> DeTai = new ArrayList<>();
		String query = " Select *  FROM DeTai where visible = 1 order by TrangThai;";

		try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																			// connection object
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

			ResultSet rs = preparedStatement.executeQuery();

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
				java.sql.Date ngaynopSQL = rs.getDate(11);

				LocalDate ngayThucHien = (ngayThucHienSQL != null) ? ngayThucHienSQL.toLocalDate() : null;
				LocalDate ngayKetThuc = (ngayKetThucSQL != null) ? ngayKetThucSQL.toLocalDate() : null;
				LocalDate ngayNop = (ngaynopSQL != null) ? ngaynopSQL.toLocalDate() : null;

				DeTai.add(new P_QuanLyModel(MaDT, TenDT, GhiChu, KetQua, TrangThai, LinkNopBai, ngayThucHien,
						ngayKetThuc, KinhPhi, ngayNop));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return DeTai;
	}

	

	public static String themdetai(P_QuanLyModel ThemDT) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "CALL ThemDeTai(?, ?, ?,?);";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, ThemDT.getMaDetai());
			preparedStatement.setString(2, ThemDT.getTenDeTai());
			preparedStatement.setString(3, ThemDT.getGhiChu());
			preparedStatement.setDouble(4, ThemDT.getKinhPhiDuKien());

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

	public static String xoadetai(String madetai) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "UPDATE DeTai SET visible = 0 WHERE MaDeTai = ?;";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, madetai);
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

	public static String suadetai(String madt, String tendt, String ghichu, String trangthai, String ketqua,
			String linknopbai, double kinhphi, LocalDate ngaythuchien, LocalDate ngayketthuc) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "UPDATE DeTai SET     TenDeTai = ?,    GhiChu = ?,    NgayThucHien = ?,    NgayKetThuc = ?,    KinhPhiDuKien = ?,    KetQua = ?,    TrangThai = ?,    LinkNopBai = ? WHERE MaDeTai = ?;";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, tendt != null ? tendt : null);
			preparedStatement.setString(2, ghichu != null ? ghichu : null);
			preparedStatement.setString(7, trangthai != null ? trangthai : null);
			preparedStatement.setString(6, ketqua != null ? ketqua : null);
			preparedStatement.setString(8, linknopbai != null ? linknopbai : null);
			preparedStatement.setString(9, madt != null ? madt : null);
			preparedStatement.setDouble(5, kinhphi);

			// Kiá»ƒm tra ngÃ y thá»±c hiá»‡n vÃ  ngÃ y káº¿t thÃºc trÆ°á»›c khi chuyá»ƒn Ä‘á»•i
			preparedStatement.setDate(3, ngaythuchien != null ? Date.valueOf(ngaythuchien) : null);
			preparedStatement.setDate(4, ngayketthuc != null ? Date.valueOf(ngayketthuc) : null);

			preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
			System.out.println("truy van duoc roi ne");
		} catch (SQLException e) {
			// process sql exception
			err = e.getMessage();
			HandleException.printSQLException(e);
			System.out.println("loi roi");

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

	public static List<P_QuanLyModel_Duyet> getXemDeXuatDeTai() {
		List<P_QuanLyModel_Duyet> dxDeTai = new ArrayList<>();
		String query = "CALL xemDeXuatDeTai();";

		try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																			// connection object
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				String magv = rs.getString(1);
				String maphongql = rs.getString(2);
				String tendt = rs.getString(3);
				String mota = rs.getString(4);
				double KinhPhi = rs.getDouble(5);
				String lydo = rs.getString(6);
				String trangthai = rs.getString(7);
				java.sql.Date ngayThucHienSQL = rs.getDate(8);
				String linkdinhkem = rs.getString(9);
				LocalDate ngaydexuat = (ngayThucHienSQL != null) ? ngayThucHienSQL.toLocalDate() : null;

				dxDeTai.add(
						new P_QuanLyModel_Duyet(magv, maphongql, tendt, mota, KinhPhi, lydo, trangthai, ngaydexuat, linkdinhkem));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return dxDeTai;
	}

	public static String themdetaiDuyet(P_QuanLyModel ThemDT) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "CALL ThemDeTai(?, ?, ?,?);";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, ThemDT.getMaDetai());
			preparedStatement.setString(2, ThemDT.getTenDeTai());
			preparedStatement.setString(3, ThemDT.getGhiChu());
			preparedStatement.setDouble(4, ThemDT.getKinhPhiDuKien());

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

	public static String DuyetDeTai(String madetai, String tendt, String ghichu, double kinhphi, String MaGV,
			String MaPQL) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = "CALL ThemDeXuatDeTai(?, ?, ?,?);";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, madetai);
			preparedStatement.setString(2, tendt);
			preparedStatement.setString(3, ghichu);
			preparedStatement.setDouble(4, kinhphi);

			preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
			

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

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = " Update QLKH.DeXuatDetai set MaPhongQL = ? ,TrangThai = 'Đã duyệt'  where MaGV = ? and TenDeTai = ?;";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, MaPQL);
			preparedStatement.setString(2, MaGV);
			preparedStatement.setString(3, tendt);
			preparedStatement.executeUpdate();
			System.out.println(preparedStatement);

		} catch (SQLException e) {
			// process sql exception
			err = e.getMessage();
			HandleException.printSQLException(e);

		}

		return err;
	}

	public static String HuyDeTai(String tendt, String MaGV, String MaPQL, String noiDung) throws SQLException {
		Connection connection = null;
		String err = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = (Connection) JDBCUtil.getConnection();
			String query = " Update QLKH.DeXuatDetai set MaPhongQL = ? ,TrangThai = 'Đã hủy', LyDo = ?  where MaGV = ? and TenDeTai = ?;";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
			preparedStatement.setString(1, MaPQL);
			preparedStatement.setString(2, noiDung);
			preparedStatement.setString(3, MaGV);
			preparedStatement.setString(4, tendt);
			preparedStatement.executeUpdate();
			

		} catch (SQLException e) {
			// process sql exception
			err = e.getMessage();
			HandleException.printSQLException(e);

		}

		return err;
	}

	public static String TimEmail(String MaTK) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String rsEmail = null;

		try {
			// Láº¥y káº¿t ná»‘i Ä‘áº¿n cÆ¡ sá»Ÿ dá»¯ liá»‡u
			connection = (Connection) JDBCUtil.getConnection();

			// Chuáº©n bá»‹ truy váº¥n SQL
			String query = "select Email From GiangVien where MaGV = ?;";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho tham sá»‘ trong truy váº¥n
			preparedStatement.setString(1, MaTK);

			// Thá»±c hiá»‡n truy váº¥n SQL vÃ  nháº­n káº¿t quáº£
			resultSet = preparedStatement.executeQuery();

			// Xá»­ lÃ½ káº¿t quáº£
			if (resultSet.next()) {
				rsEmail = resultSet.getString("Email");
			}
		} catch (SQLException e) {
			// Xá»­ lÃ½ ngoáº¡i lá»‡ SQL
			e.printStackTrace();
		} finally {
			// Ä�Ã³ng táº¥t cáº£ tÃ i nguyÃªn
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// Xá»­ lÃ½ ngoáº¡i lá»‡ khi Ä‘Ã³ng tÃ i nguyÃªn
				e.printStackTrace();
			}
		}

		return rsEmail;
	}

	public static String TimMaPQL(String MaTK) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String rsEmail = null;

		try {
			// Láº¥y káº¿t ná»‘i Ä‘áº¿n cÆ¡ sá»Ÿ dá»¯ liá»‡u
			connection = (Connection) JDBCUtil.getConnection();

			// Chuáº©n bá»‹ truy váº¥n SQL
			String query = "select MaPhongQL From PhongQLKH where MaTK = (select MaTk from TaiKhoan where username = ?);";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giÃ¡ trá»‹ cho tham sá»‘ trong truy váº¥n
			preparedStatement.setString(1, MaTK);

			// Thá»±c hiá»‡n truy váº¥n SQL vÃ  nháº­n káº¿t quáº£
			resultSet = preparedStatement.executeQuery();

			// Xá»­ lÃ½ káº¿t quáº£
			if (resultSet.next()) {
				rsEmail = resultSet.getString("MaPhongQL");
			}
		} catch (SQLException e) {
			// Xá»­ lÃ½ ngoáº¡i lá»‡ SQL
			e.printStackTrace();
		} finally {
			// Ä�Ã³ng táº¥t cáº£ tÃ i nguyÃªn
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// Xá»­ lÃ½ ngoáº¡i lá»‡ khi Ä‘Ã³ng tÃ i nguyÃªn
				e.printStackTrace();
			}
		}

		return rsEmail;
	}
}
