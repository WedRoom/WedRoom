package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComDeleteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		 //deleteForm.jsp?num=2&pageNum=1->deletePro.jsp(deleteArticle)
		int free_no=Integer.parseInt(request.getParameter("free_no"));//게시물번호
		int comment_no=Integer.parseInt(request.getParameter("comment_no"));//댓글번호
		String pageNum=request.getParameter("pageNum");//페이지 번호
	    System.out.println("deleteForm.do의 free_no=>"+free_no+",comment_no=>"+comment_no+",pageNum=>"+pageNum);
	    
	    request.setAttribute("free_no", free_no);
	    request.setAttribute("comment_no", comment_no);
	    request.setAttribute("pageNum", pageNum);
		
		return "/free_comdelete.jsp";
	}

}
