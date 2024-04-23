package DAOGV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelGV.Khoa;
import ModelGV.taikhoangv;


import Util.*;

public class taiKhoanDao {

	
	// TODO Auto-generated constructor stub
	public taikhoangv ShowTTTaiKhoan(String username) throws ClassNotFoundException {
        String SHOW_TT = "SELECT HoTen, MaGV, GioiTinh,Email, TrinhDo, TenKhoa FROM QLKH.GiangVien GV JOIN QLKH.Khoa KH ON GV.MaKhoa = KH.MaKhoa Where MaTK = (SELECT MaTK FROM TaiKhoan WHERE username = ?);";

        taikhoangv tkgv = null;
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
            preparedStatement.setString(1, username);
        	
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
            	String ten = rs.getString("HoTen");
            	String MaGV = rs.getString("MaGV");
            	String GioiTinh = rs.getString("GioiTinh");
            	String Email = rs.getString("Email");
            	String TrinhDo = rs.getString("TrinhDo");
            	String Khoa = rs.getString("TenKhoa");
            	tkgv = new taikhoangv(ten, MaGV, GioiTinh, Email, TrinhDo, Khoa);
            }
        } catch (SQLException e) {
            // process sql exception
            HandleException.printSQLException(e);
        }
        return tkgv;
	
	}
	public String ChangePass(String Pass, String Npass, String Cpass, String username) throws ClassNotFoundException {
        String ChangePass = "CALL ChangePassword (?,?,?,?);";
        String err = null;
        
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
        	
            PreparedStatement preparedStatement = connection.prepareStatement(ChangePass)) {
        	preparedStatement.setString(1, Pass);
        	preparedStatement.setString(2, Npass);
        	preparedStatement.setString(3, Cpass);
        	preparedStatement.setString(4, username);
        	preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            
            
        } catch (SQLException e) {
            // process sql exception
        	err = e.getMessage();
            HandleException.printSQLException(e);
        }
        System.out.println(err);
        return err;
	
	}
	public String ChangeInfo(String usern,taikhoangv info, String MaKH) throws ClassNotFoundException {
        String Changeinf = "CALL ChangeInfoGV (?,?,?,?, ?, ?);";
        String err = null;
        
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
        	
            PreparedStatement preparedStatement = connection.prepareStatement(Changeinf)) {
        	preparedStatement.setString(1, usern);
        	preparedStatement.setString(2, info.getHoten());
        	preparedStatement.setString(3, info.getGTinh());
        	preparedStatement.setString(4, info.getEmail());
        	preparedStatement.setString(5, info.getTrinhDo());
        	preparedStatement.setString(6, MaKH);
        	
            System.out.println(preparedStatement + "aaaaa");
            preparedStatement.executeUpdate();
            // Step 3: Execute the query or update query
            
            
        } catch (SQLException e) {
            // process sql exception
        	err = e.getMessage();
            HandleException.printSQLException(e);
        }
        System.out.println(err);
        return err;
	
	}
	public List<Khoa> ListKhoa() throws ClassNotFoundException {
        String Changeinf = "SELECT * FROM Khoa";
        String err = null;
        List <Khoa> khoas = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
        	
            PreparedStatement preparedStatement = connection.prepareStatement(Changeinf)) {
        	
        	preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
            	String MaKhoa = rs.getString("MaKhoa");
            	String TenKhoa = rs.getString("TenKhoa");
            	Khoa kh = new Khoa(MaKhoa, TenKhoa);
            	khoas.add(kh);
            }
            
        } catch (SQLException e) {
            // process sql exception
        	err = e.getMessage();
            HandleException.printSQLException(e);
        }
        System.out.println(err);
        return khoas;
	
	}
	
}
