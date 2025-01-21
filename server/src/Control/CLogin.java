package Control;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import DAO.LoginDAO;
import Interface.ICLogin;
import ValueObject.MemberVO;

public class CLogin extends UnicastRemoteObject implements ICLogin {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO;

	public CLogin() throws RemoteException {
		this.loginDAO = new LoginDAO();
	}

	@Override
	public boolean loginAccess(String Id, String Pw) throws RemoteException {
		System.out.println("[RMI-SERVER] 로그인을 시도했습니다.");
		return this.loginDAO.loginAccess(Id, Pw);
	}

	@Override
	public MemberVO getMemberVO(String Id, String Pw) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("[RMI-SERVER] 로그인에 성공했습니다.");
		System.out.println("[RMI-SERVER] 유저정보를 열람했습니다.");
		return this.loginDAO.validateUser(Id,Pw);
	}
}
