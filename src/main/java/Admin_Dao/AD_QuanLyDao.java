package Admin_Dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Util.JDBCUtil;

public class AD_QuanLyDao {
	
	
	
	public static String TimMaPQL(String MaTK) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String rsEmail = null;

		try {
			// Lấy kết nối đến cơ sở dữ liệu
			connection = (Connection) JDBCUtil.getConnection();

			// Chuẩn bị truy vấn SQL
			String query = "select MaPhongQL From PhongQLKH where MaTK = (select MaTk from TaiKhoan where username = ?);";
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			// Set giá trị cho tham số trong truy vấn
			preparedStatement.setString(1, MaTK);

			// Thực hiện truy vấn SQL và nhận kết quả
			resultSet = preparedStatement.executeQuery();

			// Xử lý kết quả
			if (resultSet.next()) {
				rsEmail = resultSet.getString("MaPhongQL");
			}
		} catch (SQLException e) {
			// Xử lý ngoại lệ SQL
			e.printStackTrace();
		} finally {
			// Đóng tất cả tài nguyên
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
				// Xử lý ngoại lệ khi đóng tài nguyên
				e.printStackTrace();
			}
		}

		return rsEmail;
	}
}
