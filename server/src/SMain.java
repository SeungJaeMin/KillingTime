import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Interface.ICLectureSelection;
import Interface.ICLogin;
import Interface.ICMiridamgi;
import Interface.ICMyInfo;
import Interface.ICTimetable;
import ValueObject.MemberVO;
import Control.CLectureSelection;
import Control.CLogin;
import Control.CMiridamgi;
import Control.CMyInfo;
import Control.CTimeTable;

public class SMain {

    public static void main(String[] args) {
        SMain main = new SMain();
        main.run();
    }

    private void run() {
        try {
            ICLogin login = new CLogin();
            ICLectureSelection cLectureSelection = new CLectureSelection();
            ICMiridamgi miridamgi = new CMiridamgi();
            ICMyInfo myInfo = new CMyInfo();
            ICTimetable timetable = new CTimeTable();
            Registry registry = LocateRegistry.createRegistry(12345);
            registry.rebind("Login", login);
            registry.rebind("CLectureSelection", cLectureSelection);
            registry.rebind("miridamgi", miridamgi);
            registry.rebind("myInfo", myInfo);
            registry.rebind("timetable", (Remote) timetable);
            
            System.out.println("서버가 실행 중입니다. 클라이언트 요청을 대기합니다.");

            // 서버가 계속 대기하도록 처리 (수동으로 종료될 때까지 실행됨)
            Object lock = new Object();
            synchronized (lock) {
                lock.wait();
            }

        } catch (Exception e) {
            System.err.println("서버 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }
}






