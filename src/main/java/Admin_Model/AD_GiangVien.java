package Admin_Model;

public class AD_GiangVien {
    private String MaGV;
    private String HoTen;
    private String Email;
    private String TrinhDo;
    private String MaKhoa;
    private String MaTK;
    private String GioiTinh;
    private String Image;
    private int Visible;
    public AD_GiangVien() {
        super();
    }

    public AD_GiangVien(String maGV, String hoTen, String email, String trinhDo, String maKhoa, String maTK, String gioiTinh,String image) 
    {
        super();
        MaGV = maGV;
        HoTen = hoTen;
        Email = email;
        TrinhDo = trinhDo;
        MaKhoa = maKhoa;
        MaTK = maTK;
        GioiTinh = gioiTinh;
        Image =image;
    }
    public AD_GiangVien( String hoTen, String email, String trinhDo, String maKhoa,  String gioiTinh,String image, String maTK) {
        super();
        
        HoTen = hoTen;
        Email = email;
        TrinhDo = trinhDo; 	
        MaKhoa = maKhoa;
        GioiTinh = gioiTinh;
        MaTK = maTK;
        Image=image;
    }
    public AD_GiangVien(int visible, String maTK)
    {
    	MaTK = maTK;
    	Visible=visible;
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String maGV) {
        MaGV = maGV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
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

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        MaKhoa = maKhoa;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String maTK) {
        MaTK = maTK;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }
    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
    
    
    public int getVisible() {
        return Visible;
    }

    public void setVisible(int visible) {
        Visible =visible;
    }
}
