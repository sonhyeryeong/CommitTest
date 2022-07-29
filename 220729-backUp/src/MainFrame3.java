import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.security.acl.Owner;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;


public class MainFrame3 extends JFrame {

	JButton loginBtn;
	public String what;
	public JLabel lbl1;
	public JLabel lbl2;
	public JLabel lbl3;
	int count;
	DAO_heart daoheart;
	DAO_cart daocart;
	private JButton likeBtn1;
	private JButton likeBtn2;
	private JButton likeBtn3;
	private JButton getBtn1;
	private JButton getBtn2;
	private JButton getBtn3;
	private JButton writeBtn;
	private int liketop1;
	private int liketop2;
	private int liketop3;
	String loginuser = null;
	private JButton myBtn;
	private int countcart;
///////////////getter setter///////////////////////
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public JLabel getLbl1() {
		return lbl1;
	}

	public void setLbl1(JLabel lbl1) {
		this.lbl1 = lbl1;
	}

///////////////getter setter///////////////////////

///////////// 생성자/////////////////////////////////
	public MainFrame3(String login_userid,boolean yesno) {
		//////////////// 페이지 컴포넌트 생성됨////////////////////
		super("메인창");
		ImageIcon mypageImg = new ImageIcon(".\\img\\mypage.png");
		// [좋아요]버튼 이미지
		ImageIcon like = new ImageIcon(".\\img\\likeImg.png");// 이미지 경로지정
		ImageIcon like2 = new ImageIcon(".\\img\\like2.png");// 이미지 경로지정

		// 제일 큰 프레임
		JPanel pnl = new JPanel();

		// 윗부분
		JPanel topPnl = new JPanel();
		JLabel lbl = new JLabel("메인화면 ");
		JButton loginBtn = new JButton("로그인");
		myBtn = new JButton(mypageImg);
		JButton f5 = new JButton("새로고침");
		settingBtn(myBtn);
		topPnl.add(lbl);
		topPnl.add(f5);
		topPnl.add(loginBtn);
		topPnl.add(myBtn);
		BoxLayout bltop = new BoxLayout(topPnl, BoxLayout.X_AXIS);// 입력패널 세로배치
		topPnl.setLayout(bltop);
		loginBtn.setText(login_userid);

		// 중간부분

		JPanel middlePnl = new JPanel();// 중간 전체 감싸는 패널
		// 위 - 좋아요 top3를 감싸는 제일 큰 패널
		JPanel top3Pnl = new JPanel();
		// 하나씩 top3를 감싸는 패널(사진,버튼을 한 셋트로 묶을 패널)
		JPanel pnltoplbl1 = new JPanel();
		JPanel pnltoplbl2 = new JPanel();
		JPanel pnltoplbl3 = new JPanel();
		pnltoplbl1.setLayout(null);// 패널에 절대값으로 모양 지정할 거라서 레이아웃 널로 셋팅함.
		pnltoplbl2.setLayout(null);
		pnltoplbl3.setLayout(null);
		// 그림이 들어갈 라벨
		JLabel toplbl1 = new JLabel();
		toplbl1.setBounds(0, 0, 276, 315);
		toplbl1.setBorder(new LineBorder(Color.CYAN, 2));
		JLabel toplbl2 = new JLabel("top2");
		toplbl2.setBounds(0, 0, 276, 315);
		toplbl2.setBorder(new LineBorder(Color.CYAN, 2));
		JLabel toplbl3 = new JLabel("top3");
		toplbl3.setBounds(0, 0, 276, 315);
		toplbl3.setBorder(new LineBorder(Color.CYAN, 2));

		likeBtn1 = new JButton(like);
		likeBtn2 = new JButton(like);
		likeBtn3 = new JButton(like);
		settingBtn(likeBtn1);
		settingBtn(likeBtn2);
		settingBtn(likeBtn3);

		top3Pnl.add(pnltoplbl1);
		top3Pnl.add(pnltoplbl2);
		top3Pnl.add(pnltoplbl3);
		top3Pnl.setLayout(new GridLayout(0, 3));

		// 패널에 구성요소 더하기
		pnltoplbl1.add(toplbl1);
		pnltoplbl2.add(toplbl2);
		pnltoplbl3.add(toplbl3);
		pnltoplbl1.add(likeBtn1);
		pnltoplbl2.add(likeBtn2);
		pnltoplbl3.add(likeBtn3);

		///////////
		// 신상 부분 제일 큰 패널
		JPanel pnlNew = new JPanel();
		// 3개 감쌀 패널(사진,버튼을 한 셋트로 묶을 패널)
		JPanel pnllblnew1 = new JPanel();
		JPanel pnllblnew2 = new JPanel();
		JPanel pnllblnew3 = new JPanel();
		pnllblnew1.setLayout(null);// 패널에 절대값으로 모양 지정할 거라서 레이아웃 널로 셋팅함.
		pnllblnew2.setLayout(null);
		pnllblnew3.setLayout(null);

		// ----------혜령0728---------------
		getBtn1 = new JButton("담기");
		getBtn1.setBounds(109, 330, 60, 23);
		getBtn2 = new JButton("담기");
		getBtn2.setBounds(109, 330, 60, 23);
		getBtn3 = new JButton("담기");
		getBtn3.setBounds(109, 330, 60, 23);

		// 사진 들어갈 라벨
		JLabel lblnew1 = new JLabel();
		lblnew1.setBounds(0, 0, 276, 315);
		lblnew1.setBorder(new LineBorder(Color.CYAN, 2));
		JLabel lblnew2 = new JLabel();
		lblnew2.setBounds(0, 0, 276, 315);
		lblnew2.setBorder(new LineBorder(Color.CYAN, 2));
		JLabel lblnew3 = new JLabel();
		lblnew3.setBounds(0, 0, 276, 315);
		lblnew3.setBorder(new LineBorder(Color.CYAN, 2));

		// 사진,버튼 하나씩 더해준다.
		pnllblnew1.add(lblnew1);
		pnllblnew2.add(lblnew2);
		pnllblnew3.add(lblnew3);
		pnllblnew1.add(getBtn1);
		pnllblnew2.add(getBtn2);
		pnllblnew3.add(getBtn3);

		// 3개의 구성요소를 비율에 맞춰 셋팅하기.
		pnlNew.add(pnllblnew1);
		pnlNew.add(pnllblnew2);
		pnlNew.add(pnllblnew3);
		pnlNew.setLayout(new GridLayout(0, 3));

		// 중간부분을 가로로 2개 나눈다.
		middlePnl.add(top3Pnl);
		middlePnl.add(pnlNew);
		middlePnl.setLayout(new GridLayout(2, 0));
		/////////////////////// 중간 부분 끝

		////////////////////// bottom
		JPanel bottomPnl = new JPanel();// bottom전체 감싸는 큰 패널
		writeBtn = new JButton("글쓰기");
		bottomPnl.add(writeBtn);
		BoxLayout blbottom = new BoxLayout(bottomPnl, BoxLayout.Y_AXIS);// 입력패널 세로배치
		bottomPnl.setLayout(blbottom);
		//

		pnl.add(topPnl);
		pnl.add(middlePnl);
		pnl.add(bottomPnl);
		BoxLayout allLayout = new BoxLayout(pnl, BoxLayout.Y_AXIS);
		pnl.setLayout(allLayout);

		btnSetLogin(yesno);
		getContentPane().add(pnl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850, 850);

////////////////////////////////////////이벤트 리스너, 다오 		
		DAO_allproduct daoallpro = new DAO_allproduct();
		daoheart = new DAO_heart();
		//// 좋아요 top3 사진 부분
		
		// 좋아요 top1
		try {
			// 좋아요 top1의 사진
			daoheart.imgliketop3().get(0);
			InputStream in = daoheart.imgliketop3().get(0).getBinaryStream();
			BufferedImage blobImage = ImageIO.read(in);
			Image img = blobImage;
			ImageIcon convertedImage = new ImageIcon(img);
			toplbl1.setIcon(scaleImage(convertedImage, 276, 315));
			// 좋아요 top1의 codiset_id
			System.out.println("좋아요 탑1 의 코디셋아이디:" + daoheart.intliketop().get(0));
		} catch (MalformedURLException | SQLException e2) {
			e2.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 좋아요 top2
		try {
			// 좋아요 top2의 사진
			daoheart.imgliketop3().get(1);
			InputStream in = daoheart.imgliketop3().get(1).getBinaryStream();
			BufferedImage blobImage = ImageIO.read(in);
			Image img = blobImage;
			ImageIcon convertedImage = new ImageIcon(img);
			toplbl2.setIcon(scaleImage(convertedImage, 276, 315));
			// 좋아요 top2의 codiset_id
			System.out.println("좋아요 탑2 의 코디셋아이디:" + daoheart.intliketop().get(1));
		} catch (MalformedURLException | SQLException e2) {
			e2.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 좋아요 top3
		try {
			// 좋아요 top3의 사진
			daoheart.imgliketop3().get(2);
			InputStream in = daoheart.imgliketop3().get(2).getBinaryStream();
			BufferedImage blobImage = ImageIO.read(in);
			Image img = blobImage;
			ImageIcon convertedImage = new ImageIcon(img);
			toplbl3.setIcon(scaleImage(convertedImage, 276, 315));
			// 좋아요 top3의 codiset_id
			System.out.println("좋아요 탑2 의 코디셋아이디:" + daoheart.intliketop().get(2));
		} catch (MalformedURLException | SQLException e2) {
			e2.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// ---------------
		// 좋아요 버튼 두 번 누루면 취소되게 끔
		count = 0;
		liketop1 = 0;
		liketop2 = 0;
		liketop3 = 0;
		
		
		
		likeBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				++count;
				if (count % 2 == 0) {
					System.out.println("좋아요 취소 -> 좋아요 db에 데이터 삭제");
					likeBtn1.setIcon(like);
					
					try {
						System.out.println("유저아이디:" +login_userid);
						int liketop1=daoheart.intliketop().get(0);
						System.out.println("좋아요 top1 코디셋아이디:"+ liketop1);
						daoheart.delete(login_userid, liketop1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else {
					System.out.println("좋아요 버튼 클릭 -> 좋아요 db에 데이터 삽입");
					likeBtn1.setIcon(like2);
					try {
						System.out.println("유저아이디:" + login_userid);
						int liketop1=daoheart.intliketop().get(0);
						System.out.println("좋아요 top1 코디셋아이디:"+ liketop1);
						daoheart.create(login_userid, liketop1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		likeBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				++count;
				if (count % 2 == 0) {
					System.out.println("좋아요 취소 -> 좋아요 db에 데이터 삭제");
					likeBtn2.setIcon(like);
					try {
						System.out.println("유저아이디:" + login_userid);
						int liketop2=daoheart.intliketop().get(1);
						System.out.println("좋아요 top2 코디셋아이디:"+ liketop2);
						daoheart.delete(login_userid, liketop2);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else {
					System.out.println("좋아요 버튼 클릭 -> 좋아요 db에 데이터 삽입");
					likeBtn2.setIcon(like2);
					try {
						System.out.println("유저아이디:" + login_userid);
						int liketop2=daoheart.intliketop().get(1);
						System.out.println("좋아요 top2 코디셋아이디:"+ liketop2);
						daoheart.create(login_userid, liketop2);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		likeBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				++count;
				if (count % 2 == 0) {
					System.out.println("좋아요 취소 -> 좋아요 db에 데이터 삭제");
					likeBtn3.setIcon(like);
					try {
						System.out.println("유저아이디:" + login_userid);
						int liketop3=daoheart.intliketop().get(2);
						System.out.println("좋아요 top3 코디셋아이디:"+ liketop3);
						daoheart.delete(login_userid, liketop3);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else {
					System.out.println("좋아요 버튼 클릭 -> 좋아요 db에 데이터 삽입");
					likeBtn3.setIcon(like2);
					try {
						System.out.println("유저아이디:" + login_userid);
						int liketop3=daoheart.intliketop().get(2);
						System.out.println("좋아요 top3 코디셋아이디:"+ liketop3);
						daoheart.create(login_userid, liketop3);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		try {
			if(daoheart.likedCodisetId(login_userid).get(0)== daoheart.intliketop().get(0)) {
				likeBtn1.setIcon(like2);
			}
			if(daoheart.likedCodisetId(login_userid).get(1)== daoheart.intliketop().get(1)) {
				likeBtn2.setIcon(like2);
			}
			if(daoheart.likedCodisetId(login_userid).get(2)== daoheart.intliketop().get(2)) {
				likeBtn3.setIcon(like2);
			}
			
				
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
				
				
		
		// 클릭한 코디셋의 상세보기 페이지 들어가는 부분.
		pnltoplbl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("글 눌렀음! -> 글 상세보기 페이지로 이동합니다.");
				LookCodiset lookCodiset = null;
				try {
					lookCodiset = new LookCodiset(MainFrame3.this, login_userid,daoheart.intliketop().get(0));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				lookCodiset.setVisible(true);
			}
		});
		pnltoplbl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("글 눌렀음! -> 글 상세보기 페이지로 이동합니다.");
				LookCodiset lookCodiset = null;
				try {
					lookCodiset = new LookCodiset(MainFrame3.this, login_userid,daoheart.intliketop().get(1));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				lookCodiset.setVisible(true);
			}
		});
		pnltoplbl3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("글 눌렀음! -> 글 상세보기 페이지로 이동합니다.");
				LookCodiset lookCodiset = null;
				try {
					lookCodiset = new LookCodiset(MainFrame3.this, login_userid,daoheart.intliketop().get(2));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				lookCodiset.setVisible(true);
			}
		});


		// ----------혜령0728---------------
		// [담기] 버튼 누루면 cart테이블에 정보 삽입
		daocart = new DAO_cart();
		countcart = 0;
		
		
		
		getBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					++countcart;
					if (countcart % 2 == 0) {
						
						System.out.println("담기 취소 -> cart db에 데이터 삭제");
						System.out.println("유저아이디:"+login_userid+"상품명:"+daoallpro.listnew3().get(0));
						daocart.delete(login_userid, daoallpro.listnew3().get(0));
						getBtn1.setText("담기");
					}else {
						System.out.println("담기  -> cart테이블에 product이름을 넣습니다.");
						System.out.println("유저아이디:"+login_userid+"상품명:"+daoallpro.listnew3().get(0));
						daocart.create(login_userid, daoallpro.listnew3().get(0));
						getBtn1.setText("취소");
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		getBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					++countcart;
					if (countcart % 2 == 0) {
						
						System.out.println("담기 취소 -> cart db에 데이터 삭제");
						System.out.println("유저아이디:"+login_userid+"상품명:"+daoallpro.listnew3().get(1));
						daocart.delete(login_userid, daoallpro.listnew3().get(1));
						getBtn2.setText("담기");
					}else {
						System.out.println("담기  -> cart테이블에 product이름을 넣습니다.");
						System.out.println("유저아이디:"+login_userid+"상품명:"+daoallpro.listnew3().get(1));
						daocart.create(login_userid, daoallpro.listnew3().get(1));
						getBtn2.setText("취소");
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		getBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					++countcart;
					if (countcart % 2 == 0) {
						
						System.out.println("담기 취소 -> cart db에 데이터 삭제");
						System.out.println("유저아이디:"+login_userid+"상품명:"+daoallpro.listnew3().get(2));
						daocart.delete(login_userid, daoallpro.listnew3().get(2));
						getBtn3.setText("담기");
					}else {
						System.out.println("담기  -> cart테이블에 product이름을 넣습니다.");
						System.out.println("유저아이디:"+login_userid+"상품명:"+daoallpro.listnew3().get(2));
						daocart.create(login_userid, daoallpro.listnew3().get(2));
						getBtn3.setText("취소");
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		// ----------혜령0728---------------
		// 최근 신상품 3개 사진 들어오는 부분
		
		try {

			InputStream in = daoallpro.imgnew3().get(0).getBinaryStream();
			BufferedImage blobImage = ImageIO.read(in);
			Image img = blobImage;
			ImageIcon convertedImage = new ImageIcon(img);
			lblnew1.setIcon(scaleImage(convertedImage, 276, 315));

		} catch (MalformedURLException | SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			InputStream in = daoallpro.imgnew3().get(1).getBinaryStream();
			BufferedImage blobImage = ImageIO.read(in);
			Image img = blobImage;
			ImageIcon convertedImage = new ImageIcon(img);
			lblnew2.setIcon(scaleImage(convertedImage, 276, 315));

		} catch (MalformedURLException | SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			InputStream in = daoallpro.imgnew3().get(2).getBinaryStream();
			BufferedImage blobImage = ImageIO.read(in);
			Image img = blobImage;
			ImageIcon convertedImage = new ImageIcon(img);
			lblnew3.setIcon(scaleImage(convertedImage, 276, 315));

		} catch (MalformedURLException | SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		

////////////////////////////////////////////////////////////생성자 끝//////////////////////////////////////
	}

	// 사진 사이즈 조절
	public ImageIcon scaleImage(ImageIcon icon, int w, int h) {
		int nw = icon.getIconWidth();
		int nh = icon.getIconHeight();

		if (icon.getIconWidth() > w) {
			nw = w;
			nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
		}

		if (nh > h) {
			nh = h;
			nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
		}

		return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
	}

	// 로그아웃 된 상태에서는 쓸데 없는 버튼 들이 보이지 않게
	public void btnSetLogin(boolean yesno) {
		likeBtn1.setVisible(yesno);
		likeBtn2.setVisible(yesno);
		likeBtn3.setVisible(yesno);
		getBtn1.setVisible(yesno);
		getBtn2.setVisible(yesno);
		getBtn3.setVisible(yesno);
		writeBtn.setVisible(yesno);
		myBtn.setVisible(yesno);

	}

	// ----------혜령0728---------------
	public void settingBtn(JButton btn) {
		btn.setBounds(102, 325, 69, 28);
		btn.setPreferredSize(new Dimension(32, 32));
		btn.setContentAreaFilled(false);// 버튼 안 색 채우기 안함
		btn.setBorderPainted(false);// 버튼 외각선 안 보이게
		btn.setFocusPainted(false);// 버튼 눌렀을 때 외각선 안 보이게
	}
	// ----------혜령0728---------------

	public static void main(String[] args) {
		MainFrame3 mainframe = new MainFrame3("lossryeong",true);
		mainframe.setVisible(true);

	}

}