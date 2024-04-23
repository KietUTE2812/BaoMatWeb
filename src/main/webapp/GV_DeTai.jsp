<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đề tài của tôi</title>
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
main{
	margin: 0px;
	position: relative;
	left: 2%;
	width: 100%;
}
/* Đặt độ rộng cho các cột trong bảng */
    table {
        width: 100%; /* Độ rộng của bảng */
    }

    table td {
        padding: 8px; /* Khoảng cách giữa nội dung và biên của ô */
        text-align: left; /* Căn lề nội dung sang trái */
    }

    /* Độ rộng của các cột cụ thể */
    
    .column2 { width: 15%; }
    .column3 { width: 10%; }
    .column4 { width: 10%; }
    .column5 { width: 10%; }
    .column6 { width: 0%; }
    .column7 { width: 10%; }
    .column8 { width: 0%; }
    .column9 { width: 0%; }
    .column10 { width: 15%; }
    .column11 { width: 10%; }
.edit-link {
	background-color: #8F9BE3;
	color: white;
	padding: 5px;
	border-radius: 10px;
	text-decoration: none;
}

.edit-link:hover {
	background-color: #6072E1;
	color: white !important;
	text-decoration: none;
}

.delete-link:hover {
	background-color: #FC3B0E;
	color: white !important;
	text-decoration: none;
}

.delete-link {
	background-color: #AD481B;
	color: white;
	padding: 5px;
	border-radius: 10px;
	text-decoration: none;
}

a#button {
	text-decoration: none;
	color: white;
	background-color: #007bff;
	border-radius: 5px;
	padding: 5px;
	width: 150px;
	text-align: center;
	/* Đặt độ rộng cho các cột trong bảng */
    
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


			<div class="col-md-10 ">

					<main class="main-panel">
						<h3>Danh sách đề tài</h3>
						<c:if test="${not empty errDK}">
							<div class="alert alert-danger" role="alert">${errDK}</div>
						</c:if>
						<div class="DanhsachDT">

							<table class="table table-bordered">
								<thead class="fixed-header">
									<tr>

										<th scope="col">Nhóm</th>
										<th scope="col">Tên Đề Tài</th>
										<th scope="col">Ngày Thực Hiện</th>
										<th scope="col">Ngày Kết Thúc</th>
										<th scope="col">Kinh phí dự kiến</th>
										<th scope="col">Kết Quả</th>
										<th scope="col">Trạng Thái Đề Tài</th>
										<th scope="col">Link Nộp Bài</th>
										<th scope="col">Ngày Nộp</th>

										<th scope="col">Thao Tác</th>

									</tr>
								</thead>
								<tbody>
									<!-- Dữ liệu đề tài -->
									<c:forEach var="dt" items="${dtaiofgv}">

										<tr>

											<td class="column1"><c:out value="${dt.getNhom()}" /></td>
											<td class="column2"><c:out value="${dt.getTenDeTai()}" /></td>
											<td class="column3"><fmt:parseDate var="localDate"
													value="${dt.getNgayThucHien()}" pattern="yyyy-MM-dd" /> <fmt:formatDate
													value="${localDate}" pattern="dd/MM/yyyy"
													var="formattedDate" /> <c:out value="${formattedDate}" /></td>
											<td class="column4"><fmt:parseDate var="localDate"
													value="${dt.getNgayKetThuc()}" pattern="yyyy-MM-dd" /> <fmt:formatDate
													value="${localDate}" pattern="dd/MM/yyyy"
													var="formattedDate" /> <c:out value="${formattedDate}" /></td>
											<td class="column5"><c:out value="${dt.getKinhPhiDuKien()}" /></td>
											<td class="column6"><c:out value="${dt.getKetQua()}" /></td>
											<td class="column7"><c:out value="${dt.getTrangThai()}" /></td>
											<td class="column8"><c:out value="${dt.getLinknop()}" /></td>
											<td class="column9"><fmt:parseDate var="localDate"
													value="${dt.getNgayNop()}" pattern="yyyy-MM-dd" /> <fmt:formatDate
													value="${localDate}" pattern="dd/MM/yyyy"
													var="formattedDate" /> <c:out value="${formattedDate}" /></td>
											<td class="column10"><c:if test="${empty dt.getLinknop()}">
													<c:if test="${not empty dt.getNgayKetThuc()}">
														<a type="" class="edit-link"
															href="ShowGiaHan?id=<c:out value='${dt.getMaDT()}' />">
															Gia hạn</a>
														<c:if test="${nop}">
															<td class="column11"><a type="" class="delete-link"
																href="ShowNop?id=<c:out value='${dt.getMaDT()}' />">Nộp
															</a></td>
														</c:if>

													</c:if>

												</c:if></td>


										</tr>
									</c:forEach>



									<!-- Thêm các hàng khác nếu cần -->
								</tbody>
							</table>
						</div>








					</main>
				</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<script>
    // Lấy giá trị của attribute "errDX"
    var errDX = '<%=request.getAttribute("errDX")%>';

    // Kiểm tra xem attribute tồn tại hay không
    if (errDX != "null") {
        // Nếu tồn tại, tạo cảnh báo
        alert(errDX);
    }
    errDX = "null";
 // Lấy giá trị của attribute "errDX"
    var errNop = '<%=request.getAttribute("errNop")%>
		';

		// Kiểm tra xem attribute tồn tại hay không
		if (errNop != "null") {
			// Nếu tồn tại, tạo cảnh báo
			alert(errNop);
		}
		errNop = "null";
	</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>