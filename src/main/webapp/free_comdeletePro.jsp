<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   
<c:if test="${check==1}">
<script>
        alert("댓글이 삭제되었습니다.");
</script>
<meta http-equiv="Refresh" content="0;url=/WedRoom0/free.do?pageNum=${pageNum}">
</c:if>

<%--    <c:if test="${check==1}">
   <meta http-equiv="Refresh" content="0;url=/JspBoard2/list.do?pageNum=${pageNum}">
  </c:if>
  <c:if test="${check==0}">
   <script>
        alert("게시글이 삭제되었습니다.");
   </script> 
  </c:if>  --%>