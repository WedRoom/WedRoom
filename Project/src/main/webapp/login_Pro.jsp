<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*"%>

<jsp:useBean id="memMgr" class="member.MemberDAO" />

<%
	//Login.jsp->LoginProc.jsp -> LoginSuccess.jsp
	String id=request.getParameter("id");
	String password=request.getParameter("password");
	///int id_no=0;
	//int id_no=Integer.parseInt(request.getParameter("id_no"));
	
	System.out.println("id=>"+id+",password=>"+password);
	//MemberDAO 객체 필요-> loginCheck() 호출
	//MemberDAO memMgr=new MemberDAO();
	boolean check=memMgr.loginCheck(id, password);	
	//int id_no=memMgr.loginSession(id, password);
	//System.out.println("id_no=>"+id_no);
	
	//MemberDTO mem=new MemberDTO();
	//mem.setId(id);
	//mem.(integer)setId_no(id_no);
	//session.setAttribute("mem",mem);
%>
<%
//check->LoginSuccess.jsp(인증화면),LogError.jsp(에러페이지)
if(check){//if(check==true)인증성공
	session.setAttribute("id", id);
	//session.setAttribute("id_no", id_no);
	//response.sendRedirect("LoginSuccess.jsp");//단순페이지이동
	System.out.println("로그인 성공");
	//System.out.println("id=>"+id+", id_no=>"+id_no);
	response.sendRedirect("main.jsp");
}else{
	System.out.println("로그인 실패");
	response.sendRedirect("LoginError.jsp");
	
}

%>
