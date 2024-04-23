/*
 * package Admin_Controller;
 * 
 * import java.io.IOException; import java.sql.SQLException;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import Admin_Dao.AD_QuanLyDao; import Admin_Dao.AD_ThongBaoDao; import
 * Admin_Model.AD_Account; import Admin_Model.AD_ThongBao;
 * 
 * 
 * @WebServlet("/ADGuiTB") public class GuiTB_Admin extends HttpServlet {
 * private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public GuiTB_Admin() { super(); // TODO Auto-generated constructor stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * request.setCharacterEncoding("UTF-8"); String TieuDeGui =
 * request.getParameter("TieuDe"); String NoiDung =
 * request.getParameter("NoiDung"); String NguoiNhan =
 * request.getParameter("NguoiNhan");
 * 
 * String maTK = "";
 * 
 * HttpSession session = request.getSession(); AD_Account account = (AD_Account)
 * session.getAttribute("user_login"); if (account != null) { maTK =
 * account.getUsername(); System.out.println("Username" + maTK);
 * 
 * } String NguoiGui=""; try { NguoiGui = AD_QuanLyDao.TimMaPQL(maTK);
 * System.out.println("Ma pql " + NguoiGui); } catch (SQLException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 * System.out.println("GuiThongbao");
 * 
 * 
 * AD_ThongBao GuiTB = new AD_ThongBao(NguoiNhan, TieuDeGui, NoiDung, NguoiGui);
 * RequestDispatcher dispatcher =
 * request.getRequestDispatcher("AD_ThongBao.jsp"); try {
 * AD_ThongBaoDao.GuiThongBao(GuiTB); } catch (SQLException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 * response.sendRedirect("XemThongBao"); }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doGet(request, response); }
		 * 
		 * }
		 */