package Control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Vector;

import Interface.ICLogin;
import Interface.ICMiridamgi;
import ValueObject.LectureVO;
import ValueObject.MemberVO;

public class CMiridamgi implements ICMiridamgi {
	
    private ICMiridamgi cMiridamgi;
    public CMiridamgi() {
        Registry registry;
        
        try {
            registry = LocateRegistry.getRegistry(12345);
            cMiridamgi = (ICMiridamgi) registry.lookup("CLectureSelection");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        
    }

	@Override
	public Vector<LectureVO> getMiridamgi() throws RemoteException {
		try {
			return cMiridamgi.getMiridamgi();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public void add(Vector<LectureVO> vLectureVector) throws RemoteException {
		try {
			cMiridamgi.add(vLectureVector);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void delete(LectureVO vLecture) throws RemoteException {
		try {
			cMiridamgi.delete(vLecture);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

  
	
}
