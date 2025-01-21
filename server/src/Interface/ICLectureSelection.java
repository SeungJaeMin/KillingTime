package Interface;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
import ValueObject.LectureVO;


public interface ICLectureSelection extends Remote {
	public String getLectureRoot() throws RemoteException;
	public void delete(LectureVO vLecture)throws RemoteException;
	public Vector<LectureVO> getLectureInfo(File lecturefile) throws RemoteException;

}
