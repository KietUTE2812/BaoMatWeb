package DAOGV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import ModelGV.ThongBao;
import Util.HandleException;
import Util.JDBCUtil;

public class ThongBaoDao {

	public ThongBaoDao() {
		// TODO Auto-generated constructor stub
	}
	public List<ThongBao> XemTB(String MaGV) throws ClassNotFoundException {
        String Changeinf = "SELECT TB.TieuDe, TB.NgayGui, TB.NoiDung, QL.NguoiDaiDien From ThongBao TB Join PhongQLKH QL ON TB.MaPhongQL  = QL.MaPhongQL WHERE TB.MaGV = ? ORDER BY TB.NgayGui DESC;";
        String err = null;
        List <ThongBao> tbs = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
        	
            PreparedStatement preparedStatement = connection.prepareStatement(Changeinf)) {
        	preparedStatement.setString(1, MaGV);
        	
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
            	String TieuDe = rs.getString("TieuDe");
            	LocalDate NgayGui = rs.getDate("Ngaygui").toLocalDate();
            	String NoiDung =  rs.getString("NoiDung");
            	String NguoiGui =  rs.getString("NguoiDaiDien");
            	ThongBao tb = new ThongBao(TieuDe, NgayGui, NoiDung, NguoiGui);
            	tbs.add(tb);
            }
            
        } catch (SQLException e) {
            // process sql exception
        	err = e.getMessage();
            HandleException.printSQLException(e);
        }
        System.out.println(err);
        return tbs;
	
	}

}
