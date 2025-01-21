package DAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import ValueObject.MemberVO;

public class MyInfoDAO {
	
	@SuppressWarnings("null")
	public MemberVO validateUser(String iD, String pW) {
		if((iD == null) || (pW==null) ) {System.out.println("값을 입력하십시오.");return null;}		
		MemberVO memberVO = new MemberVO();
		String InputId = iD;
		String InputPw = pW;
		File file = new File("./data/Account.txt");
			
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
		String line = null;
		while((line = br.readLine()) != null){
			String[] parts = line.split(" ");
			memberVO.setId(parts[0]);
			memberVO.setPw(parts[1]);
			if(memberVO.getId().equals(InputId) && memberVO.getPw().equals(InputPw))
			{
				memberVO.setName(parts[2]);
				memberVO.setDepartmemt(parts[3]);
				memberVO.setGrade(parts[4]);
				memberVO.setCredit(parts[5]);
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
