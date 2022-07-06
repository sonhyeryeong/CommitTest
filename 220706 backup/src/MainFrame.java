import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;

//첫번째 화면- 로또 번호 입력화면

/*
       요약
----주요 버튼 이름----
MainFrame: 첫번째 창(패널을 클래스화 )
pnl : 첫 화면의 가장 큰 레이아웃

topPnl: 위쪽 레이아웃
lbl: 입력창인 것을 표시해주기 위한 라벨

middlePnl: 중간 레이아웃
bf1-5: 각각 게임 하나인 클래스

bottomPnl: 아래 레이아웃
btnNext: [추첨 시작] 두번째 화면(확인창)으로 넘어가기 버튼
btnReset:[리셋하기] 텍스트 필드에 입력한 값을 초기화 하기 위한 버튼!

 */




//메인프레임
public class MainFrame extends JFrame {
	// getter setter 만들기 위해 버튼을 필드로 선언
	private JButton btnNext;
	private JButton btnReset;

	//게임 하나하나 (클래스)
	private BigFrame bf1;
	private BigFrame bf2;
	private BigFrame bf3;
	private BigFrame bf4;
	private BigFrame bf5;
	
	
	//서브프레임에 넘기는 최종 값이다.
	ArrayList<Integer> gameNumber1;
	ArrayList<Integer> gameNumber2;
	ArrayList<Integer> gameNumber3;
	ArrayList<Integer> gameNumber4;
	ArrayList<Integer> gameNumber5;


/////////////////// 생성자//////////////////////////////////////////
	public MainFrame() {
		// 가장 큰 패널
		JPanel pnl = new JPanel();

		// top
		JPanel topPnl = new JPanel();
		topPnl.setBounds(0, 0, 691, 95);
		topPnl.setLayout(null);
		JLabel lbl = new JLabel("로또 번호를 6개를 입력하세요 ");
		lbl.setBounds(132, 20, 475, 51);
		lbl.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 31));
//		lbl.setFont(new Font("Serif",Font.BOLD,11));
		topPnl.add(lbl);

		
		// middle
		JPanel middlePnl = new JPanel();//중간 전체 감싸는 패널
		middlePnl.setBounds(0, 190, 0, 0);
		BoxLayout blMiddle = new BoxLayout(middlePnl, BoxLayout.Y_AXIS);// 입력패널 세로배치
		middlePnl.setLayout(blMiddle);
		//중간패널 끝

		
		// bottom
		JPanel bottomPnl = new JPanel();//bottom전체 감싸는 큰 패널
		bottomPnl.setBounds(0, 570, 691, 95);
		
		//게임결과보기 버튼-SubFrame(입력창)으로 넘어간다.
		btnNext = new JButton("게임 결과보기");
		btnNext.setBounds(358, 34, 173, 35);
		btnNext.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 12));
		btnNext.setEnabled(false);
		bottomPnl.setLayout(null);
		
		//현재 입력창에 있는 모든 텍스트 필드에 입력한 내용 초기화 하는 버튼
		btnReset = new JButton("리셋하기");
		btnReset.setBounds(152, 34, 173, 35);
		btnReset.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 12));
		bottomPnl.add(btnReset);
		bottomPnl.add(btnNext);
		///마지막 끝
		
		
		//패널에 마우스리스너 추가
		//하나라도 구매 했으면, 게임결과보기 버튼을 활성화 한다. 
		pnl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (bf1.getBuyCount() > 0 || bf2.getBuyCount() > 0 || bf3.getBuyCount() > 0 || bf4.getBuyCount() > 0
						|| bf5.getBuyCount() > 0) {//하나라도 구매 되었을 때,게임결과보기 버튼 활성화
					btnNext.setEnabled(true);
				} else {//하나도 구매 안됐을 때,게임결과보기 버튼 비활성화
					btnNext.setEnabled(false);
				}
			}
		});
		

		///////게임결과보기 버튼 눌렀을 때
		// 구매 버튼을 안 누르고 제출 버튼을 누르면 아예 0인 배열로 리턴한다.
		btnNext.addActionListener(new ActionListener() {//게임결과보기 눌렀을 때 gameNumber 이라는 배열을 생성!
			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력 버튼을 안 누르고 제출 버튼을 누르면 아예 0인 배열로 리턴한다.
				//게임넘버배열  생성
				gameNumber1 = new ArrayList<Integer>();
				gameNumber2 = new ArrayList<Integer>();
				gameNumber3 = new ArrayList<Integer>();
				gameNumber4 = new ArrayList<Integer>();
				gameNumber5 = new ArrayList<Integer>();


				// 구매창이 비활성화이고, 콤보박스가 구매안함이 아닐 떄, ->게임을 참여한 것이다. 
				//게임을 참여하지 않은것은-> 0인 배열로 리턴하고 
				//게임을 참여한 것은 -> 입력한 값으로 리턴한다. 
				//구매했으면 최종배열 리턴하고, 구해 안했으면 0배열 리턴하는 메소드
				playGame(bf1,gameNumber1);//게임A
				playGame(bf2,gameNumber2);//게임B
				playGame(bf3,gameNumber3);//게임C
				playGame(bf4,gameNumber4);//게임D
				playGame(bf5,gameNumber5);//게임E
				
				// 확인용
//				System.out.println(getGameNumber1().toString() + "+" + bf1.comboToString());
//				System.out.println(getGameNumber2().toString() + "+" + bf2.comboToString());
//				System.out.println(getGameNumber3().toString() + "+" + bf3.comboToString());
//				System.out.println(getGameNumber4().toString() + "+" + bf4.comboToString());
//				System.out.println(getGameNumber5().toString() + "+" + bf5.comboToString());

				
				//서브프레임 창 띄운다. 
				//서브프레임에 최종 생성된 배열과 콤보상자 선택 값을 전부 넘김
				SubFrame subframe = new SubFrame(MainFrame.this, gameNumber1, gameNumber2, gameNumber3, gameNumber4,
						gameNumber5, bf1.comboToString(), bf2.comboToString(), bf3.comboToString(), bf4.comboToString(),
						bf5.comboToString());
				subframe.setVisible(true);;

			}
		});
		///////////////////////
		

		// 리셋했을 때, 배열을 모두 비우자!!
		// (문제)입력 > 리셋하고 다시 입력하였을 때 , 배열이 입력되어 있는 문제가 발생한다
		// (해결)입력 버튼을 눌렀을 때 , 최종으로 메인프레임에 반환하는 배열을 전부 0으로 리셋하고, 다시 값을 받는다.
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AllReset();
			}
		});
		pnl.setLayout(null);
		
		// 큰 패널에 추가하기
		pnl.add(topPnl);
		//한 줄 한 줄 
		JPanel bf1middlePnl = new JPanel();
		bf1middlePnl.setBounds(0, 95, 691, 95);
		pnl.add(bf1middlePnl);
		bf1 = new BigFrame();
		bf1.setBounds(37, 21, 657, 49);
		JLabel bfLabel1 = new JLabel("게임 A");
		bfLabel1.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 13));
		bfLabel1.setBounds(12, 21, 45, 42);
		bf1middlePnl.setLayout(null);
		
		//한 줄 한 출 레이아웃
		bf1middlePnl.add(bfLabel1);
		bf1middlePnl.add(bf1);
		pnl.add(middlePnl);
		JPanel bf2middlePnl = new JPanel();
		bf2middlePnl.setBounds(0, 190, 691, 95);
		pnl.add(bf2middlePnl);
		bf2 = new BigFrame();
		bf2.setBounds(37, 21, 657, 49);
		JLabel bfLabel2 = new JLabel("게임 B");
		bfLabel2.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 13));
		bfLabel2.setBounds(12, 21, 45, 42);
		bf2middlePnl.setLayout(null);
		bf2middlePnl.add(bfLabel2);
		bf2middlePnl.add(bf2);
		JPanel bf3middlePnl = new JPanel();
		bf3middlePnl.setBounds(0, 285, 691, 95);
		pnl.add(bf3middlePnl);
		bf3 = new BigFrame();
		bf3.setBounds(37, 21, 657, 49);
		JLabel bfLabel3 = new JLabel("게임 C");
		bfLabel3.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 13));
		bfLabel3.setBounds(12, 21, 45, 42);
		bf3middlePnl.setLayout(null);
		bf3middlePnl.add(bfLabel3);
		bf3middlePnl.add(bf3);
		JPanel bf4middlePnl = new JPanel();
		bf4middlePnl.setBounds(0, 380, 691, 95);
		pnl.add(bf4middlePnl);
		bf4 = new BigFrame();
		bf4.setBounds(37, 21, 657, 49);
		JLabel bfLabel4 = new JLabel("게임 D");
		bfLabel4.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 13));
		bfLabel4.setBounds(12, 21, 45, 42);
		bf4middlePnl.setLayout(null);
		bf4middlePnl.add(bfLabel4);
		bf4middlePnl.add(bf4);
		JPanel bf5middlePnl = new JPanel();
		bf5middlePnl.setBounds(0, 475, 691, 95);
		pnl.add(bf5middlePnl);
		bf5 = new BigFrame();
		bf5.setBounds(37, 21, 659, 49);
		bf5middlePnl.setLayout(null);
		JLabel bfLabel5 = new JLabel("게임 E");
		bfLabel5.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 13));
		bfLabel5.setBounds(12, 21, 45, 42);
		bf5middlePnl.add(bfLabel5);
		bf5middlePnl.add(bf5);
		pnl.add(bottomPnl);
		getContentPane().add(pnl);
//		setBounds(700, 700, 700, 700);
		setSize(713, 716);

	}
	
	/////////메인!!!!!!!
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
	}
	///////////////
	
	//게임 참여했는지 안했는지 확인하고 리턴함. 
	public void playGame(BigFrame b,ArrayList<Integer> arr) {
		if ((b.ableEnable() == false) && !(b.comboToString().equals("구매안함"))) {
			arr.addAll(b.getLastNumber());
		} else {
			arr.addAll(Arrays.asList(0, 0, 0, 0, 0, 0));
			b.setStrCombo();
		}
	}
	//첫번째 창 모든 컴포넌트를 초기화하는 메소드 
	public void AllReset() {
		// 콤보박스를 기본값으로 변경
		bf1.setStrCombo();
		bf2.setStrCombo();
		bf3.setStrCombo();
		bf4.setStrCombo();
		bf5.setStrCombo();
		// 텍스트 필드 입력부분을 전부 공백값으로
		bf1.setReset();
		bf2.setReset();
		bf3.setReset();
		bf4.setReset();
		bf5.setReset();
		// 입력 버튼을 누르면 저장하는 배열을 0으로 리셋한다.
		bf1.setLastNumber(Arrays.asList(0, 0, 0, 0, 0, 0));
		bf2.setLastNumber(Arrays.asList(0, 0, 0, 0, 0, 0));
		bf3.setLastNumber(Arrays.asList(0, 0, 0, 0, 0, 0));
		bf4.setLastNumber(Arrays.asList(0, 0, 0, 0, 0, 0));
		bf5.setLastNumber(Arrays.asList(0, 0, 0, 0, 0, 0));
		// 리셋하기 눌렀을 때 텍스트필드 비활성화 하는 기능
		bf1.tfSetEnabled(false);
		bf2.tfSetEnabled(false);
		bf3.tfSetEnabled(false);
		bf4.tfSetEnabled(false);
		bf5.tfSetEnabled(false);
		// 구매 버튼 비활성화
		bf1.setSmallBtn(false);
		bf2.setSmallBtn(false);
		bf3.setSmallBtn(false);
		bf4.setSmallBtn(false);
		bf5.setSmallBtn(false);
		// 삭제 버튼 비활성화
		bf1.getDeleteBtn();
		bf2.getDeleteBtn();
		bf3.getDeleteBtn();
		bf4.getDeleteBtn();
		bf5.getDeleteBtn();
		// 수정 버튼 비활성화
		bf1.getAdaptBtn();
		bf2.getAdaptBtn();
		bf3.getAdaptBtn();
		bf4.getAdaptBtn();
		bf5.getAdaptBtn();
		//BuyCount 초기화
		bf1.setBuyCount(0);
		bf2.setBuyCount(0);
		bf3.setBuyCount(0);
		bf4.setBuyCount(0);
		bf5.setBuyCount(0);
	}
	// 버튼 두 개를 반환하도록 getter를 설정했다.
	public JButton getBtnNext() {
		return btnNext;
	}

	public JButton getBtnReset() {
		return btnReset;
	}
}
////메인프레임 클래스 끝
