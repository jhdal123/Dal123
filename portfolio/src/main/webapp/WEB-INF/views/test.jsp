<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Login</title>

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css"
	rel="stylesheet">
<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
<script
	src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script
	src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/resources/js/sb-admin-2.min.js"/>"></script>

<!-- Page level plugins -->
<script
	src="<c:url value="/resources/vendor/datatables/jquery.dataTables.min.js"/>"></script>
<script
	src="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.js"/>"></script>

<!-- Page level custom scripts -->
<script src="<c:url value="/resources/js/demo/datatables-demo.js"/>"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#loginCheck').click(function() {
			$('.user').submit();
		});
		$('#join').click(function() {
			location.href = '/register';
		});
	});
</script>
</head>

<body class="bg-gradient-primary">
	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">환영합니다</h1>
									</div>

									<c:if test="${empty sessionScope.dto}">
										<form action="/loginCheck" class="user">
											<div class="form-group">
												<input name="email" type="email"
													class="form-control form-control-user"
													id="exampleInputEmail" aria-describedby="emailHelp"
													placeholder="Enter Email Address...">
											</div>
											<div class="form-group">
												<input name="pw" type="password"
													class="form-control form-control-user"
													id="exampleInputPassword" placeholder="Password">
											</div>
											<div class="form-group">
												<div class="custom-control custom-checkbox small">
													<input name="emailsave" type="checkbox"
														class="custom-control-input" id="customCheck"> <label
														class="custom-control-label" for="customCheck">Check
														me out</label>
												</div>
											</div>
											<button id="loginCheck" type="button"
												class="btn btn-primary btn-user btn-block">로그인</button>
											<button id="join" type="button"
												class="btn btn-primary btn-user btn-block">회원가입</button>
											<hr>
											<span style="color: red;">${logininfo}</span>
											<%-- 					${aaaa} --%>
										</form>
									</c:if>

									<hr>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>



</body>

</html>
