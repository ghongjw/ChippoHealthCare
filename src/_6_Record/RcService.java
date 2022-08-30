package _6_Record;

public class RcService {

	public void setRecord(String id, String date, String startT, String endTime, String text) {
		RcDAO rcDao = new RcDAO();
		if(rcDao.dateExiste(id, date).equals("")) {
		rcDao.setRecordinsert(id,date,startT,endTime,text);}
		else {
			rcDao.setRecordUpdate(id,date,startT,endTime,text);
		}
		
		
	}

}
