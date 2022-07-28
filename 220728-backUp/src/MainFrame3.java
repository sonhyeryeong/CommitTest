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

//---------------------------------------------------최장호 추가한 코드-----------------------------------------------------------//
class logout extends JDialog {
	JButton yesButton;

	public logout() {
		JLabel logout = new JLabel("로그아웃 하시겠습니까?");
		yesButton = new JButton("확인");
		JButton noButton = new JButton("아니요");
		setLayout(new FlowLayout());
		add(logout);
		add(yesButton);
		add(noButton);
		setSize(200, 100);

		yesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		noButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		setLocationRelativeTo(null);
	}
}
//****************************************************************************************************************************//

public class MainFrame3 extends JFrame {

	// -----------------------------------------------최장호 추가한
	// 코드-------------------------------------------------------------//
	String user_id;
	JButton loginBtn;
	// ****************************************************************************************************************************//

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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	// 생성자
	public MainFrame3() {
		super("메인창");
		// 제일 큰 프레임
		JPanel pnl = new JPanel();

		ImageIcon mypageImg = new ImageIcon(".\\img\\mypage.png");

		// 윗부분
		JPanel topPnl = new JPanel();
		JLabel lbl = new JLabel("메인화면 ");
		JButton loginBtn = new JButton("로그인");
		JButton myBtn = new JButton(mypageImg);
		settingBtn(myBtn);
		topPnl.add(lbl);
		topPnl.add(loginBtn);
		topPnl.add(myBtn);
		BoxLayout bltop = new BoxLayout(topPnl, BoxLayout.X_AXIS);// 입력패널 세로배치
		topPnl.setLayout(bltop);
		///////////////

		// 중간부분
		JPanel middlePnl = new JPanel();// 중간 전체 감싸는 패널
		// 위 - 추천 게시글 3개
		JPanel recommendPnl = new JPanel();

//		lbl1 = new JLabel("첫 번째 추천");
//		lbl2 = new JLabel("두 번째 추천");
//		lbl3 = new JLabel("세 번째 추천");
////		lbl1.setContentAreaFilled(false);버튼에만 가능
//		lbl1.setBorder(new LineBorder(Color.CYAN, 2));
//		lbl2.setBorder(new LineBorder(Color.CYAN, 2));
//		lbl3.setBorder(new LineBorder(Color.CYAN, 2));

		// top3 부분
//				JPanel top3Pnl = new JPanel();
//				top3Pnl.setBackground(Color.PINK);
		// top3를 감싸는 패널(사진,버튼을 한 셋트로 묶을 패널)
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

		// [좋아요]버튼 이미지
		ImageIcon like = new ImageIcon(".\\img\\likeImg.png");// 이미지 경로지정
		ImageIcon like2 = new ImageIcon(".\\img\\like2.png");// 이미지 경로지정
		likeBtn1 = new JButton(like);
		likeBtn2 = new JButton(like);
		likeBtn3 = new JButton(like);
		settingBtn(likeBtn1);
		settingBtn(likeBtn2);
		settingBtn(likeBtn3);

		count = 0;
		daoheart = new DAO_heart();

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

//		lbl1.add(pnltoplbl1);
//		lbl2.add(pnltoplbl2);
//		lbl3.add(pnltoplbl3);

		recommendPnl.add(pnltoplbl1);
		recommendPnl.add(pnltoplbl2);
		recommendPnl.add(pnltoplbl3);
		recommendPnl.setLayout(new GridLayout(0, 3));

		MouseListener pageLook = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("글 누름~~");
				LookCodiset lookCodiset = new LookCodiset(MainFrame3.this);
				lookCodiset.setVisible(true);
			}
		};
		pnltoplbl1.addMouseListener(pageLook);
		pnltoplbl2.addMouseListener(pageLook);
		pnltoplbl3.addMouseListener(pageLook);

		// 아래 - 탭으로 넘기는 섹션
		JTabbedPane tapPnl = new JTabbedPane();

		// ---------------------------------------------------최장호 추가한
		// 코드----------------------------------------------------------//
		login login = new login();
		logout logout = new logout();

		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인이 되고 있을때
				if (login.loginStatement == true) {
					logout.setVisible(true);
					logout.yesButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							login.loginStatement = false;
							login.loginUser_id = null;
							loginBtn.setText("로그인");
							btnSetLogin(login.loginStatement);
						}
					});
				}
				// 로그인이 안되어 있을때
				else {
					login.setVisible(true);
				}
			}
		});

		login.login_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("아이디와 비밀번호 확인 들어갑니다~");
				try {
					if (login.id_tf.getText().equals("*MIN*") && login.pw_tf.getText().equals("java")) {
						System.out.println("관리자 창으로 갑니다 + 여기에 관리자창 여는 코드 쓰세요!");
						login.dispose();
					} else {
						if (login.uDI.login_read(login.id_tf.getText(), login.pw_tf.getText()) != null) {
							System.out.println("로그인 되었습니다");
							login.loginStatement = true;
							login.loginUser_id = login.id_tf.getText();
							System.out.println("메인창으로~! + 여기에 메인창 여는 코드 쓰세요!");
							login.dispose();
							btnSetLogin(login.loginStatement);
						} else {
							System.out.println("아이디 또는 비밀번호가 틀렸습니다");
							btnSetLogin(login.loginStatement);
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				loginBtn.setText(login.loginUser_id);
				System.out.println("로그인 된 유저의 아이디는 ? " + login.loginUser_id);
				System.out.println(login.loginStatement);
			}
		});
		// ****************************************************************************************************************************//

		// ----------혜령0728---------------
		// 좋아요 버튼 두 번 누루면 취소되게 끔
		likeBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				++count;
				if (count % 2 == 0) {
					System.out.println("좋아요 취소 -> 좋아요 db에 데이터 삭제");
					likeBtn1.setIcon(like);
					try {
						System.out.println("유저아이디 들어가나요?" + login.loginUser_id);
						daoheart.delete(login.loginUser_id, daoheart.intliketop().get(0));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else {
					System.out.println("좋아요 버튼 클릭 -> 좋아요 db에 데이터 삽입");
					likeBtn1.setIcon(like2);
					try {
						System.out.println(login.loginStatement);
						System.out.println("유저아이디 들어가나요?" + login.loginUser_id);
						daoheart.create(login.loginUser_id, daoheart.intliketop().get(0));
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
						System.out.println("유저아이디 들어가나요?" + login.loginUser_id);
						daoheart.delete(login.loginUser_id, daoheart.intliketop().get(1));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else {
					System.out.println("좋아요 버튼 클릭 -> 좋아요 db에 데이터 삽입");
					likeBtn2.setIcon(like2);
					try {
						System.out.println(login.loginStatement);
						System.out.println("유저아이디 들어가나요?" + login.loginUser_id);
						daoheart.create(login.loginUser_id, daoheart.intliketop().get(1));
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
						System.out.println("유저아이디 들어가나요?" + login.loginUser_id);
						daoheart.delete(login.loginUser_id, daoheart.intliketop().get(2));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else {
					System.out.println("좋아요 버튼 클릭 -> 좋아요 db에 데이터 삽입");
					likeBtn3.setIcon(like2);
					try {
						System.out.println(login.loginStatement);
						System.out.println("유저아이디 들어가나요?" + login.loginUser_id);
						daoheart.create(login.loginUser_id, daoheart.intliketop().get(2));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		// ----------혜령0728---------------

		// 패널에 구성요소 더하기
		pnltoplbl1.add(toplbl1);
		pnltoplbl1.add(likeBtn1);
		pnltoplbl2.add(toplbl2);
		pnltoplbl3.add(toplbl3);
		pnltoplbl2.add(likeBtn2);
		pnltoplbl3.add(likeBtn3);

		// 패널에 비율로 3개 똑같이 맞춰 넣기.
//		top3Pnl.setLayout(new GridLayout(0, 3));
//		top3Pnl.add(pnltoplbl1);
//		top3Pnl.add(pnltoplbl2);
//		top3Pnl.add(pnltoplbl3);
//		// 탭에 top3 넣기
//		tapPnl.add(top3Pnl);
//		tapPnl.add("TOP3", top3Pnl);

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

		daocart = new DAO_cart();
		getBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("담기 버튼을 클릭 -> cart테이블에 product이름을 넣습니다. ");
				try {
					daocart.create(login.loginUser_id, "상의_1");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		getBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("담기 버튼을 클릭 -> cart테이블에 product이름을 넣습니다. ");
				try {
					daocart.create(login.loginUser_id, "상의_1");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		getBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("담기 버튼을 클릭 -> cart테이블에 product이름을 넣습니다. ");
				try {
					daocart.create(login.loginUser_id, "상의_1");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		// ----------혜령0728---------------

		// 사진 들어갈 라벨
		JLabel lblnew1 = new JLabel("신상1");
		lblnew1.setBounds(0, 0, 276, 315);
		lblnew1.setBorder(new LineBorder(Color.CYAN, 2));
		JLabel lblnew2 = new JLabel("신상2");
		lblnew2.setBounds(0, 0, 276, 315);
		lblnew2.setBorder(new LineBorder(Color.CYAN, 2));
		JLabel lblnew3 = new JLabel("신상3");
		lblnew3.setBounds(0, 0, 276, 315);
		lblnew3.setBorder(new LineBorder(Color.CYAN, 2));

		// --혜령 0728 사진 들어올 거임

		DAO_allproduct daoallpro = new DAO_allproduct();
		try {

			InputStream in = daoallpro.imgnew3().get(0).getBinaryStream();
			BufferedImage blobImage = ImageIO.read(in);
			Image img = blobImage;
			ImageIcon convertedImage = new ImageIcon(img);
			lblnew1.setIcon(scaleImage(convertedImage,276,315));

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
			lblnew2.setIcon(scaleImage(convertedImage,276,315));

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
			lblnew3.setIcon(scaleImage(convertedImage,276,315));

		} catch (MalformedURLException | SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		//-----------------
		
		
		
		// 사진,버튼 하나씩 더해준다.
		pnllblnew1.add(lblnew1);
		pnllblnew1.add(getBtn1);
		pnllblnew2.add(lblnew2);
		pnllblnew2.add(getBtn2);
		pnllblnew3.add(lblnew3);
		pnllblnew3.add(getBtn3);

		// 3개의 구성요소를 비율에 맞춰 셋팅하기.
		pnlNew.add(pnllblnew1);
		pnlNew.add(pnllblnew2);
		pnlNew.add(pnllblnew3);
		pnlNew.setLayout(new GridLayout(0, 3));

		// tap에다가 더해준다.
//		tapPnl.add(pnlNew);
//		tapPnl.add("신제품", pnlNew);
		/////////// TAP부분 끝

		// 중간부분을 가로로 2개 나눈다.
		middlePnl.add(recommendPnl);
		middlePnl.add(pnlNew);
		middlePnl.setLayout(new GridLayout(2, 0));
		//////// 중간 부분 끝

		// bottom
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

		btnSetLogin(login.loginStatement);
		getContentPane().add(pnl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850, 850);

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
		MainFrame3 mainframe = new MainFrame3();
		mainframe.setVisible(true);

	}

}