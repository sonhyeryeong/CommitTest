import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TestPlz {
	public static void main(String[] args) {
		dbDAOImpl dao = new dbDAOImpl();
		MainFrame3 mainframe = new MainFrame3();
		try {
			//이미지 경로 텍스트로 불러오기 
			String what = dao.readimg();
			System.out.println(what);
			
			
			mainframe.getLbl1().setIcon(new ImageIcon(".\\\\img\\\\likeImg.png"));
			mainframe.setVisible(true);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
