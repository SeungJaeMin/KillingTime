package View.MainPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LMiriButtonPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	// Components
	private JButton btnmiriCancel;
	private JButton btnShincheongCancel;
	private JButton btnShincheong;
	
	// Association
	private LMiriTable lMiriTable;
	private LShincheongTable ShincheongTable;

	
	
	public LMiriButtonPanel() {
		setBounds(0, 265, 700, 100);
		
        // 버튼 생성 및 추가
		ActionHandler actionhandler = new ActionHandler();
        this.btnmiriCancel = new JButton("미리담기 취소");
        this.btnmiriCancel.setBounds(450, 560, 100, 50);
        this.btnmiriCancel.addActionListener(actionhandler);
        add(btnmiriCancel);
        
        this.btnShincheongCancel = new JButton("수강신청 취소");
        this.btnShincheongCancel.setBounds(500, 560, 100, 50);
        this.btnShincheongCancel.addActionListener(actionhandler);
        add(btnShincheongCancel);
		
		this.btnShincheong = new JButton("수강신청하기");
		this.btnShincheong.setBounds(50, 560, 200, 50);        
		this.btnShincheong.addActionListener(actionhandler);
        add(btnShincheong);
	}
	public void associate(LMiriTable lMiriTable, LShincheongTable ShincheongTable) {
	    this.lMiriTable = lMiriTable;
	    this.ShincheongTable = ShincheongTable;
	}	

	public void initialize() {
		
	}


   private class ActionHandler implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnmiriCancel) {
			
		}
		if(e.getSource()==btnShincheongCancel) {
			
		}
		if(e.getSource()==btnShincheong) {
	
		}
    }


}
}




