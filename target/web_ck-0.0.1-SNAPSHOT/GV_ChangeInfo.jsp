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
a#button{
        text-decoration: none;
        color: white;
        background-color: #007bff;
        border-radius: 5px;
        padding: 5px;
    }
    .form {
  width: 100%;
  max-width: 20rem;
  margin: 0 auto;
  position: relative;
  top: 10%;
  left: -10%;
}

.input {
  display: block;
  width: 100%;
  height: 2.5rem;
  margin-bottom: .5rem;
  padding: .5rem 1rem;
  
  background: #f4f8f7;
    
  border: none;
  border-radius: 2px;
}

.button {
  transition: border .2s ease-in-out, background .2s ease-in-out, color .2s ease-in-out;
  
  display: block;
  width: calc(100% - 10rem);
  height: 2.5rem;
  margin-top: 1rem;
  
  background: #5fb3b3;
  border: 1px solid #5fb3b3;
  border-radius: 1.25rem;
  outline: none;
  
  color: #fff;
  font-size: .7rem;
  text-transform: uppercase;
  letter-spacing: .5px;
  
  &:hover {
    background: transparent;
    border-color: #5fb3b3;
    color: #5fb3b3;
  }

}
h3{
  text-align: center;
  color: #5f83b3;
  font-size: 1.5rem;
  margin-bottom: 1rem;

}

.custom-radio {
  appearance: none;
  -webkit-appearance: none;
  -moz-appearance: none;
  width: 20px;
  height: 20px;
  border: 2px solid #3498db;
  border-radius: 50%;
  display: inline-block;
  position: relative;
}

/* Style for checked custom radio */
.custom-radio:checked::before {
  content: "\2022";
  color: #3498db;
  font-size: 24px;
  position: absolute;
  top: 45%;
  left: 50%;
  transform: translate(-50%, -50%);
}
label{
  padding-right: 50px;
  
}
select{
  display: block;
  width: 100%;
  height: 2.5rem;
  margin-bottom: 1rem;
  padding: .5rem 1rem;
  
  background: #f4f8f7;
    
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
					<form class="form" data-form="form-1" method="post" action="cinfo">
					  <h3>Thay đổi thông tin cá nhân</h3>
					  <c:if test="${tkgv != null}">
					  <input type="text" placeholder="Họ và Tên" value="<c:out value='${tkgv.getHoten()}' />" class="input" id="name" name="name" required autocomplete="off">
					  <input type="radio" class="custom-radio" ${tkgv.getGTinh() == 'Nam' ? 'checked' : ''}  name="sex" value="Nam" id="nam"><label for="nam">Nam</label>
					  <input type="radio" class="custom-radio" ${tkgv.getGTinh() == 'Nu' ? 'checked' : ''} name="sex" value="Nu" id="nu"><label for="nu">Nữ</label>
					
					  <input type="email" placeholder="Email" value="<c:out value='${tkgv.getEmail()}' />" class="input" id="email" name="email" required autocomplete="off">
					  
					  <input type="text" placeholder="Trình Độ" value="<c:out value='${tkgv.getTrinhDo()}' />" class="input" id="trinhdo" name="trinhdo" required autocomplete="off">
					  
					  <select name="khoa" id="khoa">
					    <c:forEach var="khoa" items="${khoas}">
					        <c:choose>
					            <c:when test="${khoa.getTenKhoa() eq tkgv.getKhoa()}">
					                <option value="${khoa.getMaKhoa()}" selected>${khoa.getTenKhoa()}</option>
					            </c:when>
					            <c:otherwise>
					                <option value="${khoa.getMaKhoa()}">${khoa.getTenKhoa()}</option>
					            </c:otherwise>
					        </c:choose>
					    </c:forEach>
					</select>
					
					  <input type="submit" value="Change" class="button">
					  </c:if>
					</form>
				</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>