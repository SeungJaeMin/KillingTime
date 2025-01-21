package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import ValueObject.LectureVO;
import ValueObject.MemberVO;

public class SugangDAO {
	private MemberVO memberVO;
	private String Filepath; 
	private Vector<LectureVO> vLecture;
	
	public SugangDAO(MemberVO memberVO) {
		this.memberVO = memberVO;
		this.Filepath = "./userdata/"+ this.memberVO.getId()+"MySugangShincheng";
        File file = new File(this.Filepath);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("파일이 생성되었습니다.");
                } else {
                    System.out.println("파일 생성에 실패하였습니다.");
                }
            } catch (IOException e) {
                System.out.println("파일 생성 중 오류가 발생하였습니다.");
                e.printStackTrace();
            }
        } else {  }
	}

	public void add(Vector<LectureVO> vLectureVector) {
		// 텍스트 파일에 데이터를 추가하는 매서드
		String seperator = " ";
        try {
            FileWriter writer = new FileWriter(Filepath, true); // append 모드로 파일 열기, 두번째 파라미터의 의미
            int i = 0;
            for(LectureVO lectureVO: vLectureVector) {
                writer.write(vLectureVector.get(i).getCode());
                writer.write(seperator); // 구분자를 추가
                writer.write(vLectureVector.get(i).getLectureName());
                writer.write(seperator);
                writer.write(vLectureVector.get(i).getProfessor());
                writer.write(seperator);
                writer.write(vLectureVector.get(i).getCredit());  
                writer.write(seperator);
                writer.write(vLectureVector.get(i).getLectureTime());
                writer.write(seperator);
                writer.write("\n"); // 다음 줄에 저장하기 위한 CR + LF
                i++;
            }
            writer.close();            
        } catch (IOException e) {
            e.printStackTrace();
        }		
	}

	public Vector<LectureVO> getSugangBasketVector() {
		this.vLecture = new Vector<LectureVO>();
        try {
        FileReader fileReader = new FileReader(Filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
       	while ((line = bufferedReader.readLine()) != null) {
		LectureVO lectureVO = new LectureVO();
       	String[] parts = line.split(" ");
       	lectureVO.setCode(parts[0]);
       	lectureVO.setLectureName(parts[1]);
       	lectureVO.setprofessor(parts[2]);
       	lectureVO.setCredit(parts[3]);
       	lectureVO.setLectureTime(parts[4]);
        String[] lecturetime = parts[4].split("-");
        lectureVO.setLectureDay(parseDayToIndex(parts[4]));
        lectureVO.setStartTime(parseTimeToIndex(lecturetime[0]));
        lectureVO.setEndTime(parseTimeToIndex(lecturetime[1]));       
       	vLecture.add(lectureVO);
       	    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
		return vLecture;
	}

	public void delete(LectureVO vLecture) {
		Vector<LectureVO> storedLecture = new Vector<LectureVO>();
		Vector<LectureVO> newLecture = new Vector<LectureVO>();
		storedLecture = getSugangBasketVector();
		int i = 0;
		for(LectureVO lectureVO : storedLecture) {
			if(!storedLecture.get(i).getCode().equals(vLecture.getCode())) {
				newLecture.add(storedLecture.get(i));
			}
			i++;
		}
		clear();
		add(newLecture);	
		
	}	
	public void clear() {
	    try {
	        FileWriter writer = new FileWriter(Filepath);
	        writer.write("");
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public static int parseTimeToIndex(String time) {
		int i = 0;
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
	
	public static  List<Integer> parseDayToIndex(String time) {
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
	

}
