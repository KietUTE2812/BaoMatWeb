package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.P_TaiKhoanModel;
import Model.P_ThongBaoModel;

import Util.JDBCUtil;

public class P_ThongBaoDAO {

	public static List<P_ThongBaoModel> getXemThongBao() {
		List<P_ThongBaoModel> tb = new ArrayList<>();
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

				tb.add(new P_ThongBaoModel(tieude, noidung, nguoigui, ngaygui));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return tb;
	}

	public static List<P_ThongBaoModel> getXemGV() {
		List<P_ThongBaoModel> tb = new ArrayList<>();
		String query = "select MaGV, HoTen from GiangVien;";

		try (Connection connection = (Connection) JDBCUtil.getConnection();
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				String magv = rs.getString(1);
				String tengv = rs.getString(2);

				tb.add(new P_ThongBaoModel(magv, tengv));

			}
		} catch (

		SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return tb;
	}

	 public static void luuThongBao(P_ThongBaoModel thongBao) throws SQLException {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connection = (Connection) JDBCUtil.getConnection();
	            String query = "INSERT INTO ThongBao (MaTB, TieuDe, NgayGui, NoiDung, MaGv, MaPhongQL) VALUES (?, ?, ?, ?, ?, ?)";
	            preparedStatement = (PreparedStatement) connection.prepareStatement(query);
	            
	            System.out.println(query);
	            // Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
	            preparedStatement.setString(1, getmaTB()); // HÃ m generateMaTB() Ä‘á»ƒ táº¡o mÃ£ TB
	            preparedStatement.setString(2, thongBao.getTieuDeGui());
	            preparedStatement.setTimestamp(3, getCurrentTimestamp()); // HÃ m getCurrentTimestamp() Ä‘á»ƒ láº¥y thá»�i gian hiá»‡n táº¡i
	            preparedStatement.setString(4, thongBao.getNoiDungGui());
	            preparedStatement.setString(5, thongBao.getNguoiNhan());
	            preparedStatement.setString(6, "QL001");

	            preparedStatement.executeUpdate();
	        } finally {
	            // Ä�Ã³ng káº¿t ná»‘i vÃ  tÃ i nguyÃªn
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        }
	    }

	    private static String generateMaTB() {
	        // Logic Ä‘á»ƒ táº¡o mÃ£ TB, vÃ­ dá»¥: return UUID.randomUUID().toString();
	        return "GeneratedMaTB";
	    }

	    private static Timestamp getCurrentTimestamp() {
	        // Láº¥y thá»�i gian hiá»‡n táº¡i
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
	    public static void GuiThongBao(P_ThongBaoModel GuiTB) throws SQLException {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        

	        try {
	            connection = (Connection) JDBCUtil.getConnection();
	            String query = "INSERT INTO ThongBao (MaTB, TieuDe, NgayGui, NoiDung, MaGv, MaPhongQL) VALUES (?, ?, ?, ?, ?, ?)";
	            preparedStatement = (PreparedStatement) connection.prepareStatement(query);
	            
	            
	            // Set giÃ¡ trá»‹ cho cÃ¡c tham sá»‘
	            preparedStatement.setString(1, getmaTB()); // HÃ m generateMaTB() Ä‘á»ƒ táº¡o mÃ£ TB
	            preparedStatement.setString(2, GuiTB.getTieuDeGui());
	            preparedStatement.setTimestamp(3, getCurrentTimestamp()); // HÃ m getCurrentTimestamp() Ä‘á»ƒ láº¥y thá»�i gian hiá»‡n táº¡i
	            preparedStatement.setString(4, GuiTB.getNoiDungGui());
	            preparedStatement.setString(5, GuiTB.getNguoiNhan());
	            preparedStatement.setString(6, GuiTB.getNguoiGui());

	            preparedStatement.executeUpdate();
	            System.out.println(preparedStatement);
	        } finally {
	            // Ä�Ã³ng káº¿t ná»‘i vÃ  tÃ i nguyÃªn
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
	            // Láº¥y káº¿t ná»‘i Ä‘áº¿n cÆ¡ sá»Ÿ dá»¯ liá»‡u
	            connection = (Connection) JDBCUtil.getConnection();
	            
	            // Chuáº©n bá»‹ truy váº¥n SQL
	            String query = "SELECT Email FROM GiangVien WHERE MaGV = ?";
	            preparedStatement = (PreparedStatement) connection.prepareStatement(query);
	            
	            // Set giÃ¡ trá»‹ cho tham sá»‘ trong truy váº¥n
	            preparedStatement.setString(1, MaGV);
	            
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
	    
	    public static List<P_ThongBaoModel> magvdangthuchien() {
			List<P_ThongBaoModel> tb = new ArrayList<>();
			String query = "call maGVDangThucHien();";

			try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																				// connection object
					PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {

					String magv= rs.getString(1);
					

					tb.add(new P_ThongBaoModel(magv));

				}
			} catch (

			SQLException exception) {
				JDBCUtil.printSQLException(exception);
			}
			return tb;
		}
	    public static List<P_TaiKhoanModel> emailgvdangthuchien() {
			List<P_TaiKhoanModel> tb = new ArrayList<>();
			String query = "call emailGVDangThucHien();";

			try (Connection connection = (Connection) JDBCUtil.getConnection(); // Step 2:Create a statement using
																				// connection object
					PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);) {

				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {

					String emailgv = rs.getString(1);
					

					tb.add(new P_TaiKhoanModel(emailgv));

				}
			} catch (

			SQLException exception) {
				JDBCUtil.printSQLException(exception);
			}
			return tb;
		}
}
