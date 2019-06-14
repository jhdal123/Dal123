<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>자유게시판</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
  <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>	
</head>

<body id="page-top">
  <div id="wrapper">
<!-- 사이드바 -->
	<jsp:include page="../sidemenu.jsp"/>
<!-- 	중앙틀 -->
	<div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
<!-- 탑메뉴 -->
		<jsp:include page="../topmenu.jsp"/>
      </div>
      <div class = "container-fluid">
<!--       	여 맞나 -->
<div id="root">
 <header>
  <h1>게시판이다</h1>
 </header>

<hr />
 
 <nav>
  처음화면 - 글쓰기 - 로그인
 </nav>

<hr />

 <section id="container">
 
  <form role="form" method="post" autocomplete="off">
  
  	<input type="hidden" id="page" name="page" value="${scri.page}" readonly="readonly"/>
  	<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}" readonly="readonly"/>
  	<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}" readonly="readonly"/>
  	<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}" readonly="readonly"/>
  
 	<p>
    <label for="idx">글 번호</label><input type="text" id="idx" name="idx" value="${read.idx}" readonly="readonly" />
    </p>
  </form>
  
  
   <p>
    <label for="title">글 제목</label><input type="text" id="title" name="title" value="${read.title}" readonly="readonly"  />
   </p>
   <p>
    <label for="content">글 내용</label><textarea id="content" name="content" readonly="readonly" >${read.content}</textarea>
   </p>
   <p>
    <label for="writer">작성자</label><input type="text" id="writer" name="writer" value="${read.writer}" readonly="readonly" /><br />
    <label>작성 날짜</label> <span><fmt:formatDate value="${read.regDate}" pattern="yyyy-MM-dd" /></span>
   </p>
   <p>
      <button type="button" id="list_btn">목록</button>	
	  <button type="button" id="modity_btn">수정</button>
	  <button type="button" id="delete_btn">삭제</button>
	  
	  <script>
		 // 폼을 변수에 저장
		 var formObj = $("form[role='form']");
		 
		 // 목록 버튼 클릭 
		 $("#list_btn").click(function(){
			self.location = "/board/listSearch?"
					+ "page=${scri.page}&perPageNum=${scri.perPageNum}"
					+ "&searchType=${scri.searchType}&keyword=${scri.keyword}";
		 });
		 // 수정 버튼 클릭
		 $("#modity_btn").click(function(){
		  
		  formObj.attr("action", "/board/modify");
		  formObj.attr("method", "get");  
		  formObj.submit();     
		  
		 });
		 
		 
		 // 삭제 버튼 클릭
		 $("#delete_btn").click(function(){
		  
		  formObj.attr("action", "/board/delete");
		  formObj.attr("method", "get");  
		  formObj.submit();
		  
		 });
	  </script>
	  
   </p> 
  

 </section>

<hr />

 <footer>
  <p>만든이 : 나다</p>  
 </footer>

</div>
<!--  여 맞냐고 -->
	  <jsp:include page="../footermenu.jsp"/>
	</div>
<!-- 	End of content-wrapper -->
   </div>
<!--   End of wrapper 	 -->
 </div>
      