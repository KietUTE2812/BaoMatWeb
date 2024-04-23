package DAOGV;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ModelGV.DeTai;
import ModelGV.GV_DonGiaHan;
import Util.HandleException;
import Util.JDBCUtil;

public class QLDTDao {

	public QLDTDao() {
		// TODO Auto-generated constructor stub
	}

	public List<DeTai> ShowDeTaiofGV(String MaGV) {
		String SHOW_TT = "select DK.MaGV, nh.TenNhom, DK.MaDeTai, DT.TenDeTai, "
				+ "DT.NgayNop, DT.NgayThucHien, DT.NgayKetThuc, DT.KinhPhiDuKien, DT.KetQua, DT.LinkNopBai, DT.TrangThai from DangKyDeTai DK Join DeTai DT ON DK.MaDeTai = DT.MaDeTai Join Nhom nh ON DK.MaNhom = nh.MaNhom where DK.MaGV = ? AND DK.TrangThai = 'Đã duyệt'";

		List<DeTai> DeTais = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
			preparedStatement.setString(1, MaGV);

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String MaDeTai = rs.getString("MaDeTai");
				String tenDeTai = rs.getString("TenDeTai");
				LocalDate NgayThucHien = (rs.getDate("NgayThucHien") != null) ? rs.getDate("NgayThucHien").toLocalDate()
						: null;
				LocalDate NgayKetThuc = (rs.getDate("NgayKetThuc") != null) ? rs.getDate("NgayKetThuc").toLocalDate()
						: null;
				String KinhPhi = rs.getString("KinhPhiDuKien");
				String KetQua = rs.getString("KetQua");
				String LinkNop = rs.getString("LinkNopBai");
				String TrangThai = rs.getString("TrangThai");
				String TenNhom = rs.getString("TenNhom");
				LocalDate NgayNop = (rs.getDate("NgayNop") != null) ? rs.getDate("NgayNop").toLocalDate() : null;
				DeTai detai = new DeTai(MaDeTai, tenDeTai, "", NgayThucHien, NgayKetThuc, KinhPhi, KetQua, TrangThai,
						LinkNop, TenNhom, NgayNop);
				DeTais.add(detai);
			}
		} catch (SQLException e) {
			// process sql exception
			HandleException.printSQLException(e);
		}
		return DeTais;

	}

	public DeTai TTDeTaiFrom(String MaDeTai) {
		String SHOW_TT = "select DK.MaGV, nh.TenNhom, DK.MaDeTai, DT.TenDeTai, DT.NgayThucHien, DT.NgayKetThuc, DT.KinhPhiDuKien, DT.KetQua, DT.LinkNopBai, DT.TrangThai from DangKyDeTai DK Join DeTai DT ON DK.MaDeTai = DT.MaDeTai Join Nhom nh ON DK.MaNhom = nh.MaNhom WHERE DT.MaDeTai = ?\r\n"
				+ "";

		DeTai dt = new DeTai();
		try (Connection connection = JDBCUtil.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
			preparedStatement.setString(1, MaDeTai);

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				String tenDeTai = rs.getString("TenDeTai");
				LocalDate NgayThucHien = (rs.getDate("NgayThucHien") != null) ? rs.getDate("NgayThucHien").toLocalDate()
						: null;
				LocalDate NgayKetThuc = (rs.getDate("NgayThucHien") != null) ? rs.getDate("NgayKetThuc").toLocalDate()
						: null;
				String KinhPhi = rs.getString("KinhPhiDuKien");
				String KetQua = rs.getString("KetQua");
				String LinkNop = rs.getString("LinkNopBai");
				String TrangThai = rs.getString("TrangThai");
				String TenNhom = rs.getString("TenNhom");
				dt = new DeTai(MaDeTai, tenDeTai, "", NgayThucHien, NgayKetThuc, KinhPhi, KetQua, TrangThai, LinkNop,
						TenNhom, null);
			}
		} catch (SQLException e) {
			// process sql exception
			HandleException.printSQLException(e);
		}
		return dt;

	}

	public String GuiDonGiaHan(GV_DonGiaHan dgh) {
		String SHOW_TT = "CALL XinGiaHan (?, ?, ?, ?, ?)";
		String err = "";

		try (Connection connection = JDBCUtil.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {
			preparedStatement.setString(1, dgh.getNgayGiaHan().toString());
			preparedStatement.setString(2, dgh.getNgayKetThuc().toString());
			preparedStatement.setString(3, dgh.getLinkDonXin());
			preparedStatement.setString(4, dgh.getLyDoXin());
			preparedStatement.setString(5, dgh.getMaDT());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			err = e.getMessage();
			HandleException.printSQLException(e);
		}
		return err;

	}

	public String NopDT(String MaDT, String LinkNop) {
		String SHOW_TT = "CALL Nop(?, ?);";
		String err = "";

		try (Connection connection = JDBCUtil.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TT)) {

			preparedStatement.setString(1, MaDT);
			preparedStatement.setString(2, LinkNop);

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			err = e.getMessage();
			HandleException.printSQLException(e);
		}
		return err;

	}

}
