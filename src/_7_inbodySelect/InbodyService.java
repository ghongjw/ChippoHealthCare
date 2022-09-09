package _7_inbodySelect;

import java.util.ArrayList;

import _3_UserMain.UMController;
import _7_1_inbodyResister.InbodyRegDAO;

public class InbodyService {

	private InbodyDAO inbodydao;
	

	public InbodyService() {
		inbodydao = new InbodyDAO();

	}

//	public void selectdate(String date) {
//
//		InbodyDTO selectinbody = inbodydao.selectdate(date, UMController.staticId);
//
//		System.out.println("나이 : " + selectinbody.getAge());
//		System.out.println("신장 : " + selectinbody.getHeight());
//		System.out.println("무게 : " + selectinbody.getWeight());
//		System.out.println("근육량 : " + selectinbody.getMusle());
//		System.out.println("체지방량 : " + selectinbody.getFat());
//		System.out.println("체지방률 : " + selectinbody.getFatper());
//		System.out.println("bmi : " + selectinbody.getBmi());
//
//	}

	public ArrayList<String> getdate(String id) {
		 ArrayList<String> inbodysS=inbodydao.getdate(id);
		return inbodysS;

	}
}
