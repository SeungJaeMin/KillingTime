package View.MainPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ValueObject.MemberVO;

public class LMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Component
	public LNevigation nevigation;
	private LMaininfo maininfo;
	private LSugangShincheong sugang;
	private LMiridamgi miri;
	private LTimeTable timetable;
	private LMyInfo myinfo;
	public JButton btnLogout;
	
	
	// Cash
	private MemberVO userInfo;


	
	
	public LMainPanel() {	
        setLayout(null);
 
        this.nevigation = new LNevigation();
        this.add(nevigation);

        this.maininfo = new LMaininfo();        
        this.add(maininfo);
        
        this.sugang = new LSugangShincheong();
        this.add(sugang);
        
        this.miri = new LMiridamgi();
        this.add(miri);
        
        this.timetable = new LTimeTable();
        this.add(timetable);
        
        this.myinfo = new LMyInfo();
        this.add(myinfo);
	}	


	public void initialize() {			
		this.maininfo.initialize();
		this.sugang.initialize();
		this.miri.initialize();
		this.timetable.initialize();
		this.myinfo.initialize();
		
		this.sugang.directoryTolecturelist.associateToTable(this.miri.lMiriTable, this.miri.lShincheongTable);
		
		this.nevigation.associate(maininfo, sugang, miri, timetable, myinfo);
		this.nevigation.initialize();
	}
	
	public void getMember(MemberVO Member) {
		this.userInfo = Member;
	}

}
