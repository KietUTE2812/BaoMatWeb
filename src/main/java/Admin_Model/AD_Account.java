package Admin_Model;

public class AD_Account {
    private String MaTK; // Thêm thuộc tính MaTK
    private String username;
    private String password;
    private String role;
    private int Status;

    public AD_Account() {
        super();
    }
   

    public AD_Account( String username, String password, String role,String MaTK) {
        super();
        this.MaTK = MaTK;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public AD_Account(int status, String maTK) {
    	MaTK=maTK;
    	Status=status;
    }
    
    

    // Getter và Setter cho MaTK
    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    // Getter và Setter cho username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter và Setter cho password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter và Setter cho role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        this.Status = status;
    }
}
