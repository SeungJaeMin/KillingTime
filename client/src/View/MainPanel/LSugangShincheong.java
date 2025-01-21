package View.MainPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import ValueObject.MemberVO;

public class LSugangShincheong extends JPanel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	// Association
	private LDirectory directory;
	private LTable lectureList;
	public LButtonPanel directoryTolecturelist;
	
	// Components
	
	public LSugangShincheong() {
		// set Design
		setBounds(250,220,1000,600);
		
        // 디버깅용
//		setBackground(Color.BLUE); 
		
		// set Panels
        this.directory = new LDirectory();
        add(directory);
        
        this.lectureList = new LTable();        
        add(lectureList);
        
        this.directoryTolecturelist = new LButtonPanel();
        add(directoryTolecturelist);  
        
	}	
	public void initialize() {		
		this.directory.initialize();
		this.lectureList.initialize();
		
		this.directoryTolecturelist.associate(directory,lectureList);
		this.directoryTolecturelist.initialize();
	}
}

