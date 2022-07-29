import java.sql.SQLException;

import javax.swing.ImageIcon;

public class TestDao {
	public static void main(String[] args) {
		dbDAOImpl dao = new dbDAOImpl();
		MainFrame3 mainframe = new MainFrame3();
		try {
			String what = dao.readimg();
			//이미지 경로 텍스트로 불러오기 
			System.out.println(what);
			mainframe.getLbl1().setIcon(new ImageIcon(what));
			mainframe.setVisible(true);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
