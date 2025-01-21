package Control;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import DAO.LectureSelectionDAO;
import DAO.LoginDAO;
import Interface.ICLectureSelection;
import Interface.ICLogin;
import ValueObject.LectureVO;
import ValueObject.MemberVO;

public class CLectureSelection extends UnicastRemoteObject implements ICLectureSelection {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LectureSelectionDAO lectureSelectionDAO;

	public CLectureSelection() throws RemoteException {
		this.lectureSelectionDAO = new LectureSelectionDAO();
	}

	@Override
	public String getLectureRoot() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("[RMI-SERVER] 강좌폴더 주소를 인식했습니다.");
		return lectureSelectionDAO.getRoot();
	}

	@Override
	public void delete(LectureVO vLecture) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<LectureVO> getLectureInfo(File lecturefile) throws RemoteException {	
		System.out.println("[RMI-SERVER] 강좌정보 : "+ lecturefile.getName() +"를 열람했습니다.");
		return lectureSelectionDAO.getLectureVector(lecturefile);
	}
}
