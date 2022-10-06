package free.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;//ArrayList,List을 사용

import free.board.FreeDTO;
import free.comment.DBConnectionMgr;

//자유게시판 댓글
public class Free_comDAO {

	//1.객체생성할 멤버변수선언
	private DBConnectionMgr pool=null;//DB
	
	private Connection con=null;
	private PreparedStatement pstmt=null;//SQL구문실행
	private ResultSet rs=null;//select
	private String sql="";//실행시킬 SQL구문
	
	//2.생성자를 통해 DB연결
	public Free_comDAO() {
		try {
			pool=DBConnectionMgr.getInstance();//DB생성 객체 불러오기
			System.out.println("pool=>"+pool);
		} catch(Exception e) {
			System.out.println("DB접속 오류=>"+e);
		}
	}
	
	//3.메서드처리
	//(1)게시물 당 댓글 수
	public int getCountCom(int free_no) {
		int x=0;
		try {
			con=pool.getConnection();
			System.out.println("con=>"+con);
			sql="select count(*) from Free_com where free_no=?";
			pstmt=con.prepareStatement(sql);//저장
			pstmt.setInt(1, free_no);
			rs=pstmt.executeQuery();//실행
			if(rs.next()) {
				x=rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("getNextCom() 에러유발=>"+e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;//댓글이 없는 경우
	}
	
//	//(1)게시물 당 댓글 수
//	public int getNextCom(int free_no) {
//		int x=0;
//		try {
//			con=pool.getConnection();
//			System.out.println("con=>"+con);
//			sql="select comment_no from Free_com where free_no=? order by comment_no desc";
//			pstmt=con.prepareStatement(sql);//저장
//			pstmt.setInt(1, free_no);
//			rs=pstmt.executeQuery();//실행
//			if(rs.next()) {
//				x=rs.getInt(1);
//			}
//		} catch(Exception e) {
//			System.out.println("getNextCom() 에러유발=>"+e);
//		} finally {
//			pool.freeConnection(con, pstmt, rs);
//		}
//		return x;//댓글이 없는 경우
//	}
	
//	//(2)댓글 보기?
//	public List<Free_comDTO> getComs(int free_no) {
//	String SQL="select * from Free_com where free_no=? order by comment_no desc";
//	List<Free_comDTO> comList=new ArrayList();
//	try {
//		con=pool.getConnection();
//		pstmt=con.prepareStatement(SQL);
//		pstmt.setInt(1, free_no);
//		rs=pstmt.executeQuery();
//		while(rs.next()) {
//			Free_comDTO com=new Free_comDTO();
//			  com.setComment_no(rs.getInt("comment_no"));
//			  com.setFree_no(rs.getInt("free_no"));
//			  com.setId(rs.getString("id"));
//			  com.setContent(rs.getString("content"));
//			  com.setCreated_datetime(rs.getTimestamp("created_datetime"));
//			  comList.add(com);//생략하면 데이터가 저장X->for문 에러유발
//		}
//	} catch(Exception e) {
//		System.out.println("getComs() 메서드 에러유발=>"+e);
//	} finally {
//		pool.freeConnection(con, pstmt, rs);
//	}
//	return comList;
//	
//}
	
		//(2)댓글 보기?
		public ArrayList<Free_comDTO> getComs(int free_no) {
		String SQL="select * from Free_com where free_no=? order by comment_no desc";
		ArrayList<Free_comDTO> comList=null;
		try {
			con=pool.getConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setInt(1, free_no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				comList=new ArrayList<Free_comDTO>();
				do {
					  Free_comDTO com=new Free_comDTO();
					  com.setComment_no(rs.getInt("comment_no"));
					  com.setFree_no(rs.getInt("free_no"));
					  com.setId(rs.getString("id"));
					  com.setContent(rs.getString("content"));
					  com.setCreated_datetime(rs.getTimestamp("created_datetime"));
					  comList.add(com);//생략하면 데이터가 저장X->for문 에러유발
					}while(rs.next());
				}
		} catch(Exception e) {
			System.out.println("getComs() 메서드 에러유발=>"+e);
		}
		return comList;
		
	}
	
	//(2)댓글보기
	public Free_comDTO getListCom(int free_no) {
	String SQL="select * from Free_com where free_no=? order by comment_no desc";
	Free_comDTO list=null;
	try {
		con=pool.getConnection();
		pstmt=con.prepareStatement(SQL);
		pstmt.setInt(1, free_no);
		rs=pstmt.executeQuery();
		if(rs.next()) {
				list=new Free_comDTO();
				list.setComment_no(rs.getInt("comment_no"));
				list.setFree_no(rs.getInt("free_no"));
				list.setId(rs.getString("id"));
				list.setContent(rs.getString("content"));
				list.setCreated_datetime(rs.getTimestamp("created_datetime"));
				System.out.println(rs);
			}
	} catch(Exception e) {
		System.out.println("getListCom() 메서드 에러유발=>"+e);
	}
	return list;
	
}
	
	//(3)댓글 쓰기
	public void writeCom(Free_comDTO list) {
		int free_no=list.getComment_no();//0 신규글
		System.out.println("writeCom에서 free_no=>"+free_no);
	
		int number=0;
		try {
			con=pool.getConnection();
			sql="select max(comment_no) from Free_com";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {//보여주는 결과가 있다면
				int max=rs.getInt(1);
				list.setComment_no(max+1);
				System.out.println("writeCom메서드의 getComment_no=>"+list.getComment_no());
			}else {
				number=1;//테이블에 한개의 데이터가 없다면
			}
			sql="insert into Free_com(comment_no,free_no,id,content,created_datetime)values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, list.getComment_no());
			pstmt.setInt(2, list.getFree_no());
			pstmt.setString(3, list.getId());
			pstmt.setString(4, list.getContent());
			pstmt.setTimestamp(5, list.getCreated_datetime());
			int write=pstmt.executeUpdate();
			System.out.println("Comment_no"+list.getComment_no());
			System.out.println("댓글쓰기 성공유무(write)=>"+write);
		} catch (Exception e) {
			System.out.println("writeCom()메서드 에러유발=>"+e);
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}
		
	}
	
	//(4)댓글 수정
	//1)수정할 데이터를 찾을 메서드 필요
		public Free_comDTO updateGetCom(int comment_no) {
			
	        Free_comDTO list=null;
			try {
				con=pool.getConnection();
				sql="select * from Free_com where comment_no=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, comment_no);
				rs=pstmt.executeQuery();
				if(rs.next()) {//보여주는 결과가 있다면
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, list.getComment_no());
					pstmt.setInt(2, list.getFree_no());
					pstmt.setString(3, list.getId());
					pstmt.setString(4, list.getContent());
					pstmt.setTimestamp(5, list.getCreated_datetime());
				}
			}catch(Exception e) {
				System.out.println("updateGetCom() 에러유발=>"+e);
			}finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return list;
		}
		
		//2)수정시키는 메서드 작성
			public int updateCom(Free_comDTO list) {
				int x = -1;
				try {
					con = pool.getConnection();
					sql = "update Free_com set content=?,created_datetime=? where comment_no=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, list.getContent());
					pstmt.setTimestamp(2, list.getCreated_datetime());
					pstmt.setInt(3, list.getComment_no());
					int update = pstmt.executeUpdate();
					System.out.println("게시판의 글수정 성공유무(update)=>" + update);
					x = 1;
				} catch (Exception e) {
					System.out.println("updateCom() 메서드 에러유발=>" + e);
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return x;
			}
	
	//(5)댓글 삭제
			public int deleteCom(int comment_no) {
				int x = -1;// 게시물의 삭제성공유무
				try {
					con = pool.getConnection();
					sql = "delete from Free_com where comment_no=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, comment_no);
					int delete= pstmt.executeUpdate();
					System.out.println("게시판의 글삭제 성공유무(delete)=>" + delete);
					x = 1;// 삭제성공유무
				} catch (Exception e) {
					System.out.println("deleteCom() 메서드 에러유발=>" + e);
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return x;
			}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	1)게시글 당 댓글 총 갯수
//	public int getCommentCount(int free_no) { 
//		int x=0;//해당 게시글 댓글갯수를 저장
//		try {
//			con=pool.getConnection();
//			System.out.println("con=>"+con);
//			sql="select count(*) from Free_com where free_no=?";//작성
//			pstmt=con.prepareStatement(sql);//저장
//			pstmt.setInt(1, free_no);
//			rs=pstmt.executeQuery();//실행
//			if(rs.next()) {
//				x=rs.getInt(1);
//			}
//		}catch(Exception e) {
//			System.out.println("getCommentCount() 에러유발=>"+e);
//		}finally {
//			pool.freeConnection(con, pstmt, rs);
//		}
//		return x;
//	}
//	
//	public ArrayList<Free_comDTO> getList(int free_no,int pageNumber) {
//		String SQL="select * from Free_com where comment_no<? and free_no=? order by comment_no desc";
//		ArrayList<Free_comDTO> list=new ArrayList<Free_comDTO>();
//		try {
//			con=pool.getConnection();
//			pstmt=con.prepareStatement(SQL);
//			pstmt.setInt(1, getNext()-(pageNumber-1)*10);
//			pstmt.setInt(2, free_no);
//			rs=pstmt.executeQuery();
//				while(rs.next()) {
//					Free_comDTO com=new Free_comDTO();
//					com.setComment_no(rs.getInt("comment_no"));
//					com.setFree_no(rs.getInt("free_no"));
//					com.setId(rs.getString("id"));
//					com.setContent(rs.getString("content"));
//					com.setCreated_datetime(rs.getTimestamp("created_datetime"));
//					list.add(com);
//				}
//		} catch(Exception e) {
//			System.out.println("getList() 메서드 에러유발=>"+e);
//		}
//		return list;
//		
//	}
//	
//	public int getNext() {
//		String SQL="select comment_no from Free_com order by comment_no desc";
//		try {
//		
//			PreparedStatement pstmt=con.prepareStatement(SQL);
//			rs=pstmt.executeQuery();
//			if(rs.next()) {
//				System.out.println(rs.getInt(1)); // select문에서 첫번째 값
//				return rs.getInt(1)+1;  // 현재 인덱스(현재 게시글 개수) +1 반환
//			}
//			return 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
//	}
//	
//	public String getDate() {
//		String SQL="select now()";
//		try {
//		
//			PreparedStatement pstmt=con.prepareStatement(SQL);
//			rs=pstmt.executeQuery();
//			if(rs.next()) {
//				return rs.getString(1);  // 현재 날짜 반환
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
//	
//	public int write(int free_no,String content,String id) {
//		String SQL="insert into Free_com(comment_no,free_no,id,content,created_datetime)values(?,?,?,?,?)";
//		
//		try {
//			con=pool.getConnection();
//			pstmt=con.prepareStatement(SQL);
//			pstmt.setInt(1,getNext());
//			pstmt.setInt(2, free_no);
//			pstmt.setString(3,id);
//			pstmt.setString(4,content);
//			pstmt.setString(5,getDate());
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
//		
//	}
//	
	
}
