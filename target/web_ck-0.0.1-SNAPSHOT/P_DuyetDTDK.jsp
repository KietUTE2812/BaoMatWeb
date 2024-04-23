<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Duyệt đề tài đăng ký</title>
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

					<div class="container-Duyet table-container">
						<h2>Duyệt đề tài đăng ký</h2>
						<c:if test="${not empty errorMessage}">
							<div class="alert alert-danger" role="alert">
								${errorMessage}</div>
						</c:if>
						<table class="table table-bordered">
							<thead class="fixed-header">
								<tr>
									<th scope="col">Mã giảng viên</th>
									<th scope="col">Mã đề tài</th>
									<th scope="col">Ngày đăng ký</th>
									<th scope="col">Ghi chú</th>
									<th scope="col">Trạng thái</th>
									<th scope="col">Mã nhóm</th>

								</tr>
							</thead>
							<tbody>
								<!-- Dữ liệu DeXuatDetai -->
								<c:forEach var="thongBao" items="${danhsachdetaidk}">
									<tr>
										<!-- Các ô dữ liệu -->
										<td><c:out value="${thongBao.maGV}" /></td>
										<td><c:out value="${thongBao.maDeTai}" /></td>
										<%-- <td><c:out value="${thongBao.ngayDangKy}" /></td> --%>
										<td><fmt:parseDate var="localDate"
												value="${thongBao.ngayDangKy}" pattern="yyyy-MM-dd" /> <fmt:formatDate
												value="${localDate}" pattern="dd/MM/yyyy"
												var="formattedDate" /> ${formattedDate}</td>
										<td><c:out value="${thongBao.ghiChu}" /></td>
										<td><c:out value="${thongBao.trangThai}" /></td>
										<td><c:out value="${thongBao.maNhom}" /></td>

										<td>
											<button type="button" class="btn btn-success" data-toggle="modal"
												data-target="#duyetModal" id="editDeTaiModalBtn"
												onclick="Duyet(this)"
												${thongBao.trangThai eq 'Đã duyệt' || thongBao.trangThai eq 'Đã hủy' ? 'disabled' : ''}>Duyệt</button>
										</td>
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
												<label for="TenDT">Mã đề tài:</label> <input type="text"
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
				
				<div class="DuyetDeTai">

						<!-- Modal -->
						<div class="modal fade" id="duyetModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Duyệt đề tài
											đề xuất</h5>

									</div>
									<div class="modal-body">
										<!-- Form gửi thông báo có thể thêm ở đây -->
										<form>

											<div class="form-group">
												<label for="duyetTenDT">Mã đề tài:</label> <input type="text"
													class="form-control" id="duyetTenDT" name="duyetTenDT" value=""
													readonly>
											</div>

											<div class="form-group">
												<label for="duyetMaGV">Mã giảng viên:</label> <input type=text
													"
													class="form-control" id="duyetMaGV" name="duyetMaGV"
													value="" readonly>
											</div>

											<div class="form-group">
												<label for="duyetTieuDe">Tiêu đề:</label> <input type="text"
													class="form-control" id="duyetTieuDe" name="duyetTieuDe" required>
											</div>

											<div class="form-group">
												<label for="duyetNoiDung">Nội dung(kèm link minh chứng):
												</label>
												<textarea type="text" class="form-control" id="duyetNoiDung"
													name="duyetNoiDung" rows="4"></textarea>
											</div>

											<button type="button" class="btn btn-success btnHUY"
												onclick="GuiTbDuyet()">Gửi</button>

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
	function GuiTbHuy() {
	    var maDeTai = $('#TenDT').val();
	    var maGV = $('#MaGV').val();
	    var tieuDe = $('#TieuDe').val();
	    var noiDung = $('#NoiDung').val();
	    

	    // Sửa lại tên biến thành tiêuDe và noiDung
	    var data = {
	        NguoiNhan: maGV,
	        TieuDe: tieuDe,
	        NoiDung: noiDung,
	        maDeTai: maDeTai,
	        maGV: maGV
	    };

	    $.ajax({
	        type: 'GET',
	        url: 'GuiTB', // Thay đổi đường dẫn đến tầng controller của bạn
	        data: data,
	        success: function(response) {
	            
	        },
	        error: function(error) {
	            // Xử lý lỗi nếu có
	            alert('Đã xảy ra lỗi: ' + error);
	        }
	    });
	    $.ajax({
			type : 'GET',
			url : 'huyDTDK', // Thay đổi đường dẫn đến tầng controller của bạn
			data : data,
			success : function(response) {
				
				window.location.href = "/web_ck/danhsachdetaidk";
			},
			error : function(error) {
				// Xử lý lỗi nếu có
				alert('Đã xảy ra lỗi: ' + error);
			}
		});
	}
	function GuiTbDuyet() {
	    var maDeTai = $('#duyetTenDT').val();
	    var maGV = $('#duyetMaGV').val();
	    var tieuDe = $('#duyetTieuDe').val();
	    var noiDung = $('#duyetNoiDung').val();
	    

	    // Sửa lại tên biến thành tiêuDe và noiDung
	    var data = {
	        NguoiNhan: maGV,
	        TieuDe: tieuDe,
	        NoiDung: noiDung,
	        maDeTai: maDeTai,
	        maGV: maGV
	    };

	    $.ajax({
	        type: 'GET',
	        url: 'GuiTB', // Thay đổi đường dẫn đến tầng controller của bạn
	        data: data,
	        success: function(response) {
	            
	        },
	        error: function(error) {
	            // Xử lý lỗi nếu có
	            alert('Đã xảy ra lỗi: ' + error);
	        }
	    });
	    $.ajax({
			type : 'GET',
			url : 'duyetDTDK', // Thay đổi đường dẫn đến tầng controller của bạn
			data : data,
			success : function(response) {
				
				window.location.href = "/web_ck/danhsachdetaidk";
			},
			error : function(error) {
				// Xử lý lỗi nếu có
				alert('Đã xảy ra lỗi: ' + error);
			}
		});
	}
	</script>



	<!-- <script>
		function Duyet(button) {
			var row = button.closest('tr');
			var maDeTai = row.cells[1].innerText;
			var maGV = row.cells[0].innerText;
			alert("Đã duyet de tai dang ky " + maDeTai + maGV);
			var TieuDe = "Duyệt đề tài đăng ký";
			var NoiDung = "Đề tài bạn đănng ký đã được duyệt.";

			// Tạo đối tượng chứa dữ liệu để gửi đi
			var data = {
				NguoiNhan : maGV,
				TieuDe : TieuDe,
				NoiDung : NoiDung,
				maDeTai : maDeTai,
				maGV : maGV
			};

			// Gửi dữ liệu bằng Ajax
			$.ajax({
				type : 'GET',
				url : 'GuiTB', // Thay đổi đường dẫn đến tầng controller của bạn
				data : data,
				success : function(response) {
					alert("Đã gửi thông báo duyệt đề tài đăng ký");

				},
				error : function(error) {
					// Xử lý lỗi nếu có
					alert('Đã xảy ra lỗi: ' + error);
				}
			});
			$.ajax({
				type : 'GET',
				url : 'duyetDTDK', // Thay đổi đường dẫn đến tầng controller của bạn
				data : data,
				success : function(response) {
					alert("Đã duyệt");
					window.location.href = "/web_ck/danhsachdetaidk";
				},
				error : function(error) {
					// Xử lý lỗi nếu có
					alert('Đã xảy ra lỗi: ' + error);
				}
			});
		}
	</script> -->
	<script>
		function editRow(button) {
			var row = button.closest('tr');
			var maDeTai = row.cells[1].innerText;
			var maGV = row.cells[0].innerText;

			$('#editModal #MaGV').val(maGV);
			$('#editModal #TenDT').val(maDeTai);

		}
		function Duyet(button) {
			var row = button.closest('tr');
			var maDeTai = row.cells[1].innerText;
			var maGV = row.cells[0].innerText;

			$('#duyetModal #duyetMaGV').val(maGV);
			$('#duyetModal #duyetTenDT').val(maDeTai);

		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
