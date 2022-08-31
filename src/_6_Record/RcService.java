package _6_Record;

public class RcService {
	RcDAO rcDao = new RcDAO();
	public void setRsetRecordInsertecord(String id, String date, String startT, String endTime, String text) {
		
		if(rcDao.dateExiste(id, date).equals("")) {
		rcDao.setRecordInsert(id,date,startT,endTime,text);}
		else {
			System.out.println(rcDao);
			rcDao.setRecordUpdate(id,date,startT,endTime,text);
		}
		
	}

}
