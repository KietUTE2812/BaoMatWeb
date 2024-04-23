<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý đề tài</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>




<style>
.main-panel {
	padding: 20px; /* Thêm padding để không bị lộn màu nền vào mép */
	max-height: 100%
}

.selected-row {
	background-color: #cce5ff; /* Màu nền khi được chọn */
}

.Add {
	display: flex;
	justify-content: flex-end;
}

.DanhsachDT {
	max-height: 500px; /* Đặt chiều cao tối đa cho phần tbody */
	overflow-y: auto;
}

.DanhsachDT td {
	max-width: 200px;
	word-wrap: break-word;
}

.fixed-header th {
	position: sticky;
	top: 0;
	background-color: #f5f5f5; /* Màu nền cho header cố định */
}

.btn-accept {
	background-color: green;
	margin-left: 20px;
	color: white;
}

.ThemDeTai {
	margin-top: 10px;
	display: flex;
	justify-content: flex-end;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<!-- Sidebar (3 cột) -->
			<div class="col-md-2">
				<jsp:include page="P_sidebar.jsp"></jsp:include>
			</div>

			<!-- Nội dung (9 cột) -->
			<div class="col-md-10">
				<main class="main-panel">
					<h3>Danh sách đề tài</h3>
					<c:if test="${not empty errorMessage}">
						<div class="alert alert-danger" role="alert">
							${errorMessage}</div>
					</c:if>
						<a href="<%=request.getContextPath()%>/DeTai"
										class="btn btn-success">Làm mới</a>
					<div class="DanhsachDT">

						<table class="table table-bordered">
							<thead class="fixed-header">
								<tr>
									<th scope="col">Mã Đề Tài</th>
									<th scope="col">Tên Đề Tài</th>
									<th scope="col">Ghi Chú</th>
									<th scope="col">Ngày Thực Hiện</th>
									<th scope="col">Ngày Kết thúc</th>
									<th scope="col">Kinh phí dự kiến</th>
									<th scope="col">Kết quả</th>
									<th scope="col">Link nộp bài</th>
									<th scope="col">Ngày nộp</th>
									<th scope="col">Trạng Thái</th>
									<th scope="col">Thao Tác</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<!-- Dữ liệu đề tài -->
								<c:forEach var="dt" items="${dtai}">

									<tr>
										<td><c:out value="${dt.maDetai}" /></td>
										<td><c:out value="${dt.tenDeTai}" /></td>
										<td><c:out value="${dt.ghiChu}" /></td>
										<%-- <td><c:out value="${dt.ngayThucHien}" /></td>
										<td><c:out value="${dt.ngayKetThuc}" /></td> --%>
										<td><fmt:parseDate var="localDate"
												value="${dt.ngayThucHien}" pattern="yyyy-MM-dd" /> <fmt:formatDate
												value="${localDate}" pattern="dd/MM/yyyy"
												var="formattedDate" /> ${formattedDate}</td>
										<td><fmt:parseDate var="localDate1"
												value="${dt.ngayKetThuc}" pattern="yyyy-MM-dd" /> <fmt:formatDate
												value="${localDate1}" pattern="dd/MM/yyyy"
												var="formattedDate1" /> ${formattedDate1}</td>
										<td><c:out value="${dt.kinhPhiDuKien}" /></td>
										<td><c:out value="${dt.ketQua}" /></td>
										

							
										<td><c:out value="${dt.linkNopBai}" /></td>
										<%-- <td><c:out value="${dt.getNgayNop()}" /></td> --%>
										<td><fmt:parseDate var="localDate1"
												value="${dt.getNgayNop()}" pattern="yyyy-MM-dd" /> <fmt:formatDate
												value="${localDate1}" pattern="dd/MM/yyyy"
												var="formattedDate1" /> ${formattedDate1}</td>
										<td><c:out value="${dt.trangThai}" /></td>
										<td>
											<button class="btn btn-primary" data-toggle="modal"
												data-target="#editModal" id="editDeTaiModalBtn"
												onclick="editRow(this)"
												data-projectCode="<c:out value='${dt.maDetai}' />"
												data-projectName="<c:out value='${dt.tenDeTai}' />"
												data-notes="<c:out value='${dt.ghiChu}' />"
												data-startDate="<c:out value='${dt.ngayThucHien}' />"
												data-endDate="<c:out value='${dt.ngayKetThuc}' />"
												data-budget="<c:out value='${dt.kinhPhiDuKien}' />"
												data-result="<c:out value='${dt.ketQua}' />"
												data-status="<c:out value='${dt.trangThai}' />"
												data-submissionLink="<c:out value='${dt.linkNopBai}' />">Sửa</button>
										</td>
										<td>
											<button type="button" class="btn btn-danger"
												onclick="deleteRow(this)">Xóa</button>
										</td>
									</tr>
								</c:forEach>



								<!-- Thêm các hàng khác nếu cần -->
							</tbody>
						</table>
					</div>

					<div class="ThemDeTai">
						<!-- Button trigger modal -->

						<button class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModal" id="openModalBtn">Thêm đề
							tài</button>
						<!-- <button class="btn btn-accept" onclick="duyetDeTai()">Duyệt
							đề tài đề xuất</button>
						<button class="btn btn-accept" onclick="duyetDeTaiDK()">Duyệt
							đề tài đăng ký</button> -->

						<!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Thêm đề
											tài mới</h5>

									</div>
									<div class="modal-body">
										<!-- Form gửi thông báo có thể thêm ở đây -->
										<form id="projectForm" action="TaoDeTai">
											<div class="mb-3">
												<label for="madetai" class="form-label">Mã Đề Tài</label> <input
													type="text" class="form-control" id="madetai"
													name="madetai" required>
												<div class="invalid-feedback">Mã Đề Tài không được để
													trống.</div>
											</div>
											<div class="mb-3">
												<label for="tendetai" class="form-label">Tên Đề Tài</label>
												<input type="text" class="form-control" id="tendetai"
													name="tendetai" required>
												<div class="invalid-feedback">Tên Đề Tài không được để
													trống.</div>
											</div>

											<div class="mb-3">
												<label for="kinhphi" class="form-label">Kinh Phí Dự
													Kiến</label> <input type="text" class="form-control" id="kinhphi"
													name="kinhphi"  required>
												<div class="invalid-feedback">Kinh Phí Dự Kiến không
													được để trống.</div>
											</div>
											<div class="mb-3">
												<label for="ghichu" class="form-label">Ghi Chú</label>
												<textarea type="text" class="form-control" id="ghichu"
													name="ghichu" rows="4" required></textarea>
												<div class="invalid-feedback">Tên Đề Tài không được để
													trống.</div>
											</div>

											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Hủy</button>
												<input type="submit" class="btn btn-success" id="submitForm"></input>
											</div>

										</form>
									</div>

								</div>
							</div>
						</div>
					</div>


					<div class="SuaDeTai">
						<!-- Button trigger modal -->


						<!-- Modal -->
						<div class="modal fade" id="editModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Sửa đề tài
										</h5>

									</div>
									<div class="modal-body">
										<!-- Form gửi thông báo có thể thêm ở đây -->
										<form action="SuaDeTai">

											<div class="form-group">
												<label for="projectCode">Mã đề tài:</label> <input
													type="text" class="form-control" id="projectCode"
													name="projectCode"  readonly>
											</div>

											<div class="form-group">
												<label for="projectName">Tên đề tài:</label> <input
													type="text" class="form-control" id="projectName"
													name="projectName" required>
											</div>

											<div class="form-group">
												<label for="notes">Ghi chú:</label>
												<textarea class="form-control" id="notes" name="notes"
													rows="3" required></textarea>
											</div>

											<div class="form-group">
												<label for="startDate">Ngày thực hiện:</label> <input
													type="date" class="form-control" id="startDate"
													name="startDate">
											</div>

											<div class="form-group">
												<label for="endDate">Ngày kết thúc:</label> <input
													type="date" class="form-control" id="endDate"
													name="endDate">
											</div>

											<div class="form-group">
												<label for="budget">Kinh phí:</label> <input type="text"
													class="form-control" id="budget" name="budget"
													 required>
											</div>

											<div class="form-group">
												<label for="result">Kết quả:</label> <input type="text"
													class="form-control" id="result" name="result">
											</div>

											<div class="form-group">
												<label for="status" readonly>Trạng thái:</label> <select
													class="form-control" id="status" name="status">
													<option value="Chưa Đăng Ký">Chưa Đăng Ký</option>
													<option value="Ðang thực hiện">Ðang thực hiện</option>
													<option value="Hoàn thành">Hoàn thành</option>
												</select>
											</div>

											<div class="form-group">
												<label for="submissionLink">Link nộp bài:</label> <input
													type="text" class="form-control" id="submissionLink"
													name="submissionLink">
											</div>
											<br> <input type="submit" class="btn btn-success"
												id="submitForm"></input>
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Hủy</button>
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
		function duyetDeTai() {
			// Chuyển hướng trang sử dụng JavaScript
			window.location.href = "/web_ck/xemdexuatdetai";
		}
	</script>
	<script>
		function duyetDeTaiDK() {
			// Chuyển hướng trang sử dụng JavaScript
			
		}
	</script>

	<script>
		function editRow(button) {
			var projectCode = button.getAttribute('data-projectCode');
			var projectName = button.getAttribute('data-projectName');
			var notes = button.getAttribute('data-notes');
			var startDate = button.getAttribute('data-startDate');
			var endDate = button.getAttribute('data-endDate');
			var budget = button.getAttribute('data-budget');
			var result = button.getAttribute('data-result');
			var status = button.getAttribute('data-status');
			var submissionLink = button.getAttribute('data-submissionLink');

			$('#editModal #projectCode').val(projectCode);
			$('#editModal #projectName').val(projectName);
			$('#editModal #notes').val(notes);
			$('#editModal #startDate').val(startDate);
			$('#editModal #endDate').val(endDate);
			$('#editModal #budget').val(budget);
			$('#editModal #result').val(result);
			$('#editModal #status').val(status);
			$('#editModal #submissionLink').val(submissionLink);

			//alert("Trạng thái: " + status);

		}

		function deleteRow(button) {
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
		function formatNumber(input) {
			// Lấy giá trị từ input
			let inputValue = input.value;

			// Loại bỏ các ký tự không phải số từ chuỗi
			let numericValue = inputValue.replace(/[^0-9]/g, '');

			// Định dạng số theo định dạng mong muốn (ví dụ: 150000 -> 150.000)
			let formattedValue = new Intl.NumberFormat('vi-VN')
					.format(numericValue);

			// Gán giá trị đã định dạng lại cho input
			input.value = formattedValue;
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
