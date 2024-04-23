package ModelGV;

public class taikhoangv {
	
	private String Hoten;
	private String MaGV;
	private String GTinh;
	private String Email;
	private String TrinhDo;
	private String Khoa;
	
	
	public taikhoangv(String hoten, String maGV, String gTinh, String email, String trinhDo, String khoa) {
		super();
		Hoten = hoten;
		MaGV = maGV;
		GTinh = gTinh;
		Email = email;
		TrinhDo = trinhDo;
		Khoa = khoa;
	}
	public taikhoangv(String hoten, String gTinh, String email, String trinhDo) {
		super();
		Hoten = hoten;

		GTinh = gTinh;
		Email = email;
		TrinhDo = trinhDo;
		
	}
	public taikhoangv() {
		super();
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public String getMaGV() {
		return MaGV;
	}
	public void setMaGV(String maGV) {
		MaGV = maGV;
	}
	public String getGTinh() {
		return GTinh;
	}
	public void setGTinh(String gTinh) {
		GTinh = gTinh;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTrinhDo() {
		return TrinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		TrinhDo = trinhDo;
	}
	public String getKhoa() {
		return Khoa;
	}
	public void setKhoa(String khoa) {
		Khoa = khoa;
	}
	

}
