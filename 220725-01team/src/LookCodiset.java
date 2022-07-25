import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.Icon;
import java.awt.Point;

public class LookCodiset extends JFrame {
	public LookCodiset(){
		super("메인에서 게시글 클릭하면 보이는 화면");
		//제일 큰 프레임
		JPanel pnl = new JPanel();
		
		//top
		JPanel topPnl = new JPanel();
		topPnl.setBounds(0, 5, 834, 35);
		
		
		// middle
		JPanel middlePnl = new JPanel();
		middlePnl.setBounds(0, 40, 834, 737);
		//중간-왼쪽
		JPanel leftPnlCodiset = new JPanel();
		leftPnlCodiset.setBorder(new LineBorder(Color.pink,2));
		middlePnl.add(leftPnlCodiset);
		
		//중간- 오른쪽
		JPanel rightPnl = new JPanel();
		for(int i =0; i<5;i++) {
			JPanel component = new JPanel();
			JLabel photo = new JLabel("/사진/ ");
			JLabel text = new JLabel("정보가 들어가는 부분");
			JButton getBtn = new JButton("담기");
			component.add(photo);
			component.add(text);
			component.add(getBtn);
			component.setBorder(new LineBorder(Color.CYAN,1));
			rightPnl.add(component);
		}
		rightPnl.setLayout(new GridLayout(5,0));
		pnl.setLayout(null);
		
		
		
		
		
		
		
		//구성요소 더하기
		pnl.add(topPnl);
		JLabel userNamelbl = new JLabel("유저이름");
		userNamelbl.setHorizontalAlignment(SwingConstants.RIGHT);
		userNamelbl.setLocation(543, 3);
		userNamelbl.setSize(100, 25);
		JLabel lbl = new JLabel("님의 코디셋");
		lbl.setBounds(672, 5, 100, 25);
		lbl.setHorizontalAlignment(SwingConstants.LEFT);
		topPnl.setLayout(null);
		
		ImageIcon back = new ImageIcon("D:\\HyeRyeong-new\\220725-01team\\img\\back.png");
		JButton backBtn = new JButton(back);
		backBtn.setBounds(24, 2, 38, 27);
		backBtn.setPreferredSize(new Dimension(32, 32));
		backBtn.setBorderPainted(false);
		topPnl.add(backBtn);
		topPnl.add(userNamelbl);
		topPnl.add(lbl);
		
		ImageIcon like = new ImageIcon("D:\\HyeRyeong-new\\220725-01team\\img\\likeImg.png");
		JButton likeBtn = new JButton(like);
		likeBtn.setBounds(784, 2, 38, 27);
		likeBtn.setPreferredSize(new Dimension(32, 32));
		likeBtn.setBorderPainted(false);
		likeBtn.setBackground(Color.WHITE);
		topPnl.add(likeBtn);
		pnl.add(middlePnl);
		middlePnl.add(leftPnlCodiset);
		middlePnl.add(rightPnl);
		middlePnl.setLayout(new GridLayout(0, 2, 0, 0));
		getContentPane().add(pnl);
		BoxLayout allLayout = new BoxLayout(pnl,BoxLayout.Y_AXIS);
		setSize(850,850);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new LookCodiset().setVisible(true);
	}
}
