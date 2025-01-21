package View.MainPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LNevigation extends JPanel{
	private static final long serialVersionUID = 1L;
	// Components
    private Image backgroundImage;
    public JRadioButton[] buttons;
    private ImageIcon[] onIcons;
    private ImageIcon[] offIcons;
    private int numButtons = 7;
    
    // Associations
    private LMaininfo maininfo;
    private LSugangShincheong sugang;
    private LMiridamgi miri;
    private LTimeTable timetable;
    private LMyInfo myinfo;
	
    
    public LNevigation() {
        // 배경 이미지 설정
        this.backgroundImage = new ImageIcon("./uidesign/background_nevi.png").getImage();
        Dimension size = new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size.width,size.height);
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
               
        this.buttons = new JRadioButton[this.numButtons];
        this.onIcons = new ImageIcon[this.numButtons];
        this.offIcons = new ImageIcon[this.numButtons];
        ButtonGroup group = new ButtonGroup();

        for (int i = 0; i < this.numButtons; i++) {
            this.onIcons[i] = new ImageIcon("./uidesign/btn_nevi_off" + i + ".png");
            this.offIcons[i] = new ImageIcon("./uidesign/btn_nevi_on" + i + ".png");

            this.buttons[i] = createRadioButton(i);
            gbc.gridy = i;
            add(this.buttons[i], gbc);
            group.add(this.buttons[i]);
        }        
    }

    private JRadioButton createRadioButton(int index) {
    	JRadioButton button = new JRadioButton();
        this.onIcons[index] = createIcon("./uidesign/btn_nevi_off" + index + ".png");
        this.offIcons[index] = createIcon("./uidesign/btn_nevi_on" + index + ".png");

    	    
        button.setIcon(this.offIcons[index]); // 초기 상태는 Off 이미지로 설정
        button.setSelectedIcon(this.onIcons[index]);
        
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                handleButtonAction(index);
            }
        });               
        return button;
    }
	public void associate(LMaininfo maininfo, LSugangShincheong sugang, LMiridamgi miri, LTimeTable timetable,
			LMyInfo myinfo) {
            this.maininfo = maininfo;
	        this.sugang = sugang;
	        this.miri = miri;
	        this.timetable = timetable;
	        this.myinfo = myinfo;		
	}
	
    private void showPanel(JPanel panel) {
        // 다른 패널들을 숨기고, 클릭된 버튼에 해당하는 패널을 보여줌
        maininfo.setVisible(false);
        sugang.setVisible(false);
        miri.setVisible(false);
        timetable.setVisible(false);
        myinfo.setVisible(false);
        
        panel.setVisible(true);
    }      

    private void handleButtonAction(int index) {    	
        switch (index) {            
            case 0: showPanel(maininfo); break; // 버튼 0 : 메인화면 이벤트 처리                  
            case 1: showPanel(sugang); break;  // 버튼 1 : 수강신청 이벤트 처리
            case 2: showPanel(miri); break; // 버튼 2 : 미리담기 이벤트 처리 
            case 3:	showPanel(timetable); break; // 버튼 3 : 시간표확인 이벤트 처리
            case 4: showPanel(myinfo); break; // 버튼 4 : 내정보확인 이벤트 처리 
            case 5: break; // 버튼 5 : 메세지확인 이벤트 처리
            case 6: break; // 로그아웃은 메인 화면으로 처리했음
            default: break; // 이하 버튼들에 대한 이벤트 처리 추가 가능      
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 배경 이미지 그리기
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
    
    private ImageIcon createIcon(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedImage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();

        return new ImageIcon(bufferedImage);
    }

	public void initialize() {
		this.buttons[0].setSelected(true);
        showPanel(maininfo);		
	}	
}
