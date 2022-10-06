package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import free.board.*;
import free.comment.*;

import java.sql.Timestamp;//추가할 부분(시간)

// /comwritePro.do
public class ComWriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
			System.out.println("ComWriteProAction 불러옴");
		    request.setCharacterEncoding("UTF-8");//한글처리
		    Free_comDTO list=new Free_comDTO();
		    
		    list.setFree_no(Integer.parseInt(request.getParameter("free_no")));
		    list.setId(request.getParameter("id"));
		    list.setContent(request.getParameter("content"));
		    list.setCreated_datetime(new Timestamp(System.currentTimeMillis()));
		    System.out.println("free_no->"+list.getFree_no());
		    System.out.println("id->"+list.getId());
		    System.out.println("content->"+list.getContent()); 
		    
		    Free_comDAO comDao=new Free_comDAO();
		    comDao.writeCom(list);
		    
		return "/free_comwritePro.jsp";
	}
}
