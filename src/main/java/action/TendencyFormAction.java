package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TendencyFormAction implements CommandAction {

	  @Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		   //list.jsp(글쓰기)->신규글, content.jsp(글상세보기->글쓰기(답변글))
		   int id_no=0;
		   
		   //content.do에서 매개변수가 전달
		   if(request.getParameter("id_no")!=null){ //0은 아니고 ,음수X=>양수 1이상
			   id_no=Integer.parseInt(request.getParameter("id_no"));//"3"=>3
		     System.out.println("content.jsp에서 넘어온 매개변수확인");
		     System.out.println("id_no=>"+id_no);
		   }
		   //실행결과->서버의 메모리에 저장->이동
		   request.setAttribute("id_no", id_no);
		   
		return "/tendency.jsp";
	}
}
