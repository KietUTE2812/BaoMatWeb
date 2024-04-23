package Admin_Model;

public class AD_TaiKhoan {
	private String maTK;
    private String username;
    private String password;
    private String role;
    private String trangthai;
    private String maPQl;
    private String nguoiDaiDien;
    private String SDT;
    private String Email;
    private String DiaChi;
    
    private String emailgvall;
    
	public AD_TaiKhoan(String emailgvall) {
		super();
		this.emailgvall = emailgvall;
	}
	public String getEmailgvall() {
		return emailgvall;
	}
	public void setEmailgvall(String emailgvall) {
		this.emailgvall = emailgvall;
	}
	public String getMaTK() {
		return maTK;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getMaPQl() {
		return maPQl;
	}
	public void setMaPQl(String maPQl) {
		this.maPQl = maPQl;
	}
	public String getNguoiDaiDien() {
		return nguoiDaiDien;
	}
	public void setNguoiDaiDien(String nguoiDaiDien) {
		this.nguoiDaiDien = nguoiDaiDien;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		this.SDT = sDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		this.DiaChi = diaChi;
	}
	public AD_TaiKhoan(String maTK, String username, String password, String role, String trangthai, String maPQl,
			String nguoiDaiDien, String sDT, String email, String diaChi) {
		super();
		this.maTK = maTK;
		this.username = username;
		this.password = password;
		this.role = role;
		this.trangthai = trangthai;
		this.maPQl = maPQl;
		this.nguoiDaiDien = nguoiDaiDien;
		this.SDT = sDT;
		this.Email = email;
		this.DiaChi = diaChi;
	}
	public AD_TaiKhoan() {
		super();
	}
  
    

}
