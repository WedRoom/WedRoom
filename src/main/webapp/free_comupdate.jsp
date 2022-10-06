<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WedRoom</title>
</head>
<body bgcolor="#F8F2C2">
	<div class="container" align="center">
        <img src="image/logo.png" style="height:80px; margin-top:50px;">
			<div class="jumbotron" style="padding-top: 1px;">				
				<h2>댓글 수정</h2>
				<form method="post" name="free_comupdate" action="/WedRoom0/free_comupdatePro.do">
					<textarea placeholder="댓글을 입력해주세요." id="update" style="width:400px;height:100px;border:1px solid #D9D9D9;resize:none;" value=""></textarea>
                    <br><br>
					<input type="submit" onclick=""
                        style="width:80px;height:30px;background-color:#57D2C4;border:0px;color:white;" value="수정">		
				</form>
			</div>
	</div>
</body>
</html>