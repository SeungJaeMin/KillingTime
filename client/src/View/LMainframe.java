package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ValueObject.MemberVO;
import View.LoginPanel.LLoginPanel;
import View.MainPanel.LMainPanel;

public class LMainframe extends JFrame {
	private static final long serialVersionUID = 1L;

	// Associate
	private LLoginPanel loginPanel;
    private LMainPanel mainPanel;
    
    // Design
	private final int CLIENT_WIDTH = 1280;
	private final int CLIENT_HEIGHT = 830;
	private final String CLIENT_TITLE = " 60210808 민승재 / LMS 클라이언트 ";

	  
	public LMainframe() {
		new BorderLayout();
		
		// Set Mainframe property
		this.setPreferredSize(new Dimension(CLIENT_WIDTH, CLIENT_HEIGHT));
		this.setSize(CLIENT_WIDTH, CLIENT_HEIGHT);
		this.setTitle(CLIENT_TITLE);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(rootPaneCheckingEnabled);
		this.setResizable(false);
		setBackground(Color.WHITE);
		
		// 배경디자인 생성		
		
		// 로그인 패널 생성
        createLoginPanel();
        
        // 메인 패널 생성
        createMainPanel();   
		
        this.add(loginPanel);
        this.setVisible(true);		
	}

	public void initialize() {
		this.loginPanel.initialize();
		this.mainPanel.initialize();	
	}
	
    private void createLoginPanel() {
        this.loginPanel = new LLoginPanel();
        this.loginPanel.setLayout(null);
        this.loginPanel.setBounds(0, 0, 400, 300);         
        this.loginPanel.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {               
                // 일반적으로 로그인 패널 내부에 독립적으로 이벤트를 처리하나, 메인 프레임에 다른 패널을 repaint해야하므로, Mainframe 클래스에 처리함.       	
                String username = loginPanel.getUsername(); 
                char[] passwordChars = loginPanel.getPassword(); 
                String password = new String(passwordChars); 
                
                if (loginPanel.loginAccess(username,password)) {
                    remove(loginPanel);
                    add(mainPanel, BorderLayout.CENTER); // mainMenuPanel을 중앙에 추가
                    revalidate();
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(LMainframe.this,
                            "잘못된 사용자 이름 또는 비밀번호입니다. 다시 시도하세요.");
                }            	
            }
        });
    }

	private void createMainPanel() {
        this.mainPanel = new LMainPanel();
        this.mainPanel.setLayout(null);
        this.mainPanel.setBounds(0, 0, 400, 300);

        this.mainPanel.nevigation.buttons[6].addActionListener(new ActionListener() {
            @Override
         // 일반적으로 로그인 패널 내부에 독립적으로 이벤트를 처리하나, 다른 패널을 repaint해야하므로, Mainframe 클래스에 처리함. 
            public void actionPerformed(ActionEvent e) {
                remove(mainPanel);
                add(loginPanel);
                revalidate();
                repaint();
            }
        });
    }
}

