package _6_Record;

public class RcService {
	RcDAO rcDao = new RcDAO();
	RcDTO rcDto=new RcDTO();
	
	public RcService() {
		rcDao.setBcDto(rcDto);
	}
	public void setRsetRecordInsertecord(String id, String date, String startT, String endTime, String text) {
		
		if(rcDao.dateExiste(id, date).equals("")) {
		rcDao.setRecordInsert(id,date,startT,endTime,text);}
		else {
			rcDao.setRecordUpdate(id,date,startT,endTime,text);
		}
		
	}
	
	public void discon() {
		rcDao.disconnection();
		
	}
	public void setRsetRecord(String id, String clikedDate) {
		if(rcDao.dateExiste(id, clikedDate).equals("")) {
			
		}else {
			
		}
		
	}
	
	public RcDTO getBcDto() {
		return rcDto;
	}
	public void setBcDto(RcDTO bcDto) {
		this.rcDto = bcDto;
	}

}
