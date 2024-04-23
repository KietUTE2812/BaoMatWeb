package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.P_QuanLyDAO;
import DAO.P_ThongBaoDAO;
import Admin_Model.AD_Account;
import Util.EmailUtility;

/**
 * Servlet implementation class EmailControllers
 */
@WebServlet("/EmailDuyet")
public class EmailDuyet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// reads form fields

		request.setCharacterEncoding("UTF-8");
		String TieuDeGui = "Duyệt đề tài";
		String NoiDung = "Đề tài của bạn đã được duyệt";
		String MaTK = request.getParameter("maGV");

		String NguoiNhan = "";
		try {
			NguoiNhan = P_QuanLyDAO.TimEmail(MaTK);
			System.out.println("OK");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resultMessage = "";
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write("success");
		
		try {
			EmailUtility.sendEmail(host, port, user, pass, NguoiNhan, TieuDeGui, NoiDung);
			resultMessage = "The e-mail was sent successfully";
			System.out.println("OK GuiEmailThongBao" + resultMessage);
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = "There were an error: " + ex.getMessage();
		} 

	}

}
