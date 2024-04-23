<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

  <style type="text/css">
    body {
      background-color: #eee; /* Light pink background color */
      color: #000; /* Black text color */
    }

    .form-gap {
      padding-top: 70px;
    }

    .panel-default {
      border: none; /* Remove panel border */
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Add subtle box shadow */
    }

    .panel-body {
      padding: 20px;
    }

    h2 {
      color: #31708f; /* Dark blue heading color */
    }

    .text-center {
      color: #31708f; /* Dark blue text color for the lock icon */
    }

    .btn-primary {
      background-color: #31708f; /* Dark blue button color */
      border-color: #31708f; /* Dark blue button border color */
    }

    .btn-primary:hover {
      background-color: #286090; /* Darker blue on button hover */
      border-color: #286090; /* Darker blue on button hover */
    }

    .color-blue {
      color: #31708f; /* Dark blue color for envelope icon */
    }

    .text-danger {
      color: #c9302c; /* Dark red text color for error message */
    }
  </style>
</head>

<body>
  <jsp:include page="/headerlogin.jsp"></jsp:include>
  <div class="form-gap"></div>
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <div class="panel panel-default">
          <div class="panel-body">
            <div class="text-center">
              <h3>
                <i class="fa fa-lock fa-4x"></i>
              </h3>
              <h2 class="text-center">Nhập OTP</h2>
              <%
                if(request.getAttribute("message")!=null)
                {
                  out.print("<p class='text-danger ml-1'>"+request.getAttribute("message")+"</p>");
                }
              %>
              <div class="panel-body">
                <form id="register-form" action="<%=request.getContextPath()%>/ValidateOtp" role="form" autocomplete="off" class="form" method="post">
                  <div class="form-group">
                    <div class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                      <input id="opt" name="otp" placeholder="Nhập OTP" class="form-control" type="text" required="required">
                    </div>
                  </div>
                  <div class="form-group">
                    <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Đổi Mật Khẩu" type="submit">
                  </div>
                  <input type="hidden" class="hide" name="token" id="token" value="">
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
