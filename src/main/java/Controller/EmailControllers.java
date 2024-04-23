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
@WebServlet("/EmailControllers")
public class EmailControllers extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// reads form fields
		request.setCharacterEncoding("UTF-8");
		String TieuDeGui = request.getParameter("TieuDe");
		String NoiDung = request.getParameter("NoiDung");
		String MaGV = request.getParameter("NguoiNhan");

		String NguoiNhan = "";
		try {
			NguoiNhan = P_ThongBaoDAO.TimEmail(MaGV);
			System.out.println("OK");
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
		} finally {
			System.out.println("chuyá»ƒn form");
			String action = request.getParameter("action");

			if ("GuiThongBaoGet".equals(action)) {
			    // Gá»�i servlet `GuiThongBaoGet` thÃ´ng qua forward
			    try {
			        // Sá»­ dá»¥ng HttpServletResponse Ä‘á»ƒ forward
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/GuiTB");
			        
			        dispatcher.forward(request, response);
			    } catch (Exception e) {
			        e.printStackTrace();
			        System.out.println("Lá»—i khi chuyá»ƒn form");
			    }
			} else {
			    // Other logic for non-GuiThongBaoGet actions

			    // If you need to send a response to the client, include a script for redirection
			    response.setContentType("text/html");
			    PrintWriter out = response.getWriter();
			    out.println("<script>window.location.href='/web_ck/GuiThongBaoGet';</script>");
			    out.close();
			}

		}

	}

}
