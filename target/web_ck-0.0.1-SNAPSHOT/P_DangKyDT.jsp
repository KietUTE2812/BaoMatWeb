<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="Model.P_ThongBaoModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý đợt nghiên cứu khoa học</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<!-- <title>Tạo Đợt Nghiên Cứu Khoa Học</title> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/vis/4.21.0/vis.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/vis/4.21.0/vis.min.js"></script>

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

body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

#timeline {
	height: 150px;
}

form {
	max-width: 600px;
	margin: 20px auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	display: none;
}

label {
	display: block;
	margin-bottom: 8px;
	font-weight: bold;
}

input, select {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

button {
	background-color: #4caf50;
	color: #fff;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-top: 20px;
}

button:hover {
	background-color: #45a049;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

th {
	background-color: #f2f2f2;
}

.update {
	margin-top: 20px;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>


	<div class="container-fluid">
		<div class="row">

			<div class="col-md-2">
				<jsp:include page="P_sidebar.jsp"></jsp:include>
			</div>


			<div class="col-md-10">

				<main class="main-panel">
					<!-- <div id="timeline"></div>
 -->

					<c:if test="${not empty errorMessage}">
						<div class="alert alert-danger" role="alert">
							${errorMessage}</div>
					</c:if>

					<div class="table-container">
						<h2>Thông Tin Đợt Nghiên Cứu</h2>

						<table id="dsdot">
							<tr>
								<th>Mã Đợt</th>
								<th>Trạng Thái</th>
								<th>Ngày Mở Đăng Ký</th>
								<th>Ngày Đóng Đăng Ký</th>
								<th>Ngày Mở Thực Hiện</th>
								<th>Ngày Đóng Thực Hiện</th>
								<th>Ngày Mở Báo Cáo</th>
								<th>Ngày Đóng Báo Cáo</th>
								<th>Ngày Mở Nghiệm Thu</th>
								<th>Ngày Đóng Nghiệm Thu</th>
								<th>Ngày Đóng Đợt</th>
							</tr>
							<c:forEach var="dot" items="${dots}">
								<tr data-maDot="${dot.maDot}" onclick="showDetail(this)"
									data-trangThai="${dot.trangThaiDot}"
									data-ngayMoDangKy="${dot.ngaymodk}"
									data-ngayDongDangKy="${dot.ngaydongdk}"
									data-ngayMoThucHien="${dot.ngaymoth}"
									data-ngayDongThucHien="${dot.ngaydongth}"
									data-ngayMoBaoCao="${dot.ngaymobc}"
									data-ngayDongBaoCao="${dot.ngaydongbc}"
									data-ngayMoNghiemThu="${dot.ngaymont}"
									data-ngayDongNghiemThu="${dot.ngaydongnt}"
									data-ngayDongDot="${dot.ngaydongdot}"
									onclick="showDetail(this)">
									<td value="madot">${dot.maDot}</td>
									<td>${dot.trangThaiDot}</td>
									<td><fmt:parseDate var="localDate" value="${dot.getNgaymodk()}"
											pattern="yyyy-MM-dd" /> <fmt:formatDate value="${localDate}"
											pattern="dd/MM/yyyy" var="formattedDate" /> ${formattedDate}
									</td>

									<td><fmt:parseDate var="localDate"
											value="${dot.getNgaydongdk()}" pattern="yyyy-MM-dd" /> <fmt:formatDate
											value="${localDate}" pattern="dd/MM/yyyy" var="formattedDate" />
										${formattedDate}</td>

									<td><fmt:parseDate var="localDate" value="${dot.getNgaymoth()}"
											pattern="yyyy-MM-dd" /> <fmt:formatDate value="${localDate}"
											pattern="dd/MM/yyyy" var="formattedDate" /> ${formattedDate}
									</td>

									<td><fmt:parseDate var="localDate"
											value="${dot.getNgaydongth()}" pattern="yyyy-MM-dd" /> <fmt:formatDate
											value="${localDate}" pattern="dd/MM/yyyy" var="formattedDate" />
										${formattedDate}</td>

									<td><fmt:parseDate var="localDate" value="${dot.getNgaymobc()}"
											pattern="yyyy-MM-dd" /> <fmt:formatDate value="${localDate}"
											pattern="dd/MM/yyyy" var="formattedDate" /> ${formattedDate}
									</td>

									<td><fmt:parseDate var="localDate"
											value="${dot.getNgaydongbc()}" pattern="yyyy-MM-dd" /> <fmt:formatDate
											value="${localDate}" pattern="dd/MM/yyyy" var="formattedDate" />
										${formattedDate}</td>

									<td><fmt:parseDate var="localDate" value="${dot.getNgaymont()}"
											pattern="yyyy-MM-dd" /> <fmt:formatDate value="${localDate}"
											pattern="dd/MM/yyyy" var="formattedDate" /> ${formattedDate}
									</td>

									<td><fmt:parseDate var="localDate"
											value="${dot.getNgaydongnt()}" pattern="yyyy-MM-dd" /> <fmt:formatDate
											value="${localDate}" pattern="dd/MM/yyyy" var="formattedDate" />
										${formattedDate}</td>

									<td><fmt:parseDate var="localDate"
											value="${dot.getNgaydongdot()}" pattern="yyyy-MM-dd" /> <fmt:formatDate
											value="${localDate}" pattern="dd/MM/yyyy" var="formattedDate" />
										${formattedDate}</td>

								</tr>
							</c:forEach>
						</table>


					</div>
					<div class="update" id="updateDetails"
						style="display: none; margin-top: 20px;">
						<!-- Thêm các input để người dùng có thể sửa thông tin -->
						<h4>Chỉnh sửa thông tin chi tiết của đợt</h4>
						<label for="maDot">Mã Đợt:</label> 
						
						<input type="text"
							id="detailMaDot" readonly>
							
							 <label for="trangThai">Trạng
							Thái:</label> 
							<select name="detailTrangThai"
									id="detailTrangThai" class="input">
										<option value="Đã đóng"
											<c:if test="${dot.trangThaiDot eq 'Đã đóng'}">selected</c:if>>Đã đóng</option>
										<option value="Đang mở"
											<c:if test="${dot.trangThaiDot eq 'Đang mở'}">selected</c:if>>Đang mở</option>
											</select>
							
							<!-- <input type="text" id="detailTrangThai" required> -->
							
							 <label
							for="ngayMoDangKy">Ngày mở đăng ký:</label> <input type="date"
							id="detailNgayMoDangKy" required> <label
							for="ngayDongDangKy">Ngày đóng đăng ký:</label> <input
							type="date" id="detailNgayDongDangKy" required> <label
							for="ngayMoThucHien">Ngày mở thực hiện:</label> <input
							type="date" id="detailNgayMoThucHien" required> <label
							for="ngayDongThucHien">Ngày đóng thực hiện:</label> <input
							type="date" id="detailNgayDongThucHien" required> <label
							for="ngayMoBaoCao">Ngày mở báo cáo:</label> <input type="date"
							id="detailNgayMoBaoCao" required> <label
							for="ngayDongBaoCao">Ngày đóng báo cáo:</label> <input
							type="date" id="detailNgayDongBaoCao" required> <label
							for="ngayMoNghiemThu">Ngày mở nghiệm thu:</label> <input
							type="date" id="detailNgayMoNghiemThu" required> <label
							for="ngayDongNghiemThu">Ngày đóng nghiệm thu:</label> <input
							type="date" id="detailNgayDongNghiemThu" required> <label
							for="ngayDongDot">Ngày đóng đợt:</label> <input type="date"
							id="detailNgayDongDot" required>
						<button onclick="saveUpdatedData()">Lưu thay đổi</button>
						<button onclick="huy()">Hủy</button>
					</div>

					<button id="btnTaoDot" onclick="toggleForm()">Tạo Đợt
						Nghiên Cứu</button>

					<br>
					<form id="createResearchForm">
						<h2>Tạo Đợt Nghiên Cứu Khoa Học</h2>
						<label for="maDot">Mã Đợt:</label> <input type="text" id="maDot"
							name="maDot" required> <label for="trangThai">Trạng
							Thái:</label> <input type="text" id="trangThai" name="trangThai" required>

						<label for="ngayMoDangKy">Ngày Mở Đăng Ký:</label> <input
							type="date" id="ngayMoDangKy" name="ngayMoDangKy" required>

						<label for="ngayMoThucHien">Ngày Mở Thực Hiện:</label> <input
							type="date" id="ngayMoThucHien" name="ngayMoThucHien" required>

						<label for="ngayMoBaoCao">Ngày Mở Báo Cáo:</label> <input
							type="date" id="ngayMoBaoCao" name="ngayMoBaoCao" required>

						<label for="ngayMoNghiemThu">Ngày Mở Nghiệm Thu:</label> <input
							type="date" id="ngayMoNghiemThu" name="ngayMoNghiemThu" required>

						<label for="ngayDongDot">Ngày Đóng Đợt:</label> <input type="date"
							id="ngayDongDot" name="ngayDongDot" required>

						<button type="button" onclick="createResearch()">Tạo</button>
					</form>

				</main>
			</div>
		</div>
	</div>
	<%-- <%
	// Gọi phương thức để lấy số lượng trạng thái đang mở từ session
	int slTrangThai = (Integer) session.getAttribute("sltrangthai");
	%>
	<script>
		window.onload = function() {
			var sl =
	<%=slTrangThai%>
		;
			console.log("sl " + sl);

			var btnTaoDot = document.getElementById("btnTaoDot");

			if (sl > 0) {
				btnTaoDot.style.display = 'none'; // Ẩn nút
			} else {
				btnTaoDot.style.display = 'block'; // Hiện nút
			}
		};
	</script> --%>


	<script>
		function updateSLTrangThai() {
			$.ajax({
				type : "GET",
				url : "sltrangthai", // Điều chỉnh URL cho API của bạn
				success : function(data) {
					var sl = parseInt(data); // Giả sử API trả về một chuỗi số

					console.log("sl::: " + sl);
					var btnTaoDot = document.getElementById("btnTaoDot");

					if (sl > 0) {
						btnTaoDot.style.display = 'none'; // Ẩn nút
					} else {
						btnTaoDot.style.display = 'block'; // Hiện nút
					}
				},
				error : function() {
					console.error("Không thể lấy giá trị mới.");
				}
			});
		}

		// Gọi hàm khi trang được tải
		window.onload = function() {
			updateSLTrangThai();
		};
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

	<script>
		// Hàm hiển thị chi tiết đợt khi nhấn vào hàng tương ứng
		function showDetail(clickedRow) {
			console.log(clickedRow);

			// Log the maDot value to check if it's null or has the expected value

			var maDot = clickedRow.getAttribute("data-maDot");
			var trangThai = clickedRow.getAttribute("data-trangThai");
			var ngayMoDangKy = clickedRow.getAttribute("data-ngayMoDangKy");
			var ngayDongDangKy = clickedRow.getAttribute("data-ngayDongDangKy");
			var ngayMoThucHien = clickedRow.getAttribute("data-ngayMoThucHien");
			var ngayDongThucHien = clickedRow
					.getAttribute("data-ngayDongThucHien");
			var ngayMoBaoCao = clickedRow.getAttribute("data-ngayMoBaoCao");
			var ngayDongBaoCao = clickedRow.getAttribute("data-ngayDongBaoCao");
			var ngayMoNghiemThu = clickedRow
					.getAttribute("data-ngayMoNghiemThu");
			var ngayDongNghiemThu = clickedRow
					.getAttribute("data-ngayDongNghiemThu");
			var ngayDongDot = clickedRow.getAttribute("data-ngayDongDot");

			console.log("ct: " + maDot);

			// Hiển thị giá trị lên form chi tiết
			$("#detailMaDot").val(maDot);
			$("#detailTrangThai").val(trangThai);
			$("#detailNgayMoDangKy").val(ngayMoDangKy);
			$("#detailNgayDongDangKy").val(ngayDongDangKy);
			$("#detailNgayMoThucHien").val(ngayMoThucHien);
			$("#detailNgayDongThucHien").val(ngayDongThucHien);
			$("#detailNgayMoBaoCao").val(ngayMoBaoCao);
			$("#detailNgayDongBaoCao").val(ngayDongBaoCao);
			$("#detailNgayMoNghiemThu").val(ngayMoNghiemThu);
			$("#detailNgayDongNghiemThu").val(ngayDongNghiemThu);
			$("#detailNgayDongDot").val(ngayDongDot);

			// Hiển thị chi tiết đợt
			$("#updateDetails").show();
			// Hiển thị chi tiết đợt
			document.getElementById('updateDetails').style.display = 'block';
		}

		function huy() {
			document.getElementById('updateDetails').style.display = 'none';
		}
		function saveUpdatedData() {
			var maDot = document.getElementById('detailMaDot').value;
			var trangThai = document.getElementById('detailTrangThai').value;
			var ngayMoDangKy = document.getElementById('detailNgayMoDangKy').value;
			var ngayDongDangKy = document
					.getElementById('detailNgayDongDangKy').value;
			var ngayMoThucHien = document
					.getElementById('detailNgayMoThucHien').value;
			var ngayDongThucHien = document
					.getElementById('detailNgayDongThucHien').value;
			var ngayMoBaoCao = document.getElementById('detailNgayMoBaoCao').value;
			var ngayDongBaoCao = document
					.getElementById('detailNgayDongBaoCao').value;
			var ngayMoNghiemThu = document
					.getElementById('detailNgayMoNghiemThu').value;
			var ngayDongNghiemThu = document
					.getElementById('detailNgayDongNghiemThu').value;
			var ngayDongDot = document.getElementById('detailNgayDongDot').value;

			// Tạo đối tượng chứa dữ liệu
			var data = {
				maDot : maDot,
				trangThai : trangThai,
				ngayMoDangKy : ngayMoDangKy,
				ngayDongDangKy : ngayDongDangKy,
				ngayMoThucHien : ngayMoThucHien,
				ngayDongThucHien : ngayDongThucHien,
				ngayMoBaoCao : ngayMoBaoCao,
				ngayDongBaoCao : ngayDongBaoCao,
				ngayMoNghiemThu : ngayMoNghiemThu,
				ngayDongNghiemThu : ngayDongNghiemThu,
				ngayDongDot : ngayDongDot
			};
			$.ajax({
				type : 'GET',
				url : 'thaydoidot', // Thay đổi đường dẫn đến tầng controller của bạn
				data : data,
				success : function(response) {
					if (response.error) {
						alert('Đã xảy ra lỗi khi chỉnh sửa' );
					} else {
						// Xử lý logic khi không có lỗi
						window.location.href = "/web_ck/danhsachdot";
					}
				},
				error : function(error) {
					// Xử lý lỗi nếu có
					alert('Đã xảy ra lỗi: ' + error);
				}
			});
		}
	</script>

	<script>
		function toggleForm() {

			var form = document.getElementById('createResearchForm');
			form.style.display = (form.style.display === 'none' || form.style.display === '') ? 'block'
					: 'none';
		}

		function createResearch() {
			// Lấy giá trị từ form
			var maDot = document.getElementById('maDot').value;
			var trangThai = document.getElementById('trangThai').value;
			var ngayMoDangKy = document.getElementById('ngayMoDangKy').value;

			var ngayMoThucHien = document.getElementById('ngayMoThucHien').value;

			var ngayMoBaoCao = document.getElementById('ngayMoBaoCao').value;

			var ngayMoNghiemThu = document.getElementById('ngayMoNghiemThu').value;

			var ngayDongDot = document.getElementById('ngayDongDot').value;
			var data = {
				maDot : maDot,
				trangThai : trangThai,
				ngayMoDangKy : ngayMoDangKy,
				ngayMoThucHien : ngayMoThucHien,
				ngayMoBaoCao : ngayMoBaoCao,
				ngayMoNghiemThu : ngayMoNghiemThu,
				ngayDongDot : ngayDongDot,
			}
			// Kiểm tra và xử lý dữ liệu
			if (maDot && trangThai && ngayMoDangKy && ngayDongDangKy
					&& ngayMoThucHien && ngayDongThucHien && ngayMoBaoCao
					&& ngayDongBaoCao && ngayMoNghiemThu && ngayDongNghiemThu
					&& ngayDongDot) {
				// Thực hiện hành động tạo đợt nghiên cứu (có thể là gửi dữ liệu đến server)
				$.ajax({
					type : 'GET',
					url : 'taodot', // Thay đổi đường dẫn đến tầng controller của bạn
					data : data,
					success : function(response) {

						window.location.href = "/web_ck/danhsachdot";
					},
					error : function(error) {
						// Xử lý lỗi nếu có
						alert('Đã xảy ra lỗi: ' + error);
					}
				});
			} else {
				alert('Vui lòng nhập đầy đủ thông tin.');
			}
		}
	</script>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
