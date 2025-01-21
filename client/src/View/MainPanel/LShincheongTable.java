/**
 * 
 */
package View.MainPanel;

import java.awt.Component;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ValueObject.LectureVO;

public class LShincheongTable extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private JTable table;

	public LShincheongTable() {
        tableModel = new DefaultTableModel(new String[]{"요일", "시간", "강좌이름", "학점", "강의자이름"}, 0);
        table = new JTable(tableModel);        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 500, 1000, 100); // JTable이 위치할 좌표와 크기 설정
        add(scrollPane);
	}

	public void initialize() {
	
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addRow(LectureVO lecture) {
		tableModel.addRow(new Object[]{
                lecture.getlectureDay(),
                lecture.getStartTime() + "-" + lecture.getEndTime(),
                lecture.getLectureName(),
                lecture.getCredit(), 
                lecture.getProfessor()
        });;		
	}

	public void addRow(Object[] rowData) {
		// TODO Auto-generated method stub
		
	}


}
