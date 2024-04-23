<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký đề tài</title>
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
a#button {
    text-decoration: none;
    color: white;
    background-color: #007bff;
    border-radius: 5px;
    padding: 5px;
    width: 150px;
    text-align: center;
  }

  .form {
    width: 100%;
    max-width: 50rem;
    margin: 0 auto;
    position: relative;
    top: 20%;
    left: 10%;
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

  .button {
    transition: border .2s ease-in-out, background .2s ease-in-out, color .2s ease-in-out;

    display: block;
    width: 100%;
    height: 2.5rem;
    
	
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

  h3 {
    text-align: left !important;
    color: #5f83b3 !important;
    font-size: 1.5rem !important;
    margin-bottom: 1rem !important;

  }
  #ghichu{
  height: 100px;
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


			<div class="col-md-9">
					<form class="form" data-form="form-1" method="post"
						action="<%=request.getContextPath()%>/GV/dkdt">
						<h3>Đăng ký Đề Tài</h3>
						<table><tr>
								<td>Nhóm:</td>
								<td><select class="form-control groups d-inline-block" id="nhom"
										name="nhom">
										<c:forEach var="nhom" items="${nhomOfGV}">
											
													<option value="${nhom.getMaNhom()}">${nhom.getTenNhom()}</option>
												
											

										</c:forEach>
									</select></td>
							</tr>
							<tr>
								<td>Mã Giáo Viên:</td>
								<td><input type="text" class="input" id="magv" value="${ctttgv.getMaGV()}"
									name="magv" required autocomplete="off" readonly></td>
							</tr>
							<tr>
								<td>Mã Đề Tài:</td>
								<td><input type="text" class="input" id="madt" value="${ctdetai.getMaDT()}"
									name="madt" required autocomplete="off" readonly></td>
							</tr>
							<tr>
								<td>Ngày Đăng ký:</td>
								<td><input type="text" class="input" id="datedk" 
									name="datedk" required autocomplete="off" readonly></td>
							</tr>
							<tr>
								<td>Ghi Chú:</td>
								<td><textarea class="input" id="ghichu" name="ghichu" readonly
										required autocomplete="off">${ctdetai.getGhiChu()} </textarea></td>
							</tr>
							<tr>
								<td><input type="submit" value="Đăng ký" class="button"></td>
								<td></td>
							</tr>
						</table>
						

						
					</form>
				</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<script>
    // Lấy ngày hôm nay
    var today = new Date();

    // Định dạng ngày thành chuỗi YYYY-MM-DD
    var formattedDate = ('0' + today.getDate()).slice(-2) + '-'
                      + ('0' + (today.getMonth() + 1)).slice(-2) + '-'
                      + today.getFullYear();

    // Gán giá trị cho ô nhập liệu
    document.getElementById('datedk').value = formattedDate;
</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>