package View.LoginPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Control.CLogin;
import ValueObject.MemberVO;

public class LLoginPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
    private JPasswordField txtPassword;
    public JButton btnLogin;
    public JButton btnRegister;
    private Image backgroundImage;
    
    private CLogin clogin;

    public LLoginPanel() {
        this.clogin = new CLogin();    	
    	
    	setLayout(null);

        this.backgroundImage = new ImageIcon("./uidesign/background_login.png").getImage();

        this.txtUsername = new JTextField();
        txtUsername.setBounds(70, 255, 381, 49);
        txtUsername.setBorder(null);
        txtUsername.setOpaque(true);
        add(txtUsername);

        this.txtPassword = new JPasswordField();
        txtPassword.setBounds(70, 354, 381, 49);
        txtPassword.setBorder(null);
        txtPassword.setOpaque(true);
        add(txtPassword);

        this.btnLogin = new JButton();
        btnLogin.setIcon(new ImageIcon("./uidesign/btn_loginpanel_login.png"));
        btnLogin.setBounds(70, 493, 381, 49);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setFocusPainted(false);
        add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Login 버튼 클릭 시 수행할 작업
            }
        });

        this.btnRegister = new JButton();
        btnRegister.setIcon(new ImageIcon("./uidesign/btn_loginpanel_register.png"));
        btnRegister.setBounds(123, 558, 290, 19);
        btnRegister.setBorderPainted(false);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setFocusPainted(false);
        add(btnRegister);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LRegister();
            }
        }); 
       
    }

    public String getUsername() {
        return this.txtUsername.getText();
    }

    public char[] getPassword() {
        return this.txtPassword.getPassword();
    }

    public void initialize() {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

	public boolean loginAccess(String username, String password) {
		return this.clogin.loginAccess(username,password);
	}	

	public MemberVO getUserInfo(String username, String password) {
		// TODO Auto-generated method stub
		return this.clogin.getUserinfo(username,password);
	}

}
