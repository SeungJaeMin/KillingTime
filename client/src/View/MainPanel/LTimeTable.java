package View.MainPanel;

import java.awt.Dimension;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.CTimetable;
import ValueObject.LectureVO;
import ValueObject.MemberVO;

public class LTimeTable extends JPanel  {
	
	private String[][] schedule;
	private Vector<LectureVO> vLectureVector;
	private CTimetable cTimetable;
	private MemberVO member;

	public LTimeTable() {
		this.member = new MemberVO();
		this.member = member;
		
		CTimetable cTimetable = new CTimetable();
		vLectureVector = new Vector<LectureVO>();
		
		String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
	    DefaultTableModel model = new DefaultTableModel(schedule, days);
	    JTable table = new JTable(model);

	    // JScrollPane에 JTable 추가
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setPreferredSize(new Dimension(1000, 700));

	    // 패널에 JScrollPane 추가
	    JPanel panel = new JPanel();
	    panel.add(scrollPane);

	}
	
	public void showMyTable(MemberVO member) {
	    int i = 0;
	   
		try {
			this.vLectureVector = cTimetable.getLectureInfo(member);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // 강의 요일과 시간 정보를 2차원 매트릭스로 저장할 배열 생성
	    this.schedule = new String[10][5];

	    for (LectureVO vLecture : vLectureVector) {
	        vLecture = vLectureVector.get(i);
	        int startTimeIndex = vLecture.getStartTime();
	        int endTimeIndex = vLecture.getEndTime();
	        List<Integer> lectureDays = vLecture.getlectureDay();

	        for (int j = startTimeIndex; j <= endTimeIndex; j++) {
	            for (Integer dayIndex : lectureDays) {
	                // 해당 강의 요일과 시간을 매트릭스에 매핑
	                schedule[j][dayIndex] = vLecture.getLectureName();
	            }
	        }
	        i++;
	    }
	}

	public void initialize() {
				
	}
}
