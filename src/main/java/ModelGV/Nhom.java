package ModelGV;

public class Nhom {
	
	private String MaNhom;
	private String TenNhom;
	private String MaGV;
	
	public Nhom() {
		// TODO Auto-generated constructor stub
	}
	
	public Nhom(String maNhom, String tenNhom, String maGV) {
		super();
		MaNhom = maNhom;
		TenNhom = tenNhom;
		MaGV = maGV;
	}

	public String getMaNhom() {
		return MaNhom;
	}

	public void setMaNhom(String maNhom) {
		MaNhom = maNhom;
	}

	public String getTenNhom() {
		return TenNhom;
	}

	public void setTenNhom(String tenNhom) {
		TenNhom = tenNhom;
	}

	public String getMaGV() {
		return MaGV;
	}

	public void setMaGV(String maGV) {
		MaGV = maGV;
	}
	

}
