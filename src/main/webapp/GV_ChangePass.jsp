<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi mật khẩu</title>
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

a#button{
        text-decoration: none;
        color: white;
        background-color: #007bff;
        border-radius: 5px;
        padding: 5px;
        width: 150px;
        text-align: center;
    }
.form {
  width: 100%;
  max-width: 20rem;
  margin: 0 auto;
  position: relative;
  top: 20%;
  left: -10%;
}

.input {
  display: block;
  width: 100%;
  height: 2.5rem;
  margin-bottom: .5rem;
  padding: .5rem 1rem;
  
  background: #f4f8f7;
    
  border: none;
  border-radius: 2px;
}

.button {
  transition: border .2s ease-in-out, background .2s ease-in-out, color .2s ease-in-out;
  
  display: block;
  width: calc(100% - 10rem);
  height: 2.5rem;
  margin: 0 5rem;
  
  background: #5fb3b3;
  border: 1px solid #5fb3b3;
  border-radius: 1.25rem;
  outline: none;
  
  color: #fff;
  font-size: .7rem;
  text-transform: uppercase;
  letter-spacing: .5px;
  
  &:hover {
    background: transparent;
    border-color: #5fb3b3;
    color: #5fb3b3;
  }
}
h3{
  text-align: center !important;
  color: #5f83b3 !important;
  font-size: 1.5rem !important;
  margin-bottom: 1rem!important;
  
}
.valid {
  color: green;
}

.valid:before {
  position: relative;
  left: -35px;
  content: "✔";
}


.invalid {
  color: red;
}

.invalid:before {
  position: relative;
  left: -35px;
  content: "✖";
}
#message-pass{
display: none;
}
#message-conf{
display: none;
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


			<div class="col-md-9">
				<%
				String err = (String) request.getAttribute("error");
				%>
				<form class="form" data-form="form-1" method="post"
					action="GV/cpass">
					<h3>Đổi Mật Khẩu</h3>
					<%
					if (err != null) {
					%>
					<p style="color: green"><%=err%></p>
					<%
					}
					%>
					<input type="text" placeholder="Current Password" class="input"
						id="pass" name="password" required autocomplete="off"> <input
						type="text" placeholder="New Password" class="input" id="Npass"
						name="Npassword" required autocomplete="off">
					<div id="message-pass">
						<h3>Password must contain the following:</h3>
						<p id="letter" class="invalid">
							A <b>lowercase</b> letter
						</p>
						<p id="capital" class="invalid">
							A <b>capital (uppercase)</b> letter
						</p>
						<p id="number" class="invalid">
							A <b>number</b>
						</p>
						<p id="length" class="invalid">
							Minimum <b>8 characters</b>
						</p>
						<p id="special" class="invalid">
							A <b>special letter</b>
						</p>
					</div>
					<input type="text" placeholder="Confirm Password" class="input"
						id="Cpass" name="confirm" required autocomplete="off">
					<div id="message-conf">

						<p id="conf" class="invalid">
							<b>Equal</b> new password
						</p>
					</div>
					<input type="submit" value="Change" class="button">
				</form>

				<script>
					var myInput = document.getElementById("Npass");
					var letter = document.getElementById("letter");
					var myConf = document.getElementById("Cpass");
					myConf.onfocus = function() {
						document.getElementById("message-conf").style.display = "block";
					}

					myConf.onblur = function() {
						document.getElementById("message-conf").style.display = "none";
					}
					myInput.onfocus = function() {
						document.getElementById("message-pass").style.display = "block";
					}

					myInput.onblur = function() {
						document.getElementById("message-pass").style.display = "none";
					}

					var conf = document.getElementById("conf");
					var capitalLetter = document.getElementById("capital");
					var number = document.getElementById("number");
					var length = document.getElementById("length");
					var special = document.getElementById("special");

					myConf.onkeyup = function() {
						if (myConf.value == myInput.value) {
							conf.classList.remove("invalid");
							conf.classList.add("valid");
						} else {
							conf.classList.remove("valid");
							conf.classList.add("invalid");
						}
					}

					myInput.onkeyup = function() {
						var lowerCaseLetters = /[a-z]/g;
						var upperCaseLetters = /[A-Z]/g;
						var numbers = /[0-9]/g;
						var specialCharacter = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/g;

						if (myInput.value.match(lowerCaseLetters)) {
							letter.classList.remove("invalid");
							letter.classList.add("valid");
						} else {
							letter.classList.remove("valid");
							letter.classList.add("invalid");
						}
						if (myInput.value.match(upperCaseLetters)) {
							capitalLetter.classList.remove("invalid");
							capitalLetter.classList.add("valid");
						} else {
							capitalLetter.classList.remove("valid");
							capitalLetter.classList.add("invalid");
						}
						if (myInput.value.match(numbers)) {
							number.classList.remove("invalid");
							number.classList.add("valid");
						} else {
							number.classList.remove("valid");
							number.classList.add("invalid");
						}
						if (myInput.value.length >= 8) {
							length.classList.remove("invalid");
							length.classList.add("valid");
						} else {
							length.classList.remove("valid");
							length.classList.add("invalid");
						}
						if (myInput.value.match(specialCharacter)) {
							special.classList.remove("invalid");
							special.classList.add("valid");
						} else {
							special.classList.remove("valid");
							special.classList.add("invalid");
						}
					}
					$("message-pass a").click(function() {
						$("form").animate({
							height : "toggle",
							opacity : "toggle"
						}, "slow");

					});
				</script>
			</div>

		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>