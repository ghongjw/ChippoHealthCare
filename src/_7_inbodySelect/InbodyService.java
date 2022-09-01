package _7_inbodySelect;

import java.util.ArrayList;

import _7_1_inbodyResister.InbodyRegDAO;

public class InbodyService {

	private InbodyDAO inbodydao;

	public InbodyService() {
		inbodydao = new InbodyDAO();

	}

	public void selectdate(String date) {

		inbodydao.selectdate(date);
		InbodyDTO selectinbody = inbodydao.selectdate(date);

		System.out.println("나이 : " + selectinbody.getAge());
		System.out.println("신장 : " + selectinbody.getHeight());
		System.out.println("무게 : " + selectinbody.getWeight());
		System.out.println("근육량 : " + selectinbody.getMusle());
		System.out.println("체지방량 : " + selectinbody.getPat());
		System.out.println("체지방률 : " + selectinbody.getPatper());
		System.out.println("bmi : " + selectinbody.getBmi());

	}

	public ArrayList<InbodyDTO> getdate() {

		return inbodydao.getdate();

	}
}
