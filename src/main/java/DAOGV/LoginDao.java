package DAOGV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Admin_Model.AD_Account;
import Util.HandleException;
import Util.JDBCUtil;

public class LoginDao {
    public AD_Account onLogin(AD_Account loginData) throws ClassNotFoundException {
        AD_Account account = null;

        try {
            // Bước 1: Mở kết nối đến MySQL
            Connection conn = JDBCUtil.getConnection();

            // Bước 2: Khởi tạo Prepare Statement
            PreparedStatement preparedStatement = conn
                    .prepareStatement("select * from TaiKhoan where username = ? and password = ? and role= ? ");
            preparedStatement.setString(1, loginData.getUsername());
            preparedStatement.setString(2, loginData.getPassword());
            preparedStatement.setString(3, loginData.getRole());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                // Nếu tìm thấy bản ghi, tạo đối tượng Account và thiết lập thông tin từ ResultSet
                account = new AD_Account();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getString("role"));
            }

        } catch (SQLException e) {
            // Xử lý ngoại lệ SQL
        	HandleException.printSQLException(e);
        }
        return account;                           
    }
}
