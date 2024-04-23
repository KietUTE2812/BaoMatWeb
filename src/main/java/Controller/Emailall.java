package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.P_ThongBaoDAO;
import Model.P_TaiKhoanModel;
import Util.EmailUtility;

/**
 * Servlet implementation class EmailControllers
 */
@WebServlet("/Emailall")
public class Emailall extends HttpServlet {
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

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String TieuDeGui = request.getParameter("TieuDe");
		String NoiDung = request.getParameter("NoiDung");
		// String MaGV = request.getParameter("NguoiNhan");

		String resultMessage = "";
		List<P_TaiKhoanModel> emailList = P_ThongBaoDAO.emailgvdangthuchien();
		System.out.println("nguoi nhan " + emailList);
		for (P_TaiKhoanModel taiKhoan : emailList) {
			String NguoiNhan = taiKhoan.getEmailgvall();
			System.out.println("nguoi nhan 1: " + NguoiNhan);
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

}
