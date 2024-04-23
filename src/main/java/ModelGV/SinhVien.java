package ModelGV;

import java.time.LocalDate;

public class SinhVien {
	
	private String MaSV;
	private String MSSV;
	private String HoTen;
	private LocalDate NgaySinh;
	private String Email;
	private String CCCD;
	private String SDT;
	private String Lop;
	private String NienKhoa;
	private String DiaChi;
	private String MaNhom;
	private String MaNganh;
	
	
	public SinhVien(String maSV, String mSSV, String hoTen, LocalDate ngaySinh, String email, String cCCD, String sDT,
			String lop, String nienKhoa, String diaChi, String maNhom, String maNganh) {
		super();
		MaSV = maSV;
		MSSV = mSSV;
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		Email = email;
		CCCD = cCCD;
		SDT = sDT;
		Lop = lop;
		NienKhoa = nienKhoa;
		DiaChi = diaChi;
		MaNhom = maNhom;
		MaNganh = maNganh;
	}


	public SinhVien() {
		// TODO Auto-generated constructor stub
	}


	public String getMaSV() {
		return MaSV;
	}


	public void setMaSV(String maSV) {
		MaSV = maSV;
	}


	public String getMSSV() {
		return MSSV;
	}


	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}


	public String getHoTen() {
		return HoTen;
	}


	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}


	public LocalDate getNgaySinh() {
		return NgaySinh;
	}


	public void setNgaySinh(LocalDate ngaySinh) {
		NgaySinh = ngaySinh;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getCCCD() {
		return CCCD;
	}


	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}


	public String getSDT() {
		return SDT;
	}


	public void setSDT(String sDT) {
		SDT = sDT;
	}


	public String getLop() {
		return Lop;
	}


	public void setLop(String lop) {
		Lop = lop;
	}


	public String getNienKhoa() {
		return NienKhoa;
	}


	public void setNienKhoa(String nienKhoa) {
		NienKhoa = nienKhoa;
	}


	public String getDiaChi() {
		return DiaChi;
	}


	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}


	public String getMaNhom() {
		return MaNhom;
	}


	public void setMaNhom(String maNhom) {
		MaNhom = maNhom;
	}


	public String getMaNganh() {
		return MaNganh;
	}


	public void setMaNganh(String maNganh) {
		MaNganh = maNganh;
	}
	

}
