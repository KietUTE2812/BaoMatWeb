<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Thông Báo</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
          integrity="sha384-eolR+Fss5BLiKKpQteBvps/ihyBBrJzo6OpBkf9eV5PmI2sXf+JvBRdf1zFRP0W5"
          crossorigin="anonymous">
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
            <jsp:include page="AD_sidebar.jsp"></jsp:include>
        </div>


        <div class="col-md-10">

            <main class="main-panel">
                <div class="table-noti">
                    <h2>Danh sách thông báo</h2>
                    <br>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="btn-reoload">
                                <a href="<%=request.getContextPath()%>/AD/XemThongBao"
                                   class="btn btn-success">Làm mới</a>

                                <button class="btn btn-primary" data-toggle="modal"
                                        data-target="#tbModal" id="openModalBtntb">Thông báo
                                </button>
                            </div>
                        </div>

                    </div>
                    <br>
                    <div class="table-container">
                        <table class="table table-bordered table-striped">
                            <thead class="fixed-header">
                            <tr>
                                <th scope="col">Tiêu đề</th>
                                <th scope="col">Nội dung</th>
                                <th scope="col">Người nhận</th>
                                <th scope="col">Ngày gửi</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="thongBao" items="${tb}">
                                <tr>
                                    <td><c:out value="${thongBao.tieuDe}"/></td>
                                    <td><c:out value="${thongBao.noiDung}"/></td>
                                    <td><c:out value="${thongBao.nguoiGui}"/></td>
                                        <%-- <td><c:out value="${thongBao.ngayGui}" /></td> --%>
                                    <td><fmt:parseDate var="localDate"
                                                       value="${thongBao.ngayGui}" pattern="yyyy-MM-dd"/>
                                        <fmt:formatDate
                                                value="${localDate}" pattern="dd/MM/yyyy"
                                                var="formattedDate"/> ${formattedDate}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <br>
                    </div>
                    <div class="send-noti">
                        <!-- Button trigger modal -->


                        <!-- Modal -->
                        <div class="modal fade" id="tbModal" tabindex="-1"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel1">Gửi thông
                                            báo</h5>

                                    </div>
                                    <div class="modal-body">
                                        <!-- Form gửi thông báo có thể thêm ở đây -->
                                        <form id="notificationFormtb">
                                            <!-- Các trường thông báo -->

                                            <div class="mb-3">
                                                <%--@declare id="title"--%><label for="title" class="form-label">Tiêu
                                                đề:</label> <input
                                                    type="text" class="form-control" id="tbTieuDe"
                                                    name="tbTieuDe">
                                            </div>
                                            <div class="mb-3">
                                                <%--@declare id="message"--%><label for="message" class="form-label">Nội
                                                dung:</label>
                                                <textarea class="form-control" id="tbNoiDung"
                                                          name="tbNoiDung" rows="4"></textarea>
                                            </div>

                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary"
                                                        data-dismiss="modal">Hủy
                                                </button>
                                                <button type="button" class="btn btn-primary"
                                                        onclick="tball()">Gửi thông báo đến tất cả
                                                </button>
                                            </div>

                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="send-noti">
                        <!-- Button trigger modal -->
                        <br>
                        <button class="btn btn-primary" data-toggle="modal"
                                data-target="#exampleModal" id="openModalBtn" onclick="dsgv()">Gửi
                            thông báo
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal" tabindex="-1"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Gửi thông
                                            báo</h5>

                                    </div>
                                    <div class="modal-body">
                                        <!-- Form gửi thông báo có thể thêm ở đây -->
                                        <form id="notificationForm" action="EmailControllers"
                                              method="POST">
                                            <!-- Các trường thông báo -->

                                            <input type="hidden" name="action" value="GuiThongBaoGet">
                                            <div class="mb-3">
                                                <label for="title" class="form-label">Người nhận:</label> <select
                                                    class="form-control" id="NguoiNhan" name="NguoiNhan">

                                                <c:forEach var="gv" items="${tengv}">
                                                    <option value="${gv.maGV}">${gv.tenGV}</option>
                                                    </option>
                                                </c:forEach>
                                            </select>
                                            </div>
                                            <div class="mb-3">
                                                <label for="title" class="form-label">Tiêu đề:</label> <input
                                                    type="text" class="form-control" id="TieuDe" name="TieuDe">
                                            </div>
                                            <div class="mb-3">
                                                <label for="message" class="form-label">Nội dung:</label>
                                                <textarea class="form-control" id="NoiDung" name="NoiDung"
                                                          rows="4"></textarea>
                                            </div>

                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary"
                                                        data-dismiss="modal">Hủy
                                                </button>
                                                <input type="submit" class="btn btn-success"
                                                       id="submitForm"></input>
                                            </div>

                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function tball() {
        // Thêm logic để xử lý duyệt đơn ở đây

        var TieuDe = document.getElementById("tbTieuDe").value;
        var NoiDung = document.getElementById("tbNoiDung").value;
        //alert("tb: " + TieuDe + NoiDung);
        // Tạo đối tượng chứa dữ liệu để gửi đi
        var data = {
            TieuDe: TieuDe,
            NoiDung: NoiDung,

        };
        // Gửi dữ liệu bằng Ajax
        $.ajax({
            type: 'GET',
            url: 'GuiTBall', // Thay đổi đường dẫn đến tầng controller của bạn
            data: data,
            success: function (response) {

            },
            error: function (error) {
                // Xử lý lỗi nếu có
                alert('Đã xảy ra lỗi: ' + error);
            }
        });
        $.ajax({
            type: 'GET',
            url: 'Emailall', // Thay đổi đường dẫn đến tầng controller của bạn
            data: data,
            success: function (response) {
                alert("Đã gửi");
                window.location.href = "/web_ck/AD/XemThongBao";
            },
            error: function (error) {
                // Xử lý lỗi nếu có
                alert('Đã xảy ra lỗi: ' + error);
            }
        });
    }
</script>


<script>
    document.getElementById('notificationForm').addEventListener('submit',
        function (event) {
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
        // Chuyển hướng trang sử dụng JavaScript
        window.location.href = "/ndnweb/GuiThongBaoGet";
    }
</script>

<script>
    function dsgv() {

    }
</script>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>