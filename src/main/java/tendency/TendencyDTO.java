package tendency;

public class TendencyDTO {
	
	private int id_no;//아이디 일련번호
	private String start_time;//출근시간
	private String end_time;//퇴근시간
	private String sleep_time;//수면시간
	private String shower_time;//샤워시간
	private String sleepinghabbit;//잠버릇
	private String smoking;//흡연유무
	private String pet;//반려동물유무
	
	public int getId_no() {
		return id_no;
	}
	public void setId_no(int id_no) {
		this.id_no = id_no;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getSleep_time() {
		return sleep_time;
	}
	public void setSleep_time(String sleep_time) {
		this.sleep_time = sleep_time;
	}
	public String getShower_time() {
		return shower_time;
	}
	public void setShower_time(String shower_time) {
		this.shower_time = shower_time;
	}
	public String getSleepinghabbit() {
		return sleepinghabbit;
	}
	public void setSleepinghabbit(String sleepinghabbit) {
		this.sleepinghabbit = sleepinghabbit;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public String getPet() {
		return pet;
	}
	public void setPet(String pet) {
		this.pet = pet;
	}
	
}
