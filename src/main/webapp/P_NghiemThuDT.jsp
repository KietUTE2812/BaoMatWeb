<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nghiệm thu đề tài</title>
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
					<div class="container-danhgia">
						<h2>Đánh Giá Đề Tài</h2>
						<c:if test="${not empty errorMessage}">
							<div class="alert alert-danger" role="alert">
								${errorMessage}</div>
						</c:if>
						<form>
							<div class="mb-3">
								<label for="selectTopic" class="form-label">Chọn Đề Tài:</label>
								<select class="form-select" id="selectTopic" name="selectTopic">
									<c:forEach var="dt" items="${danhsachdetai}">
										<option value="${dt.maDeTai}">${dt.maDeTai}</option>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="mb-3">
								<label for="inputScore" class="form-label">Điểm Số:</label> <input
									type="text" class="form-control" id="inputScore"
									name="inputScore">
							</div>
							<div class="mb-3">
								<label for="inputEvidence" class="form-label">Minh
									Chứng:</label> <input type="text" class="form-control"
									id="inputEvidence" name="inputEvidence">
							</div>
							<div class="mb-3">
								<label for="textareaReview" class="form-label">Đánh Giá:</label>
								<textarea class="form-control" id="textareaReview"
									name="textareaReview" rows="3"></textarea>
							</div>
							<button type="button" class="btn btn-primary" onclick="danhgia()">Đánh
								Giá</button>
						</form>
					</div>

					<div class="quaylai-container ">
						<button type="button" class="btn btn-success"
							onclick="bienbannghiemthu()">Biên bản nghiệm thu</button>
					</div>
				</main>
			</div>
		</div>
	</div>
	<script>
		function bienbannghiemthu() {
			// Chuyển hướng trang sử dụng JavaScript
			window.location.href = '/web_ck/xembienbannghiemthu';
		}
	</script>
	<script>
		function danhgia() {

			// Lấy giá trị từ các trường nhập liệu
			var maDeTai = $('#selectTopic').val();
			var diem = $('#inputScore').val();
			var minhchung = $('#inputEvidence').val();
			var danhgia = $('#textareaReview').val();

			// Tạo đối tượng chứa dữ liệu để gửi đi
			var data = {
				maDeTai : maDeTai,
				diem : diem,
				minhchung : minhchung,
				danhgia : danhgia
			};

			// Gửi dữ liệu bằng Ajax
			$.ajax({
				type : 'GET',
				url : 'ThemBBNT', // Thay đổi đường dẫn đến tầng controller của bạn
				data : data,
				success : function(response) {
					
					window.location.href = '/web_ck/xembienbannghiemthu';
				},
				error : function(error) {
					// Xử lý lỗi nếu có
					alert('Đã xảy ra lỗi: ' + error);
				}
			});
			//window.location.href = '/web_ck/xembienbannghiemthu';
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
