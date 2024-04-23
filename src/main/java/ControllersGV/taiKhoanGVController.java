package ControllersGV;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOGV.DangKyDTDao;
import DAOGV.ImportTVDao;
import DAOGV.QLDTDao;
import DAOGV.QLSVDao;
import DAOGV.ThongBaoDao;
import DAOGV.taiKhoanDao;
import Admin_Model.AD_Account;
import Admin_Model.AD_TaiKhoan;
import ModelGV.DeTai;
import ModelGV.GV_DonGiaHan;
import ModelGV.Khoa;
import ModelGV.Nganh;
import ModelGV.Nhom;
import ModelGV.SinhVien;
import ModelGV.ThongBao;
import ModelGV.Time;
import ModelGV.taikhoangv;

/**
 * Servlet implementation class taiKhoanGV
 */
@WebServlet("/GV/*")
@MultipartConfig(
	    fileSizeThreshold = 0,
	    maxFileSize = 10240,
	    maxRequestSize = 102400
	)
public class taiKhoanGVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private taiKhoanDao tkgv;
	private QLSVDao qlsv;
	private DangKyDTDao dt;
	private String err;
	private QLDTDao qldt;
	private ThongBaoDao thongbao;
	private ImportTVDao imTV;
	AD_Account account = new AD_Account();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public taiKhoanGVController() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void init(ServletConfig config) throws ServletException {
		tkgv = new taiKhoanDao();
		qlsv = new QLSVDao();
		err = null;
		dt = new DangKyDTDao();
		qldt = new QLDTDao();
		thongbao = new ThongBaoDao();
		imTV = new ImportTVDao();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		account = (AD_Account) session.getAttribute("user_login");
		  if (account == null) {
		   request.getRequestDispatcher("/Login.jsp").forward(request, response);
		  }
		String action = request.getPathInfo();
		System.out.println(action + "aaa");
		try {
			switch (action) {
			case "/info":
				infoGV(request, response);
				break;
			case "/cpass":
				cpass(request, response);
				break;
			case "/cinfo":
				cinfo(request, response);
				break;
			case "/list":
				ShowCinfoGV(request, response);
				break;
			case "/qlsv":
				infoNhom(request, response);
				break;
			case "/main":
				Main(request, response);
				break;
			case "/ANhom":
				AddNhom(request, response);
				break;
			case "/AThanhVien":
				AddTV(request, response);
				break;
			case "/showDT":
				ShowDT(request, response);
				break;
			case "/showdk":
				ShowFormDK(request, response);
				break;
			case "/dkdt":
				DKDT(request, response);
				break;
			case "/dxdt":
				DXDT(request, response);
				break;
			case "/qldt":
				ShowDTofGV(request, response);
				break;
			case "/showATV":
				ShowFormThemTV(request, response);
				break;
			case "/showSuaTV":
				ShowFormSuaTV(request, response);
				break;
			case "/ATV":
				ThemTV(request, response);
				break;
			case "/XoaTV":
				XoaTV(request, response);
				break;
			case "/EditTV":
				EditTV(request, response);
				break;
			case "/ShowGiaHan":
				ShowGiaHan(request, response);
				break;
			case "/GiaHan":
				GiaHan(request, response);
				break;
			case "/ShowNop":
				ShowNop(request, response);
				break;
			case "/Nop":
				NopDT(request, response);
				break;
			case "/ShowAllTB":
				ShowALLTB(request, response);
				break;
			case "/ImportTV":
				ImportTV(request, response);
				break;
			case "/ShowTVTemp":
				ShowImportTV(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			request.setAttribute("err", ex);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

	private void infoGV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		taikhoangv gv = null;
		try {
			HttpSession session = request.getSession();

			gv = tkgv.ShowTTTaiKhoan(account.getUsername());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("tkgv", gv);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_TaiKhoan.jsp");
		dispatcher.forward(request, response);
	}

	private void ShowCinfoGV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		taikhoangv gv = null;
		List<Khoa> khoas = new ArrayList<>();
		try {
			khoas = tkgv.ListKhoa();
			HttpSession session = request.getSession();

			gv = tkgv.ShowTTTaiKhoan(account.getUsername());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("tkgv", gv);
		request.setAttribute("khoas", khoas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_ChangeInfo.jsp");
		dispatcher.forward(request, response);
	}

	private void cpass(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String pass = request.getParameter("password");
		String Npass = request.getParameter("Npassword");
		String Cpass = request.getParameter("confirm");
		// String MaGV = request.getParameter("pass");

		try {
			HttpSession session = request.getSession();

			err = tkgv.ChangePass(pass, Npass, Cpass, account.getUsername());
			System.out.println(err);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(err);
		request.setAttribute("error", err);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_ChangePass.jsp");
		dispatcher.forward(request, response);
	}

	private void cinfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String usern = account.getUsername();
		String Hoten = request.getParameter("name");
		String Gtinh = request.getParameter("sex");
		String Email = request.getParameter("email");
		String trinhDo = request.getParameter("trinhdo");
		String Khoa = request.getParameter("khoa");
		taikhoangv infoGv = new taikhoangv(Hoten, Gtinh, Email, trinhDo);

		try {

			err = tkgv.ChangeInfo(usern, infoGv, Khoa);
			List<Khoa> khoas = tkgv.ListKhoa();
			request.setAttribute("khoas", khoas);
			System.out.println(err);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(err);
		request.setAttribute("error", err);
		RequestDispatcher dispatcher = request.getRequestDispatcher("info");
		dispatcher.forward(request, response);
	}

	private void infoNhom(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Nhom> nhs = new ArrayList<>();
		HttpSession session = request.getSession();

		nhs = qlsv.ShowTTNhom(account.getUsername());
		request.setAttribute("nhoms", nhs);

		List<SinhVien> svs = new ArrayList<>();
		svs = qlsv.ShowTTSV(request.getParameter("nhom"));
		request.setAttribute("sinhvienkiet", svs);

		String nhom = request.getParameter("nhom");
		session.setAttribute("seleNhom", nhom);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_QuanLySV.jsp");
		dispatcher.forward(request, response);
	}

	/*
	 * private void infoSV(HttpServletRequest request, HttpServletResponse response)
	 * throws SQLException, IOException, ServletException { List<SinhVien> svs = new
	 * ArrayList<>(); HttpSession session = request.getSession(); Account acc =
	 * (Account) session.getAttribute("user_login"); svs =
	 * qlsv.ShowTTSV(request.getParameter("nhom"));
	 * request.setAttribute("sinhvienkiet", svs.get(0));
	 * System.out.println(svs.get(0).getHoTen()); RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("GV_QuanLySV.jsp"); dispatcher.forward(request,
	 * response); }
	 */
	private void Main(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		taikhoangv gv = null;
		boolean isDK = false;
		boolean isNop = false;
		try {
			List<Nhom> nhs = new ArrayList<>();
			nhs = qlsv.ShowTTNhom(account.getUsername());
			session.setAttribute("nhomOfGV", nhs);
			gv = tkgv.ShowTTTaiKhoan(account.getUsername());
			session.setAttribute("ctttgv", gv);
			isDK = dt.KiemTraTgDK();
			isNop = dt.KiemTraTgNop();
			Time time = dt.ShowTG();
			request.setAttribute("time", time);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("tkGv", gv);
		session.setAttribute("ttgv", account);
		session.setAttribute("dk", isDK);
		session.setAttribute("nop", isNop);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_TrangChu.jsp");
		dispatcher.forward(request, response);
	}

	private void AddNhom(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		taikhoangv gv = null;
		String err1 = null;
		try {
			HttpSession session = request.getSession();

			gv = tkgv.ShowTTTaiKhoan(account.getUsername());

			String maGV = request.getParameter("magv");
			String TenNhom = request.getParameter("tennhom");

			err1 = qlsv.ThemNhom(TenNhom, maGV);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("ttgv", gv);
		request.setAttribute("errAddNhom", err1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_ThemNhom.jsp");
		dispatcher.forward(request, response);
	}

	private void AddTV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		taikhoangv gv = null;
		String err1 = null;
		try {
			HttpSession session = request.getSession();

			gv = tkgv.ShowTTTaiKhoan(account.getUsername());

			String maGV = request.getParameter("magv");
			String TenNhom = request.getParameter("tennhom");

			err1 = qlsv.ThemNhom(TenNhom, maGV);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("ttgv", gv);
		request.setAttribute("errAddNhom", err1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_ThemNhom.jsp");
		dispatcher.forward(request, response);
	}
	private void ShowImportTV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		InputStream input = request.getPart("file").getInputStream();
		HttpSession session = request.getSession();
		
		List<SinhVien> svs = imTV.importFile(request, input);
		System.out.println("dday2");
		session.setAttribute("listsvTmp", svs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_ImportTV.jsp");
		dispatcher.forward(request, response);
	}
	private void ImportTV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		

		List<SinhVien> svs = (List<SinhVien>) session.getAttribute("listsvTmp");
		for(SinhVien sv: svs) {
			imTV.InsertExcelToDB(sv);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("qlsv");
		dispatcher.forward(request, response);
	}

	private void ShowDT(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<DeTai> dtai = new ArrayList<>();
		dtai = dt.ShowTTDeTai();
		request.setAttribute("dtai", dtai);
		HttpSession session = request.getSession();
		session.setAttribute("detais", dtai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_DKDT.jsp");
		dispatcher.forward(request, response);
	}

	private void DKDT(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String err1 = null;
		String maGV = request.getParameter("magv");
		String MaDeTai = request.getParameter("madt");
		String MaNhom = request.getParameter("nhom");

		err1 = dt.DangKyDeTai(maGV, MaDeTai, MaNhom);

		request.setAttribute("errDK", err1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("showDT");
		dispatcher.forward(request, response);
	}

	private void ShowFormDK(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		DeTai ctdetai = null;
		String maDT = request.getParameter("id");

		ctdetai = dt.showctdt(maDT);
		request.setAttribute("ctdetai", ctdetai);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_DangKyDT.jsp");
		dispatcher.forward(request, response);
	}

	private void DXDT(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String err1 = null;
		String maGV = request.getParameter("magv");
		String Link = request.getParameter("link");
		String TenDeTai = request.getParameter("name");
		String KinhPhi = request.getParameter("tien");
		String MoTa = request.getParameter("mota");

		err1 = dt.DeXuatDeTai(maGV, TenDeTai, MoTa, KinhPhi, Link);

		request.setAttribute("errDX", err1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_DXDT.jsp");
		dispatcher.forward(request, response);
	}

	private void ShowDTofGV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<DeTai> dtai = new ArrayList<>();
		HttpSession session = request.getSession();
		taikhoangv MaGV = (taikhoangv) session.getAttribute("ctttgv");

		dtai = qldt.ShowDeTaiofGV(MaGV.getMaGV());

		request.setAttribute("dtaiofgv", dtai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_DeTai.jsp");
		dispatcher.forward(request, response);
	}

	private void ShowFormThemTV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Nganh> ngs = new ArrayList<>();
		String maNhom = request.getParameter("id");
		String TenNhom = qlsv.ShowTenNhomForm(maNhom);
		ngs = qlsv.ShowFormThemTV();

		request.setAttribute("nganhs", ngs);
		request.setAttribute("tennhom", TenNhom);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_ThemTV.jsp");
		dispatcher.forward(request, response);
	}

	private void ThemTV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String MaNhom = request.getParameter("nhom");
		String MSSV = request.getParameter("mssv");
		String HoTen = request.getParameter("name");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate ngaysinh = LocalDate.parse(request.getParameter("bd"), df);
		String Email = request.getParameter("email");
		String CCCD = request.getParameter("cccd");
		String SDT = request.getParameter("sdt");
		String NienKhoa = request.getParameter("nienkhoa");
		String DiaChi = request.getParameter("diachi");
		String MaNganh = request.getParameter("nganh");

		SinhVien sv = new SinhVien("", MSSV, HoTen, ngaysinh, Email, CCCD, SDT, "", NienKhoa, DiaChi, MaNhom, MaNganh);
		qlsv.ThemTV(sv);
		RequestDispatcher dispatcher = request.getRequestDispatcher("qlsv");
		dispatcher.forward(request, response);
	}

	private void XoaTV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String MSSV = request.getParameter("id");

		qlsv.XoaTV(MSSV);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("qlsv");
		dispatcher.forward(request, response);
	}
	private void ShowNop(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String MaDeTai = request.getParameter("id");
		
		DeTai dt = qldt.TTDeTaiFrom(MaDeTai);
		request.setAttribute("ttnopdt", dt);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_NopDT.jsp");
		dispatcher.forward(request, response);
	}
	private void NopDT(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String MaDeTai = request.getParameter("madt");
		String linkNop = request.getParameter("linknop");
		String err = qldt.NopDT(MaDeTai, linkNop);
		request.setAttribute("ttnopdt", dt);
		request.setAttribute("errNop", err);
		RequestDispatcher dispatcher = request.getRequestDispatcher("qldt");
		dispatcher.forward(request, response);
	}

	private void ShowFormSuaTV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Nganh> ngs = new ArrayList<>();
		ngs = qlsv.ShowFormThemTV();
		List<Nhom> nhs = new ArrayList<>();
		HttpSession session = request.getSession();
		

		nhs = qlsv.ShowTTNhom(account.getUsername());
		session.setAttribute("nhomss", nhs);
		request.setAttribute("nganhs", ngs);
		String MSSV = request.getParameter("id");
		SinhVien sv = qlsv.ShowTTTVFrom(MSSV);

		request.setAttribute("suasv", sv);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_SuaTV.jsp");
		dispatcher.forward(request, response);
	}

	private void EditTV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String MaNhom = request.getParameter("nhom");
		String MSSV = request.getParameter("mssv");
		String HoTen = request.getParameter("name");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate ngaysinh = LocalDate.parse(request.getParameter("bd"), df);
		String Email = request.getParameter("email");
		String CCCD = request.getParameter("cccd");
		String SDT = request.getParameter("sdt");
		String NienKhoa = request.getParameter("nienkhoa");
		String DiaChi = request.getParameter("diachi");
		String MaNganh = request.getParameter("nganh");

		SinhVien sv = new SinhVien("", MSSV, HoTen, ngaysinh, Email, CCCD, SDT, "", NienKhoa, DiaChi, MaNhom, MaNganh);
		qlsv.EditTV(MSSV, sv);
		RequestDispatcher dispatcher = request.getRequestDispatcher("qlsv");
		dispatcher.forward(request, response);
	}
	private void ShowGiaHan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		String MaDeTai = request.getParameter("id");
		DeTai dt = qldt.TTDeTaiFrom(MaDeTai);

		request.setAttribute("ttdt", dt);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_GiaHan.jsp");
		dispatcher.forward(request, response);
	}
	private void GiaHan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		  
		  String MaDeTai = request.getParameter("madt");
		  DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  LocalDate NgayKetThuc = LocalDate.parse(request.getParameter("ngayketthuc"), df);
		  LocalDate NgayGiaHan = LocalDate.parse(request.getParameter("ngaygiahan"), df);
		  String LinkDonXin = request.getParameter("linkdonxin");
		  String LyDoXin = request.getParameter("lydo");
		  
		  GV_DonGiaHan dgh = new GV_DonGiaHan("", "", NgayGiaHan, NgayKetThuc, LinkDonXin, LyDoXin, MaDeTai);
		  String err = qldt.GuiDonGiaHan(dgh);
		  request.setAttribute("errDX", err);
		  RequestDispatcher dispatcher = request.getRequestDispatcher("qldt");
		  dispatcher.forward(request, response);
		 
	}
	private void ShowALLTB(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		taikhoangv MaGV = (taikhoangv) session.getAttribute("ctttgv");
		List<ThongBao> tb = new ArrayList<>();
		try {
			tb = thongbao.XemTB(MaGV.getMaGV());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("tbs", tb);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/GV_ThongBao.jsp");
		dispatcher.forward(request, response);
	}
	

}
