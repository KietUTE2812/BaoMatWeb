package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Admin_Model.AD_Account;
import DAO.P_QuanLyDAO;
import Model.P_QuanLyModel;

/**
 * Servlet implementation class DeTai
 */
@WebServlet("/DeTaiload")
public class DeTaiload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeTaiload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession();
		AD_Account account = (AD_Account) session1.getAttribute("user_login");
		if (account == null) {
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<P_QuanLyModel> detai = P_QuanLyDAO.getXemDeTai();
		System.out.println(detai);
		HttpSession session = request.getSession();
		session.setAttribute("dtai", detai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("P_QuanLyDT.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
