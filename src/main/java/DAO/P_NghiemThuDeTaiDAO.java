package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.P_NghiemThuDeTaiModel;
import Model.P_QuanLyModel;
import Model.P_ThongBaoModel;
import Util.HandleException;
import Util.JDBCUtil;

import java.sql.Timestamp;



public class P_NghiemThuDeTaiDAO {
	public static List<P_NghiemThuDeTaiModel> getxemdanhsachdetai() {
		List<P_NghiemThuDeTaiModel> DeTai = new ArrayList<>();
		String query = "call DSDeTaiCanNghiemThu();";

		try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																			// connection object
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				String MaDT = rs.getString(1);

				DeTai.add(new P_NghiemThuDeTaiModel(MaDT));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return DeTai;
	}

	public static List<P_NghiemThuDeTaiModel> xembienbannghiemthu() {
		List<P_NghiemThuDeTaiModel> bb = new ArrayList<>();
		String query = "SELECT * FROM QLKH.BienBanNghiemThu order by NgayNghiemThu;";

		try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																			// connection object
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				String mabienban = rs.getString(1);
				double diem = rs.getDouble(2);
				String danhgia = rs.getString(3);
				String minhchung = rs.getString(4);
				java.sql.Date ngayThucHienSQL = rs.getDate(5);
				LocalDate ngaynghiemthu = (ngayThucHienSQL != null) ? ngayThucHienSQL.toLocalDate() : null;
				String madetai = rs.getString(6);
				String mapql = rs.getString(7);

				bb.add(new P_NghiemThuDeTaiModel(mabienban, diem, danhgia, minhchung, ngaynghiemthu, madetai, mapql));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return bb;
	}
	
	public static String TimMabb() throws SQLException {
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String Mabb = null;

        try {
            // Láº¥y káº¿t ná»‘i Ä‘áº¿n cÆ¡ sá»Ÿ dá»¯ liá»‡u
            connection = (Connection) JDBCUtil.getConnection();
            
            // Chuáº©n bá»‹ truy váº¥n SQL
            String query = "select count(*) + 1 as mabb from BienBanNghiemThu;";
            preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            
            // Set giÃ¡ trá»‹ cho tham sá»‘ trong truy váº¥n
            
            
            // Thá»±c hiá»‡n truy váº¥n SQL vÃ  nháº­n káº¿t quáº£
            resultSet = preparedStatement.executeQuery();
            
            // Xá»­ lÃ½ káº¿t quáº£
            if (resultSet.next()) {
            	Mabb = resultSet.getString("mabb");
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

        return Mabb;
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
	public static String TimMaGVDKDT(String MaDT) throws SQLException {
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String MaGV = null;

        try {
            // Láº¥y káº¿t ná»‘i Ä‘áº¿n cÆ¡ sá»Ÿ dá»¯ liá»‡u
            connection = (Connection) JDBCUtil.getConnection();
            
            // Chuáº©n bá»‹ truy váº¥n SQL
            String query = "select MaGV from DangKyDeTai where MaDeTai = ?;";
            preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            
            // Set giÃ¡ trá»‹ cho tham sá»‘ trong truy váº¥n
            preparedStatement.setString(1, MaDT);
            
            // Thá»±c hiá»‡n truy váº¥n SQL vÃ  nháº­n káº¿t quáº£
            resultSet = preparedStatement.executeQuery();
            
            // Xá»­ lÃ½ káº¿t quáº£
            if (resultSet.next()) {
            	MaGV = resultSet.getString("MaGV");
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

        return MaGV;
    }
	
	public static LocalDate getCurrentDate() {
        // Láº¥y ngÃ y hiá»‡n táº¡i
        return LocalDate.now();
    }
	
	public static String themBBNT(P_NghiemThuDeTaiModel ThemBB) throws SQLException {
        Connection connection = null;
        String err = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = (Connection) JDBCUtil.getConnection();
            String query = "CALL InsertBienBanNghiemThu(?,?, ?, ?, ?, ?, ?);";
            preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            
            // Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
            preparedStatement.setString(1, ThemBB.getMaBienBan());
            preparedStatement.setDouble(2, ThemBB.getDiem());
            preparedStatement.setString(3, ThemBB.getDanhGia());
            preparedStatement.setString(4, ThemBB.getMinhChung());
            preparedStatement.setDate(5, ThemBB.getNgayNghiemThu() != null ? Date.valueOf(ThemBB.getNgayNghiemThu()) : null);
            preparedStatement.setString(6, ThemBB.getMaDeTai());
            preparedStatement.setString(7, ThemBB.getMaPQL());
            
            

            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
        	err = e.getMessage();
            HandleException.printSQLException(e);
            
        }finally {
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
}
