import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

public class MainFrame3 extends JFrame{
	public String what;
	public JLabel lbl1;
	
	public String getWhat() {
		return what;
	}


	public void setWhat(String what) {
		this.what = what;
	}


	

	public JLabel getLbl1() {
		return lbl1;
	}


	public void setLbl1(JLabel lbl1) {
		this.lbl1 = lbl1;
	}


	//생성자 
	public MainFrame3() {
		super("메인창");
		//제일 큰 프레임
		JPanel pnl = new JPanel();
		
		//윗부분
		JPanel topPnl = new JPanel();
		JLabel lbl = new JLabel("메인화면 ");
		JButton loginBtn  = new JButton("로그인");
		JButton myBtn  = new JButton("내 정보");
		topPnl.add(lbl);
		topPnl.add(loginBtn);
		topPnl.add(myBtn);
		BoxLayout bltop = new BoxLayout(topPnl, BoxLayout.X_AXIS);// 입력패널 세로배치
		topPnl.setLayout(bltop);
		///////////////
		
		//중간부분
		JPanel middlePnl = new JPanel();//중간 전체 감싸는 패널
		//위 - 추천 게시글 3개 
		what =" ";
		JPanel recommendPnl  = new JPanel();
		
		
		lbl1 = new JLabel();
		JButton lbl2 = new JButton("두 번째 추천");
		JButton lbl3 = new JButton("세 번째 추천");
//		lbl1.setContentAreaFilled(false);
		lbl2.setContentAreaFilled(false);
		lbl3.setContentAreaFilled(false);
		lbl1.setBorder(new LineBorder(Color.CYAN,2));
		lbl2.setBorder(new LineBorder(Color.CYAN,2));
		lbl3.setBorder(new LineBorder(Color.CYAN,2));
		recommendPnl.add(lbl1);
		recommendPnl.add(lbl2);
		recommendPnl.add(lbl3);
		recommendPnl.setLayout(new GridLayout(0,3));
		
		ActionListener pageLook = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 누름~~");
				LookCodiset lookCodiset = new LookCodiset(MainFrame3.this);
				lookCodiset.setVisible(true);
			}
		};
		
//		lbl1.addActionListener(pageLook);
		lbl2.addActionListener(pageLook);
		lbl3.addActionListener(pageLook);
		
		//아래 - 탭으로 넘기는  섹션
		JTabbedPane  tapPnl = new JTabbedPane();
		
		//top3 부분
		JPanel top3Pnl = new JPanel();
		top3Pnl.setBackground(Color.PINK);
		JPanel pnltoplbl1 = new JPanel();
		JPanel pnltoplbl2 = new JPanel();
		JPanel pnltoplbl3 = new JPanel();
		JLabel toplbl1 = new JLabel("top1");
		toplbl1.setBounds(0, 0, 276, 315);
		toplbl1.setBorder(new LineBorder(Color.CYAN,2));
		JLabel toplbl2 = new JLabel("top2");
		toplbl2.setBackground(Color.WHITE);
		toplbl2.setBounds(0, 0, 276, 315);
		toplbl2.setBorder(new LineBorder(Color.CYAN,2));
		JLabel toplbl3 = new JLabel("top3");
		toplbl3.setBounds(0, 0, 276, 315);
		toplbl3.setBorder(new LineBorder(Color.CYAN,2));
		//[좋아요]버튼

		ImageIcon like = new ImageIcon(".\\img\\likeImg.png");//이미지 경로지정
		JButton likeBtn2= new JButton(like);
		JButton likeBtn3= new JButton(like);
		likeBtn3.setBounds(102, 325, 69, 28);
		settingBtn(likeBtn2);
		settingBtn(likeBtn3);
		pnltoplbl1.setLayout(null);
		
			
		//좋아요 버튼 전부 생성 
		JButton likeBtn1= new JButton(like);
		likeBtn1.setBounds(102, 325, 69, 28);
		
		settingBtn(likeBtn1);
		pnltoplbl1.add(likeBtn1);
	
		
		
		pnltoplbl1.add(toplbl1);
		pnltoplbl2.setLayout(null);
		pnltoplbl2.add(toplbl2);
		pnltoplbl3.setLayout(null);
		pnltoplbl3.add(toplbl3);
		pnltoplbl2.add(likeBtn2);
		pnltoplbl3.add(likeBtn3);
		
		
		
		
		
		top3Pnl.setLayout(new GridLayout(0,3));
		top3Pnl.add(pnltoplbl1);
		top3Pnl.add(pnltoplbl2);
		top3Pnl.add(pnltoplbl3);
		
		tapPnl.add(top3Pnl);
		tapPnl.add("TOP3",top3Pnl);
		
		//신상 부분
		JPanel pnlNew = new JPanel();
		
		//[담기]버튼
		JButton getBtn1 = new JButton("담기");
		getBtn1.setBounds(109, 330, 60, 23);
		JButton getBtn2 = new JButton("담기");
		getBtn2.setBounds(109, 330, 60, 23);
		JButton getBtn3 = new JButton("담기");
		getBtn3.setBounds(109, 330, 60, 23);
		JPanel pnllblnew1 = new JPanel();
		JPanel pnllblnew2 = new JPanel();
		JPanel pnllblnew3 = new JPanel();
		JLabel lblnew1 = new JLabel("신상1");
		lblnew1.setBounds(0, 0, 276, 315);
		lblnew1.setBorder(new LineBorder(Color.CYAN,2));
		JLabel lblnew2 = new JLabel("신상2");
		lblnew2.setBounds(0, 0, 276, 315);
		lblnew2.setBorder(new LineBorder(Color.CYAN,2));
		JLabel lblnew3 = new JLabel("신상3");
		lblnew3.setBounds(0, 0, 276, 315);
		lblnew3.setBorder(new LineBorder(Color.CYAN,2));
		pnllblnew1.setLayout(null);
		
		pnllblnew1.add(lblnew1);
		pnllblnew2.setLayout(null);
		pnllblnew2.add(lblnew2);
		pnllblnew3.setLayout(null);
		pnllblnew3.add(lblnew3);
		pnllblnew1.add(getBtn1);
		pnllblnew2.add(getBtn2);
		pnllblnew3.add(getBtn3);
		
			
		
		pnlNew.setLayout(new GridLayout(0,3));
		
		
		
		pnlNew.add(pnllblnew1);
		pnlNew.add(pnllblnew2);
		pnlNew.add(pnllblnew3);
//		pnlNew.add(lblnew2);
//		pnlNew.add(lblnew3);
		
		
		
		
		
		
		
		
		
		tapPnl.add(pnlNew);
		tapPnl.add("신제품",pnlNew);
		//중간패널 끝
		
		
		middlePnl.add(recommendPnl);
		middlePnl.add(tapPnl);
		middlePnl.setLayout(new GridLayout(2,0));
		////////중간 부분 끝
		
	
		
		
		// bottom
		JPanel bottomPnl = new JPanel();//bottom전체 감싸는 큰 패널
		JButton writeBtn = new JButton("글쓰기");
		bottomPnl.add(writeBtn);
		BoxLayout blbottom = new BoxLayout(bottomPnl, BoxLayout.Y_AXIS);// 입력패널 세로배치
		bottomPnl.setLayout(blbottom);
		//
		
	
		
		
		pnl.add(topPnl);
		pnl.add(middlePnl);
		pnl.add(bottomPnl);
		BoxLayout allLayout = new BoxLayout(pnl,BoxLayout.Y_AXIS);
		pnl.setLayout(allLayout);
		
		
		getContentPane().add(pnl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850,850);
	
	}
	
	
	public void settingBtn(JButton btn) {
		btn.setBounds(102, 325, 69, 28);
		btn.setPreferredSize(new Dimension(32, 32));
		btn.setContentAreaFilled(false);//버튼 안 색 채우기 안함
		btn.setBorderPainted(false);//버튼 외각선 안 보이게
		btn.setFocusPainted(false);// 버튼 눌렀을 때 외각선 안 보이게
	}
	
	public static void main(String[] args) {
		new MainFrame3().setVisible(true);
	}
}
