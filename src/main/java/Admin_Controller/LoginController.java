package Admin_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Admin_Dao.LoginDao;
import Admin_Model.AD_Account;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDAO;

    public LoginController() {
        super();
    }

    public void init() throws ServletException {
        loginDAO = new LoginDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Role: " + role);





        AD_Account account = new AD_Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setRole(role);

   
        try {
            AD_Account acc = loginDAO.onLogin(account);
            if (acc != null ) 
            {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1000);
                session.setAttribute("user_login", acc);

                
                if ("Admin".equals(acc.getRole())) {
                    response.sendRedirect("AD_TrangChu.jsp");
                } else if ("GV".equals(acc.getRole())) {
                    response.sendRedirect("GV/main");
                } else if ("QL".equals(acc.getRole())) {
                    response.sendRedirect("P_TrangChu.jsp");
                }
            } 
            else 
            {
              
                request.setAttribute("errMsg", "Thông tin tài khoản không chính xác!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
