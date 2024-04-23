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

import DAO.P_ThongBaoDAO;
import Util.EmailUtility;

/**
 * Servlet implementation class EmailControllers
 */
@WebServlet("/EmailHuy")
public class EmailHuy extends HttpServlet {
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
		String TieuDeGui = request.getParameter("tieuDe");
		String NoiDung = request.getParameter("noiDung");
		String MaGV = request.getParameter("maGV");
		System.out.println("mailhuyr" + MaGV);
		String NguoiNhan = "";
		try {
			NguoiNhan = P_ThongBaoDAO.TimEmail(MaGV);
			System.out.println("OK gui email huy thanh cong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resultMessage = "";

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
