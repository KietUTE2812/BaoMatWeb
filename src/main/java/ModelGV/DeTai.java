package ModelGV;

import java.time.LocalDate;

public class DeTai {

	private String MaDT;
	private String TenDeTai;
	private String GhiChu;
	private LocalDate NgayThucHien;
	private LocalDate NgayKetThuc;
	private String KinhPhiDuKien;
	private String KetQua;
	private String TrangThai;
	private String linknop;
	private String Nhom;
	private LocalDate NgayNop;
	public LocalDate getNgayNop() {
		return NgayNop;
	}



	public void setNgayNop(LocalDate ngayNop) {
		NgayNop = ngayNop;
	}



	public DeTai() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getNhom() {
		return Nhom;
	}



	public void setNhom(String nhom) {
		Nhom = nhom;
	}



	public DeTai(String maDT, String tenDeTai, String ghiChu, LocalDate ngayThucHien, LocalDate ngayKetThuc,
			String kinhPhiDuKien, String ketQua, String trangThai, String linknop, String nhom, LocalDate NgayNop) {
		super();
		MaDT = maDT;
		TenDeTai = tenDeTai;
		GhiChu = ghiChu;
		NgayThucHien = ngayThucHien;
		NgayKetThuc = ngayKetThuc;
		KinhPhiDuKien = kinhPhiDuKien;
		KetQua = ketQua;
		TrangThai = trangThai;
		this.linknop = linknop;
		this.Nhom = nhom;
		this.NgayNop = NgayNop;
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



	public String getKetQua() {
		return KetQua;
	}



	public void setKetQua(String ketQua) {
		KetQua = ketQua;
	}



	public String getLinknop() {
		return linknop;
	}



	public void setLinknop(String linknop) {
		this.linknop = linknop;
	}



	public DeTai(String maDT, String tenDeTai, String ghiChu, String kinhPhiDuKien, String trangThai) {
		super();
		MaDT = maDT;
		TenDeTai = tenDeTai;
		GhiChu = ghiChu;
		KinhPhiDuKien = kinhPhiDuKien;
		TrangThai = trangThai;
	}

	public String getMaDT() {
		return MaDT;
	}

	public void setMaDT(String maDT) {
		MaDT = maDT;
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

	public String getKinhPhiDuKien() {
		return KinhPhiDuKien;
	}

	public void setKinhPhiDuKien(String kinhPhiDuKien) {
		KinhPhiDuKien = kinhPhiDuKien;
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}

}
