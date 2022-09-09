package _11_4_scheduleManagement;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import _11_0_TrainManagement.TMcontroller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class SMcontroller implements Initializable {
	@FXML
	private CheckBox time7, time9, time11, time13, time15, time17, time19, time21, time23;
	@FXML
	private Label name7, name9, name11, name13, name15, name17, name19, name21, name23;
	private Opener opener;
	private SMService smService;
	private SMDTO smDto = new SMDTO();
	private String point;
	private String trainername;
	private String date;
	private String[] membersId = { "", "", "", "", "", "", "", "", "" };
	private int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public void setOpener(Opener opener) {
		this.opener = opener;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		smService = new SMService();
		smService.setsmDto(smDto);
		TMcontroller tmCon = new TMcontroller();
		point = tmCon.getPoint();
		trainername = tmCon.getName();
		date = tmCon.getDate();

		// 데이터 가져왔는지 확인용
//		System.out.println("sm화면 : " + tmCon.getPoint());
//		System.out.println("sm화면 : " + tmCon.getName());
//		System.out.println("sm화면 : " + tmCon.getDate());
		String[] PTmembers = smService.getMatchMemeber(tmCon.getPoint(), tmCon.getName(), tmCon.getDate(), smDto);
		Label[] label = { name7, name9, name11, name13, name15, name17, name19, name21, name23 };

		for (int i = 0; i < label.length; i++) {
			label[i].setText(PTmembers[i]);
		}
		String[] membersId = { "", "", "", "", "", "", "", "", "" };
		for (int j = 0; j < membersId.length; j++) {
			membersId = smService.getIdmembers(); // 여까지 아
		}
		this.membersId = membersId;

	}

	// 스케줄 관리 화면에서 뒤로가기 버튼 누르면 동작하는 메서드
	public void backProc() {
		opener.tmOpen();
	}

	// 스케줄 관리 화면에서 logo 누르면 동작하는 메서드
	public void homeProc() {
		opener.mmOpen();
	}

	// 스케줄 관리 화면에서 저장 버튼 누르면 동작하는 메서드
	public void saveProc() {
		// checkBox의 참조값 확인용
//		System.out.println("time7 : " + time7.toString().substring(41).replace("'", ""));

		smService = new SMService();
		// 예약된 PT 취소하는 if문들
		if (time7.isSelected() && name7.getText().equals(" ") == false) {
			smService.PTcancel(time7, point, trainername, date);
		}
		if (time9.isSelected() && name9.getText().equals(" ") == false) {
			smService.PTcancel(time9, point, trainername, date);
		}
		if (time11.isSelected() && name11.getText().equals(" ") == false) {
			smService.PTcancel(time11, point, trainername, date);
		}
		if (time13.isSelected() && name13.getText().equals(" ") == false) {
			smService.PTcancel(time13, point, trainername, date);
		}
		if (time15.isSelected() && name15.getText().equals(" ") == false) {
			smService.PTcancel(time15, point, trainername, date);
		}
		if (time17.isSelected() && name17.getText().equals(" ") == false) {
			smService.PTcancel(time17, point, trainername, date);
		}
		if (time19.isSelected() && name19.getText().equals(" ") == false) {
			smService.PTcancel(time19, point, trainername, date);
		}
		if (time21.isSelected() && name21.getText().equals(" ") == false) {
			smService.PTcancel(time21, point, trainername, date);
		}
		if (time23.isSelected() && name23.getText().equals(" ") == false) {
			smService.PTcancel(time23, point, trainername, date);
		}

		// PT예약 없는데 체크해서 저장 시 휴무(DB에 y로 변경 = 회원이 PT예약할 수 없음)
		if (time7.isSelected() && name7.getText().equals(" ")) {
			smService.rest(time7, point, trainername, date);
		}
		if (time9.isSelected() && name9.getText().equals(" ")) {
			smService.rest(time9, point, trainername, date);
		}
		if (time11.isSelected() && name11.getText().equals(" ")) {
			smService.rest(time11, point, trainername, date);
		}
		if (time13.isSelected() && name13.getText().equals(" ")) {
			smService.rest(time13, point, trainername, date);
		}
		if (time15.isSelected() && name15.getText().equals(" ")) {
			smService.rest(time15, point, trainername, date);
		}
		if (time17.isSelected() && name17.getText().equals(" ")) {
			smService.rest(time17, point, trainername, date);
		}
		if (time19.isSelected() && name19.getText().equals(" ")) {
			smService.rest(time19, point, trainername, date);
		}
		if (time21.isSelected() && name21.getText().equals(" ")) {
			smService.rest(time21, point, trainername, date);
		}
		if (time23.isSelected() && name23.getText().equals(" ")) {
			smService.rest(time23, point, trainername, date);
		}

//		// PT취소된 회원 PTcount 반환
//		if (time7.isSelected() && name7.getText().equals(" ")) {
//			smService.PTcountReturn(membersId[0]);
//		}
//		if (time9.isSelected() && name9.getText().equals(" ")) {
//			smService.PTcountReturn(membersId[1]);
//		}
//		if (time11.isSelected() && name11.getText().equals(" ")) {
//			smService.PTcountReturn(membersId[2]);
//		}
//		if (time13.isSelected() && name13.getText().equals(" ")) {
//			smService.PTcountReturn(membersId[3]);
//		}
//		if (time15.isSelected() && name15.getText().equals(" ")) {
//			smService.PTcountReturn(membersId[4]);
//		}
//		if (time17.isSelected() && name17.getText().equals(" ")) {
//			smService.PTcountReturn(membersId[5]);
//		}
//		if (time19.isSelected() && name19.getText().equals(" ")) {
//			smService.PTcountReturn(membersId[6]);
//		}
//		if (time21.isSelected() && name21.getText().equals(" ")) {
//			smService.PTcountReturn(membersId[7]);
//		}
//		if (time23.isSelected() && name23.getText().equals(" ")) {
//			smService.PTcountReturn(membersId[8]);
//		}

		opener.tmOpen();
		CommonService.msg("스케줄 변경 완료");
	}

}
