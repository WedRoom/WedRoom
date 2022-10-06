package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kbk.board.RoomDAO;
import kbk.board.RoomDTO;

public class WriteFormAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        System.out.println("0.room_no확인");
        int room_no=0;
        System.out.println("room_no->"+room_no);
        
        if (request.getParameter("room_no") != null) {
            room_no = Integer.parseInt(request.getParameter("room_no"));
            System.out.println("content.jsp에서 넘어온 매개변수확인");
            System.out.println("room_no=>" + room_no );
        }

        // 2.처리한결과를 공유(서버메모리에 저장)=>이동할 페이지에 공유해서 사용(request)
        request.setAttribute("room_no", room_no);

        
        // 3.공유해서 이동할 수 있도록 페이지를 지정
        return "/share_writeForm.jsp";
    }

}