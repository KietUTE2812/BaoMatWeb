package ModelGV;

public class ChangPass {
	
	private String Pass;
	private String Npass;
	private String Cpass;
	private String MaGV;
	
	public ChangPass() {
		// TODO Auto-generated constructor stub
	}
	
	public ChangPass(String pass, String npass, String cpass, String maGV) {
		super();
		Pass = pass;
		Npass = npass;
		Cpass = cpass;
		MaGV = maGV;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getNpass() {
		return Npass;
	}

	public void setNpass(String npass) {
		Npass = npass;
	}

	public String getCpass() {
		return Cpass;
	}

	public void setCpass(String cpass) {
		Cpass = cpass;
	}

	public String getMaGV() {
		return MaGV;
	}

	public void setMaGV(String maGV) {
		MaGV = maGV;
	}
	

}
