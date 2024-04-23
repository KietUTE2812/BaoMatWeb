<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin tài khoản</title>
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
img {
		align-item:left;
		width: 200px;
		}
	#list{
    position: relative !important;
    top: 10% !important;
}
#list a{
    text-decoration: none; 
    padding-top: 5px;
    height: 60px;
    font-size: 20px;
	text-align: left;
    font-family: 'Outfit', sans-serif;
    padding-left: 5px;
    color: #000000;
	-ms-border-radius: 15px;
	-o-border-radius: 15px;
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
	border-radius: 15px;
    position: relative;
    left: -30%;
}
#list a:hover{
    background-color: #e3780d;
    color: #ffffff;
}
a#button{
        text-decoration: none;
        color: white;
        background-color: #007bff;
        border-radius: 5px;
        padding: 5px;
        width: 150px;
        text-align: center;
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
					<fieldset>
						<legend>Thông tin Tài Khoản</legend>
						<div class="row">
						<div class="col-md-2">
						<img src="https://cdn-icons-png.flaticon.com/512/2815/2815428.png">
						</div>
							<div class="col-md-9">
							<c:if test="${tkgv != null}">
							<table>
							  <tr>
							    <th>Họ Và Tên:</th>
							    <th><input type="text"
							      value="<c:out value='${tkgv.hoten}' />" class="form-control"
							      name="hoten" required="required" readonly></th>
							  </tr>
							  <tr>
							    <th>Mã Giảng Viên:</th>
							    <th><input type="text"
							      value="<c:out value='${tkgv.maGV}' />" class="form-control"
							      name="magv" required="required" readonly></th>
							  </tr>
							  <tr>
							    <th>Giới Tính:</th>
							    <th><input type="text"
							      value="<c:out value='${tkgv.GTinh}' />" class="form-control"
							      name="gtinh" required="required" readonly></th>
							  </tr>
							 <tr>
							    <th>Email:</th>
							    <th><input type="text"
							      value="<c:out value='${tkgv.email}' />" class="form-control"
							      name="email" required="required" readonly></th>
							  </tr>
							  <tr>
							    <th>Trình độ:</th>
							    <th><input type="text"
							      value="<c:out value='${tkgv.trinhDo}' />" class="form-control"
							      name="trinhdo" required="required" readonly></th>
							  </tr>
							  
							  <tr>
							    <th>Khoa:</th>
							    <th><input type="text"
							      value="<c:out value='${tkgv.khoa}' />" class="form-control"
							      name="khoa" required="required" readonly></th>
							  </tr>
							  
							</table>
							</c:if>
						</div>
						</div>
					</fieldset>
					
					<a href="<%=request.getContextPath()%>/GV_ChangePass.jsp"
     				 class="nav-link mt-5 d-inline-block" id="button">Đổi mật khẩu</a>
     				 <a href="list"
     				 class="nav-link mt-5 d-inline-block" id="button">Cập nhật thông tin</a>
				</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>