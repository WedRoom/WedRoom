package kbk.board;

import java.sql.Timestamp;
import kbk.board.MemberDTO;
public class RoomDTO {
	

	private int room_no;//게시판번호
	private int id_no; //외래키
	private String title;//제목
	private int view;//조회수
	private String address; //주소
	private String room_count; //방갯수
	private String room_option; //옵션
	private String fee; //요금
	private String room_info; //방정보
	private Timestamp created_datetime; //생성날짜
	private Double lat;//위도
	private Double lng;//경도
	
	
	
	public int getId_no() {
		return id_no;
	}
	public void setId_no(int id_no) {
		this.id_no = id_no;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
		//System.out.println("값 확인=>"+lat);
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
		//System.out.println("값 확인=>"+lng);
	}
	public String getTitle() {
		return title.trim();
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRoom_count() {
		return room_count;
	}
	public void setRoom_count(String room_count) {
		this.room_count = room_count;
	}
	public String getRoom_option() {
		return room_option;
	}
	public void setRoom_option(String room_option) {
		this.room_option = room_option;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getRoom_info() {
		return room_info;
	}
	public void setRoom_info(String room_info) {
		this.room_info = room_info;
	}
	public Timestamp getCreated_datetime() {
		return created_datetime;
	}
	public void setCreated_datetime(Timestamp created_datetime) {
		this.created_datetime = created_datetime;
	}
	

}