package Model;

import java.time.LocalDate;

public class P_ThongKeModel {
	private String maDot;
	private LocalDate ngayMoDangKy;
	private LocalDate ngayDongDot;
	
	
	private String MaDetai;
	private String TenDeTai;
	private String GhiChu;
	private LocalDate NgayThucHien;
	private LocalDate NgayKetThuc;
	private double KinhPhiDuKien;
	private String KetQua;
	private String TrangThai;
	private String LinkNopBai;
	private LocalDate NgayNop;
	
	
	
	
	public P_ThongKeModel(LocalDate ngayMoDangKy, LocalDate ngayDongDot) {
		super();
		this.ngayMoDangKy = ngayMoDangKy;
		this.ngayDongDot = ngayDongDot;
	}
	public P_ThongKeModel(String maDetai, String tenDeTai, String ghiChu, LocalDate ngayThucHien, LocalDate ngayKetThuc,
			double kinhPhiDuKien, String ketQua, String trangThai, String linkNopBai, LocalDate ngayNop) {
		super();
		MaDetai = maDetai;
		TenDeTai = tenDeTai;
		GhiChu = ghiChu;
		NgayThucHien = ngayThucHien;
		NgayKetThuc = ngayKetThuc;
		KinhPhiDuKien = kinhPhiDuKien;
		KetQua = ketQua;
		TrangThai = trangThai;
		LinkNopBai = linkNopBai;
		NgayNop = ngayNop;
	}
	public P_ThongKeModel(String maDot) {
		super();
		this.maDot = maDot;
	}
	public P_ThongKeModel() {
		super();
	}
	public String getMaDot() {
		return maDot;
	}
	public void setMaDot(String maDot) {
		this.maDot = maDot;
	}
	public LocalDate getNgayMoDangKy() {
		return ngayMoDangKy;
	}
	public void setNgayMoDangKy(LocalDate ngayMoDangKy) {
		this.ngayMoDangKy = ngayMoDangKy;
	}
	public LocalDate getNgayDongDot() {
		return ngayDongDot;
	}
	public void setNgayDongDot(LocalDate ngayDongDot) {
		this.ngayDongDot = ngayDongDot;
	}
	public String getMaDetai() {
		return MaDetai;
	}
	public void setMaDetai(String maDetai) {
		MaDetai = maDetai;
	}
	public String getTenDeTai() {
		return TenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		TenDeTai = tenDeTai;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public LocalDate getNgayThucHien() {
		return NgayThucHien;
	}
	public void setNgayThucHien(LocalDate ngayThucHien) {
		NgayThucHien = ngayThucHien;
	}
	public LocalDate getNgayKetThuc() {
		return NgayKetThuc;
	}
	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}
	public double getKinhPhiDuKien() {
		return KinhPhiDuKien;
	}
	public void setKinhPhiDuKien(double kinhPhiDuKien) {
		KinhPhiDuKien = kinhPhiDuKien;
	}
	public String getKetQua() {
		return KetQua;
	}
	public void setKetQua(String ketQua) {
		KetQua = ketQua;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	public String getLinkNopBai() {
		return LinkNopBai;
	}
	public void setLinkNopBai(String linkNopBai) {
		LinkNopBai = linkNopBai;
	}
	public LocalDate getNgayNop() {
		return NgayNop;
	}
	public void setNgayNop(LocalDate ngayNop) {
		NgayNop = ngayNop;
	}
	
	
}
