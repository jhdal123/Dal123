<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	 
	 	<%@include file="include/header.jsp" %>
	 
	 </header>
	<hr /> 
	 <nav>
	  <%@include file="include/nav.jsp" %>
	 </nav>
	<hr />
	 
	 <section id="container">
	  <h2>글 목록</h2>
	  
	  <table>
	   <tr><th>글 번호</th><th>글 제목</th><th>작성자</th><th>작성일자</th></tr>
	   
	   <!-- 목록 시작 -->
	   <c:forEach items="${list}" var="list">
	   <tr>
	    <td>${list.idx}</td>
	    <td><a href="/board/read?idx=${list.idx}">${list.title}</a></td>
	    <td>${list.writer}</td>
	    <td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd" /></td>
	   </tr>
	   </c:forEach>
	   <!-- 목록 끝 -->
	  </table>
	  
<div>
 <ul>
  <c:if test="${pageMaker.prev}">
   <li><a href="listPage${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
  </c:if> 
  
  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
   <li><a href="listPage${pageMaker.makeQuery(idx)}">${idx}</a></li>
  </c:forEach>
    
  <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
   <li><a href="listPage${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
  </c:if> 
 </ul>
</div>	
	
	 </section>
	
	<hr />
	
	 <footer>
	 
 	 <%@include file="include/footer.jsp"%>
 	 
 	 </footer>
 
	<a href="/board/write">글 작성 </a><br/>
	
	</div>

<!--  여 맞냐고 -->
	  <jsp:include page="../footermenu.jsp"/>
	</div>
<!-- 	End of content-wrapper -->
   </div>
<!--   End of wrapper 	 -->
 </div>
      