package View.MainPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ValueObject.MemberVO;

public class LMiridamgi extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Associate
	public LMiriTable lMiriTable;
	public LShincheongTable lShincheongTable;
	private LMiriButtonPanel lMiriButtonPanel;

	private MemberVO member;
	
	public LMiridamgi() {
		this.member = new MemberVO();
		this.member = member;
		
		setBounds(250,220,1000,500);
        
        this.lMiriTable = new LMiriTable();
        this.add(lMiriTable);
        
        this.lShincheongTable = new LShincheongTable();
        this.add(lShincheongTable);
        
        this.lMiriButtonPanel = new LMiriButtonPanel();
        this.add(lMiriButtonPanel);
  
    
    }	
    public void initialize() {		
	this.lMiriTable.initialize();
	this.lShincheongTable.initialize();
    }
}
