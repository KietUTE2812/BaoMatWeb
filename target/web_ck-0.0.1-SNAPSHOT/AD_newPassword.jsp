<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Reset Password</title>
<link
	href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'
	rel='stylesheet'>
<link
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css'
	rel='stylesheet'>
<script type='text/javascript'
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<style>
body {
  background-color: #eee; /* Light pink background color */
  color: #000; /* Black text color */
}

.container {
  background-color: #fff; /* White container background color */
  border-radius: 10px; /* Rounded corners */
  margin-top: 20px;
  margin-bottom: 20px;
  padding: 20px;
}

h1 {
  color: #337ab7; /* Blue heading color */
}

.border-info {
  border-color: #337ab7 !important; /* Blue border color for form inputs */
}

.btn-info {
  background-color: #337ab7; /* Blue button color */
  color: #fff; /* White text color on button */
}

.btn-info:hover {
  background-color: #286090; /* Darker blue on button hover */
}

hr {
  background-color: #337ab7; /* Blue horizontal line color */
}

.text-danger {
  color: #286090; /* Dark blue text color for "Register Now" link */
}
</style>
</head>
<body oncontextmenu='return false' class='snippet-body'>
	<jsp:include page="/headerlogin.jsp"></jsp:include>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.css">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-12 col-md-9 col-lg-7 col-xl-6 mt-5">
				<div class="container rounded">
					<div class="row justify-content-center align-items-center pt-3">
						<h1>
							<strong>Nhập Mật Khẩu Mới</strong>
						</h1>
					</div>
					<div class="pt-3 pb-3">
						<form class="form-horizontal" action="<%=request.getContextPath()%>/newPassword" method="POST">
							<div class="form-group row justify-content-center px-3">
								<div class="col-9 px-0">
									<input type="text" name="password"
										placeholder="&#xf084; &nbsp; Nhập Mật Khẩu Mới"
										class="form-control border-info">
								</div>
							</div>
							<div class="form-group row justify-content-center px-3">
								<div class="col-9 px-0">
									<input type="password" name="confPassword"
										placeholder="&#xf084; &nbsp; Nhập Lại Mật Khẩu"
										class="form-control border-info">
								</div>
							</div>
							<div class="form-group row justify-content-center">
								<div class="col-3 px-3 mt-3">
									<input type="submit" value="Đổi MK"
										class="btn btn-block btn-info">
								</div>
							</div>
						</form>
					</div>
					<div class="mx-0 px-0 bg-light">
						<div class="px-4 pt-5"></div>
						<div class="pt-2">

							<div
								class="row justify-content-center align-items-center pt-4 pb-5">
								<div class="col-4"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type='text/javascript'
		src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
</body>
</html>
