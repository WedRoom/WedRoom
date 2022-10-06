<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WedRoom</title>
<script language="JavaScript">           
/*   function deleteSave(){	
	  var result = comfirm("삭제된 글은 복구할 수 없습니다. 정말로 삭제하시겠습니까?");
      if(result) {
      	alert("삭제가 완료되었습니다.")
      } else {
      	history.go(-1);	
      }
}          */

  	if(window.confirm("삭제된 댓글은 복구할 수 없습니다. \n삭제하시겠습니까?")){
  		document.location.href='/WedRoom0/free_comdeletePro.do?pageNum=${pageNum}&free_no=${free_no}&comment_no=${list.comment_no}'
  	} else {
  		history.go(-1);
  	}
    
      
  	
 
</script>
</head>
<body>

</body>
</html>