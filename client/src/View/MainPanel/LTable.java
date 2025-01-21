package View.MainPanel;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ValueObject.LectureVO;

public class LTable extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTable table;
    private DefaultTableModel tableModel;
	private Object lMiriTable;
	private Object lShincheongTable;
    
    public LTable() {
        // JTable 생성
        tableModel = new DefaultTableModel(new String[]{"요일", "시간", "강좌이름", "학점", "강의자이름"}, 0);
        table = new JTable(tableModel);        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 0, 500, 550); // JTable이 위치할 좌표와 크기 설정
        add(scrollPane);
    }			

	public void initialize() {
		// TODO Auto-generated method stub
		
	}

    public void addLecture(Vector<LectureVO> lectures) {
        for (LectureVO lecture : lectures) {
            // LectureVO로부터 각각의 값을 가져와서 JTable에 추가
            tableModel.addRow(new Object[]{
                    lecture.getlectureDay(),
                    lecture.getStartTime() + "-" + lecture.getEndTime(),
                    lecture.getLectureName(),
                    lecture.getCredit(), 
                    lecture.getProfessor()
            });
        }
    }



	public void deleteLectureRow() {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	        tableModel.removeRow(selectedRow);
	    }
	}
	
	public void sendLectureRow(JPanel TargetPanel, LectureVO lecture) {
		
	}

	public void moveToShincheong(LShincheongTable lShincheongTable) {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	        Object[] rowData = new Object[lShincheongTable.getColumnCount()];
	        for (int i = 0; i < rowData.length; i++) {
	            rowData[i] = table.getValueAt(selectedRow, i);
	        }
	        lShincheongTable.addRow(rowData);
	        // 선택한 행을 삭제하는 코드 추가
	        tableModel.removeRow(selectedRow);
	    }
	}

	public void moveToMiri(LMiriTable lMiriTable) {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	        Object[] rowData = new Object[lMiriTable.getColumnCount()];
	        for (int i = 0; i < rowData.length; i++) {
	            rowData[i] = table.getValueAt(selectedRow, i);
	        }
	        lMiriTable.addRow(rowData);
	        // 선택한 행을 삭제하는 코드 추가
	        tableModel.removeRow(selectedRow);
	    }
	}

	
	public void associate(LMiriTable lMiriTable, LShincheongTable lShincheongTable) {
	    this.lMiriTable = lMiriTable;
	    this.lShincheongTable = lShincheongTable;
	}	

}
