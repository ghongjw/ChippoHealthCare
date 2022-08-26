package _3_UserMain;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UMController implements Initializable{
	@FXML private Label umIDLabel;
	@FXML private Label umNameLabel,umNameLabel2;
	@FXML private Label umLastday;
	@FXML private Label umPtLabel;
	@FXML private Button umgoToUiButton;
	@FXML private Button umBackButton;
	@FXML private Button umLogoutButton;
	@FXML private Button umpreviousMonth;
	@FXML private Button umNextMonth;
	@FXML private Label sDay01,sDay02,sDay03,sDay04,sDay05,sDay06,sDay07,sDay08,sDay09,sDay10;
	@FXML private Label sDay11,sDay12,sDay13,sDay14,sDay15,sDay16,sDay17,sDay18,sDay19,sDay20;
	@FXML private Label sDay21,sDay22,sDay23,sDay24,sDay25,sDay26,sDay27,sDay28,sDay29,sDay30;
	@FXML private Label sDay31,sDay32,sDay33,sDay34,sDay35;
	@FXML private Label ptReserve01,ptReserve02,ptReserve03,ptReserve04,ptReserve05,ptReserve06,ptReserve07,ptReserve08,ptReserve09,ptReserve10;
	@FXML private Label ptReserve11,ptReserve12,ptReserve13,ptReserve14,ptReserve15,ptReserve16,ptReserve17,ptReserve8,ptReserve19,ptReserve20;
	@FXML private Label ptReserve21,ptReserve22,ptReserve23,ptReserve24,ptReserve25,ptReserve26,ptReserve27,ptReserve28,ptReserve29,ptReserve30;
	@FXML private Label ptReserve31,ptReserve32,ptReserve33,ptReserve34,ptReserve35;
	@FXML private Button umGoTOPerchase;
	@FXML private Button umGoTOBo;
	@FXML private Button umGoToRc;
	@FXML private Button umGoToInboby;
	
	//서비스불러오기
	private UMService umService;
	private String userId;
	private String userName;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	//서비스에서 아이디값 호출
	public void setIdLabel() {
		userId=umService.getId();
		umIDLabel.setText(userId);
	}
	public void setNameLabel() {
		userName=umService.getName();
		umNameLabel.setText(userName);
		umNameLabel2.setText(userName);
	}
	public void umLastday() {
		umPtLabel.setText(umService.getLastDay());
	}
	
	public void umPtLabel() {
		umPtLabel.setText(umService.getPTCount());
	}
}
