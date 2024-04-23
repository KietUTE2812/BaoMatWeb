package ModelGV;

public class Khoa {
	
	private String MaKhoa;
	private String TenKhoa;
	
	public Khoa() {
		// TODO Auto-generated constructor stub
	}

	public String getMaKhoa() {
		return MaKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		MaKhoa = maKhoa;
	}

	public String getTenKhoa() {
		return TenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		TenKhoa = tenKhoa;
	}

	public Khoa(String maKhoa, String tenKhoa) {
		super();
		MaKhoa = maKhoa;
		TenKhoa = tenKhoa;
	}
	

}
