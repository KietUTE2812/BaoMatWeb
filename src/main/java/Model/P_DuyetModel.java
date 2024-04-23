package Model;

import java.time.LocalDate;

public class P_DuyetModel {
	private String maDon;
    private LocalDate ngayGiaHan;
    private LocalDate ngayHoanThanh;
    private String linkDonXin;
    private String lyDo;
    private String trangThai;
    private String maDeTai;
    private String maGV;
    private String maPQL;
    private String lyDoHuy;
    
  
	private LocalDate ngayDangKy;
    private String ghiChu;
    private String maNhom;
    
    
    //time
    private String maDot;
    private String trangThaiDot;
    private LocalDate ngaymodk;
    private LocalDate ngaydongdk;
    private LocalDate ngaymoth;
    private LocalDate ngaydongth;
    private LocalDate ngaymobc;
    private LocalDate ngaydongbc;
    private LocalDate ngaymont;
    private LocalDate ngaydongnt;
    private LocalDate ngaydongdot;
 
    
    
    public P_DuyetModel(String maDot, String trangThaiDot, LocalDate ngaymodk, LocalDate ngaydongdk, LocalDate ngaymoth,
			LocalDate ngaydongth, LocalDate ngaymobc, LocalDate ngaydongbc, LocalDate ngaymont, LocalDate ngaydongnt,
			LocalDate ngaydongdot) {
		super();
		this.maDot = maDot;
		this.trangThaiDot = trangThaiDot;
		this.ngaymodk = ngaymodk;
		this.ngaydongdk = ngaydongdk;
		this.ngaymoth = ngaymoth;
		this.ngaydongth = ngaydongth;
		this.ngaymobc = ngaymobc;
		this.ngaydongbc = ngaydongbc;
		this.ngaymont = ngaymont;
		this.ngaydongnt = ngaydongnt;
		this.ngaydongdot = ngaydongdot;
	}
	public String getMaDot() {
		return maDot;
	}
	public void setMaDot(String maDot) {
		this.maDot = maDot;
	}
	public String getTrangThaiDot() {
		return trangThaiDot;
	}
	public void setTrangThaiDot(String trangThaiDot) {
		this.trangThaiDot = trangThaiDot;
	}
	public LocalDate getNgaymodk() {
		return ngaymodk;
	}
	public void setNgaymodk(LocalDate ngaymodk) {
		this.ngaymodk = ngaymodk;
	}
	public LocalDate getNgaydongdk() {
		return ngaydongdk;
	}
	public void setNgaydongdk(LocalDate ngaydongdk) {
		this.ngaydongdk = ngaydongdk;
	}
	public LocalDate getNgaymoth() {
		return ngaymoth;
	}
	public void setNgaymoth(LocalDate ngaymoth) {
		this.ngaymoth = ngaymoth;
	}
	public LocalDate getNgaydongth() {
		return ngaydongth;
	}
	public void setNgaydongth(LocalDate ngaydongth) {
		this.ngaydongth = ngaydongth;
	}
	public LocalDate getNgaymobc() {
		return ngaymobc;
	}
	public void setNgaymobc(LocalDate ngaymobc) {
		this.ngaymobc = ngaymobc;
	}
	public LocalDate getNgaydongbc() {
		return ngaydongbc;
	}
	public void setNgaydongbc(LocalDate ngaydongbc) {
		this.ngaydongbc = ngaydongbc;
	}
	public LocalDate getNgaymont() {
		return ngaymont;
	}
	public void setNgaymont(LocalDate ngaymont) {
		this.ngaymont = ngaymont;
	}
	public LocalDate getNgaydongnt() {
		return ngaydongnt;
	}
	public void setNgaydongnt(LocalDate ngaydongnt) {
		this.ngaydongnt = ngaydongnt;
	}
	public LocalDate getNgaydongdot() {
		return ngaydongdot;
	}
	public void setNgaydongdot(LocalDate ngaydongdot) {
		this.ngaydongdot = ngaydongdot;
	}
	public String getLyDoHuy() {
    	return lyDoHuy;
    }
    public void setLyDoHuy(String lyDoHuy) {
    	this.lyDoHuy = lyDoHuy;
    }
    
    
	public P_DuyetModel(String maGV, String maDeTai,  LocalDate ngayDangKy, String ghiChu,String trangThai,
			String maNhom) {
		super();
		this.trangThai = trangThai;
		this.maDeTai = maDeTai;
		this.maGV = maGV;
		this.ngayDangKy = ngayDangKy;
		this.ghiChu = ghiChu;
		this.maNhom = maNhom;
	}
	public LocalDate getNgayDangKy() {
		return ngayDangKy;
	}
	public void setNgayDangKy(LocalDate ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getMaNhom() {
		return maNhom;
	}
	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}
	public P_DuyetModel(String maDon, LocalDate ngayGiaHan, LocalDate ngayHoanThanh, String linkDonXin, String lyDo, String lyDoHuy,
			String trangThai, String maDeTai, String maGV, String maPQL) {
		super();
		this.maDon = maDon;
		this.ngayGiaHan = ngayGiaHan;
		this.ngayHoanThanh = ngayHoanThanh;
		this.linkDonXin = linkDonXin;
		this.lyDo = lyDo;
		this.lyDoHuy = lyDoHuy;
		this.trangThai = trangThai;
		this.maDeTai = maDeTai;
		this.maGV = maGV;
		this.maPQL = maPQL;
	}
	public P_DuyetModel() {
		super();
	}
	public String getMaDon() {
		return maDon;
	}
	public void setMaDon(String maDon) {
		this.maDon = maDon;
	}
	public LocalDate getNgayGiaHan() {
		return ngayGiaHan;
	}
	public void setNgayGiaHan(LocalDate ngayGiaHan) {
		this.ngayGiaHan = ngayGiaHan;
	}
	public LocalDate getNgayHoanThanh() {
		return ngayHoanThanh;
	}
	public void setNgayHoanThanh(LocalDate ngayHoanThanh) {
		this.ngayHoanThanh = ngayHoanThanh;
	}
	public String getLinkDonXin() {
		return linkDonXin;
	}
	public void setLinkDonXin(String linkDonXin) {
		this.linkDonXin = linkDonXin;
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
	public String getMaDeTai() {
		return maDeTai;
	}
	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
	}
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public String getMaPQL() {
		return maPQL;
	}
	public void setMaPQL(String maPQL) {
		this.maPQL = maPQL;
	}
}
