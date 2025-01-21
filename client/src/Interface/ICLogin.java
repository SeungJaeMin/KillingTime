package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import ValueObject.MemberVO;

public interface ICLogin extends Remote {
	public boolean loginAccess(String Id, String Pw) throws RemoteException;

	public MemberVO getMemberVO(String username, String password) throws RemoteException;
}
