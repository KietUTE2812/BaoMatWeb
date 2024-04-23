package Admin_Model;

import java.time.LocalDate;


public class AD_ThongBao {
	private String TieuDe;
	private String NoiDung;
	private String NguoiGui;

	private LocalDate NgayGui;
	
	private String MaGV;
	private String TenGV;

	
	private String NguoiNhan;
    private String TieuDeGui;
    private String NoiDungGui;

    private String magvall;
	private String emailgvall;
	
    
	

	public AD_ThongBao(String magvall) {
		super();
		this.magvall = magvall;
	}

	public String getMagvall() {
		return magvall;
	}

	public void setMagvall(String magvall) {
		this.magvall = magvall;
	}

	public String getEmailgvall() {
		return emailgvall;
	}

	public void setEmailgvall(String emailgvall) {
		this.emailgvall = emailgvall;
	}

	public AD_ThongBao(String nguoiNhan, String tieuDeGui, String noiDungGui, String nguoiGui) {
		super();
		NguoiNhan = nguoiNhan;
		TieuDeGui = tieuDeGui;
		NoiDungGui = noiDungGui;
		NguoiGui = nguoiGui;
	}

	public String getNguoiNhan() {
		return NguoiNhan;
	}

	public void setNguoiNhan(String nguoiNhan) {
		NguoiNhan = nguoiNhan;
	}

	public String getTieuDeGui() {
		return TieuDeGui;
	}

	public void setTieuDeGui(String tieuDeGui) {
		TieuDeGui = tieuDeGui;
	}

	public String getNoiDungGui() {
		return NoiDungGui;
	}

	public void setNoiDungGui(String noiDungGui) {
		NoiDungGui = noiDungGui;
	}

	public AD_ThongBao(String maGV, String tenGV) {
		super();
		MaGV = maGV;
		TenGV = tenGV;
	}

	public String getMaGV() {
		return MaGV;
	}

	public void setMaGV(String maGV) {
		MaGV = maGV;
	}

	public String getTenGV() {
		return TenGV;
	}

	public void setTenGV(String tenGV) {
		TenGV = tenGV;
	}

	public String getTieuDe() {
		return TieuDe;
	}

	public void setTieuDe(String tieuDe) {
		TieuDe = tieuDe;
	}

	public String getNoiDung() {
		return NoiDung;
	}

	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}

	public String getNguoiGui() {
		return NguoiGui;
	}

	public void setNguoiGui(String nguoiGui) {
		NguoiGui = nguoiGui;
	}

	public LocalDate getNgayGui() {
		return NgayGui;
	}

	public void setNgayGui(LocalDate ngayGui) {
		NgayGui = ngayGui;
	}

	public AD_ThongBao(String tieuDe, String noiDung, String nguoiGui, LocalDate ngayGui) {
		super();
		TieuDe = tieuDe;
		NoiDung = noiDung;
		NguoiGui = nguoiGui;
		NgayGui = ngayGui;
	}

	public AD_ThongBao() {
		super();
	}
	
	@Override
    public String toString() {
        return "P_ThongBaoModel [nguoiNhan=" + NguoiNhan + ", tieuDe=" + TieuDeGui + ", noiDung=" + NoiDungGui + "]";
    }


}
