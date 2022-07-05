
import java.awt.Color;
//두번째 화면- 당첨 확인하는 창
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * SubFrame: 로또 당첨 확인을 위한 두 번째 창
 * pnl: 큰 프레임
 * lbl: 입력창인 것을 표시해주기 위한 라벨 
 * btnReset: 첫번째 창으로 돌아가기 위한 버튼
 * btnEnd: 시스템 종료 버튼
 * */

//커밋테스트

public class SubFrame extends JDialog {
	// getter setter 만들기 위해 필드로 선언
	private JButton btnReset2;
	private JButton btnEnd;

	// 두 번째 창 세부 만들기
	// 나중에 혹시 호출하거나 메소드로 불러와야할 것 같은 것들만 선언해줬다.

	// ♣ 1등 번호가 들어가는 Label
	private JLabel prizeNumbers1; // 뒤에다가도 이미지 넣기
	private JLabel prizeNumbers2;
	private JLabel prizeNumbers3;
	private JLabel prizeNumbers4;
	private JLabel prizeNumbers5;
	private JLabel prizeNumbers6;
	private JLabel bonusNumber;
	private JLabel prizePlus; // + 이미지넣기

	// ♣ 번호 표시 패널 안에 숫자가 표시되는 Label을 넣는다.
	// 사용자가 입력한 값들의 Label
	private JLabel numLblA1;
	private JLabel numLblA2;
	private JLabel numLblA3;
	private JLabel numLblA4;
	private JLabel numLblA5;
	
	private JLabel numLblB1;
	private JLabel numLblB2;
	private JLabel numLblB3;
	private JLabel numLblB4;
	private JLabel numLblB5;
	
	private JLabel numLblC1;
	private JLabel numLblC2;
	private JLabel numLblC3;
	private JLabel numLblC4;
	private JLabel numLblC5;
	
	private JLabel numLblD1;
	private JLabel numLblD2;
	private JLabel numLblD3;
	private JLabel numLblD4;
	private JLabel numLblD5;
	
	private JLabel numLblE1;
	private JLabel numLblE2;
	private JLabel numLblE3;
	private JLabel numLblE4;
	private JLabel numLblE5;
	

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

	// ♣ 1등번호를 만들어주는 메소드를 받아오기 위한 객체생성
	PrizeNum prn = new PrizeNum();
	// 1등번호 배열을 다시 배열에 집어넣기...ㅎㅎ
	ArrayList<Integer> prn2 = new ArrayList<Integer>(prn.PrizeNum());

	// 보너스번호만 따로 떼놓기
	int bonus = prn2.get(6);

	// 오름차순 위해서 get(0)~get(5)까지만 배열에 집어넣고 오름차순하기
	public ArrayList<Integer> getPrn3() {

		ArrayList<Integer> prn3 = new ArrayList<Integer>();
		prn3.add(prn2.get(0));
		prn3.add(prn2.get(1));
		prn3.add(prn2.get(2));
		prn3.add(prn2.get(3));
		prn3.add(prn2.get(4));
		prn3.add(prn2.get(5));
		Collections.sort(prn3);
		return prn3;
	}

	// 메인프레임을 받아오는 객체 생성
	MainFrame mfr = new MainFrame();

	// 두번째 창- 로또 당첨 확인창을 생성자로 만듬
	public SubFrame(JFrame owner, ArrayList<Integer> game1, ArrayList<Integer> game2, ArrayList<Integer> game3,
			ArrayList<Integer> game4, ArrayList<Integer> game5, String str1, String str2, String str3, String str4,
			String str5) {

		ArrayList<Integer> gameNumber1 = game1;
		ArrayList<Integer> gameNumber2 = game2;
		ArrayList<Integer> gameNumber3 = game3;
		ArrayList<Integer> gameNumber4 = game4;
		ArrayList<Integer> gameNumber5 = game5;

		String comboStr1 = str1;
		String comboStr2 = str2;
		String comboStr3 = str3;
		String comboStr4 = str4;
		String comboStr5 = str5;

		// 큰 패널
		JPanel pnl = new JPanel();
		JLabel lbl = new JLabel("확인창");
		JLabel lbl2 = new JLabel("확인창2");

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

		// ♣ 1등 번호가 들어가는 부분
		// 인덱스 0부터 5까지 들어가고
		// plus에는 더하기 이미지가 들어갈거고
		// 보너스에는 보너스 번호
		// prizeNumbers1 = new JLabel(prn.PrizeNum().get(0).toString());
		prizeNumbers1 = new JLabel(String.format("%02d", getPrn3().get(0)));
		prizeNumbers2 = new JLabel(String.format("%02d", getPrn3().get(1)));
		prizeNumbers3 = new JLabel(String.format("%02d", getPrn3().get(2)));
		prizeNumbers4 = new JLabel(String.format("%02d", getPrn3().get(3)));
		prizeNumbers5 = new JLabel(String.format("%02d", getPrn3().get(4)));
		prizeNumbers6 = new JLabel(String.format("%02d", getPrn3().get(5)));
		prizePlus = new JLabel("+"); // 이미지
		bonusNumber = new JLabel(String.format("%02d", prn2.get(6)));

		// ♣ 번호가 표시되는 패널 -> 번호는 앞에서 받아온 번호들의 getSource 혹은 getText가 될 것 같다.
		JPanel line1 = new JPanel();
		JPanel line2 = new JPanel();
		JPanel line3 = new JPanel();
		JPanel line4 = new JPanel();
		JPanel line5 = new JPanel();

		// ♣ 사용자가 입력한 숫자들이 표시되는 Label -> 나중에 디자인을 위해 하나하나씩 담아줬다.
		
		// 첫번째줄 A1~A5
		numLblA1 = new JLabel(String.format("%02d", gameNumber1.get(0)));
		numLblA2 = new JLabel(String.format("%02d", gameNumber1.get(1)));
		numLblA3 = new JLabel(String.format("%02d", gameNumber1.get(2)));
		numLblA4 = new JLabel(String.format("%02d", gameNumber1.get(3)));
		numLblA5 = new JLabel(String.format("%02d", gameNumber1.get(4)));
		// 두번째줄 B1~B5
		numLblB1 = new JLabel(String.format("%02d", gameNumber2.get(0)));
		numLblB2 = new JLabel(String.format("%02d", gameNumber2.get(1)));
		numLblB3 = new JLabel(String.format("%02d", gameNumber2.get(2)));
		numLblB4 = new JLabel(String.format("%02d", gameNumber2.get(3)));
		numLblB5 = new JLabel(String.format("%02d", gameNumber2.get(4)));
		// 세번째줄 C1~C5
		numLblC1 = new JLabel(String.format("%02d", gameNumber3.get(0)));
		numLblC2 = new JLabel(String.format("%02d", gameNumber3.get(1)));
		numLblC3 = new JLabel(String.format("%02d", gameNumber3.get(2)));
		numLblC4 = new JLabel(String.format("%02d", gameNumber3.get(3)));
		numLblC5 = new JLabel(String.format("%02d", gameNumber3.get(4)));
		// 네번째줄 D1~D5
		numLblD1 = new JLabel(String.format("%02d", gameNumber4.get(0)));
		numLblD2 = new JLabel(String.format("%02d", gameNumber4.get(1)));
		numLblD3 = new JLabel(String.format("%02d", gameNumber4.get(2)));
		numLblD4 = new JLabel(String.format("%02d", gameNumber4.get(3)));
		numLblD5 = new JLabel(String.format("%02d", gameNumber4.get(4)));
		// 다섯번째줄 E1~E5
		numLblE1 = new JLabel(String.format("%02d", gameNumber5.get(0)));
		numLblE2 = new JLabel(String.format("%02d", gameNumber5.get(1)));
		numLblE3 = new JLabel(String.format("%02d", gameNumber5.get(2)));
		numLblE4 = new JLabel(String.format("%02d", gameNumber5.get(3)));
		numLblE5 = new JLabel(String.format("%02d", gameNumber5.get(4)));
		
		resultCombo1 = new JLabel(comboStr1);
		resultCombo2 = new JLabel(comboStr2);
		resultCombo3 = new JLabel(comboStr3);
		resultCombo4 = new JLabel(comboStr4);
		resultCombo5 = new JLabel(comboStr5);

		resultRank1 = new JLabel(rank_Real(gameNumber1));
		resultRank2 = new JLabel(rank_Real(gameNumber2));
		resultRank3 = new JLabel(rank_Real(gameNumber3));
		resultRank4 = new JLabel(rank_Real(gameNumber4));
		resultRank5 = new JLabel(rank_Real(gameNumber5));

		// ♣ 1등 번호가 표시되는 Panel 에 1등 숫자들이 표시되는 Label을 넣었따.
		// 1등 번호가 들어가는 곳은 panel topPnl

		// 1등 번호 여섯개가 들어가는 Label
		luckyHere.add(prizeNumbers1);
		luckyHere.add(prizeNumbers2);
		luckyHere.add(prizeNumbers3);
		luckyHere.add(prizeNumbers4);
		luckyHere.add(prizeNumbers5);
		luckyHere.add(prizeNumbers6);

		// 더하기 이미지가 들어갈 Label
		luckyHere.add(prizePlus);

		// 보너스 숫자가 들어갈 Label
		luckyHere.add(bonusNumber);

		luckyHere.setBackground(Color.cyan);
		BoxLayout luckBox = new BoxLayout(topPnl, BoxLayout.X_AXIS);
		topPnl.setLayout(luckBox);

		lbl.add(lbl2);

		topPnl.add(luckyHere);
		topPnl.setBackground(Color.red);

		// 번호가 들어가는 줄은 panel middlePnl

		// ♣ 첫번째 줄 A
		// 첫번째 숫자가 표시되는 패널에 자동/수동 표시되는 Label
		// 숫자가 표시되는 Label, 당첨결과가 표시되는 Label을 넣었다.
		line1.add(resultCombo1);
		line1.add(numLblA1);
		line1.add(numLblA2);
		line1.add(numLblA3);
		line1.add(numLblA4);
		line1.add(numLblA5);
		line1.add(resultRank1);

		// ♣ 두번째 줄 B
		line2.add(resultCombo2);
		line2.add(numLblB1);
		line2.add(numLblB2);
		line2.add(numLblB3);
		line2.add(numLblB4);
		line2.add(numLblB5);
		line2.add(resultRank2);

		// ♣ 세번째 줄 C
		line3.add(resultCombo3);
		line3.add(numLblC1);
		line3.add(numLblC2);
		line3.add(numLblC3);
		line3.add(numLblC4);
		line3.add(numLblC5);
		line3.add(resultRank3);

		// ♣ 네번째 줄 D
		line4.add(resultCombo4);
		line4.add(numLblD1);
		line4.add(numLblD2);
		line4.add(numLblD3);
		line4.add(numLblD4);
		line4.add(numLblD5);
		line4.add(resultRank4);

		// ♣ 다섯번째 줄 E
		line5.add(resultCombo5);
		line5.add(numLblE1);
		line5.add(numLblE1);
		line5.add(numLblE1);
		line5.add(numLblE1);
		line5.add(numLblE1);
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

		
		
//		numLblA1.setBackground(blue);
		// bottomPnl
		// 첫번째 창으로 넘어가서 다시 번호를 입력하기 위한 버튼
		btnReset2 = new JButton("다시 입력하기");
		// 시스템 종료를 위한 버튼
		btnEnd = new JButton("종료하기");

		ActionListener actionlistener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("다시 입력하기")) {
					dispose();
					((MainFrame) owner).AllReset();

				} else if (e.getActionCommand().equals("종료하기")) {
					dispose();
					owner.dispose();
				}

			}
		};

		btnReset2.addActionListener(actionlistener);
		btnEnd.addActionListener(actionlistener);

		// GUI 나오게 넣어주는 부분
		bottomPnl.add(lbl);
		bottomPnl.add(lbl2);
		bottomPnl.add(btnReset2);
		bottomPnl.add(btnEnd);

		pnl.add(topPnl);
		pnl.add(middlePnl);
		pnl.add(bottomPnl);

		add(pnl);
		BoxLayout boxPnl = new BoxLayout(pnl, BoxLayout.Y_AXIS);
		pnl.setLayout(boxPnl);
		setSize(700, 700);
		setLocationRelativeTo(owner);

	}

	// ♣ 만들어낸 Label을 return 받기 위해 getter와 setter을 만들었다.
	// 값을 넘겨받아서 넣기 위해서는 필요할 것 같아서 만들었는데 필요가 없으려나...?

	public JButton getBtnReset2() {
		return btnReset2;
	}

	public JButton getBtnEnd() {
		return btnEnd;
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

//	// 당첨번호와 같은 숫자만 뽑아주는 메소드 1
//	public Integer getLuckyNum(ArrayList<Integer> arr2) {
//		
//		for (Integer a : prn2) {
//			boolean isEquals = false;
//
//			for (Integer b : arr2) {
//
//				if (a.equals(arr2)) {
//					isEquals = true;
//				}
//			}
//
//			if (isEquals) {
//				return a;
//			} else {
//				return a;
//			}
//		}
//		return null;
//	}

	// 당첨번호와 같은 숫자만 뽑아주는 메소드2
	public Integer getLuckyNum2(ArrayList<Integer> arr3) {

		getPrn3().retainAll(arr3);

		System.out.println(arr3);

		return bonus;

	}

	// 당첨결과를 출력해주는 메소드
	public String rank_Real(ArrayList<Integer> arr) {

		int count = 0;

		for (int i = 0; i < getPrn3().size(); i++) {

			if (getPrn3().contains(arr.get(i))) {

				count++;

				if (count == 6 && bonus != arr.get(i)) {
					System.out.println("당첨");
					return "당첨";

				} else if (count == 5 && bonus == arr.get(i)) {
					System.out.println("2등");
					return "2등";

				} else if (count == 5) {
					System.out.println("3등");
					return "3등";

				} else if (count == 4) {
					System.out.println("4등");
					return "4등";

				} else if (count == 3) {
					System.out.println("5등");
					return "5등";

				} else {
					System.out.println("다음 기회에");
					return "다음 기회";
				}
			}
		}
		return "다음 기회";
	}

}

