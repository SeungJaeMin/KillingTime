package Control;

import java.rmi.RemoteException;
import java.util.Vector;

import Interface.ICMyInfo;
import ValueObject.LectureVO;

public class CMyInfo implements ICMyInfo {

	@Override
	public String getLectureRoot() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<LectureVO> getLectureInfo(String collegeFile) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(LectureVO vLecture) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
