function free_Delete(){
	if (confirm("삭제된 글은 복구할 수 없습니다. \n 삭제하시겠습니까?")) {
            document.location.href='/WedRoom0/free_deletePro.do?num=${article.free_no}&pageNum=${pageNum}'
    }
	
 }    
