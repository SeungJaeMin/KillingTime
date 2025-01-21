package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
import ValueObject.LectureVO;


public interface ICMyInfo extends Remote {
	public String getLectureRoot() throws RemoteException;
	public Vector<LectureVO> getLectureInfo(String collegeFile) throws RemoteException;
}
