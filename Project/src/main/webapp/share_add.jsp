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
		<link href="test/css/main.css" rel="stylesheet" type="text/css" />
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
			crossorigin="anonymous"
		/>
	</head>
<meta charset="UTF-8">
<title>add test</title>
</head>
<div class="wrap">
			<!-- 로고 -->
			<header class="hd">
				<div class="logo">
					<a href="share.html"><img src="test/img/logo.png" /></a>
				</div>
			</header>
			<!-- 메뉴바 -->
			<nav class="nav">
				<ul class="menu">
					<li><a href="share.html">쉐어하우스</a></li>
					<li><a href="#">룸메이트</a></li>
					<li><a href="#">자유게시판</a></li>
					<li><a href="#">공지사항</a></li>
				</ul>
			</nav>
			<!-- 바디 -->
			<section>
				<div class="section">
					<div class="section2">
						<form class="row g-3 needs-validation" novalidate>
							<div class="col-md-4">
								<label
									for="validationCustom01"
									class="form-label"
									>작성자</label
								>
								<input
									type="text"
									class="form-control"
									id="validationCustom01"
									placeholder="작성자를 입력하시오"
									required
								/>
								<div class="valid-feedback">Looks good!</div>
							</div>
							<div class="col-md-4">
								<label
									for="validationCustom02"
									class="form-label"
									>방 개수</label
								>
								<input
									type="text"
									class="form-control"
									id="validationCustom02"
									placeholder="방 개수를 적어주세요"
									required
								/>
								<div class="valid-feedback">Looks good!</div>
							</div>
							<div class="col-md-4">
								<label
									for="validationCustom02"
									class="form-label"
									>방 옵션</label
								>
								<input
									type="text"
									class="form-control"
									id="validationCustom02"
									placeholder="ex)냉장고,에어컨 보유"
									required
								/>
								<div class="valid-feedback">Looks good!</div>
							</div>
							<div class="col-md-6">
								<label
									for="validationCustom03"
									class="form-label"
									>주소</label
								>
								<input
									type="text"
									class="form-control"
									id="validationCustom03"
									placeholder="서울특별시 종로3가"
									required
								/>
								<div class="invalid-feedback">
									Please provide a valid city.
								</div>
							</div>
							<div class="col-md-3">
								<label
									for="validationCustom02"
									class="form-label"
									>방 정보</label
								>
								<input
									type="text"
									class="form-control"
									id="validationCustom02"
									placeholder="ex)주변 3분거리에 편의점"
									required
								/>
								<div class="valid-feedback">Looks good!</div>
							</div>
							<div class="col-md-3">
								<label
									for="validationCustom05"
									class="form-label"
									>월세</label
								>
								<input
									type="text"
									class="form-control"
									id="validationCustom05"
									required
									placeholder="30/1000"
								/>
								<div class="invalid-feedback">
									Please provide a valid zip.
								</div>
							</div>
							<div class="div_btnbox">
								<input
									type="submit"
									value="방 추가"
									class="btn btn-outline-primary btn-lg"
								/>
								<input
									class="btn btn-outline-secondary btn-lg"
									type="button"
									onclick="location.href='share.html'"
									value="뒤로가기"
								/>
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
					<a
						>상호 : (주)위드룸&nbsp;|&nbsp;주소 : 서울특별시 강남구
						테헤란로1길 10&nbsp;|&nbsp;팩스 : 02-123-4567</a
					>
					<br />
					<a
						>서비스 이용문의 : 1234-9876&nbsp;|&nbsp;이메일 :
						cs@wedroom.com</a
					>
				</p>
			</footer>
		</div>
	</body>
</html>