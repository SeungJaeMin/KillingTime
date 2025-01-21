package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
import ValueObject.LectureVO;
import ValueObject.MemberVO;


public interface ICMiridamgi extends Remote {
	public Vector<LectureVO> getMiridamgi() throws RemoteException;
	public void add(Vector<LectureVO> vLectureVector) throws RemoteException;
	public void delete(LectureVO vLecture)throws RemoteException;	
}
