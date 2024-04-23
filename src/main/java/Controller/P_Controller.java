package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.P_DuyetDAO;
import DAO.P_NghiemThuDeTaiDAO;
import DAO.P_QuanLyDAO;
import DAO.P_TaiKhoanDAO;
import DAO.P_ThongBaoDAO;
import DAO.P_ThongKeDAO;
import Admin_Model.AD_Account;
import Model.P_DuyetModel;
import Model.P_NghiemThuDeTaiModel;
import Model.P_QuanLyModel;
import Model.P_QuanLyModel_Duyet;
import Model.P_TaiKhoanModel;
import Model.P_ThongBaoModel;
import Model.P_ThongKeModel;
import Util.EmailUtility;

/**
 * Servlet implementation class P_ThongBaoController
 */
@WebServlet("/")
public class P_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String P_ThongkeDAO = null;
	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public P_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		AD_Account account = (AD_Account) session.getAttribute("user_login");
		if (account == null) {
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		String action = request.getServletPath();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			switch (action) {
			case "/XemThongBao":
				XemThongBao(request, response);
				break;
			case "/list":
				XemThongBao(request, response);
				break;
			case "/GuiThongBaoGet":
				GuiThongBaoGet(request, response);
				response.sendRedirect("P_ThongBao.jsp");
				break;
			case "/ThongBao":
				XemGV(request, response);
				break;
			case "/DeTai":
				XemDeTai(request, response);
				break;
			case "/SuaDeTai":
				suadetai(request, response);
				break;
			case "/TaoDeTai":
				Taodetai(request, response);
				break;
			case "/XoaDeTai":
				xoadetai(request, response);
				break;
			case "/error":
				Error(request, response);
				break;
			case "/GuiEmailThongBao11":
				GuiEmailThongBao(request, response);
				break;
			case "/xemdexuatdetai":
				xemdexuatdetai(request, response);
				break;
			case "/duyetdexuatdetai":
				xemdexuatdetai(request, response);
				break;
			case "/xemdanhsachdetai":
				xemdanhsachdetai(request, response);
				break;
			case "/xembienbannghiemthu":
				xembienbannghiemthu(request, response);
				break;
			case "/danhsachdonxin":
				danhsachdonxin(request, response);
				break;
			case "/duyetdonxingiahan":
				duyetdonxingiahan(request, response);
				break;
			case "/huydonxingiahan":
				huydonxingiahan(request, response);
				break;
			case "/danhsachdetaidk":
				danhsachdetaidk(request, response);
				break;
			case "/duyetDTDK":
				duyetDTDK(request, response);
				break;
			case "/huyDTDK":
				huyDTDK(request, response);
				break;
			case "/danhsachdot":
				danhsachdot(request, response);
				break;
			case "/thaydoidot":
				thaydoidot(request, response);
				break;
			case "/taodot":
				taodot(request, response);
				break;
			case "/p_taikhoan":
				p_taikhoan(request, response);
				break;
			case "/updatetkp":
				updatetkp(request, response);
				break;
			case "/dsdetaithongke":
				dsdetaithongke(request, response);
				break;
			case "/xemthongke":
				dsdetaithongke(request, response);
				break;
			case "/dsmadot":
				dsmadot(request, response);
				break;
			case "/sltrangthai":
				sltrangthai(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_TrangChu.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "/GuiEmailThong":
			if ("GuiEmailThongBao".equals(action)) {
				GuiEmailThongBao(request, response);
			} else {
				// Xá»­ lÃ½ máº·c Ä‘á»‹nh hoáº·c chuyá»ƒn hÆ°á»›ng tÃ¹y thuá»™c vÃ o yÃªu cáº§u
				// cá»§a báº¡n
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_TrangChu.jsp");
				dispatcher.forward(request, response);
			}
			break;

		default:
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_TrangChu.jsp");
			dispatcher.forward(request, response);
			break;
		}

	}

	private void GuiEmailThongBao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// reads form fields
		request.setCharacterEncoding("UTF-8");
		String TieuDeGui = request.getParameter("TieuDe");
		String NoiDung = request.getParameter("NoiDung");
		String MaGV = request.getParameter("NguoiNhan");

		String NguoiNhan = "";
		try {
			NguoiNhan = P_ThongBaoDAO.TimEmail(MaGV);
			System.out.println("OK GuiEmailThongBao tb");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resultMessage = "";
		System.out.println(NguoiNhan);
		try {
			EmailUtility.sendEmail(host, port, user, pass, NguoiNhan, TieuDeGui, NoiDung);
			// resultMessage = "The e-mail was sent successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = "There were an error: " + ex.getMessage();
		} finally {
			request.setAttribute("errorMessage", resultMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_ThongBao.jsp");
			dispatcher.forward(request, response);
		}
		System.out.println(resultMessage);
	}

	private void XemThongBao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<P_ThongBaoModel> thongBaos = P_ThongBaoDAO.getXemThongBao();

		HttpSession session = request.getSession();
		session.setAttribute("tb", thongBaos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("P_ThongBao.jsp");
		dispatcher.forward(request, response);
	}

	private void GuiThongBaoGet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

	}

	private void XemGV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<P_ThongBaoModel> thongBaos = P_ThongBaoDAO.getXemGV();
		// Kiá»ƒm tra náº¿u danh sÃ¡ch khÃ´ng rá»—ng

		HttpSession session = request.getSession();
		session.setAttribute("tengv", thongBaos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("P_ThongBao.jsp");
		dispatcher.forward(request, response);
	}

	// ---------------------------------------------------- Quáº£n lÃ½ Ä‘á»� tÃ i
	// ----------------------------------------
	private void XemDeTai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<P_QuanLyModel> detai = P_QuanLyDAO.getXemDeTai();
		System.out.println(detai);
		HttpSession session = request.getSession();
		session.setAttribute("dtai", detai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT.jsp");
		dispatcher.forward(request, response);
	}

	private void Error(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		dispatcher.forward(request, response);
	}

	private void Taodetai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String madt = request.getParameter("madetai");
		String tendt = request.getParameter("tendetai");
		String ghichu = request.getParameter("ghichu");
		double kinhphi = Double.parseDouble(request.getParameter("kinhphi"));

		P_QuanLyModel ThemDT = new P_QuanLyModel(madt, tendt, ghichu, kinhphi);
		try {
			String errorMessage = P_QuanLyDAO.themdetai(ThemDT);
			if (errorMessage != null) {
				request.setAttribute("errorMessage", "Lỗi khi thực hiện thêm đề tài: " + errorMessage);

				RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT.jsp");
				dispatcher.forward(request, response);
			} else {
				// Chuyá»ƒn hÆ°á»›ng sau khi thÃªm thÃ nh cÃ´ng
				response.sendRedirect("DeTai");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Lỗi khi thực hiện thêm đề tài: " + e.getMessage());

			RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void xoadetai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String maDeTai = request.getParameter("maDeTai");

		System.out.println(maDeTai);

		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write("success");

		try {
			String errorMessage = P_QuanLyDAO.xoadetai(maDeTai);
			if (errorMessage != null) {
				request.setAttribute("errorMessage", "Lỗi khi thực hiện thêm đề tài: " + errorMessage);

				RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT.jsp");
				dispatcher.forward(request, response);
			} else {
				// Chuyá»ƒn hÆ°á»›ng sau khi thÃªm thÃ nh cÃ´ng
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", " " + e.getMessage());
			// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void suadetai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String maDeTai = request.getParameter("projectCode");
		String tendetai = request.getParameter("projectName");
		String ghichu = request.getParameter("notes");
		String ketqua = request.getParameter("result");
		String trangthai = request.getParameter("status");
		String linknopbai = request.getParameter("submissionLink");

		// Kiá»ƒm tra tá»«ng biáº¿n vÃ  gÃ¡n giÃ¡ trá»‹ máº·c Ä‘á»‹nh náº¿u rá»—ng
		maDeTai = (maDeTai != null && !maDeTai.isEmpty()) ? maDeTai : null;
		tendetai = (tendetai != null && !tendetai.isEmpty()) ? tendetai : null;
		ghichu = (ghichu != null && !ghichu.isEmpty()) ? ghichu : null;
		ketqua = (ketqua != null && !ketqua.isEmpty()) ? ketqua : null;
		trangthai = (trangthai != null && !trangthai.isEmpty()) ? trangthai : null;
		linknopbai = (linknopbai != null && !linknopbai.isEmpty()) ? linknopbai : null;

		double kinhphi = Double.parseDouble(request.getParameter("budget"));
		String ngayBatDauString = request.getParameter("startDate");
		LocalDate ngaythuchien = null;

		if (ngayBatDauString != null && !ngayBatDauString.isEmpty()) {
			ngaythuchien = LocalDate.parse(ngayBatDauString);
		}

		String ngayKetThucString = request.getParameter("endDate");
		LocalDate ngayketthuc = null;

		if (ngayKetThucString != null && !ngayKetThucString.isEmpty()) {
			ngayketthuc = LocalDate.parse(ngayKetThucString);
		}

		try {
			String errorMessage = P_QuanLyDAO.suadetai(maDeTai, tendetai, ghichu, trangthai, ketqua, linknopbai,
					kinhphi, ngaythuchien, ngayketthuc);
			if (errorMessage != null) {
				request.setAttribute("errorMessage", " " + errorMessage);
				// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT.jsp");
				dispatcher.forward(request, response);
			} else {
				// Chuyá»ƒn hÆ°á»›ng sau khi thÃªm thÃ nh cÃ´ng
				response.sendRedirect("DeTai");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", " " + e.getMessage());
			// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void xemdexuatdetai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<P_QuanLyModel_Duyet> dt = P_QuanLyDAO.getXemDeXuatDeTai();

		HttpSession session = request.getSession();
		session.setAttribute("dt", dt);
		RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT_Duyet.jsp");
		dispatcher.forward(request, response);
	}

	// --------------- Bien báº£n nghiá»‡m thu ----------------

	private void xemdanhsachdetai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<P_NghiemThuDeTaiModel> detai = P_NghiemThuDeTaiDAO.getxemdanhsachdetai();
		System.out.println(detai);
		HttpSession session = request.getSession();
		session.setAttribute("danhsachdetai", detai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("P_NghiemThuDT.jsp");
		dispatcher.forward(request, response);
	}

	private void xembienbannghiemthu(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<P_NghiemThuDeTaiModel> detai = P_NghiemThuDeTaiDAO.xembienbannghiemthu();
		System.out.println(detai);
		HttpSession session = request.getSession();
		session.setAttribute("bienbannghiemthu", detai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("P_BienBanNghiemThuDT.jsp");
		dispatcher.forward(request, response);
	}

//-----------------------------------------Duyet don xin ---------------------------
	private void danhsachdonxin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<P_DuyetModel> DonXin = P_DuyetDAO.DonXinGiaHan();
		System.out.println(DonXin);
		HttpSession session = request.getSession();
		session.setAttribute("danhsachdonxin", DonXin);
		RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDonXinGiaHan.jsp");
		dispatcher.forward(request, response);
	}

	private void duyetdonxingiahan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String madon = request.getParameter("MaDon");
		String madt = request.getParameter("MaDeTai");
		String ngayht = request.getParameter("NgayHoanThanh");
		LocalDate ngayHoanThanh = LocalDate.parse(ngayht);
		/* LocalDate ngayhoanthanh = ngayHoanThanh.plusMonths(6); */

		System.out.println(madon);

		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write("success");
		String maTK = "";

		HttpSession session = request.getSession();
		AD_Account account = (AD_Account) session.getAttribute("user_login");
		if (account != null) {
			maTK = account.getUsername();
			System.out.println("Username" + maTK);

		}
		String NguoiGui = "";
		try {
			NguoiGui = P_QuanLyDAO.TimMaPQL(maTK);
			System.out.println("Ma pql " + NguoiGui);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String errorMessage = P_DuyetDAO.duyetdonxin(madon, NguoiGui, madt, ngayHoanThanh);
			if (errorMessage != null) {
				request.setAttribute("errorMessage", " " + errorMessage);
				// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDonXinGiaHan.jsp");
				dispatcher.forward(request, response);
			} else {
				// Chuyá»ƒn hÆ°á»›ng sau khi thÃªm thÃ nh cÃ´ng
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDonXinGiaHan.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "" + e.getMessage());
			// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDonXinGiaHan.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void huydonxingiahan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String madon = request.getParameter("MaDon");
		String lydohuy = request.getParameter("NoiDung");
		// Xá»­ lÃ½ logic xÃ³a vá»›i mÃ£ Ä‘á»� tÃ i
		System.out.println(madon);
		// Gá»­i pháº£n há»“i (response) náº¿u cáº§n
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write("success");
		String maTK = "";

		HttpSession session = request.getSession();
		AD_Account account = (AD_Account) session.getAttribute("user_login");
		if (account != null) {
			maTK = account.getUsername();
			System.out.println("Username" + maTK);

		}
		String NguoiGui = "";
		try {
			NguoiGui = P_QuanLyDAO.TimMaPQL(maTK);
			System.out.println("Ma pql " + NguoiGui);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String errorMessage = P_DuyetDAO.huydonxin(madon, NguoiGui, lydohuy);
			if (errorMessage != null) {
				request.setAttribute("errorMessage", " " + errorMessage);
				// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDonXinGiaHan.jsp");
				dispatcher.forward(request, response);
			} else {
				// Chuyá»ƒn hÆ°á»›ng sau khi thÃªm thÃ nh cÃ´ng
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDonXinGiaHan.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", " " + e.getMessage());
			// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDonXinGiaHan.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void danhsachdetaidk(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<P_DuyetModel> DTDK = P_DuyetDAO.DeTaiDK();
		System.out.println(DTDK);
		HttpSession session = request.getSession();
		session.setAttribute("danhsachdetaidk", DTDK);
		RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDTDK.jsp");
		dispatcher.forward(request, response);
	}

	private void duyetDTDK(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String maGV = request.getParameter("maGV");
		String maDeTai = request.getParameter("maDeTai");
		String noiDung = request.getParameter("NoiDung");
		// Xá»­ lÃ½ logic xÃ³a vá»›i mÃ£ Ä‘á»� tÃ i
		System.out.println(maGV);
		// Gá»­i pháº£n há»“i (response) náº¿u cáº§n
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write("success");

		try {
			String errorMessage = P_DuyetDAO.duyetDTDK(maGV, maDeTai, noiDung);
			if (errorMessage != null) {
				request.setAttribute("errorMessage", "" + errorMessage);
				// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDTDK.jsp");
				dispatcher.forward(request, response);
			} else {
				// Chuyá»ƒn hÆ°á»›ng sau khi thÃªm thÃ nh cÃ´ng
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDTDK.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", " " + e.getMessage());
			// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDTDK.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void huyDTDK(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String maGV = request.getParameter("maGV");
		String maDeTai = request.getParameter("maDeTai");
		String noiDung = request.getParameter("NoiDung");
		// Xá»­ lÃ½ logic xÃ³a vá»›i mÃ£ Ä‘á»� tÃ i
		System.out.println(maGV);

		try {
			String errorMessage = P_DuyetDAO.huyDTDK(maGV, maDeTai, noiDung);
			if (errorMessage != null) {
				request.setAttribute("errorMessage", " " + errorMessage);
				// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDTDK.jsp");
				dispatcher.forward(request, response);
			} else {
				// Chuyá»ƒn hÆ°á»›ng sau khi thÃªm thÃ nh cÃ´ng
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDTDK.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "" + e.getMessage());
			// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_DuyetDTDK.jsp");
			dispatcher.forward(request, response);
		}

	}

	// -----------------------------
	private void danhsachdot(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<P_DuyetModel> tg = P_DuyetDAO.ThoiGian();
		System.out.println(tg);
		HttpSession session = request.getSession();
		session.setAttribute("dots", tg);
		RequestDispatcher dispatcher = request.getRequestDispatcher("P_DangKyDT.jsp");
		dispatcher.forward(request, response);
	}

	private void thaydoidot(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		PrintWriter out = response.getWriter();
		String maDot = request.getParameter("maDot");
		String trangThai = request.getParameter("trangThai");
		Date ngayMoDangKy = Date.valueOf(request.getParameter("ngayMoDangKy"));
		Date ngayDongDangKy = Date.valueOf(request.getParameter("ngayDongDangKy"));
		Date ngayMoThucHien = Date.valueOf(request.getParameter("ngayMoThucHien"));
		Date ngayDongThucHien = Date.valueOf(request.getParameter("ngayDongThucHien"));
		Date ngayMoBaoCao = Date.valueOf(request.getParameter("ngayMoBaoCao"));
		Date ngayDongBaoCao = Date.valueOf(request.getParameter("ngayDongBaoCao"));
		Date ngayMoNghiemThu = Date.valueOf(request.getParameter("ngayMoNghiemThu"));
		Date ngayDongNghiemThu = Date.valueOf(request.getParameter("ngayDongNghiemThu"));
		Date ngayDongDot = Date.valueOf(request.getParameter("ngayDongDot"));

		// Xá»­ lÃ½ logic xÃ³a vá»›i mÃ£ Ä‘á»� tÃ i
		System.out.println(maDot);

		try {
			String errorMessage = P_DuyetDAO.thaydoidot(maDot, trangThai, ngayMoDangKy, ngayDongDangKy, ngayMoThucHien,
					ngayDongThucHien, ngayMoBaoCao, ngayDongBaoCao, ngayMoNghiemThu, ngayDongNghiemThu, ngayDongDot);
			System.out.println(errorMessage);
			if (errorMessage != null) {
				request.setAttribute("errorMessage", "Có lỗi xảy ra!");
				System.out.println("1: " + errorMessage);
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_DangKyDT.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("2: " + errorMessage);
				out.print("{\"error\": false}");
				
		
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_DangKyDT.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_DangKyDT.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void taodot(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String maDot = request.getParameter("maDot");
		String trangThai = request.getParameter("trangThai");
		Date ngayMoDangKy = Date.valueOf(request.getParameter("ngayMoDangKy"));

		Date ngayMoThucHien = Date.valueOf(request.getParameter("ngayMoThucHien"));

		Date ngayMoBaoCao = Date.valueOf(request.getParameter("ngayMoBaoCao"));

		Date ngayMoNghiemThu = Date.valueOf(request.getParameter("ngayMoNghiemThu"));

		Date ngayDongDot = Date.valueOf(request.getParameter("ngayDongDot"));

		// Xá»­ lÃ½ logic xÃ³a vá»›i mÃ£ Ä‘á»� tÃ i
		System.out.println(maDot);

		try {
			String errorMessage = P_DuyetDAO.taodot(maDot, trangThai, ngayMoDangKy, ngayMoThucHien, ngayMoBaoCao,
					ngayMoNghiemThu, ngayDongDot);
			if (errorMessage != null) {
				request.setAttribute("errorMessage", "" + errorMessage);
				// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_DangKyDT.jsp");
				dispatcher.forward(request, response);
			} else {
				// Chuyá»ƒn hÆ°á»›ng sau khi thÃªm thÃ nh cÃ´ng
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_DangKyDT.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "" + e.getMessage());
			// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_DangKyDT.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void p_taikhoan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String maTK1 = "";
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		AD_Account account = (AD_Account) session.getAttribute("user_login");
		if (account != null) {
			maTK1 = account.getUsername();
			System.out.println("Username" + maTK1);

		}
		String NguoiGui = "";
		try {
			NguoiGui = P_QuanLyDAO.TimMaPQL(maTK1);
			System.out.println("Ma pql " + NguoiGui);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("GuiThongbao");
		List<P_TaiKhoanModel> tk = P_TaiKhoanDAO.taikhoan(NguoiGui);
		System.out.println(tk);
		HttpSession session1 = request.getSession();
		session1.setAttribute("taikhoan", tk);
		RequestDispatcher dispatcher = request.getRequestDispatcher("P_TaiKhoan.jsp");
		dispatcher.forward(request, response);
	}

	private void updatetkp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String mapql = request.getParameter("mapql");
		String matk = request.getParameter("matk");
		String nguoidaidien = request.getParameter("nguoidaidien");
		String sdt = request.getParameter("sdt");
		String email = request.getParameter("email");
		String diachi = request.getParameter("diachi");
		String mk = request.getParameter("matkhau");

		// Xá»­ lÃ½ logic xÃ³a vá»›i mÃ£ Ä‘á»� tÃ i
		System.out.println(mapql);

		try {
			String errorMessage = P_TaiKhoanDAO.updatetk(mapql, matk, nguoidaidien, sdt, email, diachi, mk);
			if (errorMessage != null) {
				request.setAttribute("errorMessage", "" + errorMessage);
				// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_TaiKhoan.jsp");
				dispatcher.forward(request, response);
			} else {
				// Chuyá»ƒn hÆ°á»›ng sau khi thÃªm thÃ nh cÃ´ng
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_TaiKhoan.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", " " + e.getMessage());
			// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_TaiKhoan.jsp");
			dispatcher.forward(request, response);
		}

	}

	// ------------------------- thong ke -------------------------
	private void dsdetaithongke(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String madot = request.getParameter("selectedDot");

		/*
		 * LocalDate ngayBatDau = P_ThongKeDAO.getNgayBatDau(madot); LocalDate
		 * ngaKetThuc = P_ThongKeDAO.getNgayKeThuc(madot); System.out.println("date:   "
		 * + ngayBatDau + ngaKetThuc); System.out.println("md:   " + madot);
		 */
		List<P_ThongKeModel> tg = P_ThongKeDAO.dsdetai(madot);
		StringBuilder htmlContent = new StringBuilder();
		for (P_ThongKeModel dt : tg) {
			htmlContent.append("<tr>");
			htmlContent.append("<td>").append(URLEncoder.encode(dt.getMaDetai(), StandardCharsets.UTF_8.toString()))
					.append("</td>");
			htmlContent.append("<td>").append(URLDecoder.decode(dt.getTenDeTai(), StandardCharsets.UTF_8.toString()))
					.append("</td>");

			htmlContent.append("<td>").append(dt.getGhiChu()).append("</td>");
			htmlContent.append("<td>").append(dt.getNgayThucHien()).append("</td>");
			htmlContent.append("<td>").append(dt.getNgayKetThuc()).append("</td>");
			htmlContent.append("<td>").append(dt.getKinhPhiDuKien()).append("</td>");
			htmlContent.append("<td>").append(dt.getKetQua()).append("</td>");
			htmlContent.append("<td>").append(dt.getTrangThai()).append("</td>");
			htmlContent.append("<td>").append(dt.getLinkNopBai()).append("</td>");
			htmlContent.append("<td>").append(dt.getNgayNop()).append("</td>");
			// ThÃªm cÃ¡c cá»™t khÃ¡c tÆ°Æ¡ng á»©ng
			htmlContent.append("</tr>");
		}
		System.out.println("html:  " + htmlContent);
		// Gá»­i ná»™i dung HTML má»›i vá»� client
		response.getWriter().write(htmlContent.toString());
	}

	private void dsmadot(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<P_ThongKeModel> tg = P_ThongKeDAO.dsMaDot();
		System.out.println(tg);
		HttpSession session = request.getSession();
		session.setAttribute("dsmadot", tg);
		RequestDispatcher dispatcher = request.getRequestDispatcher("P_ThongKe.jsp");
		dispatcher.forward(request, response);
	}

	private void sltrangthai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		try {
			int sl = P_DuyetDAO.SoLuongTT();
			response.getWriter().write(String.valueOf(sl));
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("0");
		}
		/*
		 * HttpSession session = request.getSession();
		 * session.setAttribute("sltrangthai", sl); RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("P_DangKyDT.jsp"); dispatcher.forward(request,
		 * response);
		 */
	}

}
