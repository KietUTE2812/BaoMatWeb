package Admin_Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Admin_Model.AD_TaiKhoan;
import Admin_Model.AD_ThongBao;

import Util.JDBCUtil;

public class AD_ThongBaoDao {

	public static List<AD_ThongBao> getXemThongBao() {
		List<AD_ThongBao> tb = new ArrayList<>();
		String query = "call XemThongBao();";

		try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																			// connection object
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				String tieude = rs.getString(1);
				String noidung = rs.getString(2);
				String nguoigui = rs.getString(3);
				LocalDate ngaygui = rs.getDate(4).toLocalDate();

				tb.add(new AD_ThongBao(tieude, noidung, nguoigui, ngaygui));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return tb;
	}

	public static List<AD_ThongBao> getXemGV() {
		List<AD_ThongBao> tb = new ArrayList<>();
		String query = "select MaGV, HoTen from GiangVien;";

		try (Connection connection = (Connection) JDBCUtil.getConnection();
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				String magv = rs.getString(1);
				String tengv = rs.getString(2);

				tb.add(new AD_ThongBao(magv, tengv));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return tb;
	}

	 public static void luuThongBao(AD_ThongBao thongBao) throws SQLException {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connection = (Connection) JDBCUtil.getConnection();
	            String query = "INSERT INTO ThongBao (MaTB, TieuDe, NgayGui, NoiDung, MaGv, MaPhongQL) VALUES (?, ?, ?, ?, ?, ?)";
	            preparedStatement = (PreparedStatement) connection.prepareStatement(query);
	            
	            System.out.println(query);
	            // Set giá trị cho các tham số
	            preparedStatement.setString(1, getmaTB()); // Hàm generateMaTB() để tạo mã TB
	            preparedStatement.setString(2, thongBao.getTieuDeGui());
	            preparedStatement.setTimestamp(3, getCurrentTimestamp()); // Hàm getCurrentTimestamp() để lấy thời gian hiện tại
	            preparedStatement.setString(4, thongBao.getNoiDungGui());
	            preparedStatement.setString(5, thongBao.getNguoiNhan());
	            preparedStatement.setString(6, "QL001");

	            preparedStatement.executeUpdate();
	        } finally {
	            // Đóng kết nối và tài nguyên
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        }
	    }

	    private static String generateMaTB() {
	        // Logic để tạo mã TB, ví dụ: return UUID.randomUUID().toString();
	        return "GeneratedMaTB";
	    }

	    private static Timestamp getCurrentTimestamp() {
	        // Lấy thời gian hiện tại
	        return new Timestamp(new Date().getTime());
	    }
	    
	    public static String getmaTB() throws SQLException {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            connection = (Connection) JDBCUtil.getConnection();
	            String query = "SELECT COUNT(*) AS total FROM ThongBao";
	            preparedStatement = (PreparedStatement) connection.prepareStatement(query);
	            resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	            	int MaTB = resultSet.getInt("total") + 1;
	            	System.out.println(MaTB);
	                return String.valueOf(MaTB);
	            } else {
	                return String.valueOf(0);
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
	    public static void GuiThongBao(AD_ThongBao GuiTB) throws SQLException {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        

	        try {
	            connection = (Connection) JDBCUtil.getConnection();
	            String query = "INSERT INTO ThongBao (MaTB, TieuDe, NgayGui, NoiDung, MaGv, MaPhongQL) VALUES (?, ?, ?, ?, ?, ?)";
	            preparedStatement = (PreparedStatement) connection.prepareStatement(query);
	            
	            System.out.println(query);
	            // Set giá trị cho các tham số
	            preparedStatement.setString(1, getmaTB()); // Hàm generateMaTB() để tạo mã TB
	            preparedStatement.setString(2, GuiTB.getTieuDeGui());
	            preparedStatement.setTimestamp(3, getCurrentTimestamp()); // Hàm getCurrentTimestamp() để lấy thời gian hiện tại
	            preparedStatement.setString(4, GuiTB.getNoiDungGui());
	            preparedStatement.setString(5, GuiTB.getNguoiNhan());
	            preparedStatement.setString(6, GuiTB.getNguoiGui());

	            preparedStatement.executeUpdate();
	        } finally {
	            // Đóng kết nối và tài nguyên
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        }
	    }
	    public static String TimEmail(String MaGV) throws SQLException {
	    	Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        String rsEmail = null;

	        try {
	            // Lấy kết nối đến cơ sở dữ liệu
	            connection = (Connection) JDBCUtil.getConnection();
	            
	            // Chuẩn bị truy vấn SQL
	            String query = "SELECT Email FROM GiangVien WHERE MaGV = ?";
	            preparedStatement = (PreparedStatement) connection.prepareStatement(query);
	            
	            // Set giá trị cho tham số trong truy vấn
	            preparedStatement.setString(1, MaGV);
	            
	            // Thực hiện truy vấn SQL và nhận kết quả
	            resultSet = preparedStatement.executeQuery();
	            
	            // Xử lý kết quả
	            if (resultSet.next()) {
	                rsEmail = resultSet.getString("Email");
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
	    
	    public static String getmaDT() throws SQLException {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            connection = (Connection) JDBCUtil.getConnection();
	            String query = " SELECT COUNT(*) AS total FROM DeTai;";
	            preparedStatement = (PreparedStatement) connection.prepareStatement(query);
	            resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	            	int MaTB = resultSet.getInt("total") + 1;
	            	System.out.println(MaTB);
	                return String.valueOf(MaTB);
	            } else {
	                return String.valueOf(0);
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
	    
	    public static List<AD_ThongBao> magvdangthuchien() {
			List<AD_ThongBao> tb = new ArrayList<>();
			String query = "call maGVDangThucHien();";

			try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																				// connection object
					PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {

					String magv= rs.getString(1);
					

					tb.add(new AD_ThongBao(magv));

				}
			} catch (

			SQLException exception) {
				JDBCUtil.printSQLException(exception);
			}
			return tb;
		}
	    public static List<AD_TaiKhoan> emailgvdangthuchien() {
			List<AD_TaiKhoan> tb = new ArrayList<>();
			String query = "call emailGVDangThucHien();";

			try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																				// connection object
					PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {

					String emailgv = rs.getString(1);
					

					tb.add(new AD_TaiKhoan(emailgv));

				}
			} catch (

			SQLException exception) {
				JDBCUtil.printSQLException(exception);
			}
			return tb;
		}
}
