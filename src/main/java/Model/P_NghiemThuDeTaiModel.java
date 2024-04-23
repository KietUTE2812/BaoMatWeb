package Model;

import java.time.LocalDate;

public class P_NghiemThuDeTaiModel {
	private String maBienBan;
    private double diem;
    private String danhGia;
    private String minhChung;
    private LocalDate ngayNghiemThu;
    private String maDeTai;
    private String maPQL;
    
    
	public P_NghiemThuDeTaiModel(String maDeTai) {
		super();
		this.maDeTai = maDeTai;
	}
	public P_NghiemThuDeTaiModel() {
		super();
	}
	public P_NghiemThuDeTaiModel(String maBienBan, double diem, String danhGia, String minhChung,
			LocalDate ngayNghiemThu, String maDeTai, String maPQL) {
		super();
		this.maBienBan = maBienBan;
		this.diem = diem;
		this.danhGia = danhGia;
		this.minhChung = minhChung;
		this.ngayNghiemThu = ngayNghiemThu;
		this.maDeTai = maDeTai;
		this.maPQL = maPQL;
	}
	public String getMaBienBan() {
		return maBienBan;
	}
	public void setMaBienBan(String maBienBan) {
		this.maBienBan = maBienBan;
	}
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
	public String getDanhGia() {
		return danhGia;
	}
	public void setDanhGia(String danhGia) {
		this.danhGia = danhGia;
	}
	public String getMinhChung() {
		return minhChung;
	}
	public void setMinhChung(String minhChung) {
		this.minhChung = minhChung;
	}
	public LocalDate getNgayNghiemThu() {
		return ngayNghiemThu;
	}
	public void setNgayNghiemThu(LocalDate ngayNghiemThu) {
		this.ngayNghiemThu = ngayNghiemThu;
	}
	public String getMaDeTai() {
		return maDeTai;
	}
	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
	}
	public String getMaPQL() {
		return maPQL;
	}
	public void setMaPQL(String maPQL) {
		this.maPQL = maPQL;
	}
    
    
}
