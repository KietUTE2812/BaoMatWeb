<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý đề tài nghiên cứu khoa học</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar (3 cột) -->
            <div class="col-md-2">
                <jsp:include page="AD_sidebar.jsp"></jsp:include>
            </div>

            <!-- Nội dung (9 cột) -->
            <div class="col-md-10">
                <main class="main-panel">
                    <!-- Initial content or content loaded dynamically based on the selected button -->
                    <h1>Welcome to Your Dashboard!</h1>
                </main>
            </div>
        </div>
    </div>


	<jsp:include page="/footer.jsp"></jsp:include>
	
</body>
</html>