package Kjh.board;


import java.sql.Timestamp;//DB상의 테이블의 필드와 연관


public class MateDTO {

	
	private int mate_no;//룸메이트게시판번호
	private int id_no;// 아이디일련번호
	private String writer; //작성자
	private String title; //제목
	private String gender; //성별
	private String created_datetime;// 작성일
	private String lifestyle; //라이프스타일
	private int views;//조회수
	private String other_matter; //기타사항
	
	

	public int getMate_no() {
		return mate_no;
	}
	public void setMate_no(int mate_no) {
		this.mate_no = mate_no;
	}
	public int getId_no() {
		return id_no;
	}
	public void setId_no(int id_no) {
		this.id_no = id_no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCreated_datetime() {
		return created_datetime;
	}
	public void setCreated_datetime(String created_datetime) {
		this.created_datetime = created_datetime;
	}
	public String getLifestyle() {
		return lifestyle;
	}
	public void setLifestyle(String lifestyle) {
		this.lifestyle = lifestyle;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getOther_matter() {
		return other_matter;
	}
	public void setOther_matter(String other_matter) {
		this.other_matter = other_matter;
	}


	

	
	
	
}
