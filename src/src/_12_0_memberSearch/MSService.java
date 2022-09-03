package _12_0_memberSearch;

import java.util.ArrayList;

public class MSService {
	private MSDAO msDao = new MSDAO();

	public ArrayList<MSDTO> getMemberInfo(String name, MSDTO msDto) {
		return msDao.getMemberInfo(name, msDto);
	}

	public ArrayList<MSDTO> getAllData() {
		return msDao.getAllData();
	}

}
