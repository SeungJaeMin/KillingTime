package ValueObject;

import java.io.Serializable;

public class MemberVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String pw;
	private String department;
	private String grade;
	private String credit;	
	private boolean valid;
	
	   
	public String getId() {return id;	}
	public String getName() {return name;	}
	public String getPw() {	return pw;	}
	public String getDepartment() {	return department;	}
	public String getGrade() {	return grade;	}
	public String getCredit() {	return credit;	}
	public void setId(String id) {	this.id = id;	}
	public void setPw(String pw) {	this.pw = pw;	}
	public void setValid(boolean valid) {  this.valid = valid;	}
	public boolean getValid() {	return valid;	}
	public void setDepartmemt(String string) { this.department = string;}
	public void setGrade(String string) {this.grade = string;}
	public void setCredit(String string) {this.credit = string;}	
}
