package Admin_Model;

import java.time.LocalDate;

public class AD_Admin {
    private String MaAdmin;
    private String HoTen;
    private String Email;
    private LocalDate NgaySinh;
    private String Imagead;
    private String MaTK;

    // Constructor
    public AD_Admin(String maAdmin, String hoTen, String email, LocalDate ngaySinh, String imagead, String maTK)
   {
        this.MaAdmin = maAdmin;
        this.HoTen = hoTen;
        this.Email = email;
        this.NgaySinh = ngaySinh;
        this.Imagead = imagead;
        this.MaTK = maTK;
    }

    public AD_Admin( String hoTen, String email, LocalDate ngaySinh, String imagead, String maTK)
    {
         this.HoTen = hoTen;
         this.Email = email;
         this.NgaySinh = ngaySinh;
         this.Imagead = imagead;
         this.MaTK = maTK;
     }
    // Getter và Setter cho MaAdmin
    public String getMaAdmin() {
        return MaAdmin;
    }

    public void setMaAdmin(String maAdmin) {
        MaAdmin = maAdmin;
    }

    // Getter và Setter cho HoTen
    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    // Getter và Setter cho Email
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    // Getter và Setter cho NgaySinh
    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        NgaySinh = ngaySinh;
    }

    // Getter và Setter cho Imagead
    public String getImagead() {
        return Imagead;
    }

    public void setImagead(String imagead) {
        Imagead = imagead;
    }

    // Getter và Setter cho MaTK
    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String maTK) {
        MaTK = maTK;
    }

    // Các phương thức khác nếu cần
}
