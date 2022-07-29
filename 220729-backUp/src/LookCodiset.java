import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
/*
 * -주요 컴포넌트 -
 * userNamelbl: 해당 코디셋을 작성한 유저의 이름이 들어가는 라벨
 * backBtn : [뒤로가기]버튼 . 메인페이지로 돌아간다.
 * likeBtn : [좋아요] 버튼. 좋아요 테이블에 db가 전달되어야 함.
 * getBtn[0-4] : [담기] 버튼 -> 누르면 해당 옷 db가 현재 사용자의 장바구니 db에 담긴다. 
 * 
 * */
public class LookCodiset extends JDialog {
	int count;
	String login_userId;
	int liketop;
	int liketop2;
	int liketop3;
	private String productname =" ";
	int countcart;
	
	//MainFrame3를 owner 로 쓴다. 
	public LookCodiset(JFrame owner,String login_userId, int liketop){
		super(owner,true);
		//제일 큰 프레임
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		////////////top
		JPanel topPnl = new JPanel();
		topPnl.setBounds(0, 5, 834, 35);
		topPnl.setLayout(null);//좌표값으로 위치를 정해주려면 기본 layout설정을 변경해주어야 하기 때문에 setLayout(null로 지정하여 주어야 한다)
		
		//코디셋 만든사람 이름 들어가는 라벨
		JLabel userNamelbl = new JLabel("코디셋을 만든 사람의 아이디 ");
		userNamelbl.setHorizontalAlignment(SwingConstants.RIGHT);
		userNamelbl.setLocation(543, 3);
		userNamelbl.setSize(100, 25);
		JLabel lbl = new JLabel("님의 코디셋");
		lbl.setBounds(672, 5, 100, 25);
		lbl.setHorizontalAlignment(SwingConstants.LEFT);
		//이미지 아이콘
		//[뒤로가기] 버튼
		ImageIcon back = new ImageIcon(".\\img\\back.png");//이미지 경로지정
		JButton backBtn = new JButton(back);
		backBtn.setBounds(24, 2, 38, 27);
		backBtn.setPreferredSize(new Dimension(32, 32));
		backBtn.setContentAreaFilled(false);//버튼 안 색 채우기 안함
		backBtn.setBorderPainted(false);//버튼 외각선 안 보이게
		backBtn.setFocusPainted(false);// 버튼 눌렀을 때 외각선 안 보이게
		
		//[좋아요]버튼
		ImageIcon like = new ImageIcon(".\\img\\likeImg.png");//이미지 경로지정
		ImageIcon like2 = new ImageIcon(".\\img\\like2.png");//이미지 경로지정
		JButton likeBtn = new JButton(like);
		likeBtn.setBounds(784, 2, 38, 27);
		likeBtn.setPreferredSize(new Dimension(32, 32));
		likeBtn.setContentAreaFilled(false);//버튼 안 색 채우기 안함
		likeBtn.setBorderPainted(false);//버튼 외각선 안 보이게
		likeBtn.setFocusPainted(false);// 버튼 눌렀을 때 외각선 안 보이게
		count =0;
		
		topPnl.add(backBtn);
		topPnl.add(userNamelbl);
		topPnl.add(lbl);
		topPnl.add(likeBtn);
		/////////////
		
		
		
		// middle
		JPanel middlePnl = new JPanel();
		middlePnl.setBounds(0, 40, 834, 737);
		middlePnl.setLayout(new GridLayout(0, 2));// 세로로 두 개로 나눔
		//중간-왼쪽
		JPanel leftPnlCodiset = new JPanel();
		JLabel codisetphoto = new JLabel();
		leftPnlCodiset.add(codisetphoto);		
		leftPnlCodiset.setBorder(new LineBorder(Color.pink,2));//영역 볼려고 테두리 설정해두었음
		middlePnl.add(leftPnlCodiset);

		
		//중간- 오른쪽
		JPanel rightPnl = new JPanel();
		//5개의 구성요소가 있어야 함. 
		//배열에다 구성요소 하나하나 담는다. 
		List<JPanel> component = new ArrayList<JPanel>();
		List<JLabel> photo = new ArrayList<JLabel>();
		List<JLabel> text = new ArrayList<JLabel>();
		List<JButton> getBtn = new ArrayList<JButton>();
		DAO_codiset daocodiset = new DAO_codiset();
		DAO_cart daocart = new DAO_cart();
		DAO_allproduct subDaoAllpro = new DAO_allproduct();
		try {
			for(int i =0; i<daocodiset.codisetproname(liketop).size();i++) {
				JPanel component2 = new JPanel();
				component.add(component2);
				JLabel photo2 = new JLabel();
				photo.add(photo2);
				JLabel text2 = new JLabel("정보가 들어가는 부분");
				text.add(text2);
				JButton getBtn2 = new JButton("담기");
				getBtn.add(getBtn2);
				
				//패널에 담기 
				component2.add(photo2);
				component2.add(text2);
				component2.add(getBtn2);
				component2.setLayout(new BoxLayout(component2,BoxLayout.Y_AXIS));
				component2.setBorder(new LineBorder(Color.CYAN,2));
				//패널을 또 패널에~~~
				component.add(component2);
				rightPnl.add(component2);
				

				//만들어진 컴포넌트에 의상 사진 넣기 
				// 구성요소 사진 띄움!!!
				productname  = daocodiset.codisetproname(liketop).get(i);
				InputStream in = daocodiset.productImg(productname).get(0).getBinaryStream();
				BufferedImage blobImage = ImageIO.read(in);
				Image img = blobImage;
				ImageIcon convertedImage = new ImageIcon(img);
				photo.get(i).setIcon(scaleImage(convertedImage,100,100));
				
				
				//컴포넌트 이름띄우기!!
				text.get(i).setText(productname);
				countcart =0;
				//담기 버튼에  액션 리스너 더해주기. 
				System.out.println(productname);
				
				
			}
		} catch (MalformedURLException | SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		
		
				
		
		
		
		rightPnl.setLayout(new GridLayout(5,0));
		
		middlePnl.add(leftPnlCodiset);
		middlePnl.add(rightPnl);
		/////
		
		//구성요소 더하기
		pnl.add(topPnl);
		pnl.add(middlePnl);
		
		add(pnl);
		BoxLayout allLayout = new BoxLayout(pnl,BoxLayout.Y_AXIS);
		setSize(850,850);
		
		DAO_heart daoheart = new DAO_heart();
		//////////생성자
		
/////////////////////////이벤트 리스너
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		likeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("좋아요 버튼 눌렀음");
				++count;
				if (count%2==0) {
					System.out.println("좋아요 취소 -> 좋아요 db에 데이터 삭제");
					likeBtn.setIcon(like);
					
					try {
						System.out.println("유저아이디:" + login_userId +" 코디셋 번호: "+ liketop);
						daoheart.delete(login_userId, liketop);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else {
					System.out.println("좋아요 버튼 클릭 -> 좋아요 db에 데이터 삽입");
					likeBtn.setIcon(like2);
					try {
						System.out.println("유저아이디:" + login_userId+" 코디셋 번호: "+ liketop);
						daoheart.create(login_userId, liketop);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				owner.setVisible(true);
				dispose();
			
				System.out.println("뒤로가기 버튼 눌렀음");
			}
		});
		
		//////////////////
		
		//코디셋 사진 띄운다!
		try {
			// 그 코디셋의 사진
			daocodiset.codiImg(liketop);
			InputStream in = daocodiset.codiImg(liketop).get(0).getBinaryStream();
			BufferedImage blobImage = ImageIO.read(in);
			Image img = blobImage;
			ImageIcon convertedImage = new ImageIcon(img);
			codisetphoto.setIcon(scaleImage(convertedImage, 417, 737));

		} catch (MalformedURLException | SQLException e2) {
			e2.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//코디셋을 만든 사람의 이름을 띄운다!!!
		try {
			String what = daocodiset.madeBy(liketop);
			userNamelbl.setText(what);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		///옷 상세보기 페이지에서 담기 누르면 cart 테이블에 담아지고, 
		// 두 번 누르면 cart 테이블에서 삭제된다. 
		try {
			for(int j =0; j<daocodiset.codisetproname(liketop).size();j++) {
				int whatwhat =j;
				String productname = daocodiset.codisetproname(liketop).get(j);
				getBtn.get(j).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							++countcart;
							
							if (countcart % 2 == 0) {
								System.out.println("담기 취소 -> cart db에 데이터 삭제");
								System.out.println("유저아이디:"+login_userId+"상품명:"+productname);
								daocart.delete(login_userId, productname);
								getBtn.get(whatwhat).setText("담기");
							}else {
								System.out.println("담기  -> cart테이블에 product이름을 넣습니다.");
								System.out.println("유저아이디:"+login_userId+"상품명:"+productname);
								daocart.create(login_userId,productname);
								getBtn.get(whatwhat).setText("취소");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
			}
		} catch (MalformedURLException | SQLException e1) {
			e1.printStackTrace();
		}
		
		//좋아요 했던 코디셋 확인하기. 
		try {
			//코디셋 아이디
			for(int i =0; i< daoheart.likedCodisetId(login_userId).size();i++) {
				if(daoheart.likedCodisetId(login_userId).get(i) == liketop) {
					likeBtn.setIcon(like2);
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	// 사진 사이즈 조절 메소드
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
}

