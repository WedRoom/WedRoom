package action;

import kbk.board.*; 
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		// 1.writePro.jsp의 자바처리 구문
		request.setCharacterEncoding("utf-8");// 한글처리
		System.out.println("request.getParameter(id_no)=>"+request.getParameter("id_no"));
		System.out.println("request.getParameter(room_no)=>"+request.getParameter("room_no"));
		
		RoomDTO room = new RoomDTO();
		//MemberDTO mem = new MemberDTO();
		room.setRoom_no(Integer.parseInt(request.getParameter("room_no")));
		room.setId_no(Integer.parseInt(request.getParameter("id_no")));
		room.setTitle(request.getParameter("title"));
		room.setAddress(request.getParameter("address"));
		room.setView(Integer.parseInt(request.getParameter("view")));
		room.setRoom_count(request.getParameter("room_count"));
		room.setRoom_option(request.getParameter("room_option"));
		room.setFee(request.getParameter("fee"));
		room.setRoom_info(request.getParameter("room_info"));
		room.setLat(Double.parseDouble(request.getParameter("lat")));
		room.setLng(Double.parseDouble(request.getParameter("lng")));
		
		System.out.println("세팅후");
		System.out.println("request.getParameter(id_no)=>"+request.getParameter("id_no"));
		System.out.println("request.getParameter(room_no)=>"+request.getParameter("room_no"));
		
		
		RoomDAO dbPro = new RoomDAO();
		dbPro.insertRoom(room);

		//3.공유->페이지 이동
		return "/share_writePro.jsp";// /list.do로 처리->/list.jsp
	}

}
