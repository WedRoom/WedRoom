package free.comment;

import java.sql.Timestamp;

public class Free_comDTO {
	
	private int comment_no,free_no,id_no;
	
	private String id;
	private String content;
	
	private Timestamp created_datetime;//작성일
	private Timestamp update_datetime;//수정일
	
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public int getFree_no() {
		return free_no;
	}
	public void setFree_no(int free_no) {
		this.free_no = free_no;
	}
	public int getId_no() {
		return id_no;
	}
	public void setId_no(int id_no) {
		this.id_no = id_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreated_datetime() {
		return created_datetime;
	}
	public void setCreated_datetime(Timestamp created_datetime) {
		this.created_datetime = created_datetime;
	}
	public Timestamp getUpdate_datetime() {
		return update_datetime;
	}
	public void setUpdate_datetime(Timestamp update_datetime) {
		this.update_datetime = update_datetime;
	}
	
}
