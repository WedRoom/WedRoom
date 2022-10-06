package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tendency.*;

//import java.sql.Timestamp;//추가할 부분(시간)


public class TendencyProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		     request.setCharacterEncoding("UTF-8");//한글처리
		     TendencyDTO tend=new TendencyDTO();
		     
		     tend.setId_no(Integer.parseInt(request.getParameter("id_no")));
		     tend.setStart_time(request.getParameter("start_time"));
		     tend.setEnd_time(request.getParameter("end_time"));
		     tend.setSleep_time(request.getParameter("sleep_time"));
		     tend.setShower_time(request.getParameter("shower_time"));
		     tend.setSleepinghabbit(request.getParameter("sleepinghabbit"));
		     tend.setSmoking(request.getParameter("smoking"));
		     tend.setPet(request.getParameter("pet"));
		     
		     TendencyDAO tenDao=new TendencyDAO();
		     tenDao.insertTendency(tend);
		return "/tendencyPro.jsp";
	}
}
