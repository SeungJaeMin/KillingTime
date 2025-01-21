package Control;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Interface.ICLogin;
import ValueObject.MemberVO;

public class CMyInfo {
	
    private ICLogin clogin; 
    private MemberVO member;

    public CMyInfo() {
        Registry registry;
        
        try {
            registry = LocateRegistry.getRegistry(12345);
            clogin = (ICLogin) registry.lookup("Login");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        
    }

    public boolean loginAccess(String username, String password) {
        boolean result = false;
        try {
            result = clogin.loginAccess(username, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return result;
    }

	public MemberVO getUserinfo(String username, String password) {
		try {
			this.member = clogin.getMemberVO(username, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	
}
