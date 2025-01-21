package Control;

import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Vector;

import Interface.ICLectureSelection;
import Interface.ICLogin;
import ValueObject.LectureVO;
import ValueObject.MemberVO;

public class CLectureSelection implements ICLectureSelection {
	
    private ICLectureSelection cLectureSelection;
	private Vector<LectureVO> lecuture;

    public CLectureSelection() {
        Registry registry;
        
        try {
            registry = LocateRegistry.getRegistry(12345);
            cLectureSelection = (ICLectureSelection) registry.lookup("CLectureSelection");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        
    }

	@Override
	public String getLectureRoot() throws RemoteException {
		String root = null;
		try {
			root = cLectureSelection.getLectureRoot();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return root;
	}


	@Override
	public void delete(LectureVO vLecture) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<LectureVO> getLectureInfo(File lecturefile) throws RemoteException {
		try {
			this.lecuture = cLectureSelection.getLectureInfo(lecturefile);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return lecuture;
	}
	
}
