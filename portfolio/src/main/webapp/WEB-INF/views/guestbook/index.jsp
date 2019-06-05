<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>방명록</title>

  <!-- Custom fonts for this template -->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<jsp:include page="../head.jsp" />
<script type="text/javascript">
	$(document).ready(function(){
		$('#btnshow').click(function(){
			$('#guestbookModal').modal('show');
		});
		$('#btnmodalclose').click(function(){
			$('#guestbookModal').modal('hide');
		});
		$('#btnsaveclose').click(function(){
			var textArea = $('#myTextArea').val();
			$.ajax({
				url:"/guestbook/save",
				type: "post",
				data: {"content": textArea,"var":"test"},
				success : function(result){
					result = $.trim(result);
					if(result =='success'){
						$('#saveinfo').text('방명록을 작성을 완료하였습니다.');
						$('#saveCompleted').modal('show');		
					}else{
						$('#saveinfo').text('방명록을 작성에 실패하였습니다.');
						$('#saveCompleted').modal('show');
					}
				},
				error: function(e){
					alert(e.status);
					alert(e.responseText);
				}
			});
			$('#guestbookModal').modal('hide');
		});
		
		$('#btnsaveCompleted').click(function(){
			$('#saveCompleted').modal('hide');	
			location.href='/guestbook';
		});
		
		
		$('.deleteModalshow').click(function(){
			$('#idx').val($(this).attr('idx'));
			$('#deleteModal').modal('show');
		});
		
		$('#cancelbtn').click(function(){
			$('#deleteModal').modal('hide');
		});
		
		$('#deletebtn').click(function(){
			var selectIdx = $('#idx').val();
			$.ajax({
				url: "/guestbook/delete",
				type:"post",
				data : { "idx" : selectIdx },
				success : function(){
					$('#deleteModal').modal('hide');
					$('#saveinfo').text('방명록을 삭제를 완료하였습니다.');
					$('#saveCompleted').modal('show');				
				},
				error : function(){
					$('#deleteModal').modal('hide');
					$('#saveinfo').text('방명록을 삭제를 실패하였습니다.');
					$('#saveCompleted').modal('show');	
				}
			});
		});
		
		$('#btncloseupdate').click(function(){
	//			alert('연결되냐');
			var idx = $('#idx').val();
			var content = $('#myTextAreaupdate').val();
			$.ajax({
				url :"/guestbook/update",
				data : { "idx": idx , "content":content},
				type: "post",
				success:function(){
					$('#guestbookModalupdate').modal('hide');
					$('#saveinfo').text('방명록을 수정을 완료하였습니다.');
					$('#saveCompleted').modal('show');	
				}
			});
		});
		
	});
	
	function updateModal(idx,content){
		$('#myTextAreaupdate').val(content);
		$('#idx').val(idx);
		$('#guestbookModalupdate').modal('show');
	//		alert("idx = "+idx);
	//		alert("content = "+content);
	}
</script>




</head>

<body id="page-top">
<input id="idx" type="hidden" name="idx"/>
	<!-- Modal -->
	<div class="modal fade" id="guestbookModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">방명록 글쓰기</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<textarea id="myTextArea" class="form-control" rows="10"></textarea>
				</div>
				<div class="modal-footer">
					<button id="btnmodalclose" type="button" class="btn btn-secondary">
					닫기
					</button>
					<button id="btnsaveclose" type="button" class="btn btn-primary">
					저장
					</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="guestbookModalupdate">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">방명록 글수정</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<textarea id="myTextAreaupdate" class="form-control" rows="10"></textarea>
				</div>
				<div class="modal-footer">
					<button id="btnmodalcloseupdate" type="button" class="btn btn-secondary">
					닫기
					</button>
					<button id="btncloseupdate" type="button" class="btn btn-primary">
					수정
					</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="saveCompleted">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">안내문구</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" id="saveinfo">
					정상적으로 방명록을 작성하였습니다.
				</div>
				<div class="modal-footer">
					<button id="btnsaveCompleted" type="button" class="btn btn-secondary">
					닫기
					</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="deleteModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">안내문구</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" id="saveinfo">
					삭제 하시겠습니까?
				</div>
				<div class="modal-footer">
					<button id="cancelbtn" type="button" class="btn btn-success">
					취소
					</button>
					<button id="deletebtn" type="button" class="btn btn-danger">
					확인
					</button>
				</div>
			</div>
		</div>
	</div>
	
	
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

      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">방명록</h1>
          <p class="mb-4"> 이곳은 방명록입니다.</p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">생존신고를해주세요</h6>
            </div>
            <div class="card-body">
            
		         <div class="row">
					<div class="col">
						<div class="jumbotron">
							<h1 class="display-4">방명록입니다.</h1>
							<p class="lead">bootstrap modal 라이브러리를 호출해서 구현했습니다.</p>
							<hr class="my-4">
							<p>글쓰기 버튼을 클릭시 modal창이 생성됩니다.</p>
							<p class="lead">
								<button id="btnshow" class="btn btn-primary btn-lg">
								 글쓰기
								</button>
							</p>
						</div>
					</div>
				</div>
				<c:forEach items="${list}" var="dto">
				<div class="row">
					<div class="col-sm-3">
						<img src="/resources/hu.jpg"/>
					</div>
					<div class="col-sm-9">
						<div class="row">
							<div class="col">
								${dto.content}
							</div>
						</div>
						<div class="row">
							<div class="col">
								${dto.reg_date}
							</div>
						</div>
						<div class="row">
							<div class="col text-right">
								<button onclick="updateModal('${dto.idx}','${dto.content}');" class="btn btn-primary">수정</button>
								<button idx="${dto.idx}" class="deleteModalshow btn btn-primary">삭제</button>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
				
            </div>
            <!-- card-body -->
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->
</div>
  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

  <!-- Core plugin JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

  <!-- Custom scripts for all pages-->
  <script src="<c:url value="/resources/js/sb-admin-2.min.js"/>"></script>

  <!-- Page level plugins -->
  <script src="<c:url value="/resources/vendor/datatables/jquery.dataTables.min.js"/>"></script>
  <script src="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.js"/>"></script>

  <!-- Page level custom scripts -->
  <script src="<c:url value="/resources/js/demo/datatables-demo.js"/>"></script>

</body>

</html>
