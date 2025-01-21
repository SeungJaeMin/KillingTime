package Control;

import java.rmi.RemoteException;
import java.util.Vector;

import DAO.MiridamgiDAO;
import Interface.ICMiridamgi;
import ValueObject.LectureVO;

public class CMiridamgi implements ICMiridamgi {
	private MiridamgiDAO miridamgiDAO;
	
	
	public CMiridamgi() {
		this.miridamgiDAO = new MiridamgiDAO();
	}

	public Vector<LectureVO> getMiridamgi() throws RemoteException {	
		return this.miridamgiDAO.getMiridamgi();
	}

	@Override
	public void add(Vector<LectureVO> vLectureVector) throws RemoteException {
		this.miridamgiDAO.add(vLectureVector);
	}

	@Override
	public void delete(LectureVO vLecture) throws RemoteException {
		this.miridamgiDAO.delete(vLecture);		
	}



}
