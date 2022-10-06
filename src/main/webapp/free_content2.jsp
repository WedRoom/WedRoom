<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WedRoom</title>
    <link href="css/free_content.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="wrap">
        <!-- 로고 -->
        <header class="hd">
            <div class="logo">
                <a href="#"><img src="image/logo.png"></a>
            </div>
        </header>
        <!-- 메뉴바 -->
        <nav class="nav">
            <ul class="menu">
                <li><a href="#">쉐어하우스</a></li>
                <li><a href="#">룸메이트</a></li>
                <li><a href="#">자유게시판</a></li>
                <li><a href="#">공지사항</a></li>
            </ul>
        </nav>
        <!-- 자유게시판(본문) -->
        <article class="freeboard">
            <p class="tiele">자유게시판</p>
            <div class="board_control">
                <a href="#" class="board_update" onclick="document.location.href='/WedRoom0/free_updateForm.do?num=${article.free_no}&pageNum=${pageNum}'">수정</a>&nbsp;&nbsp;
                <a href="#" class="board_delete" onclick="document.location.href='/WedRoom0/free_deleteForm.do?num=${article.free_no}&pageNum=${pageNum}'">삭제</a>
            </div>
            <div class="board">
                <table class="table">
                    <thead>
                    <tr>
                        <td class="td-title">${article.title}</td>
                        <td>${article.id}</td>
                        <td><fmt:formatDate value="${article.created_datetime}"  timeStyle="medium" pattern="yy.MM.dd" /></td>
                        <td>${article.views}</td>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="td-content" colspan="4">${article.content}</td>
                        </tr>
                    </tbody>
                </table>
                <div class="btn">
                    <button class="btn_list" type="button" onclick="document.location.href='/WedRoom0/free.do?pageNum=${pageNum}'">목록</button>
                </div>
            </div>
        </article>

        <!-- 댓글-->
        <article class="board_comment">
            <div class="comment">
                <span class="count">
                    💬 <strong>1</strong>개의 댓글이 있습니다. 
                </span>
                <form class="text">
                    <textarea id="comment" title="댓글 입력" rows="2" placeholder="댓글을 입력해주세요."></textarea>  
                    <input type="submit" class="btn_review" value="등록">
                </form>
            </div>
            <div class="comment-review">
                <table class="comment-table">
                    <tr>
                        <td><strong>wedroom</strong></td>
                    </tr>
                    <tr>
                        <td>안녕하세요!! ^^*</td>
                    </tr>
                    <tr>
                        <td class="date">2022.09.01</td>
                    </tr>
                    <form class="btn-comment">
                        <input type="submit" class="btn-update" value="수정">
                        <input type="submit" class="btn-delete" value="삭제">
                    </form>
                </table>

            </div>
        </article>

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
            <br>
            <p class="p">
                <a>상호 : (주)위드룸&nbsp;|&nbsp;주소 : 서울특별시 강남구 테헤란로1길 10&nbsp;|&nbsp;팩스 : 02-123-4567</a>
                <br>
                <a>서비스 이용문의 : 1234-9876&nbsp;|&nbsp;이메일 : cs@wedroom.com</a>
            </p>
        </footer>
    </div>
</body>
</html>