package DAOGV;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ModelGV.SinhVien;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import Util.JDBCUtil;

public class ImportTVDao {

	public ImportTVDao() {
		// TODO Auto-generated constructor stub
	}
	private static final String INSERT_SINHVIEN_IMPORT_TEMP = "CALL InsertSinhVienTemp (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String INSERT_SINHVIEN_IMPORT = "CALL InsertSinhVien (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			

	private static final String DELETE_SINHVIEN_IMPORT_TEMP = "delete from SinhVienTemp;";
	public List<SinhVien> importFile(HttpServletRequest request, InputStream inputStream) {
		List<SinhVien> svs = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection()) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SINHVIEN_IMPORT_TEMP)) {
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			// Use XSSFWorkbook for .xlsx files and HSSFWorkbook for .xls files
			Workbook workbook;
			if (request.getPart("file").getContentType().equals("application/vnd.ms-excel")) {
				workbook = new HSSFWorkbook(inputStream);
			} else if (request.getPart("file").getContentType()
					.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
				workbook = new XSSFWorkbook(inputStream);
			} else {
				throw new ServletException("Invalid file type");
			}

			Sheet sheet = workbook.getSheetAt(0);
			int i = 1;
			Row row = sheet.getRow(i);
			if (row != null)
				try {
					{
						while (row.getCell(0) != null) {

							SinhVien sv = new SinhVien();
							
							sv.setMSSV(row.getCell(0).getStringCellValue()); 

							Date ngaySinhDate = row.getCell(2).getDateCellValue();
							Instant instant = ngaySinhDate.toInstant();
							LocalDate ngaySinhLocalDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
							sv.setNgaySinh(ngaySinhLocalDate);

							sv.setHoTen(row.getCell(1).getStringCellValue());
							sv.setEmail(row.getCell(3).getStringCellValue());
							
							sv.setCCCD(row.getCell(4).getStringCellValue());
							
							sv.setSDT(row.getCell(5).getStringCellValue());
							
							sv.setNienKhoa(String.valueOf((long) row.getCell(6).getNumericCellValue()));
							 
							 
							
							sv.setDiaChi(row.getCell(7).getStringCellValue());
							sv.setMaNhom(row.getCell(8).getStringCellValue());
							sv.setMaNganh(row.getCell(9).getStringCellValue());
							svs.add(sv);
							System.out.println(sv.getHoTen());		
							InsertExcelToDBTemp(sv);

							i = i + 1;
							row = sheet.getRow(i);
						}
						workbook.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			

		} catch (IOException | ServletException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return svs;
	}
	public void InsertExcelToDBTemp(SinhVien sv) {
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SINHVIEN_IMPORT_TEMP)) {
			preparedStatement.setString(1, sv.getMSSV());
			java.sql.Date ngaysinhDate = java.sql.Date.valueOf(sv.getNgaySinh());
			preparedStatement.setDate(3, ngaysinhDate);
			preparedStatement.setString(2, sv.getHoTen());
			preparedStatement.setString(4, sv.getEmail());
			preparedStatement.setString(5, sv.getCCCD());
			preparedStatement.setString(6, sv.getSDT());
			preparedStatement.setString(7, sv.getNienKhoa());
			preparedStatement.setString(8, sv.getDiaChi());
			preparedStatement.setString(9, sv.getMaNhom());
			preparedStatement.setString(10, sv.getMaNganh());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
	}

	public void InsertExcelToDB(SinhVien sv) {
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SINHVIEN_IMPORT)) {
			preparedStatement.setString(1, sv.getMSSV());
			java.sql.Date ngaysinhDate = java.sql.Date.valueOf(sv.getNgaySinh());
			preparedStatement.setDate(3, ngaysinhDate);
			preparedStatement.setString(2, sv.getHoTen());
			preparedStatement.setString(4, sv.getEmail());
			preparedStatement.setString(5, sv.getCCCD());
			preparedStatement.setString(6, sv.getSDT());
			preparedStatement.setString(7, sv.getNienKhoa());
			preparedStatement.setString(8, sv.getDiaChi());
			preparedStatement.setString(9, sv.getMaNhom());
			preparedStatement.setString(10, sv.getMaNganh());
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
	}

}
