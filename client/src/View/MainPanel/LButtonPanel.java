package View.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import ValueObject.LectureVO;

public class LButtonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// Components
	private JButton btnMoveMiridamgi;
	private JButton btnShincheong;
	private JButton btnMoveData;
	private JButton btndelete;
	
	// Association
	private LTable lectureList;
	private LDirectory directory;

	private LMiriTable lMiriTable;

	private LShincheongTable lShincheongTable;

	
	
	public LButtonPanel() {
        // 버튼 생성 및 추가
		ActionHandler actionhandler = new ActionHandler();
        this.btndelete = new JButton("<<");
        this.btndelete.setBounds(450, 560, 100, 50);
        this.btndelete.addActionListener(actionhandler);
        add(btndelete);
        
        this.btnMoveData = new JButton(">>");
        this.btnMoveData.setBounds(500, 560, 100, 50);
        this.btnMoveData.addActionListener(actionhandler);
        add(btnMoveData);
		
		this.btnMoveMiridamgi = new JButton("미리담기");
		this.btnMoveMiridamgi.setBounds(50, 560, 200, 50);        
		this.btnMoveMiridamgi.addActionListener(actionhandler);
        add(btnMoveMiridamgi);

        this.btnShincheong = new JButton("신청하기");
        this.btnShincheong.setBounds(250, 560, 200, 50); 
        this.btnShincheong.addActionListener(actionhandler);
        add(btnShincheong);
	}
	public void associate(LDirectory directory, LTable lectureList) {
	    this.directory = directory;
	    this.lectureList = lectureList;
	}	

	public void initialize() {
		
	}
	
	public void moveDirectoryToTable() {
		Vector<LectureVO> lectures = this.directory.getLecture(directory.getSelectedFile());		
		this.lectureList.addLecture(lectures);
	}
	
	public void deleteRowOnTable() {
		this.lectureList.deleteLectureRow();
	}
	
	public void moveTableToShincheong() {
		this.lectureList.moveToMiri(lMiriTable);
	}
	
	public void moveTableToMiridamgi() {
		this.lectureList.moveToShincheong(lShincheongTable);
		
	}
	public void associateToTable(LMiriTable lMiriTable, LShincheongTable lShincheongTable) {
	    this.lMiriTable = lMiriTable;
	    this.lShincheongTable = lShincheongTable;
	}

private class ActionHandler implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnMoveMiridamgi) {
			moveTableToMiridamgi();
		}
		if(e.getSource()==btnShincheong) {
			moveTableToShincheong();
		}
		if(e.getSource()==btnMoveData) {
			moveDirectoryToTable();
		}
		if(e.getSource()==btndelete) {
			deleteRowOnTable();
		}
    }
	


}




}
