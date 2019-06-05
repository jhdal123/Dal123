<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>테스트</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>
<script type="text/javascript">
	$(document).ready(function(){
		
	})

</script>
<body class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">회원가입</h1>
              </div>
              
<!--                method="post" 넣어야함-->
              <form action="/" class="user">
	<div class="container">
		<div class="row">
			<div class="col">
				회원가입
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">ID</span>
					</div>
					<input name="id" type="text" class="form-control">
					<div class="input-group-append">
						<span class="input-group-text">아이디를 입력하세요</span>
					</div>
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">PW</span>
					</div>
					<input name="pw" type="text" class="form-control">
					<div class="input-group-append">
						<span class="input-group-text">패스워드를 입력하세요</span>
					</div>
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">NAME</span>
					</div>
					<input name="name" type="text" class="form-control">
					<div class="input-group-append">
						<span class="input-group-text">이름을 입력하세요</span>
					</div>
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">EMAIL</span>
					</div>
					<input name="email" type="text" class="form-control">
					<div class="input-group-append">
						<span class="input-group-text">이메일을 입력하세요</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col text-center">
				<button class="btn btn-primary">회원가입</button>
				<button onclick="location.href='/';" class="btn btn-primary">취소</button>
			</div>
		</div>
		<div class="row">
			<div class="col">${joininfo}</div>
		</div>
	</div>

              </form>
              <hr>
              <div class="text-center">
                <a class="small" href="login.html">계정있으면 로그인</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
  <script src="<c:url value="vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

  <!-- Core plugin JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

  <!-- Custom scripts for all pages-->
  <script src="<c:url value="/resources/js/sb-admin-2.min.js"/>"></script>

</body>

</html>
