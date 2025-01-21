package ValueObject;

import java.io.Serializable;
import java.util.List;

public class LectureVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private String credit;
	private String lectureTime;
	private String lecturer;
	private List<Integer> lectureDay;
	private int startTime;
	private int endTime;
	
	// 시간, 단위를 만드는건 굉장히 어렵지만 일단 나중에 생각해야함.
	
	public LectureVO() {
		// TODO Auto-generated constructor stub
	}
	public String getCode() {return code;}
	public String getLectureName() {return name;}
	public String getCredit() {return credit;}
	public String getLectureTime() {return lectureTime;}
	public String getProfessor() {return lecturer;}
	public List<Integer> getlectureDay() {return lectureDay;}
	public int getStartTime() {return startTime;}
	public int getEndTime() {return endTime;}
	public void setCode(String code) {this.code = code;}
	public void setLectureName(String name) {this.name = name;}
	public void setCredit(String credit) {this.credit = credit;}
	public void setprofessor(String professor) {this.lecturer = professor;}
	public void setLectureTime(String time) {this.lectureTime = time;}
	public void setLectureDay(List<Integer> list) {this.lectureDay = list;}
	public void setStartTime(int i) {this.startTime = i;}
	public void setEndTime(int i) {this.endTime = i;}
	
	
	
//	public void load(Scanner file) {
//		
//	}
//	public void show() {
//		System.out.println(this.getCode() + " : " + this.getLectureName() + " : " + this.getProfessor() + " : " +this.getCredit() + " : " + this.getLectureTime());			
//	}
}
