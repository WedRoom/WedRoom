<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>WedRoom</title>
<script language="JavaScript" src="test/js/scripts.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link href="test/css/main.css?after" rel="stylesheet" type="text/css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
</head>
<script type="text/javascript">
	//이미지 미리보기
	var sel_file;

	$(document).ready(function() {
		$("#file1").on("change", handleImgFileSelect);
	});

	function handleImgFileSelect(e) {
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);

		var reg = /(.*?)\/(jpg|jpeg|png|bmp)$/;

		filesArr.forEach(function(f) {
			if (!f.type.match(reg)) {
				alert("확장자는 이미지 확장자만 가능합니다.");
				return;
			}

			sel_file = f;

			var reader = new FileReader();
			reader.onload = function(e) {
				$("#img").attr("src", e.target.result);
			};
			reader.readAsDataURL(f);
		});
	}
</script>

<script>
	//파일 업로드
	function fn_submit() {
		var form = new FormData();
		form.append("file1", $("#file1")[0].files[0]);

		jQuery.ajax({
			url : "/share.do",
			type : "POST",
			processData : false,
			contentType : false,
			data : form,
			success : function(response) {
				alert("성공하였습니다.");
				console.log(response);
			},
			error : function(jqXHR) {
				alert(jqXHR.responseText);
			},
		});
	}
	
</script>
<body>
	<div class="wrap">
		<!-- 로고 -->
		<header class="hd">
			<div class="logo">
				<a href="test/index.html"><img src="test/img/logo.png" /></a>
			</div>
		</header>
		<!-- 메뉴바 -->
		<nav class="nav">
			<ul class="menu">
				<li><a href="share.do">쉐어하우스</a></li>
				<li><a href="#">룸메이트</a></li>
				<li><a href="#">자유게시판</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">성향테스트</a></li>
			</ul>
		</nav>
		<!-- 바디 -->
		<section>
			<div class="section">
				<div class="section2">
					<!-- onsubmit 이벤트="return 호출할 함수명(~)" -->
					<h2 style="text-align: left; margin-left: 30px">방 생성하기</h2>
					<br>

					<form class="row g-6 needs-validation" novalidate method="post"
						name="writeform" action="/Project/share_writePro.do"
						onsubmit="return writeSave()">
						<!-- 로그인 테이블 만들어지면 히든값 수정하기 -->
						<input type="hidden" name="room_no" value=${room_no}>
						<%-- <input type="hidden" name="id_no" value="${id_no}"> --%>
						<input type="hidden" name="id_no" value="1"> <input
							type="hidden" name="view" value="0">

						<!-- <div class="col-md-3">
								<label for="validationCustom01" class="form-label">방 번호
								</label> <input type="text" class="form-control" id="validationCustom01"
									placeholder="방 번호를 입력하시오" name="room_no" required />
								<div class="valid-feedback">Looks good!</div>
							</div> -->
						<div class="col-md-3">
							<label for="validationCustom02" class="form-label">방 이름</label> <input
								type="text" class="form-control" id="validationCustom02"
								placeholder="방 이름을 적어주세요" name="title" required />
							<div class="valid-feedback">Looks good!</div>
						</div>
						<div class="col-md-3">
							<label for="validationCustom10" class="form-label">방 개수 </label>
							<input type="text" class="form-control" id="validationCustom10"
								placeholder="방 개수를 입력하시오" name="room_count" required />
							<div class="valid-feedback">Looks good!</div>
						</div>
						<div class="col-md-3">
							<label for="validationCustom03" class="form-label">방 옵션</label> <input
								type="text" class="form-control" id="validationCustom03"
								placeholder="ex)냉장고,에어컨 보유" name="room_option" required />
							<div class="valid-feedback">Looks good!</div>
						</div>
						<div class="col-md-4">
							<label for="validationCustom04" class="form-label">주소</label> <input
								type="text" class="form-control" id="validationCustom04"
								placeholder="도로명 주소를 입력해주세요" name="address" readonly />
							<div class="invalid-feedback">Please provide a valid city.
							</div>
						</div>
						<div class="col-md-1">
							<label for="validationCustom04-1" class="form-label"> 찾기</label>
							<input type="button" class="form-control" type="button"
								value="🔎" onClick="findLoc()" id="validationCustom04-1">
						</div>
						<div class="col-md-4">
							<label for="validationCustom05" class="form-label">방 정보</label> <input
								type="text" class="form-control" id="validationCustom06"
								placeholder="ex)주변 3분거리에 편의점" name="room_info" required />
							<div class="valid-feedback">Looks good!</div>
						</div>
						<div class="col-md-2">
							<label for="validationCustom07" class="form-label">공과금</label> <input
								type="text" class="form-control" id="validationCustom07"
								required name="fee" placeholder="30/1000" />
							<div class="invalid-feedback">Please provide a valid zip.</div>
						</div>
						<div class="col-md-6">
							<label for="validationCustom08" class="form-label">위도</label> <input
								type="text" class="form-control" id="validationCustom08"
								placeholder="도로명 주소(위도)를 입력해주세요" name="lat" readonly />
							<div class="invalid-feedback">Please provide a valid city.</div>
						</div>
						<div class="col-md-6">
							<label for="validationCustom09" class="form-label">경도</label> <input
								type="text" class="form-control" id="validationCustom09"
								placeholder="도로명 주소(경도)를 입력해주세요" name="lng" readonly />
							<div class="invalid-feedback">Please provide a valid city.</div>
						</div>
						<br> <br>
						<div>
							<label for="file1">파일</label> <input type="file" id="file1"
								name="file1" />
							<button id="btn_submit" onclick="javascript:fn_submit()">
								전송</button>
						</div>

						<div>
							<div class="img_wrap">
								<img id="img" />
							</div>
						</div>
						<input type="file" class="real-upload" accept="image/*" required
							multiple>
						<div class="upload"></div>
						<script>
						    function getImageFiles(e) {
						      const files = e.currentTarget.files;
						      console.log(typeof files, files);
						    }
						
						    const realUpload = document.querySelector('.real-upload');
						    const upload = document.querySelector('.upload');
						
						    upload.addEventListener('click', () => realUpload.click());
						    realUpload.addEventListener('change', getImageFiles);
						  </script>

						<!-- <div class="offset-md-2 col-md-9">
							<label for="validationCustom11" class="form-label">방 사진
								업로드</label>
							<div class="input-group">
								<input type="file" class="form-control" id="validationCustom11"
									name="filename">
									aria-describedby="inputGroupFileAddon04" aria-label="Upload">
								<button class="btn btn-outline-secondary" type="button"
									id="inputGroupFileAddon04">찾아보기</button>
							</div>
						</div>  -->
						<br> <br> <br> <br>
						<div class="div_btnbox">
							<input type="submit" value="방 추가"
								class="btn btn-outline-primary btn-lg" /> <input type="reset"
								value="다시작성" class="btn btn-outline-warning"> <input
								class="btn btn-outline-secondary btn-lg" type="button"
								onclick="window.location='/Project/share.do'" value="목록보기" />
						</div>
					</form>
				</div>
			</div>
		</section>
		<!-- 꼬리말 -->
		<footer class="ft">
			<nav class="nav2">
				<ul>
					<li><a href="#">서비스 이용약관</a></li>
					<li class="l1">l</li>
					<li><a href="#">개인정보처리 방침</a></li>
					<li class="l1">l</li>
					<li><a href="#">광고 문의</a></li>
					<li class="l1">l</li>
					<li><a href="#">고객서비스 센터</a></li>
					<li class="l1">l</li>
					<li><a href="#">위치기반 서비스 이용약관</a></li>
				</ul>
			</nav>
			<br />
			<p class="p">
				<a>상호 : (주)위드룸&nbsp;|&nbsp;주소 : 서울특별시 강남구 테헤란로1길
					10&nbsp;|&nbsp;팩스 : 02-123-4567</a> <br /> <a>서비스 이용문의 :
					1234-9876&nbsp;|&nbsp;이메일 : cs@wedroom.com</a>
			</p>
		</footer>
	</div>
</body>
</html>
