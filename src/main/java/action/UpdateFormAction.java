package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.board.*;

public class UpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//1.content.jsp->글수정버튼 클릭->updateForm.do?num=3&pageNum=1
		   int free_no=Integer.parseInt(request.getParameter("free_no"));//게시물번호
		   String pageNum=request.getParameter("pageNum");//페이지 번호
		   System.out.println("UpdateFormAction에서의 pageNum=>"+pageNum);//0
		   FreeDAO dbPro=new FreeDAO();//메서드 호출목적
		   FreeDTO article=dbPro.updateGetArticle(free_no);//조회수가 증가X
		  
		//2.서버의 메모리에 저장
		  request.setAttribute("pageNum", pageNum);
		  request.setAttribute("article",article);
		
		return "/free_update.jsp";
	}
}
