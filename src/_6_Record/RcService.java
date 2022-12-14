package _6_Record;

import java.util.regex.Pattern;

import _0_main.CommonService;

public class RcService {
	RcDAO rcDao = new RcDAO();
	RcDTO rcDto = new RcDTO();

	private String StartT = "";
	private String EndTime = "";

	public RcService() {
		rcDao.setBcDto(rcDto);
	}

	public void setRsetRecordInsertecord(String id, String date, String startT, String endTime, String text) {

		if (rcDao.dateExiste(id, date).equals("")) {
			rcDao.setRecordInsert(id, date, startT, endTime, text);
		} else {
			rcDao.setRecordUpdate(id, date, startT, endTime, text);
		}

	}

	public void discon() {
		rcDao.disconnection();

	}

	public void setRsetRecord(String id, String clikedDate) {
		if (rcDao.dateExiste(id, clikedDate).equals("")) {
			rcDto.setWorkoutTimeLabelT("운동을 기록해 보세요");
			rcDto.setSavedTimeLabelT(" ");
			rcDto.setFirstT(" ");
			rcDto.setSecondT(" ");
			rcDto.setThirdT(" ");
			rcDto.setForthT(" ");

		} else if (!rcDao.dateExiste(id, clikedDate).equals("")) {
			rcDto.setWorkoutTimeLabelT("운동 기록");
			rcDao.setRctext(id, clikedDate);
			rcDto.setSavedTimeLabelT("WORKOUT TIME : "+rcDto.getStartTime() + "~" + rcDto.getEndTime());
			memoSplite();

		}
		if (rcDao.ptDateExiste(id, clikedDate).equals("")) {
			rcDto.setPtReserviedLabelT("PT예약이 없습니다.");


		} else if (!rcDao.ptDateExiste(id, clikedDate).equals("")) {
			rcDao.setPttext(id, clikedDate);


			if(rcDto.getPtbooked().equals("T1")) {
				rcDto.setPtReserviedLabelT("PT예약 : 오전 7시 "+rcDto.getTrainer() + " 트레이너 " + rcDto.getPoint());
			}else if(rcDto.getPtbooked().equals("T2")) {
				rcDto.setPtReserviedLabelT("PT예약 : 오전 9시 "+rcDto.getTrainer() + " 트레이너 "+ rcDto.getPoint());
			}
			else if(rcDto.getPtbooked().equals("T3")) {
				rcDto.setPtReserviedLabelT("PT예약 : 오전 11시 "+rcDto.getTrainer() + " 트레이너 "+ rcDto.getPoint());
			}
			else if(rcDto.getPtbooked().equals("T4")) {
				rcDto.setPtReserviedLabelT("PT예약 : 13시 "+rcDto.getTrainer() + " 트레이너 "+ rcDto.getPoint());
			}
			else if(rcDto.getPtbooked().equals("T5")) {
				rcDto.setPtReserviedLabelT("PT예약 : 15시 "+rcDto.getTrainer() + " 트레이너 "+ rcDto.getPoint());
			}
			else if(rcDto.getPtbooked().equals("T6")) {
				rcDto.setPtReserviedLabelT("PT예약 : 17시 "+rcDto.getTrainer() + " 트레이너 "+ rcDto.getPoint());
			}
			else if(rcDto.getPtbooked().equals("T7")) {
				rcDto.setPtReserviedLabelT("PT예약 : 19시 "+rcDto.getTrainer() + " 트레이너 "+ rcDto.getPoint());
			}
			else if(rcDto.getPtbooked().equals("T8")) {
				rcDto.setPtReserviedLabelT("PT예약 : 21시 "+rcDto.getTrainer() + " 트레이너 "+ rcDto.getPoint());
			}else if(rcDto.getPtbooked().equals("T9")) {
				rcDto.setPtReserviedLabelT("PT예약 : 23시 "+rcDto.getTrainer() + " 트레이너 "+ rcDto.getPoint());
			}
			//memoSplite();
		}

	}

	public RcDTO getBcDto() {
		return rcDto;
	}

	public void setBcDto(RcDTO bcDto) {
		this.rcDto = bcDto;
	}

	public void saveButtonclick(String sHour, String sMin, String eHour, String eMin, String date, String textAreaMemo,
			String id) {
		int sh = 0;
		int eh = 0;
		int sm = 0;
		int em = 0;
		try {
			sh = Integer.parseInt(sHour);
			eh = Integer.parseInt(eHour);
			sm = Integer.parseInt(sMin);
			em = Integer.parseInt(eMin);
		} catch (Exception e) {
			//CommonService.msg("시간을 입력 해 주세요");
		}
		if (date == null || sHour == null || sMin == null || eHour == null || eMin == null) {
			CommonService.msg("시간을 입력 해 주세요");
		} else {
			if (em < sm) {
				if (eh <= sh) {
					CommonService.msg("시간을 역행하고 있어요!");
				} else {
					rcDto.setStartTime(sHour + ":" + sMin);
					rcDto.setEndTime(eHour + ":" + eMin);
					setRsetRecordInsertecord(id, date, rcDto.getStartTime(), rcDto.getEndTime(), textAreaMemo);
					if (textAreaMemo.length() > 100) {
						CommonService.msg("공백 포함 100자만 입력해 주세요");
					} else {
						rcDto.setStartTime(sHour + ":" + sMin);
						rcDto.setEndTime(eHour + ":" + eMin);
						setRsetRecordInsertecord(id, date, rcDto.getStartTime(), rcDto.getEndTime(), textAreaMemo);

						CommonService.msg("저장되었습니다");
					}
				}
			} else {
				rcDto.setStartTime(sHour + ":" + sMin);
				rcDto.setEndTime(eHour + ":" + eMin);
				setRsetRecordInsertecord(id, date, rcDto.getStartTime(), rcDto.getEndTime(), textAreaMemo);
				if (textAreaMemo.length() > 100) {
					CommonService.msg("공백 포함 100자만 입력해 주세요");
				} else {
					rcDto.setStartTime(sHour + ":" + sMin);
					rcDto.setEndTime(eHour + ":" + eMin);
					setRsetRecordInsertecord(id, date, rcDto.getStartTime(), rcDto.getEndTime(), textAreaMemo);
					CommonService.msg("저장되었습니다");
				}

			}
		}

	}

	public void memoSplite() {
		if(rcDto.getRecordMemo()!=null) {
			String str = rcDto.getRecordMemo();
			rcDto.setFirstT(str);
		}
	}


	public RcDTO getRcDto() {
		return rcDto;
	}

	public void setRcDto(RcDTO rcDto) {
		this.rcDto = rcDto;
	}

}
