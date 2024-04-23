package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.P_QuanLyDAO;
import DAO.P_ThongBaoDAO;
import Admin_Model.AD_Account;;

/**
 * Servlet implementation class DuyetDeTai
 */
@WebServlet("/DuyetDeTai")
public class DuyetDeTai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DuyetDeTai() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session1 = request.getSession();
		AD_Account account1 = (AD_Account) session1.getAttribute("user_login");
		if (account1 == null) {
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		String maGV = request.getParameter("maGV");
		String maPhongQL = "";
		String tenDeTai = request.getParameter("tenDeTai");
		String moTa = request.getParameter("moTa");
		String lyDo = request.getParameter("lyDo");
		String trangThai = request.getParameter("trangThai");
		String actionValue = request.getParameter("actionValue");
		double kinhphi = Double.parseDouble(request.getParameter("kinhPhi"));
		String maDeTai = "";
		try {
			maDeTai = P_ThongBaoDAO.getmaDT();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String maTK = "";

		HttpSession session = request.getSession();
		AD_Account account = (AD_Account) session.getAttribute("user_login");
		if (account != null) {
			maTK = account.getUsername();
			System.out.println("Username" + maTK);

		}
	
		try {
			maPhongQL = P_QuanLyDAO.TimMaPQL(maTK);
			System.out.println("Ma pql " + maPhongQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			String errorMessage = P_QuanLyDAO.DuyetDeTai(maDeTai, tenDeTai, moTa, kinhphi, maGV, maPhongQL);
			if (errorMessage != null) {
				request.setAttribute("errorMessage", " " + errorMessage);
				// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT_Duyet.jsp");
				dispatcher.forward(request, response);
			} else {
				// Chuyá»ƒn hÆ°á»›ng sau khi thÃªm thÃ nh cÃ´ng
				response.sendRedirect("duyetdexuatdetai");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", " " + e.getMessage());
			// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT_Duyet.jsp");
			dispatcher.forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/EmailDuyet");
		doGet(request, response);
	}

}
