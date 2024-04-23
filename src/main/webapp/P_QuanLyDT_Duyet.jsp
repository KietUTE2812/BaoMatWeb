<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý đề tài đề xuất</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>


<style>
.main-panel {
	padding: 20px; /* Thêm padding để không bị lộn màu nền vào mép */
	max-height: 100%
}

.quaylai-container {
	display: flex;
	justify-content: flex-end;
}

.btnHUY {
	align-self: center;
	margin-top: 10px;
}

.table-container {
	max-height: 600px; /* Đặt chiều cao tối đa cho phần tbody */
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

					<div class="container-Duyet ">
						<h2>Danh sách đề tài được đề xuất</h2>
						<c:if test="${not empty errorMessage}">
							<div class="alert alert-danger" role="alert">
								${errorMessage}</div>
						</c:if>
						<a href="<%=request.getContextPath()%>/xemdexuatdetai"
							class="btn btn-success">Làm mới</a>
							<br>
						<div class="table-container">
							<table class="table table-bordered">
								<thead class="fixed-header">
									<tr>
										<th scope="col">Mã GV</th>
										<th scope="col">Mã Phòng QL</th>
										<th scope="col">Tên Đề Tài</th>
										<th scope="col">Mô Tả</th>
										<th scope="col">Kinh Phí Dự Kiến</th>
										<th scope="col">Lý Do</th>
										<th scope="col">Trạng Thái Duyệt</th>
										<th scope="col">Ngày Đề Xuất</th>
										<th scope="col">Link đính kèm</th>

										<th scope="col"></th>
										<th scope="col"></th>
									</tr>
								</thead>
								<tbody>
									<!-- Dữ liệu DeXuatDetai -->
									<c:forEach var="thongBao" items="${dt}">
										<tr data-maGV="${thongBao.maGV}"
											data-maPhongQL="${thongBao.maPhongQL}"
											data-tenDeTai="${thongBao.tenDeTai}"
											data-moTa="${thongBao.moTa}"
											data-kinhPhi="${thongBao.kinhPhi}"
											data-lyDo="${thongBao.lyDo}"
											data-trangThai="${thongBao.trangThai}"
											data-ngayThucHien="${thongBao.ngayThucHien}">
											<!-- Các ô dữ liệu -->
											<td><c:out value="${thongBao.maGV}" /></td>
											<td><c:out value="${thongBao.maPhongQL}" /></td>
											<td><c:out value="${thongBao.tenDeTai}" /></td>
											<td><c:out value="${thongBao.moTa}" /></td>
											<td><c:out value="${thongBao.kinhPhi}" /></td>
											<td><c:out value="${thongBao.lyDo}" /></td>
											<td><c:out value="${thongBao.trangThai}" /></td>

											<%-- <td><c:out value="${thongBao.ngayThucHien}" /></td> --%>
											<td><fmt:parseDate var="localDate"
													value="${thongBao.ngayThucHien}" pattern="yyyy-MM-dd" /> <fmt:formatDate
													value="${localDate}" pattern="dd/MM/yyyy"
													var="formattedDate" /> ${formattedDate}</td>
											<td><c:out value="${thongBao.linkdinhkem}" /></td>
											<td><input type="hidden" name="action"
												value="EmailDuyet">
												<button type="button" class="btn btn-success"
													onclick="Duyet(this)"
													${thongBao.trangThai eq 'Đã duyệt' || thongBao.trangThai eq 'Đã hủy' ? 'disabled' : ''}>Duyệt</button></td>
											<td>
												<button class="btn btn-danger" data-toggle="modal"
													data-target="#editModal" id="editDeTaiModalBtn"
													onclick="editRow(this)"
													${thongBao.trangThai eq 'Đã duyệt' || thongBao.trangThai eq 'Đã hủy' ? 'disabled' : ''}>Hủy</button>
											</td>
										</tr>
									</c:forEach>
									<!-- Thêm các hàng khác nếu cần -->
								</tbody>
							</table>
						</div>
					</div>

					<div class="HuyDeTai">

						<!-- Modal -->
						<div class="modal fade" id="editModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Hủy đề tài
											đề xuất</h5>

									</div>
									<div class="modal-body">
										<!-- Form gửi thông báo có thể thêm ở đây -->
										<form>

											<div class="form-group">
												<label for="TenDT">Tên đề tài:</label> <input type="text"
													class="form-control" id="TenDT" name="TenDT" value=""
													readonly>
											</div>

											<div class="form-group">
												<label for="MaGV">Mã giảng viên:</label> <input type=text
													"
													class="form-control" id="MaGV" name="MaGV"
													value="" readonly>
											</div>

											<div class="form-group">
												<label for="TieuDe">Tiêu đề:</label> <input type="text"
													class="form-control" id="TieuDe" name="TieuDe" required>
											</div>

											<div class="form-group">
												<label for="NoiDung">Nội dung(kèm link minh chứng):
												</label>
												<textarea type="text" class="form-control" id="NoiDung"
													name="NoiDung" rows="4"></textarea>
											</div>

											<button type="button" class="btn btn-success btnHUY"
												onclick="GuiTbHuy()">Gửi</button>

										</form>
									</div>

								</div>
							</div>
						</div>
					</div>




				</main>
			</div>
		</div>
	</div>
	<script>
		function unacceptRow(this) {
			var row = button.closest('tr');
			var maDeTai = row.cells[0].innerText;

			$.ajax({
				type : "GET",
				url : "XoaDeTai",
				data : {
					maDeTai : maDeTai
				},
				success : function(response) {
					
					window.location.href = "/web_ck/DeTai";
					
				},
				error : function(error) {
					console.log(error);
				}
			});
		}
	</script>
	<script>

	function QuayLaiDeTai() {
		// Chuyển hướng trang sử dụng JavaScript
		
		window.location.href = "/web_ck/DeTai";
	}
	</script>
	<script>
	function GuiTbHuy() {
		// Lấy giá trị từ các trường nhập liệu
		var tenDeTai = $('#TenDT').val();
		var maGV = $('#MaGV').val();
		var tieuDe = $('#TieuDe').val();
		var noiDung = $('#NoiDung').val();

		// Tạo đối tượng chứa dữ liệu để gửi đi
		var data = {
			tenDeTai: tenDeTai,
			maGV: maGV,
			tieuDe: tieuDe,
			noiDung: noiDung
		};

		// Gửi dữ liệu bằng Ajax
		$.ajax({
			type: 'GET',
			url: 'EmailHuy', // Thay đổi đường dẫn đến tầng controller của bạn
			data: data,
			success: function(response) {
				
				window.location.href = "/web_ck/duyetdexuatdetai";
			},
			error: function(error) {
				// Xử lý lỗi nếu có
				alert('Đã xảy ra lỗi: ' + error);
			}
		});
		$.ajax({
			type: 'GET',
			url: 'HuyDeTai', // Thay đổi đường dẫn đến tầng controller của bạn
			data: data,
			success: function(response) {
				
	        	window.location.href = "/web_ck/duyetdexuatdetai";
			},
			error: function(error) {
				// Xử lý lỗi nếu có
				alert('Đã xảy ra lỗi: ' + error);
			}
		}); 
	}
</script>



	<script>
	function Duyet(button) {
		
		var row = button.closest('tr');

	    // Lấy dữ liệu từ thuộc tính data-*
	    var maGV = row.getAttribute('data-maGV');
	    var maPhongQL = row.getAttribute('data-maPhongQL');
	    var tenDeTai = row.getAttribute('data-tenDeTai');
	    var moTa = row.getAttribute('data-moTa');
	    var kinhPhi = row.getAttribute('data-kinhPhi');
	    var lyDo = row.getAttribute('data-lyDo');
	    var trangThai = row.getAttribute('data-trangThai');
	    var ngayThucHien = row.getAttribute('data-ngayThucHien');
	    var actionValue = row.querySelector('input[name="action"]').value;

	    // Sử dụng giá trị actionValue theo nhu cầu của bạn
	    

	    // Gửi dữ liệu đi qua Ajax
	    $.ajax({
	        type: "GET", // hoặc "GET" tùy thuộc vào cách bạn xử lý trên server
	        url: "DuyetDeTai", // Thay thế bằng URL xử lý dữ liệu trên server
	        data: {
	            maGV: maGV,
	            maPhongQL: maPhongQL,
	            tenDeTai: tenDeTai,
	            moTa: moTa,
	            kinhPhi: kinhPhi,
	            lyDo: lyDo,
	            trangThai: trangThai,
	            actionValue: actionValue
	            
	        },
			success : function(response) {
				document.cookie = "cache-control=no-store; max-age=0";
				window.location.href = "/web_ck/duyetdexuatdetai";
			},
	        error: function (error) {
	            console.log(error);
	        }
	    });
	    $.ajax({
	        type: "GET",
	        url: "EmailDuyet",
	        data: {
	        	maGV: maGV
	        },
	        success: function (response) {
	            
	        	window.location.href = "/web_ck/duyetdexuatdetai";
	        },
	        error: function (error) {
	            // Xử lý lỗi nếu có
	            console.log(error);
	        }
	    });
	}
	</script>
	<script>
		function editRow(button) {
			var row = $(button).closest('tr');
		    var maGV = row.attr('data-maGV');
		    var tenDeTai = row.attr('data-tenDeTai');
		   
		    $('#editModal #MaGV').val(maGV);
		    $('#editModal #TenDT').val(tenDeTai);
		   

		}

		
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
