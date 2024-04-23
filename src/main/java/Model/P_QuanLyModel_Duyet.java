package Model;

import java.time.LocalDate;

public class P_QuanLyModel_Duyet {
	private String maGV;
	private String maPhongQL;
	private String tenDeTai;
	private String moTa;
	private double kinhPhi;
	private String lyDo;
	private String trangThai;
	private LocalDate ngayThucHien;
	private String linkdinhkem;
	
	
	
	public String getLinkdinhkem() {
		return linkdinhkem;
	}
	public void setLinkdinhkem(String linkdinhkem) {
		this.linkdinhkem = linkdinhkem;
	}
	public P_QuanLyModel_Duyet(String maGV, String maPhongQL, String tenDeTai, String moTa, double kinhPhi, String lyDo,
			String trangThai, LocalDate ngayThucHien, String linkdinhkem) {
		super();
		this.maGV = maGV;
		this.maPhongQL = maPhongQL;
		this.tenDeTai = tenDeTai;
		this.moTa = moTa;
		this.kinhPhi = kinhPhi;
		this.lyDo = lyDo;
		this.trangThai = trangThai;
		this.ngayThucHien = ngayThucHien;
		this.linkdinhkem = linkdinhkem;
	}
	public P_QuanLyModel_Duyet() {
		super();
	}
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public String getMaPhongQL() {
		return maPhongQL;
	}
	public void setMaPhongQL(String maPhongQL) {
		this.maPhongQL = maPhongQL;
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public double getKinhPhi() {
		return kinhPhi;
	}
	public void setKinhPhi(double kinhPhi) {
		this.kinhPhi = kinhPhi;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public LocalDate getNgayThucHien() {
		return ngayThucHien;
	}
	public void setNgayThucHien(LocalDate ngayThucHien) {
		this.ngayThucHien = ngayThucHien;
	}

}
