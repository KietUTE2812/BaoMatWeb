package Model;

import java.time.LocalDate;

public class P_QuanLyModel {
	private String MaDetai;
	private String TenDeTai;
	private String GhiChu;
	private String KetQua;
	private String TrangThai;
	private String LinkNopBai;

	public P_QuanLyModel(String maDetai, String tenDeTai, String ghiChu, double kinhPhiDuKien) {
		super();
		MaDetai = maDetai;
		TenDeTai = tenDeTai;
		GhiChu = ghiChu;
		KinhPhiDuKien = kinhPhiDuKien;
	}

	private LocalDate NgayThucHien;
	private LocalDate NgayKetThuc;
	private double KinhPhiDuKien;
	private LocalDate NgayNop;

	public LocalDate getNgayNop() {
		return NgayNop;
	}



	public void setNgayNop(LocalDate ngayNop) {
		NgayNop = ngayNop;
	}



	public P_QuanLyModel(String maDetai, String tenDeTai, String ghiChu, String ketQua, String trangThai,
			String linkNopBai, LocalDate ngayThucHien, LocalDate ngayKetThuc, double kinhPhiDuKien, LocalDate ngayNop) {
		super();
		MaDetai = maDetai;
		TenDeTai = tenDeTai;
		GhiChu = ghiChu;
		KetQua = ketQua;
		TrangThai = trangThai;
		LinkNopBai = linkNopBai;
		NgayThucHien = ngayThucHien;
		NgayKetThuc = ngayKetThuc;
		KinhPhiDuKien = kinhPhiDuKien;
		NgayNop = ngayNop;
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
}
