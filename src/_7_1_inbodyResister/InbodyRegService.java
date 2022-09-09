package _7_1_inbodyResister;

import java.time.LocalDate;
import java.util.ArrayList;

import _0_main.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class InbodyRegService {

	private InbodyRegDAO inbodyregdao = new InbodyRegDAO();

	public void inbodyResisterProc(ComboBox year, ComboBox month, ComboBox day, TextField height, TextField age,
			TextField weight, TextField musle, TextField fat, TextField fatper, TextField bmi ,String id) {

		InbodyRegDTO irDto = new InbodyRegDTO();

		irDto.setYear(year.getId());
		irDto.setMonth(month.getId());
		irDto.setDay(day.getId());
		irDto.setHeight(height.getText());
		irDto.setAge(age.getText());
		irDto.setWeight(weight.getText());
		irDto.setMusle(musle.getText());
		irDto.setfat(fat.getText());
		irDto.setfatper(fatper.getText());
		irDto.setBmi(bmi.getText());
		
		

		String dates = "";

		dates = year.getValue().toString() + "-" + month.getValue().toString() + "-" + day.getValue().toString();
		System.out.println(dates);

		irDto.setDates(dates);

		inbodyregdao.insert(irDto, id);

		CommonService.dateArr(dates);
	}

}
