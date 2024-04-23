package ModelGV;

import java.time.LocalDate;

public class ThongBao {
	
	private String TieuDe;
	private LocalDate NgayGui;
	private String NoiDung;
	private String NguoiGui;
	
	public ThongBao() {
		// TODO Auto-generated constructor stub
	}
	
	public ThongBao(String tieuDe, LocalDate ngayGui, String noiDung, String nguoiGui) {
		super();
		TieuDe = tieuDe;
		NgayGui = ngayGui;
		NoiDung = noiDung;
		NguoiGui = nguoiGui;
	}

	public String getTieuDe() {
		return TieuDe;
	}

	public void setTieuDe(String tieuDe) {
		TieuDe = tieuDe;
	}

	public LocalDate getNgayGui() {
		return NgayGui;
	}

	public void setNgayGui(LocalDate ngayGui) {
		NgayGui = ngayGui;
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
	
	

}
