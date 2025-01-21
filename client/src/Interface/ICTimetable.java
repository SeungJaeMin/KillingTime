package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
import ValueObject.LectureVO;
import ValueObject.MemberVO;


public interface ICTimetable extends Remote {
	public String getLectureRoot() throws RemoteException;
	public Vector<LectureVO> getLectureInfo(MemberVO member) throws RemoteException;
}
