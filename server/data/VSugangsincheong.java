package view;

import java.util.Scanner;

import valueObject.OLecture;
import valueObject.OMember;

public class VSugangsincheong {
	private static final String ROOT_FILENAME = "root";
	private Scanner scanner;
	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;
	
	public VSugangsincheong(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);	
		this.vCollege = new VIndex(this.scanner);	
		this.vDepartment = new VIndex(this.scanner);	
		this.vLecture = new VLecture(this.scanner);
	}

	public void show(OMember oMember) {
		System.out.println(oMember.getName() + "님! 안녕하세요");	
		String collegeFile = this.vCampus.show(ROOT_FILENAME, "캠퍼스를");
		if (collegeFile != null) {
			String departmentFile = this.vCollege.show(collegeFile, "대학을");
			if (departmentFile != null) {
				String lectureFileName = this.vDepartment.show(departmentFile, "학과를");
				if (departmentFile != null) {
					OLecture oLecture = this.vLecture.show(lectureFileName, "강좌를");
				}
			}
		}
	}
}
