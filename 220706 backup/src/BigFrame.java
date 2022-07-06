import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FlowLayout;

//BigFrame- 한 게임을 구성하는 모든 요소를 담은 클래스
//한 게임을 구성하는 모든 요소 -콤보박스, 텍스트필드 6개 ,구매버튼,수정버튼,삭제버튼 

/*
   		요약
-----주요컴포넌트 이름------
tf1-6: 텍스트필드 6개 
getTextAll: 텍스트 필드에 입력된 텍스트를 String 값으로 가져 온 배열 
strCombo: 콤보박스 
smallBtn: 입력 버튼
adaptBtn:수정버튼
deleteBtn:삭제버튼 
settingAuto: 자동일 때 텍스트필드에 정렬되서 보여주기 위한 배열(자동일 때 텍스트필드에
나타나게 하기 위해서만 쓴다) (mainFrame에 넘기기 위한 최종 배열)
lastNumber: getTextAll배열을 integer 값으로 변환하여 가져온 배열

-----메소드------ 
tfSetEnabled(boolean a): 텍스트필드 6개 전부 한꺼번에 활성화,비활성화 시키는 메소드
random(): 랜덤 번호를 생성하여 string 값으로 반환한다. 
lookAndSet(인덱스,텍스트): getTextAll에 String 값을 넣어주고,텍스트 필드에 그 String값을 보여준다. 
loof(): lookAndSet()메소드를 하나하나씩 적용 
getTextList():lastNumber라는 배열에 현재 텍스트필드에 입력된 값을 받아서 integer값으로 변환하는 메소드. 
lastNum(): lastNumber 배열을 오름차순 정렬해서 리턴하는 메소드 . 
comboToString() : 콤보 박스 선택한 결과를 string 으로 넘긴다.
setReset() :텍스트 박스 입력되는 부분을 공백으로 리셋하는 메소드 
autoSort():자동생성 배열을 텍스트필드에 보여주는 메소드
ableEnable():구매버튼이 활성화인지, 비활성화인지 boolean 값으로 리턴한다.
NotInt():1-45가 아닌 정수면 경고창 띄우기. 
*/

// 게임을 구성하는  class
class BigFrame extends JPanel {
	private String[] choice = { "구매안함", "자동", "수동", "반자동" };
	// 메소드로 접근하기 위해 전역 변수로 선언했다.
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JComboBox strCombo;
	private JButton smallBtn;//구매버튼
	private JButton deleteBtn;//삭제버튼
	private JButton adaptBtn;//수정버튼
	int buyCount;//구매버튼이 눌러졌는지 확인하는 변수

	List<String> getTextAll;
	List<Integer> lastNumber;
	
///////////////////////////////////////////gettersetter모음//////////////////////////////
	public int getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}

	// 메인 프레임 클래스에서 접근하기 위한 getter를 만들었다.
	public List<Integer> getLastNumber() {
		return lastNumber;
	}

	public void setLastNumber(List<Integer> lastNumber) {
		this.lastNumber = lastNumber;
	}
	//이 두 getter는 메인프레임에만 쓴다...빅프레임에선 안 쓴다??? 이거 좀 고쳐서 쓰면 좋을 텐데..
	// 삭제버튼을 비활성화 값으로 변경하여 불러올수잇는 getter
	public void getDeleteBtn() {
		this.deleteBtn.setEnabled(false);
	}
	//이 두 getter는 메인프레임에만 쓴다...빅프레임에선 안 쓴다??? 이거 좀 고쳐서 쓰면 좋을 텐데..
	// 수정버튼을 비활성화 값으로 변경하여 불러올수잇는 getter
	public void getAdaptBtn() {
		this.adaptBtn.setEnabled(false);
	}
///////////////////////////////////////////gettersetter모음//////////////////////////////
	// 콤보박스 초기화
	// 콤보박스를 활성화&&0번째 인덱스 값(구매안함)으로 변경
	public void setStrCombo() {
		this.strCombo.setEnabled(true);
		this.strCombo.setSelectedIndex(0);
	}

	// 구매버튼을 활성화 , 비활성화 변경하는 setter
	public void setSmallBtn(boolean n) {
		this.smallBtn.setEnabled(n);
	}

	// 구매버튼이 활성화인지, 비활성화인지 boolean 값으로 리턴한다.
	public boolean ableEnable() {
		if (smallBtn.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}


//////////////////////// 이건 생성자. - 여기는 배치만 있는거임.
	public BigFrame() {
		// 큰 레이아웃
		JPanel smallFrame = new JPanel();
		smallFrame.setBounds(117, 5, 548, 37);
		// 콤보박스 추가
		strCombo = new JComboBox(choice);
		strCombo.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 13));
		strCombo.setBounds(32, 10, 86, 21);

		// 텍스트필드 6개 선언함.
		tf1 = new JTextField(3);
		tf1.setBounds(12, 5, 42, 21);
		tf1.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 13));
		tf2 = new JTextField(3);
		tf2.setBounds(66, 5, 42, 21);
		tf2.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 13));
		tf3 = new JTextField(3);
		tf3.setBounds(120, 5, 42, 21);
		tf3.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 13));
		tf4 = new JTextField(3);
		tf4.setBounds(174, 5, 42, 21);
		tf4.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 13));
		tf5 = new JTextField(3);
		tf5.setBounds(228, 5, 42, 21);
		tf5.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 12));
		tf6 = new JTextField(3);
		tf6.setBounds(279, 5, 42, 21);
		tf6.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 13));

		// 텍스트 필드에 입력된 텍스트를 String 값으로 가져 올 배열- 현재 비워져 있음.
		getTextAll = new ArrayList<>(Arrays.asList("", "", "", "", "", ""));

		// 빈 배열 생성
		lastNumber = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));

		// 입력 버튼
		smallBtn = new JButton("구매");
		smallBtn.setBounds(330, 5, 64, 22);
		smallBtn.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 11));
		// 텍스트 필드 한줄의 번호 모두 삭제버튼
		deleteBtn = new JButton("삭제");
		deleteBtn.setBounds(470, 5, 64, 22);
		deleteBtn.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 11));
		// 텍스트 필드 한 줄의 번호 수정버튼
		adaptBtn = new JButton("수정");
		adaptBtn.setBounds(400, 5, 64, 22);
		adaptBtn.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 11));
		
		//구매 완료 됐는지 확인하기 위한 변수. 
		buyCount = 0;
		
		
		//keyListener 메소드 
		// 숫자가 아닌값은 입력하지 못하게 막아준다.
		// 1-45까지 숫자만 입력할 수 있도록 한다.
		KeyListener keylistener = new KeyAdapter() {
			// 숫자가 아닌값은 입력하지 못하게 막아준다.
			@Override
			public void keyTyped(KeyEvent e) { // 키보드에 KeyListener를 걸어주어 키보드가 타이핑 되면
				char c = e.getKeyChar(); // 타이밍된 값을 char값으로 받아오고
				if (!Character.isDigit(c)) { // 숫자인지 판별해주는 함수 isDigit()에 받아온 char값을 넣어 숫자가 아니라면
					e.consume(); // 입력값 e에 consume()함수를 걸어 처리되지않게끔 해줍니다.
					return;
				}
			}

			// 1-45의 정수가 아닌 수를 입력하면 경고창을 띄운다.
			@Override
			public void keyReleased(KeyEvent e) {
				NotInt();//긴거 메소드로 뺌
			}
		};
		//////////keyListener 끝////////////
		
		//텍스트필드에 keyListener 추가. 
		tf1.addKeyListener(keylistener);
		tf2.addKeyListener(keylistener);
		tf3.addKeyListener(keylistener);
		tf4.addKeyListener(keylistener);
		tf5.addKeyListener(keylistener);
		tf6.addKeyListener(keylistener);
		
		//기본값-텍스트 필드,수정버튼,구매버튼 ,삭제버튼  비활성화 
		tfSetEnabled(false);
		smallBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		adaptBtn.setEnabled(false);

		// 콤보박스 액션리스너
		//수동,반자동,자동,구매안함 선택시 일어나는 일들 
		strCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				switch (comboToString()) {
				case "수동"://구매,텍스트 필드 활성화 <> 수정버튼 비활성화
					smallBtn.setEnabled(true);// 구매버튼 활성화
					for (int i = 0; i < 6; i++) {
						if (getTextAll.get(i).equals("")) { // 텍스트 필드가 비워져 있으면 수정버튼 비활성화
							adaptBtn.setEnabled(false);
						}
					}
					tfSetEnabled(true);
					break;
				case "반자동"://구매,텍스트 필드 활성화 <> 수정버튼 비활성화
					smallBtn.setEnabled(true);/// 구매버튼 활성화
					for (int i = 0; i < 6; i++) {
						if (getTextAll.get(i).equals("")) {// 텍스트 필드가 비워져 있으면 수정버튼 비활성화
							adaptBtn.setEnabled(false);
						}
					}
					tfSetEnabled(true);
					break;
				case "자동"://텍스트 필드 활성화 <>  수정 버튼 비활성화
					tfSetEnabled(true);
					adaptBtn.setEnabled(false);
					int j = 0;
					int yesOrNo = 0;
					String num = "";
					String[] buttons = { "구매", "취소" };

					if (tf1.getText().equals("")) {
						while (true) {
							num = random();
							if (!getTextAll.contains(num)) {// 랜덤번호가 중복되지 않는다면, 텍스트 필드에 랜덤값을 보여주고, 배열에 넣는다.
								if (j == 6) {
									lastNum();// 현재 텍스트 필드에 입력된 값을 lastNumber라는 integer 배열로 변환시켜 주는 메소드
									autoSort();// 숫자를 오름차순으로 정렬하여 텍스트 필드에 보여주는 메소드
									break;
								}
								lookAndSet(j, num);// 배열에 랜덤값을 차례로 넣어줌
								j++;
							}
						}
					}
					yesOrNo = JOptionPane.showOptionDialog(null, lastNum().toString(), "이 번호로 구매하시겠습니까?",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "구매");
					autoSort();
					if (yesOrNo == JOptionPane.YES_OPTION) {// 확정 선택시
						tfSetEnabled(false);// 텍스트필드 비활성화
						smallBtn.setEnabled(false);
						strCombo.setEnabled(false);
						deleteBtn.setEnabled(true);
						++buyCount;
						break;
					} else {// [취소]와 [닫기] 선택시
						setReset();// 텍스트필드의 값을 모두 비워줌
						tfSetEnabled(false);// 텍스트필드 활성화
						strCombo.setSelectedIndex(0);
						break;
					}
				}
			}
		});
		//////////콤보박스 액션 리스너 끝

		
		// 삭제버튼 액션리스너 
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				smallBtn.setEnabled(false);// 입력버튼 비활성화
				adaptBtn.setEnabled(false);// 수정버튼 비활성화
				deleteBtn.setEnabled(false);// 자동버튼 비활성화
				strCombo.setEnabled(true);// 콤보박스 활성화
				strCombo.setSelectedIndex(0);// 콤보박스 초기화
				setReset();// 텍스트필드 초기화
				lastNum();// 넘겨줄배열 초기화한 값으로 바꿔주기
				--buyCount;
			}
		});

		// 수정버튼 액션리스너
		adaptBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (comboToString()) {
				case "자동":
					// 자동에서는 수정할 수 없음.
					break;
				case "수동":
					adaptBtn.setEnabled(false);
					tfSetEnabled(true);
					smallBtn.setEnabled(true);
					--buyCount;
					break;
				case "반자동":
					adaptBtn.setEnabled(false);
					tfSetEnabled(true);
					smallBtn.setEnabled(true);
					--buyCount;
					break;
				}
			}
		});

		// 구매버튼 엑션리스너 
		smallBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] buttons1 = { "구매", "수정" };
				String num = "";
				int yesOrNo = 0;
				int count = 0;

				switch (comboToString()) {
				case "자동":
					// 자동에서는 입력할 수 없음.
					break;
				case "수동":
					loop();// 사용자가 텍스트필드에 입력한 값을 배열에 넣어주는 메소드
					for (int i = 0; i < 6; i++) {
						if (getTextAll.get(i).equals("")) { // 텍스트 필드가 비워져 있으면 경고창을 띄워줍니다
							JOptionPane.showMessageDialog(null, "비어있는 값이 있습니다", "경고", JOptionPane.WARNING_MESSAGE);
							break;
						} else {
							count++; // 비워져 있지 않으면 count를 올립니다.
						}
						if (count == 6) { // 모든 칸이 비워져있지 않으면 패널을 고정시킵니다.
							lastNum();// 현재 텍스트 필드에 입력된 값을 lastNumber라는 integer 배열로 변환시켜 주는 메소드
							Set<Integer> overlapNum = new HashSet<>(lastNum());// 중복값을 찾기위해 lastNum()값을 set에 넣어줍니다.
							if (overlapNum.size() == 6) { // 중복값이 없으면 set의 사이즈가 6이 되므로 확정시켜줍니다.
								yesOrNo = JOptionPane.showOptionDialog(null, getTextList().toString(),
										"이 번호로 구매하시겠습니까?", JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE, null, buttons1, "구매");
								if (yesOrNo == JOptionPane.YES_OPTION) {// 확정을 눌렀을때
									tfSetEnabled(false);// 텍스트필드 비활성화
									deleteBtn.setEnabled(true);
									adaptBtn.setEnabled(true);
									smallBtn.setEnabled(false);
									strCombo.setEnabled(false);
									++buyCount;
									break;
								} else if (yesOrNo == JOptionPane.CLOSED_OPTION) {// 닫기를 눌렀을때 아무런 변화 없음
									break;
								} else {// 수정을 눌렀을때
									tfSetEnabled(true);// 텍스트필드 활성화
									break;
								}
							} else {// 중복값이 있어 set의 사이즈가 6이 아니게되면 경고창을 띄워줍니다.
								JOptionPane.showMessageDialog(null, "중복값이 있습니다.", "경고", JOptionPane.WARNING_MESSAGE);
							}
						}
					}
					lastNum();
					break;

				case "반자동":
					loop();// 사용자가 텍스트필드에 입력한 값을 배열에 넣어주는 메소드
					getTextList();// 현재 텍스트 필드에 입력된 값을 lastNumber라는 integer 배열로 변환시켜 주는 메소드
					for (int i = 0; i < 6; i++) {
						if (getTextList().get(i) == 0) {// 텍스트필드에 값이 존재하지 않으면 count 올리기
							count++;
						}
					}
//					if (count==0) {
//						JOptionPane.showMessageDialog(null, "전부 입력하여 수동으로 변경됩니다.", "경고", JOptionPane.WARNING_MESSAGE);
//						strCombo.setSelectedIndex(2);
//					}
					if (count == 6) {// 단 하나의 값도 텍스트필드에 존재하지 않으면 반자동이 아니므로 경고창
						JOptionPane.showMessageDialog(null, "사용자 입력이 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
						break;
					}
					Set<Integer> overlapNum = new HashSet<>(getTextList());// 중복값을 찾기위해 lastNum()값을 set에 넣어줍니다.
					overlapNum.remove(0);// set에서 0값을 지워준다.
					count = 0;
					for (int k = 0; k < 6; k++) {// 0이 존재하는 횟수를 센다.
						if (getTextList().get(k) == 0) {
							count++;
						}
					}
					// set으로 만들어진 overlapNum(중복값이 없는 리스트)-count1(0이 들어간 횟수)더해주어 6이되면
					// 중복값없이 리스트가 완성되었다는 뜻이 된다.
					if ((overlapNum.size() + count) == 6) {
						for (int i = 0; i < 6; i++) {
							if (getTextAll.get(i).equals("")) {// 텍스트 필드가 비워져 있으면
								while (true) {
									num = random();
									if (!getTextAll.contains(num)) {// 랜덤값을 중복되지 않게 텍스트 필드에 나타내고 , 배열에도 넣어주는 것.
										lookAndSet(i, num);
										break;
									}
								}
							}
						}
						yesOrNo = JOptionPane.showOptionDialog(null, getTextList().toString(), "이 번호로 구매하시겠습니까?",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons1, "확정");
						if (yesOrNo == JOptionPane.YES_OPTION) {// 확정을 눌렀을때
							tfSetEnabled(false);// 텍스트필드 비활성화
							deleteBtn.setEnabled(true);
							smallBtn.setEnabled(false);
							strCombo.setEnabled(false);
							adaptBtn.setEnabled(true);
							++buyCount;
							lastNum();// lastNum에 넘겨주기
							break;
						} else if (yesOrNo == JOptionPane.CLOSED_OPTION) {// 닫기를 눌렀을땐 아무일도 일어나지 않음
							break;
						} else {// 수정을 눌렀을때
							tfSetEnabled(true);// *수정해야함 * 비활성화를 풀어 수정가능하게끔 해주기
							break;
						}
					} else {// 중복값이 있어 set의 사이즈가 6이 아니게되면 경고창을 띄워줍니다.
						JOptionPane.showMessageDialog(null, "중복값이 있습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					}
					break;
				}
			}
		});
		smallFrame.setLayout(null);
		/////구매하기 액션리스너 끝

		// 레이아웃에 구성요소를 더해 준다.
		smallFrame.add(tf1);
		smallFrame.add(tf2);
		smallFrame.add(tf3);
		smallFrame.add(tf4);
		smallFrame.add(tf5);
		smallFrame.add(tf6);
		smallFrame.add(smallBtn);
		smallFrame.add(adaptBtn);
		smallFrame.add(deleteBtn);
		setLayout(null);
		add(strCombo);
		add(smallFrame);

		setSize(693, 52);

	}
////////////////////////생성자 끝/////////////////////////////
	public void NotInt() {
		if (tf1.getText().length() >= 1) {
			Integer n;
			try {
				n = Integer.valueOf(tf1.getText());
				if (!(n >= 1 && n <= 45)) {
					throw new NumberFormatException();
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "1-45까지의 정수를 입력하여 주세요", "경고", JOptionPane.WARNING_MESSAGE);
				tf1.setText("");
			}
		}
		if (tf2.getText().length() >= 1) {
			Integer n;
			try {
				n = Integer.valueOf(tf2.getText());
				if (!(n >= 1 && n <= 45)) {
					throw new NumberFormatException();
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "1-45까지의 정수를 입력하여 주세요", "경고", JOptionPane.WARNING_MESSAGE);
				tf2.setText("");
			}
		}
		if (tf3.getText().length() >= 1) {
			Integer n;
			try {
				n = Integer.valueOf(tf3.getText());
				if (!(n >= 1 && n <= 45)) {
					throw new NumberFormatException();
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "1-45까지의 정수를 입력하여 주세요", "경고", JOptionPane.WARNING_MESSAGE);
				tf3.setText("");
			}
		}
		if (tf4.getText().length() >= 1) {
			Integer n;
			try {
				n = Integer.valueOf(tf4.getText());
				if (!(n >= 1 && n <= 45)) {
					throw new NumberFormatException();
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "1-45까지의 정수를 입력하여 주세요", "경고", JOptionPane.WARNING_MESSAGE);
				tf4.setText("");
			}
		}
		if (tf5.getText().length() >= 1) {
			Integer n;
			try {
				n = Integer.valueOf(tf5.getText());
				if (!(n >= 1 && n <= 45)) {
					throw new NumberFormatException();
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "1-45까지의 정수를 입력하여 주세요", "경고", JOptionPane.WARNING_MESSAGE);
				tf5.setText("");
			}
		}
		if (tf6.getText().length() >= 1) {
			Integer n;
			try {
				n = Integer.valueOf(tf6.getText());
				if (!(n >= 1 && n <= 45)) {
					throw new NumberFormatException();
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "1-45까지의 정수를 입력하여 주세요", "경고", JOptionPane.WARNING_MESSAGE);
				tf6.setText("");
			}
		}
	}
	
	// 텍스트 필드 입력 부분을 전부 공백으로 만드는 메소드
	public void setReset() {
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		tf6.setText("");
	}

	public List<Integer> lastNum() {
		// lastNumber 라는 배열에
		// 현재 텍스트 필드에 입력된 값을 받아서 integer 값으로 변환하였다.
		getTextList();
		Collections.sort(lastNumber);
		return lastNumber;
	}

	public List<Integer> getTextList() {
		// lastNumber 라는 배열에
		// 현재 텍스트 필드에 입력된 값을 받아서 integer 값으로 변환하였다.
		for (int i = 0; i < 6; i++) {
			if (getTextAll.get(i).equals("")) {
				lastNumber.set(i, 0);
			} else {
				lastNumber.set(i, Integer.valueOf(getTextAll.get(i)));
			}
		}
		return lastNumber;
	}

	// 받은 값 정렬해서 텍스트필드에 보여주는 메소드
	public void autoSort() {
		// 텍스트필드에 보여줌
		tf1.setText(String.valueOf(lastNumber.get(0)));
		tf2.setText(String.valueOf(lastNumber.get(1)));
		tf3.setText(String.valueOf(lastNumber.get(2)));
		tf4.setText(String.valueOf(lastNumber.get(3)));
		tf5.setText(String.valueOf(lastNumber.get(4)));
		tf6.setText(String.valueOf(lastNumber.get(5)));
	}

	// 콤보박스 선택을 스트링으로 넘겨주는 메소드
	public String comboToString() {
		if (strCombo.getSelectedItem().toString() == "자동") {
			return "자동";
		} else if (strCombo.getSelectedItem().toString() == "수동") {
			return "수동";
		} else if (strCombo.getSelectedItem().toString() == "반자동") {
			return "반자동";
		} else {
			return "구매안함";
		}
	}

	// 랜덤 번호를 생성하여 string 값으로 반환한다.
	public String random() {
		Random random = new Random();
		int num = random.nextInt(45) + 1;
		return String.valueOf(num);
	}

	// setEnabled(true) : 객체를 활성화 해주는 함수
	// setEnabled(false) : 객체를 비활성화 해주는 함수
	// 텍스트필드를 비활성화 함으로써 사용자가 더이상 수정하지 못하게끔 막아주는 역할을 함.
	public void tfSetEnabled(boolean a) {
		tf1.setEnabled(a);
		tf2.setEnabled(a);
		tf3.setEnabled(a);
		tf4.setEnabled(a);
		tf5.setEnabled(a);
		tf6.setEnabled(a);
	}
	//getTextAll배열에 현재 텍스트필드에 입력된 값을 전부 넣어준다. 
	// lookAndSet()메소드를 하나하나씩 적용
	public void loop() {
		lookAndSet(0, tf1.getText());
		lookAndSet(1, tf2.getText());
		lookAndSet(2, tf3.getText());
		lookAndSet(3, tf4.getText());
		lookAndSet(4, tf5.getText());
		lookAndSet(5, tf6.getText());
	}

	//getTextAll에 String 값을 넣어주고, 
	//텍스트 필드에 그 String값을 보여준다. 
	public void lookAndSet(int index, String text) {
		if (index == 0) {
			tf1.setText(text);
			getTextAll.set(0, text);
		}
		if (index == 1) {
			tf2.setText(text);
			getTextAll.set(1, text);
		}
		if (index == 2) {
			tf3.setText(text);
			getTextAll.set(2, text);
		}
		if (index == 3) {
			tf4.setText(text);
			getTextAll.set(3, text);
		}
		if (index == 4) {
			tf5.setText(text);
			getTextAll.set(4, text);
		}
		if (index == 5) {
			tf6.setText(text);
			getTextAll.set(5, text);
		}
	}

}///////////////////////////마지막.