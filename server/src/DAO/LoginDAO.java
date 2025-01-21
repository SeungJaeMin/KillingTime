package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import ValueObject.MemberVO;

public class LoginDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	public boolean loginAccess(String id, String pw) {
		if(validateUser(id,pw)!=null) {
			return true;
		}		
		return false;
	}
	
	public MemberVO validateUser(String iD, String pW) {
		if((iD == null) || (pW==null) ) {return null;}		
		MemberVO memberVO = new MemberVO();
		String InputId = iD;
		String InputPw = pW;
		File file = new File("./Accountdata/account");
			
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
		String line = null;
		while((line = br.readLine()) != null){
			String[] parts = line.split(" ");
			memberVO.setId(parts[0]);
			memberVO.setPw(parts[1]);
			if(memberVO.getId().equals(InputId) && memberVO.getPw().equals(InputPw))
			{
				memberVO.setName(parts[2]);
				memberVO.setValid(true);
				return memberVO;
			}
		}
		br.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일을 찾지 못했습니다.");
		}		
		return null;
	}
}
