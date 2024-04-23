<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đề xuất đề tài</title>
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
					<c:if test="${not empty errDX}">
						<div class="alert alert-danger" role="alert">
							${errDX}</div>
					</c:if>
					<form id="form" class="form" data-form="form-1" method="post"
						action="<%=request.getContextPath()%>/GV/dxdt">
						<h3>Đề Xuất Đề Tài</h3>
						<table>
							<tr>
								<td>Mã Giáo Viên:</td>
								<td><input type="text" class="input" id="magv" value="${ctttgv.getMaGV()}" readonly
									name="magv" required autocomplete="off"></td>
							</tr>
							
							<tr>
								<td>Tên Đề Tài:</td>
								<td><input type="text" class="input" id="name"
									name="name" required autocomplete="off"></td>
							</tr>
							<tr>
								<td>Link đề xuất đề tài</td>
								<td><input type="text" class="input" id="link"
									name="link" required autocomplete="off"></td>
							</tr>
							<tr>
								<td>Kinh Phí:</td>
								<td><div class="input-group">
										<input type="text" id="tien" name="tien" class="form-control" required autocomplete="off"
											aria-label="Số tiền (với dấu chấm)"
											onkeyup="formatCurrency(this)"> <span
											class="input-group-text">₫</span>
										<div id="invalidMessage" style="color: red;"></div>
									</div></td>
							</tr>
							<tr>
								<td>Mô tả:</td>
								<td><textarea class="input" id="mota" name="mota" 
										required autocomplete="off"></textarea></td>

							</tr>
							<tr>
								<td></td>
								<td><input onclick="checkInput()" type="button" value="Xác nhận đề xuất" class="button mt-3"
							></td>

							</tr>

						</table>


						
					</form>
					<script>
						function checkInput() {
							var myInput = document.getElementById('tien').value;
							var myForm = document.getElementById('form');
							console.log(myInput);
							if (myInput === "") {
								alert('Vui lòng nhập giá trị.');
								return false;
							}
							else 
								{  
								myForm.submit();
								}
							return true;
						}
						function formatCurrency(input) {
							// Lấy giá trị từ trường nhập
							let value = input.value;

							// Kiểm tra nếu số đầu tiên là 0
							if (value.startsWith('0')) {
								document.getElementById('invalidMessage').innerText = 'Số không hợp lệ. Số đầu tiên không thể là 0.';
								return;
							}

							// Xóa các ký tự không phải số
							value = value.replace(/[^0-9]/g, '');

							// Thêm dấu chấm sau mỗi 3 số 0
							value = value.replace(/\B(?=(\d{3})+(?!\d))/g, '.');

							// Cập nhật giá trị vào trường nhập
							input.value = value;

							// Xóa thông báo nếu có
							document.getElementById('invalidMessage').innerText = '';
						}
					</script>
				</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>