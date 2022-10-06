package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.board.*;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pageNum=request.getParameter("pageNum");
	    //추가
	    //String id=request.getParameter("id");//입력 O
	    int free_no=Integer.parseInt(request.getParameter("free_no"));
	    //System.out.println("deletePro.do의 num=>"+num+",id="+id+",pageNum=>"+pageNum);
	    
	    FreeDAO dbPro=new FreeDAO();
	    int check=dbPro.deleteArticle(free_no);
	    
	    //공유
	    request.setAttribute("pageNum", pageNum);
	    request.setAttribute("check", check);
		
		return "/free_deletePro.jsp";
	}
}
