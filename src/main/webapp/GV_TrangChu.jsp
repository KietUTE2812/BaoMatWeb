<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <style>
        .main-panel {
            padding: 20px;
            max-height: 100%;
        }

        .table-noti {
            margin-bottom: 20px;
            /* Thêm khoảng cách giữa bảng và nút Gửi thông báo */
        }

        .send-noti {
            display: flex;
            justify-content: flex-end; /* Căn phải */
        }

        .btn-send {
            display: flex;
            justify-content: flex-end; /* Căn phải */
        }

        .table-container {
            max-height: 400px; /* Đặt chiều cao tối đa cho phần tbody */
            overflow-y: auto;
        }

        .fixed-header th {
            position: sticky;
            top: 0;
            background-color: #f5f5f5; /* Màu nền cho header cố định */
        }

        .table-container td {
            max-width: 200px;
            word-wrap: break-word;
        }

        .tc img {
            max-width: 1200px;
            max-height: 900px;
            margin-right: 10px;
        }

        .input {
            display: block;
            width: 100%;
            height: 2.5rem;
            margin-bottom: .5rem;
            padding: .5rem 1rem;
            background: #b1e4d7;
            border: none;
            border-radius: 2px;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>


<div class="container-fluid">
    <div class="row">

        <div class="col-md-2">
            <jsp:include page="/GV_List.jsp"></jsp:include>
        </div>


        <div class="col-md-10">

            <main class="main-panel">
                <div class="tc">
                    <img

                    <%--			https://drive.google.com/uc?export=view&id=1mx3TGB6a8ZDsjPbSZ-Rfy3z4i3NExYkh				src="https://drive.google.com/uc?export=view&id=1mx3TGB6a8ZDsjPbSZ-Rfy3z4i3NExYkh"--%>
                            src="https://hcmute.edu.vn/Resources/Images/SubDomain/HomePage/tin%20tuc/Nam%202021/Nen%20clip.jpg"
                            alt="TrangChu"
                            style="max-width: 1180px; max-height: 900px;">
                </div>
                <table>
                    <thead class="table-primary ">
                    <tr>
                        <th>Ngày mở đăng ký</th>
                        <th>Ngày đóng đăng ký</th>
                        <th>Ngày mở báo cáo</th>
                        <th>Ngày đóng báo cáo</th>


                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input readonly type="text" class="input" id="user1"
                                   name="username" required autocomplete="off"
                                   value="<fmt:parseDate
										var="localDate" value="${time.getMDangKy()}"
										pattern="yyyy-MM-dd" /> <fmt:formatDate value="${localDate}"
										pattern="dd/MM/yyyy" var="formattedDate" /> <c:out
										value="${formattedDate}" />">
                        </td>
                        <td><input readonly type="text" class="input" id="user2"
                                   value="<fmt:parseDate var="localDate" value="${time.getDDangKy()}"
										pattern="yyyy-MM-dd" /> <fmt:formatDate value="${localDate}"
										pattern="dd/MM/yyyy" var="formattedDate" /> <c:out
										value="${formattedDate}" />"
                                   name="username" required autocomplete="off"></td>
                        <td><input readonly type="text" class="input" id="user"
                                   value="<fmt:parseDate var="localDate" value="${time.getMBaoCao()}"
										pattern="yyyy-MM-dd" /> <fmt:formatDate value="${localDate}"
										pattern="dd/MM/yyyy" var="formattedDate" /> <c:out
										value="${formattedDate}" />"
                                   name="username" required autocomplete="off"></td>
                        <td><input readonly type="text" class="input" id="user3"
                                   value="<fmt:parseDate var="localDate" value="${time.getDBaoCao()}"
										pattern="yyyy-MM-dd" /> <fmt:formatDate value="${localDate}"
										pattern="dd/MM/yyyy" var="formattedDate" /> <c:out
										value="${formattedDate}" />"
                                   name="username" required autocomplete="off"></td>
                    </tr>
                    </tbody>
                </table>


            </main>
        </div>
    </div>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>