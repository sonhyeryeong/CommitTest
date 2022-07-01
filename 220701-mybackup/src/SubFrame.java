

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
//두번째 화면- 당첨 확인하는 창

/*
 * SubFrame: 로또 당첨 확인을 위한 두 번째 창
 * pnl: 큰 프레임
 * lbl: 입력창인 것을 표시해주기 위한 라벨 
 * btnReset: 첫번째 창으로 돌아가기 위한 버튼
 * btnEnd: 시스템 종료 버튼
 * */

//커밋테스트

public class SubFrame extends JPanel {
	// getter setter 만들기 위해 필드로 선언
	private JButton btnReset2;
	private JButton btnEnd;

	// 두 번째 창 세부 만들기
	// 나중에 혹시 호출하거나 메소드로 불러와야할 것 같은 것들만 선언해줬다.

	// ♣ 1등 번호가 들어가는 Label
	private JLabel luckLine;

	// ♣ 번호 표시 패널 안에 숫자가 표시되는 Label을 넣는다.
	private JLabel numLine1;
	private JLabel numLine2;
	private JLabel numLine3;
	private JLabel numLine4;
	private JLabel numLine5;

	// ♣ 콤보박스로 표시한 자동/수동이 표시되는 Label이다.
	// Panel line 앞에 위치한다.
	private JLabel resultCombo1;
	private JLabel resultCombo2;
	private JLabel resultCombo3;
	private JLabel resultCombo4;
	private JLabel resultCombo5;

	// ♣ 1등 ~ 5등까지의 당첨 결과가 표시되는 Label이다.
	// Panel line의 뒤에 위치한다.
	private JLabel resultRank1;
	private JLabel resultRank2;
	private JLabel resultRank3;
	private JLabel resultRank4;
	private JLabel resultRank5;

	// 두번째 창- 로또 당첨 확인창을 생성자로 만듬
	public SubFrame() {
		// 큰 패널
		JPanel pnl = new JPanel();
		JLabel lbl = new JLabel("확인창");

		// ♣ 다섯줄과 일등번호 나오는 곳을 전부를 감싸는 Panel
		// 따로 메소드에 쓸 일이 없을 것 같아서 이곳에 바로 선언했다.
		// 근데 생각해보니까 Sub에 이미 혜령이가 큰 걸 만들어뒀따.
		// NullPointerException 오류가 계속 떠서........ 일단 만들어봤따.
		// JPanel boxingAll = new JPanel();

		JPanel topPnl = new JPanel();
		JPanel middlePnl = new JPanel();
		JPanel bottomPnl = new JPanel();
		
		// ♣ 1등 번호 Panel
		JPanel luckyHere = new JPanel();
		
		// ♣ 1등 번호가 들어가는 Label
		luckLine = new JLabel("1등 번호가 들어가는 곳");
		
		// ♣ 번호가 표시되는 패널 -> 번호는 앞에서 받아온 번호들의 getSource 혹은 getText가 될 것 같다.
		JPanel line1 = new JPanel();
		JPanel line2 = new JPanel();
		JPanel line3 = new JPanel();
		JPanel line4 = new JPanel();
		JPanel line5 = new JPanel();
		
		// ♣ 일단 눈에 보이도록 하려고 글자를 넣어뒀다.
		numLine1 = new JLabel("숫자 여섯개가  표시되는 곳 1");
		numLine2 = new JLabel("숫자 여섯개가  표시되는 곳 2");
		numLine3 = new JLabel("숫자 여섯개가  표시되는 곳 3");
		numLine4 = new JLabel("숫자 여섯개가  표시되는 곳 4");
		numLine5 = new JLabel("숫자 여섯개가  표시되는 곳 5");

		resultCombo1 = new JLabel("수동");
		resultCombo2 = new JLabel("자동");
		resultCombo3 = new JLabel("수동");
		resultCombo4 = new JLabel("자동");
		resultCombo5 = new JLabel("수동");

		resultRank1 = new JLabel("당첨");
		resultRank2 = new JLabel("당첨");
		resultRank3 = new JLabel("당첨");
		resultRank4 = new JLabel("당첨");
		resultRank5 = new JLabel("당첨");

		// ♣ 1등 번호가 표시되는 Panel 에 1등 숫자들이 표시되는 Label을 넣었따.
		// 1등 번호가 들어가는 곳은 panel topPnl
		luckyHere.add(luckLine);
		luckyHere.setBackground(Color.cyan);
		BoxLayout luckBox = new BoxLayout(topPnl, BoxLayout.X_AXIS);
		topPnl.setLayout(luckBox);
		
		topPnl.add(luckyHere);
		topPnl.setBackground(Color.red);
		
		// 번호가 들어가는 줄은 panel middlePnl
		
		// ♣ 첫번째 줄
		// 첫번째 숫자가 표시되는 패널에 자동/수동 표시되는 Label
		// 숫자가 표시되는 Label, 당첨결과가 표시되는 Label을 넣었다.
		line1.add(resultCombo1);
		line1.add(numLine1);
		line1.add(resultRank1);
		

		// ♣ 두번째 줄
		line2.add(resultCombo2);
		line2.add(numLine2);
		line2.add(resultRank2);

		// ♣ 세번째 줄
		line3.add(resultCombo3);
		line3.add(numLine3);
		line3.add(resultRank3);

		// ♣ 네번째 줄
		line4.add(resultCombo4);
		line4.add(numLine4);
		line4.add(resultRank4);

		// ♣ 다섯번째 줄
		line5.add(resultCombo5);
		line5.add(numLine5);
		line5.add(resultRank5);
		//
		middlePnl.add(line1);
		middlePnl.add(line2);
		middlePnl.add(line3);
		middlePnl.add(line4);
		middlePnl.add(line5);
		
		// ♣ line1~5까지를 세로로 배열되게 한다.
		BoxLayout middleBox = new BoxLayout(middlePnl, BoxLayout.Y_AXIS);
		middlePnl.setLayout(middleBox);

		
		// bottomPnl
		// 첫번째 창으로 넘어가서 다시 번호를 입력하기 위한 버튼
		btnReset2 = new JButton("다시 입력하기");
		// 시스템 종료를 위한 버튼
		btnEnd = new JButton("종료하기");


	// GUI 나오게 넣어주는 부분
		bottomPnl.add(lbl);
		bottomPnl.add(btnReset2);
		bottomPnl.add(btnEnd);
		
		
		pnl.add(topPnl);
		pnl.add(middlePnl);
		pnl.add(bottomPnl);
		
		add(pnl);
		BoxLayout boxPnl = new BoxLayout(pnl, BoxLayout.Y_AXIS);
		pnl.setLayout(boxPnl);

	}

	// ♣ 만들어낸 Label을 return 받기 위해 getter와 setter을 만들었다.
	// 값을 넘겨받아서 넣기 위해서는 필요할 것 같아서 만들었는데 필요가 없으려나...?

	public JButton getBtnReset2() {
		return btnReset2;
	}

	public JButton getBtnEnd() {
		return btnEnd;
	}

	public JLabel getNumLine1() {
		return numLine1;
	}

	public void setNumLine1(JLabel numLine1) {
		this.numLine1 = numLine1;
	}

	public JLabel getNumLine2() {
		return numLine2;
	}

	public void setNumLine2(JLabel numLine2) {
		this.numLine2 = numLine2;
	}

	public JLabel getNumLine3() {
		return numLine3;
	}

	public void setNumLine3(JLabel numLine3) {
		this.numLine3 = numLine3;
	}

	public JLabel getNumLine4() {
		return numLine4;
	}

	public void setNumLine4(JLabel numLine4) {
		this.numLine4 = numLine4;
	}

	public JLabel getNumLine5() {
		return numLine5;
	}

	public void setNumLine5(JLabel numLine5) {
		this.numLine5 = numLine5;
	}

	public JLabel getResultCombo1() {
		return resultCombo1;
	}

	public void setResultCombo1(JLabel resultCombo1) {
		this.resultCombo1 = resultCombo1;
	}

	public JLabel getResultCombo2() {
		return resultCombo2;
	}

	public void setResultCombo2(JLabel resultCombo2) {
		this.resultCombo2 = resultCombo2;
	}

	public JLabel getResultCombo3() {
		return resultCombo3;
	}

	public void setResultCombo3(JLabel resultCombo3) {
		this.resultCombo3 = resultCombo3;
	}

	public JLabel getResultCombo4() {
		return resultCombo4;
	}

	public void setResultCombo4(JLabel resultCombo4) {
		this.resultCombo4 = resultCombo4;
	}

	public JLabel getResultCombo5() {
		return resultCombo5;
	}

	public void setResultCombo5(JLabel resultCombo5) {
		this.resultCombo5 = resultCombo5;
	}

	public JLabel getResultRank1() {
		return resultRank1;
	}

	public void setResultRank1(JLabel resultRank1) {
		this.resultRank1 = resultRank1;
	}

	public JLabel getResultRank2() {
		return resultRank2;
	}

	public void setResultRank2(JLabel resultRank2) {
		this.resultRank2 = resultRank2;
	}

	public JLabel getResultRank3() {
		return resultRank3;
	}

	public void setResultRank3(JLabel resultRank3) {
		this.resultRank3 = resultRank3;
	}

	public JLabel getResultRank4() {
		return resultRank4;
	}

	public void setResultRank4(JLabel resultRank4) {
		this.resultRank4 = resultRank4;
	}

	public JLabel getResultRank5() {
		return resultRank5;
	}

	public void setResultRank5(JLabel resultRank5) {
		this.resultRank5 = resultRank5;
	}

}