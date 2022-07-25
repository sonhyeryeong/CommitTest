import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame{
	public MainFrame() {
		super("메인화면");
		//제일 큰 프레임
		JPanel pnl = new JPanel();
		
		//윗부분
		JPanel topPnl = new JPanel();
		JLabel lbl = new JLabel("메인화면 ");
		JButton loginBtn  = new JButton("로그인");
		JButton myBtn  = new JButton("내 정보");
		
		///////////////
		
		//중간부분
		JPanel middlePnl = new JPanel();//중간 전체 감싸는 패널
		
		//코디셋 추천하는 왼쪽섹션
		JPanel mainCodiPnl  = new JPanel();
		JLabel lbl1 = new JLabel("첫 번째 추천");
		JLabel lbl3 = new JLabel("세 번째 추천");
		
		//탭으로 넘기는 오른쪽 섹션
		JTabbedPane  tapPnl = new JTabbedPane();
		
		//top3 부분
		JPanel top3Pnl = new JPanel();
		top3Pnl.setBackground(Color.PINK);
		JLabel toplbl1 = new JLabel("top1");
		JLabel toplbl2 = new JLabel("top2");
		JLabel toplbl3 = new JLabel("top3");
		top3Pnl.setLayout(new GridLayout(3,0));
		top3Pnl.add(toplbl1);
		top3Pnl.add(toplbl2);
		top3Pnl.add(toplbl3);
		
		tapPnl.add(top3Pnl);
		tapPnl.add("TOP3",top3Pnl);
		
		//신상 부분
		JPanel pnlNew = new JPanel();
		JLabel lblnew1 = new JLabel("신상1");
		JLabel lblnew2 = new JLabel("신상2");
		JLabel lblnew3 = new JLabel("신상3");
		pnlNew.setLayout(new GridLayout(3,0));
		pnlNew.add(lblnew1);
		pnlNew.add(lblnew2);
		pnlNew.add(lblnew3);
		
		tapPnl.add(pnlNew);
		tapPnl.add("신제품",pnlNew);
		//중간패널 끝
		
		////////중간 부분 끝
		
		
		
		// bottom
		JPanel bottomPnl = new JPanel();//bottom전체 감싸는 큰 패널
		JButton writeBtn = new JButton("글쓰기");
		bottomPnl.add(writeBtn);
		BoxLayout blbottom = new BoxLayout(bottomPnl, BoxLayout.Y_AXIS);// 입력패널 세로배치
		bottomPnl.setLayout(blbottom);
		//
		
		//구성요소 더하기
		pnl.add(topPnl);
		GroupLayout gl_topPnl = new GroupLayout(topPnl);
		gl_topPnl.setHorizontalGroup(
			gl_topPnl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_topPnl.createSequentialGroup()
					.addGap(140)
					.addComponent(lbl)
					.addGap(5)
					.addComponent(loginBtn)
					.addGap(5)
					.addComponent(myBtn))
		);
		gl_topPnl.setVerticalGroup(
			gl_topPnl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_topPnl.createSequentialGroup()
					.addGap(9)
					.addComponent(lbl))
				.addGroup(gl_topPnl.createSequentialGroup()
					.addGap(5)
					.addComponent(loginBtn))
				.addGroup(gl_topPnl.createSequentialGroup()
					.addGap(5)
					.addComponent(myBtn))
		);
		topPnl.setLayout(gl_topPnl);
		pnl.add(middlePnl);
		middlePnl.setLayout(new BoxLayout(middlePnl, BoxLayout.X_AXIS));
		mainCodiPnl.setLayout(new GridLayout(0, 1, 0, 0));
		//		lbl1.setBounds(12, 5, 179, 83);
				JLabel lbl2 = new JLabel("두 번째 추천");
		middlePnl.add(mainCodiPnl);
		mainCodiPnl.setLayout(new GridLayout(0, 1, 0, 0));
		mainCodiPnl.add(lbl1);
		mainCodiPnl.add(lbl2);
		mainCodiPnl.add(lbl3);
		middlePnl.add(tapPnl);
		
		
		
		pnl.add(bottomPnl);
		BoxLayout allLayout = new BoxLayout(pnl,BoxLayout.Y_AXIS);
		pnl.setLayout(allLayout);
		
		
		getContentPane().add(pnl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850,850);
	
	}
	
	
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
	}
}
