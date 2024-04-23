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
<title>Duyệt đơn xin gia hạn</title>
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

table {
	border-collapse: collapse;
	width: 80%;
	margin-bottom: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
}

th {
	background-color: #4caf50;
	color: white;
}

tr:hover {
	background-color: #f5f5f5;
	cursor: pointer;
}

#detailContainer {
	width: 80%;
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	margin-top: 20px;
	display: none;
}

/* Chia thành hai cột */
.flex-container {
	display: flex;
	width: 100%;
	justify-content: space-between;
}

.flex-item {
	width: 48%; /* Để lại khoảng trống nhỏ giữa hai cột */
}

button {
	background-color: #4caf50;
	color: #fff;
	padding: 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

button:hover {
	background-color: #45a049;
}

.lyDoHuy {
	display: none;
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
					<h3>Đơn xin gia hạn</h3>
					<div class="flex-container">
						<c:if test="${not empty errorMessage}">
							<div class="alert alert-danger" role="alert">
								${errorMessage}</div>
						</c:if>
						<div class="flex-item">
							<table>
								<thead>
									<tr>
										<th>Mã Đơn</th>
										<th>Ngày Gia Hạn</th>
										<th>Trạng Thái</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="donxin" items="${danhsachdonxin}">
										<tr data-maDon="${donxin.maDon}"
											data-ngayGiaHan="${donxin.ngayGiaHan}"
											data-ngayHoanThanh="${donxin.ngayHoanThanh}"
											data-linkDonXin="${donxin.linkDonXin}"
											data-lyDo="${donxin.lyDo}" data-lyDoHuy="${donxin.lyDoHuy}"
											data-trangThai="${donxin.trangThai}"
											data-maDeTai="${donxin.maDeTai}" data-maGV="${donxin.maGV}"
											data-maPQL="${donxin.maPQL}" onclick="showDetail(this)">
											<td><c:out value="${donxin.maDon}" /></td>
											<%-- <td><c:out value="${donxin.ngayGiaHan}" /></td> --%>
											<td><fmt:parseDate var="localDate"
													value="${donxin.ngayGiaHan}" pattern="yyyy-MM-dd" /> <fmt:formatDate
													value="${localDate}" pattern="dd/MM/yyyy"
													var="formattedDate" /> ${formattedDate}</td>
											<td><c:out value="${donxin.trangThai}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="flex-item">
							<div id="detailContainer">
								<h4>Thông Tin Chi Tiết Đơn Xin Gia Hạn</h4>
								<ul>
									<li><strong>Mã Đơn:</strong> <span id="detailMaDon"></span></li>
									<li><strong>Ngày Gia Hạn:</strong> <span
										id="detailNgayGiaHan"></span></li>
									<li><strong>Ngày Hoàn Thành:</strong> <span
										id="detailNgayHoanThanh"></span></li>
									<li><strong>Link Đơn Xin:</strong> <span
										id="detailLinkDonXin"></span></li>
									<li><strong>Lý Do:</strong> <span id="detailLyDo"></span></li>
									<li><strong>Lý Do Hủy:</strong> <span id="detailLyDoHuy"></span></li>
									<li><strong>Trạng Thái:</strong> <span
										id="detailTrangThai"></span></li>
									<li><strong>Mã Đề Tài:</strong> <span id="detailMaDeTai"></span></li>
									<li><strong>Mã Giáo Viên:</strong> <span id="detailMaGV"></span></li>
									<li><strong>Mã Phòng Quản Lý:</strong> <span
										id="detailMaPQL"></span></li>
								</ul>
								<div id="buttonContainer" class="button-container">
									<button id="duyetButton" class="action-button"
										onclick="approveRequest()">Duyệt</button>
									<button id="tuChoiButton" class="action-button"
										onclick="huyDonXin()">Từ Chối</button>
								</div>
								<div class="lyDoHuy">
									<label for="lyDoHuy">Lý do hủy:</label>
									<textarea id="lyDoHuy" name="lyDoHuy" rows="4" cols="50"></textarea>

									<br>

									<button id="tuChoiButton" class="action-button"
										onclick="rejectRequest()">Hủy đơn xin gia hạn</button>
								</div>

							</div>
						</div>

					</div>
				</main>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>


	<script>
		function showDetail(clickedRow) {
			var maDon = clickedRow.getAttribute("data-maDon");
			var ngayGiaHan = clickedRow.getAttribute("data-ngayGiaHan");
			var ngayHoanThanh = clickedRow.getAttribute("data-ngayHoanThanh");
			var linkDonXin = clickedRow.getAttribute("data-linkDonXin");
			var lyDo = clickedRow.getAttribute("data-lyDo");
			var lyDoHuy = clickedRow.getAttribute("data-lyDoHuy");
			var trangThai = clickedRow.getAttribute("data-trangThai");
			var maDeTai = clickedRow.getAttribute("data-maDeTai");
			var maGV = clickedRow.getAttribute("data-maGV");
			var maPQL = clickedRow.getAttribute("data-maPQL");

			document.getElementById("detailContainer").style.display = "block";
			document.getElementById("detailMaDon").innerText = maDon;
			document.getElementById("detailNgayGiaHan").innerText = ngayGiaHan;
			document.getElementById("detailNgayHoanThanh").innerText = ngayHoanThanh;
			document.getElementById("detailLinkDonXin").innerText = linkDonXin;
			document.getElementById("detailLyDo").innerText = lyDo;
			document.getElementById("detailLyDoHuy").innerText = lyDoHuy;
			document.getElementById("detailTrangThai").innerText = trangThai;
			document.getElementById("detailMaDeTai").innerText = maDeTai;
			document.getElementById("detailMaGV").innerText = maGV;
			document.getElementById("detailMaPQL").innerText = maPQL;

			var buttonContainer = document.getElementById("buttonContainer");
			if (trangThai === "Đã duyệt" || trangThai === "Đã hủy") {
				buttonContainer.style.display = "none";

			} else {
				buttonContainer.style.display = "block";
			}

		}

		function approveRequest() {
			// Thêm logic để xử lý duyệt đơn ở đây

			var NguoiNhan = document.getElementById("detailMaGV").innerText;
			var MaDeTai = document.getElementById("detailMaDeTai").innerText;
			var NgayHoanThanh = document.getElementById("detailNgayGiaHan").innerText;
			var TieuDe = "Duyệt đơn xin gia hạn";
			var NoiDung = "Đơn xin gia hạn của bạn đã được duyệt,....";
			var MaDon = document.getElementById("detailMaDon").innerText
			// Tạo đối tượng chứa dữ liệu để gửi đi
			var data = {
				NguoiNhan : NguoiNhan,
				TieuDe : TieuDe,
				NoiDung : NoiDung,
				MaDon : MaDon,
				MaDeTai : MaDeTai,
				NgayHoanThanh : NgayHoanThanh,
			};

			// Gửi dữ liệu bằng Ajax
			$.ajax({
				type : 'GET',
				url : 'GuiTB', // Thay đổi đường dẫn đến tầng controller của bạn
				data : data,
				success : function(response) {

					window.location.href = "/web_ck/danhsachdonxin";
				},
				error : function(error) {
					// Xử lý lỗi nếu có
					alert('Đã xảy ra lỗi: ' + error);
				}
			});
			$.ajax({
				type : 'GET',
				url : 'duyetdonxingiahan', // Thay đổi đường dẫn đến tầng controller của bạn
				data : data,
				success : function(response) {

					window.location.href = "/web_ck/danhsachdonxin";
				},
				error : function(error) {
					// Xử lý lỗi nếu có
					alert('Đã xảy ra lỗi: ' + error);
				}
			});
		}

		function rejectRequest() {
			var NguoiNhan = document.getElementById("detailMaGV").innerText;
			var TieuDe = "Hủy đơn xin gia hạn";
			var NoiDung = document.getElementById("lyDoHuy").value;
			var MaDon = document.getElementById("detailMaDon").innerText
			// Tạo đối tượng chứa dữ liệu để gửi đi
			console.log('Giá trị của textarea:', NoiDung);
			var data = {
				NguoiNhan : NguoiNhan,
				TieuDe : TieuDe,
				NoiDung : NoiDung,
				MaDon : MaDon
			};

			// Gửi dữ liệu bằng Ajax
			$.ajax({
				type : 'GET',
				url : 'GuiTB', // Thay đổi đường dẫn đến tầng controller của bạn
				data : data,
				success : function(response) {

					window.location.href = "/web_ck/danhsachdonxin";
				},
				error : function(error) {
					// Xử lý lỗi nếu có
					alert('Đã xảy ra lỗi: ' + error);
				}
			});
			$.ajax({
				type : 'GET',
				url : 'huydonxingiahan', // Thay đổi đường dẫn đến tầng controller của bạn
				data : data,
				success : function(response) {

					window.location.href = "/web_ck/danhsachdonxin";
				},
				error : function(error) {
					// Xử lý lỗi nếu có
					alert('Đã xảy ra lỗi: ' + error);
				}
			});
		}
	</script>

	<script>
		function huyDonXin() {
			var lyDoHuyDiv = document.querySelector('.lyDoHuy');

			// Hiển thị hoặc ẩn .lyDoHuy bằng cách thay đổi thuộc tính display
			if (lyDoHuyDiv.style.display === 'none'
					|| lyDoHuyDiv.style.display === '') {
				lyDoHuyDiv.style.display = 'block';
			} else {
				lyDoHuyDiv.style.display = 'none';
			}
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
