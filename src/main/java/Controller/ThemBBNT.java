package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.P_NghiemThuDeTaiDAO;
import DAO.P_QuanLyDAO;
import Admin_Model.AD_Account;
import Model.P_NghiemThuDeTaiModel;
import Model.P_QuanLyModel;

/**
 * Servlet implementation class ThemBBNT
 */
@WebServlet("/ThemBBNT")
public class ThemBBNT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemBBNT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mabb="";
		try {
			mabb = P_NghiemThuDeTaiDAO.TimMabb();
			System.out.println("mabb: " + mabb);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		double diem = Double.parseDouble(request.getParameter("diem"));
		String danhgia = request.getParameter("danhgia");
		String minhchung = request.getParameter("minhchung");
		String madetai = request.getParameter("maDeTai");
		LocalDate ngaythuchien = P_NghiemThuDeTaiDAO.getCurrentDate();
		String username ="";
		HttpSession session = request.getSession();
        AD_Account account = (AD_Account) session.getAttribute("user_login");
        if (account != null) {
        	username = account.getUsername();
            
            
        }
		String mapql="";
		try {
			mapql = P_NghiemThuDeTaiDAO.TimMaPQL(username);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		P_NghiemThuDeTaiModel ThemBB = new P_NghiemThuDeTaiModel(mabb, diem, danhgia, minhchung, ngaythuchien, madetai, mapql);
		try {
			System.out.println("try severlet");
			String errorMessage = P_NghiemThuDeTaiDAO.themBBNT(ThemBB);
			if (errorMessage != null) {
				request.setAttribute("errorMessage", " " + errorMessage);
				// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
				System.out.println("lá»—i táº¡i try " + errorMessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("P_NghiemThuDT.jsp");
				dispatcher.forward(request, response);
			} else {
				// Chuyá»ƒn hÆ°á»›ng sau khi thÃªm thÃ nh cÃ´ng
				
				response.sendRedirect("xembienbannghiemthu");
			}
		} catch (SQLException e) {
			System.out.println("catch severlet");
			e.printStackTrace();
			request.setAttribute("errorMessage", " " + e.getMessage());
			// Forward Ä‘áº¿n trang JSP hiá»ƒn thá»‹ thÃ´ng bÃ¡o lá»—i
			RequestDispatcher dispatcher = request.getRequestDispatcher("P_NghiemThuDT.jsp");
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
