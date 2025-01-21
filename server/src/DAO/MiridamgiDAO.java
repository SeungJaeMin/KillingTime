package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import ValueObject.LectureVO;
import ValueObject.MemberVO;

public class MiridamgiDAO {
	private String Filepath;
	private Vector<LectureVO> vLecture;
	private MemberVO memberVO;

	public MiridamgiDAO() {
		this.Filepath = "./AccountData/Mybag";
        File file = new File(this.Filepath);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("[RMI-SERVER] 미리담기 파일이 생성되었습니다.");
                } else {
                    System.out.println("[RMI-SERVER] 미리담기 파일 생성에 실패하였습니다.");
                }
            } catch (IOException e) {
                System.out.println("[RMI-SERVER] 파일 생성 중 오류가 발생하였습니다.");
                e.printStackTrace();
            }
        } else {  }
	}

	public void add(Vector<LectureVO> vLectureVector) {
		// 텍스트 파일에 데이터를 추가하는 매서드
//		checkOwnFolder(memberVO);
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

	public Vector<LectureVO> getMiridamgi() {		
//		checkOwnFolder(memberVO);		
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
       	vLecture.add(lectureVO);
       	    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
		return vLecture;
	}

	public void delete(LectureVO vLecture) {
		checkOwnFolder(memberVO);		
		Vector<LectureVO> storedLecture = new Vector<LectureVO>();
		Vector<LectureVO> newLecture = new Vector<LectureVO>();
		storedLecture = getMiridamgi();
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
	
	public void checkOwnFolder(MemberVO memberVO) {
		this.memberVO = memberVO;	
	}


}
