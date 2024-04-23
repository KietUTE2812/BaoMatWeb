<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="Admin_Model.AD_Account" %>
<style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
    }

    header {
        background-color: transparent;
        color: white;
        padding: 10px;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .logo {
        display: flex;
        align-items: center;
    }

    .logo img {
        max-width: 300px;
        max-height: 100px;
        margin-right: 10px;
    }

    .user-info {
        display: flex;
        color: blue;
        align-items: center;
    }

    .user-info span {
        margin-right: 10px;
    }

    .logout-btn {
        background-color: #ddd;

        border: none;
        cursor: pointer;
        border-radius: 5px;
    }
</style>

<header>
    <div class="logo">
        <img
        <%--			src="https://drive.google.com/uc?export=view&id=1cmLLXbEQ9ea_-BBgrIDBgfDNvkzan7Sh"--%>
                src="https://fit.hcmute.edu.vn/Resources/Images/SubDomain/fit/logo-news.png"
                alt="Logo hihi">

    </div>
    <div class="user-info">
        <%
            String errMsg = (String) request.getAttribute("errMsg");
            AD_Account account = (AD_Account) session.getAttribute("user_login");
        %>

        <%-- Kiểm tra xem người dùng đã đăng nhập chưa --%>
        <%
            if (account != null) {
        %>
        <span>Welcome <%=account.getUsername()%></span>
        <button class="logout-btn">
            <a href="<%=request.getContextPath()%>/LogoutController"
               class="nav-link">Đăng Xuất</a>
        </button>
        <%
        } else {
        %>
        <%-- Hiển thị thông báo lỗi nếu có --%>
        <span><%=errMsg%></span>
        <%
            }
        %>
    </div>


</header>

<script>
    function logout() {
        // Add JavaScript code to handle logout, e.g., redirect to logout servlet or perform AJAX logout
        // For example, window.location.href = "logoutServlet";
    }
</script>