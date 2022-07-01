import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class subMake extends JPanel {
	
	// ♣ 전부를 감싸는 패널
	private JPanel boxingAll;
	
	// ♣ 1등 번호가 들어가는 패널
	private JPanel luckNum;

	// ♣ 번호가 표시되는 패널 -> 번호는 앞에서 받아온 번호들의 getSource 혹은 getText가 될 것 같다.
	private JPanel lineNum1;
	private JPanel lineNum2;
	private JPanel lineNum3;
	private JPanel lineNum4;
	private JPanel lineNum5;

	// ♣ 콤보박스로 표시한 자동/수동이 표시되는 Label이다.
	// Panel line 앞에 위치한다.
	private JLabel resultCombo;

	// ♣ 1등 ~ 5등까지의 당첨 결과가 표시되는 Label이다.
	// Panel line의 뒤에 위치한다.
	private JLabel resultRank;
	
	public subMake() {
		
		lineNum1 = new JPanel();
		
		boxingAll.add(luckNum);
		
		boxingAll.add(lineNum1);
		boxingAll.add(lineNum2);
		boxingAll.add(lineNum3);
		boxingAll.add(lineNum4);
		boxingAll.add(lineNum5);
		
 

	}
	
	
	
	// ♣ 만들어낸 Panel과 Label을 return 받기 위해 getter를 만들었다.
	// 혹시 몰라서 만들었는데, 나중에 값을 수정할 때 개별 호출이 필요할 수도 있을 것 같아서 만들었다.
	
	
	
}
