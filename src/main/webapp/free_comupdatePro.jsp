<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   
	<c:if test="${check==1}">
		<meta http-equiv="Refresh" content="0;url=/WedRoom0/free.do?pageNum=${pageNum}">
	</c:if>
	<c:if test="${check==0}">
		<script>
	        alert("수정권한이 없습니다.");
	        history.go(-1);
		</script> 
	</c:if> 