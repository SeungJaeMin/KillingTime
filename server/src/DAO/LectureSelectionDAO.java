package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import ValueObject.LectureVO;


public class LectureSelectionDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String root = "E:\\J_Workspace_Mju\\SGFinalServer\\data";

	public Vector<LectureVO> getLectureVector(File lecturefile) {
		if(lecturefile == null) {return null;}
		
		Vector<LectureVO> lectureVector = new Vector<LectureVO>();
		   try (BufferedReader reader = new BufferedReader(new FileReader(lecturefile))) {
		        String line;
		        while ((line = reader.readLine()) != null) {
		            LectureVO lectureVO = new LectureVO();
		            String[] parts = line.split(" ");
		            lectureVO.setCode(parts[0]);
		            lectureVO.setLectureName(parts[1]);
		            lectureVO.setprofessor(parts[2]);
		            lectureVO.setCredit(parts[3]);
		            lectureVO.setLectureTime(parts[4]);
		            String[] lecturetime = parts[4].split("-");
		            lectureVO.setLectureDay(parsingDayToIndex(parts[4]));
		            lectureVO.setStartTime(parsingTimeToIndex(lecturetime[0]));
		            lectureVO.setEndTime(parsingTimeToIndex(lecturetime[1]));       
		            lectureVector.add(lectureVO);
		        }
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		        System.out.println("인덱스를 찾지 못했습니다.");
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		
		return lectureVector;
	}
	
	public static int parsingTimeToIndex(String time) {
		int i = 0;
		time = time.replace("~", "-").replace(":", "").replace(",","");
		while(i<time.length()) {
			char ch = time.charAt(i);
			if(Character.isDigit(ch)) {
			    int hours = Integer.parseInt(time.substring(i, i+2));
			    int minutes = Integer.parseInt(time.substring(i+2,i+4));
			    return (hours - 9) + (minutes >= 30 ? 1 : 0);            	       
			}
			else {i++;}
		}		
	    int hours = Integer.parseInt(time.substring(0, 2));
	    int minutes = Integer.parseInt(time.substring(2));
	    return (hours - 9) * 2 + (minutes >= 30 ? 1 : 0);
	}
	
	public static  List<Integer> parsingDayToIndex(String time) {
		List<Integer> dayindex = new ArrayList<>();
		String daysOfWeek = "월화수목금토일";
		int i = 0;
		while(i<time.length()) {
			char ch = time.charAt(i);
			if(daysOfWeek.contains(Character.toString(ch))) {
	            int dayIndex = daysOfWeek.indexOf(ch);
	            dayindex.add(dayIndex);
	            i++;       
			}
			else {i++;}
		}
		return dayindex;
	}

	public String getRoot() {		
		return this.root;
	}

}
