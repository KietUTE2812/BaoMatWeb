package ModelGV;

import java.time.LocalDate;

public class GV_DonGiaHan {

	public GV_DonGiaHan() {
		// TODO Auto-generated constructor stub
	}
	private String MaGV;
	private String MaDon;
	private LocalDate NgayGiaHan;
	private LocalDate NgayKetThuc;
	private String LinkDonXin;
	private String LyDoXin;
	private String MaDT;
	
	
	
	public GV_DonGiaHan(String maGV, String maDon, LocalDate ngayGiaHan, LocalDate ngayKetThuc, String linkDonXin,
			String lyDoXin, String maDT) {
		super();
		MaGV = maGV;
		MaDon = maDon;
		NgayGiaHan = ngayGiaHan;
		NgayKetThuc = ngayKetThuc;
		LinkDonXin = linkDonXin;
		LyDoXin = lyDoXin;
		MaDT = maDT;
	}
	public String getMaGV() {
		return MaGV;
	}
	public void setMaGV(String maGV) {
		MaGV = maGV;
	}
	public String getMaDon() {
		return MaDon;
	}
	public void setMaDon(String maDon) {
		MaDon = maDon;
	}
	public LocalDate getNgayGiaHan() {
		return NgayGiaHan;
	}
	public void setNgayGiaHan(LocalDate ngayGiaHan) {
		NgayGiaHan = ngayGiaHan;
	}
	public LocalDate getNgayKetThuc() {
		return NgayKetThuc;
	}
	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}
	public String getLinkDonXin() {
		return LinkDonXin;
	}
	public void setLinkDonXin(String linkDonXin) {
		LinkDonXin = linkDonXin;
	}
	public String getLyDoXin() {
		return LyDoXin;
	}
	public void setLyDoXin(String lyDoXin) {
		LyDoXin = lyDoXin;
	}
	public String getMaDT() {
		return MaDT;
	}
	public void setMaDT(String maDT) {
		MaDT = maDT;
	}
	
	
}
