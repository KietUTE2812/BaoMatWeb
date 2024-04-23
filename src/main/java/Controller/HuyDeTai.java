package Controller;

import java.io.IOException;
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

import Admin_Model.AD_Account;

/**
 * Servlet implementation class HuyDeTai
 */
@WebServlet("/HuyDeTai")
public class HuyDeTai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HuyDeTai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maGV = request.getParameter("maGV");
		String maPhongQL = "";
		String tenDeTai = request.getParameter("tenDeTai");
		String noiDung = request.getParameter("noiDung");
		
		
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
			String errorMessage = P_QuanLyDAO.HuyDeTai(tenDeTai, maGV, maPhongQL, noiDung );
			if (errorMessage != null) {
				request.setAttribute("errorMessage", " " + errorMessage);
				// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT.jsp");
				dispatcher.forward(request, response);
			} else {
				// Chuyá»ƒn hÆ°á»›ng sau khi thÃªm thÃ nh cÃ´ng
				response.sendRedirect("P_QuanLyDT_Duyet.jsp");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
