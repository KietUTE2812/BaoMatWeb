package ModelGV;

public class Nganh {
	
	private String MaNganh;
	private String TenNganh;
	private String MaKhoa;
	
	
	public Nganh(String maNganh, String tenNganh, String maKhoa) {
		super();
		MaNganh = maNganh;
		TenNganh = tenNganh;
		MaKhoa = maKhoa;
	}


	public String getMaNganh() {
		return MaNganh;
	}


	public void setMaNganh(String maNganh) {
		MaNganh = maNganh;
	}


	public String getTenNganh() {
		return TenNganh;
	}


	public void setTenNganh(String tenNganh) {
		TenNganh = tenNganh;
	}


	public String getMaKhoa() {
		return MaKhoa;
	}


	public void setMaKhoa(String maKhoa) {
		MaKhoa = maKhoa;
	}


	public Nganh() {
		// TODO Auto-generated constructor stub
	}

}
