<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="Model.P_ThongBaoModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- dòng đàu buoiiii -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xét duyệt</title>
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
					<h1>Trang chủ</h1>
				</main>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<script>
	var saveListUrl = "<%=request.getContextPath()%>
		/GuiThongBao";

		function submitForm() {
			var nguoiNhan = document.getElementById("NguoiNhan").value;
			var tieuDe = document.getElementById("TieuDe").value;
			var noiDung = document.getElementById("NoiDung").value;

			// Tạo object chứa dữ liệu để gửi lên server
			var data = {
				NguoiNhan : nguoiNhan,
				TieuDe : tieuDe,
				NoiDung : noiDung
			};
			$.ajax({
				type : "POST",
				url : saveListUrl,
				data : JSON.stringify(data),
				contentType : "application/json",
				success : function(response) {
					// Xử lý kết quả trả về từ server nếu cần
					console.log(response);
				},
				error : function(error) {
					console.error("Error:", error);
				}
			});
		}
	</script>
	<script>
		$(document).ready(function() {
			$("#btnTb").click(function() {
				// Gọi servlet bằng Ajax
				$.ajax({
					url : "/ThongBao", // Đường dẫn đến servlet
					type : "GET", // Phương thức HTTP
					success : function(response) {
						// Xử lý dữ liệu trả về từ servlet nếu cần
						console.log("Success:", response);
					},
					error : function(error) {
						// Xử lý lỗi nếu có
						console.error("Error:", error);
					}
				});
			});
		});
	</script>



	<script>
    document.getElementById('notificationForm').addEventListener('submit', function (event) {
        // Kiểm tra các trường thông báo trước khi gửi form
        var nguoiNhan = document.getElementById('NguoiNhan').value;
        var tieuDe = document.getElementById('TieuDe').value;
        var noiDung = document.getElementById('NoiDung').value;

        if (!nguoiNhan || !tieuDe || !noiDung) {
            // Nếu có bất kỳ trường nào không được điền, hiển thị thông báo và ngăn chặn việc gửi form
            alert('Vui lòng điền đầy đủ thông tin.');
            event.preventDefault(); // Ngăn chặn việc gửi form
        } else {
            // Nếu tất cả trường đã được điền đầy đủ, tiếp tục gửi form
         
        }
    	});
	</script>

	<script>
    function GuiThongBao() {
        var nguoiNhan = document.getElementById('NguoiNhan').value;
        var tieuDe = document.getElementById('TieuDe').value;
        var noiDung = document.getElementById('NoiDung').value;

        // Kiểm tra xem các giá trị có hợp lệ hay không (tùy thuộc vào yêu cầu cụ thể của ứng dụng)
        if (!nguoiNhan || !tieuDe || !noiDung) {
            alert("Vui lòng điền đầy đủ thông tin");
            return;
        }

        $.ajax({
            type: "GET", // Sử dụng phương thức POST thay vì GET để tránh giới hạn độ dài của URL
            url: "GuiThongBaoGet", // Đổi URL tương ứng với đích cần gửi dữ liệu
            data: {
                action: "GuiThongBaoGet", // Thêm action để xác định phương thức cần gọi trên server
                nguoiNhan: nguoiNhan,
                tieuDe: tieuDe,
                noiDung: noiDung
            },
            success: function (response) {
                alert("Đã gửi thông báo");
                window.location.href = "/web_ck/XemThongBao";
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
</script>


	<script>
		function dsgv() {
			
			}
	</script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
