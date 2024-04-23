package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Admin_Model.AD_Account;
import Model.P_DuyetModel;

/**
 * Servlet implementation class ChiTietDonXin
 */
@WebServlet("/ChiTietDonXin")
public class ChiTietDonXin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChiTietDonXin() {
		super();
		// TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String maDon = request.getParameter("maDon");
		String ngayGiaHanString = request.getParameter("ngayGiaHan");
		String ngayHoanThanhString = request.getParameter("ngayHoanThanh");

		
		LocalDate ngayGiaHan = LocalDate.parse(ngayGiaHanString);
		LocalDate ngayHoanThanh = LocalDate.parse(ngayHoanThanhString);
		String linkDonXin = request.getParameter("linkDonXin");
		String lyDo = request.getParameter("lyDo");
		String trangThai = request.getParameter("trangThai");
		String maDeTai = request.getParameter("maDeTai");
		String maGV = request.getParameter("maGV");
		String maPQL = request.getParameter("maPQL");

		
		P_DuyetModel donXin = getDonXinDetails(maDon, ngayGiaHan, ngayHoanThanh, linkDonXin, lyDo, trangThai, maDeTai,
				maGV, maPQL);

		
		Gson gson = new Gson();
		String jsonData = gson.toJson(donXin);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonData);
	}

	private P_DuyetModel getDonXinDetails(String maDon, LocalDate ngaygiahan, LocalDate ngayhoanthanh,
			String linkDonXin, String lyDo, String trangThai, String maDeTai, String maGV, String maPQL) {
		
		P_DuyetModel donXin = new P_DuyetModel();
		donXin.setMaDon(maDon);
		donXin.setNgayGiaHan(ngaygiahan);
		donXin.setNgayHoanThanh(ngayhoanthanh);
		donXin.setLinkDonXin(linkDonXin);
		donXin.setLyDo(lyDo);
		donXin.setTrangThai(trangThai);
		donXin.setMaDeTai(maDeTai);
		donXin.setMaGV(maGV);
		donXin.setMaPQL(maPQL);

		return donXin;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
