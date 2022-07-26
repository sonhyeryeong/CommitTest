import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import _TEAMPROJECT_DB_UTIL.DBUtil;

public class dbDAOImpl implements dbDAO {

	private String resultMapping(ResultSet rs) throws SQLException {// 정보를 새로 배치시켜서 새로운 객체를 만드는 것을 보통 mapping이라고 한다.
		String imageURL = rs.getString("product_image");
		return imageURL;
	}

	// 테이블을 파라미터로 받아서 한번 만들어 볼까?
//	@Override
//	public String readimg(String table) throws SQLException {
//		String query = "select ? from ? where ? like ?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//
//			conn = DBUtil.getConnection();
//			// 파라미터에 쿼리문 넣는다.
//			pstmt = conn.prepareStatement(query);
//			// 파라미터에 (?위치,어떤 값이 들어갈지) 적어 쿼리문을 준비시킬 수 있다.
//			pstmt.setString(1, "product_image");
//			pstmt.setString(2, table);
//			pstmt.setString(3, "product_Name");
//			pstmt.setString(4, "%상의_1%");
//			
//			rs = pstmt.executeQuery();
//			
//			return resultMapping(rs);
//		} finally {
//			DBUtil.closeRs(rs);
//			DBUtil.closeStmt(pstmt);
//			DBUtil.closeConn(conn);
//		}
//	}
	

	// 테이블에 행을 삽입하는 기능
	@Override
	public int create() throws SQLException {
		return 0;
	}

	// 테이블에 행을 수정한다.
	@Override
	public int update() throws SQLException {
		return 0;
	}

	// 테이블에 행을 삭제한다
	@Override
	public int delete() throws SQLException {
		return 0;
	}

	// 테이블의 행을 읽는다.
	@Override
	public int read() throws SQLException {
		return 0;
	}

	

	@Override
	public String readimg() throws SQLException {
		String query = "select product_image from all_product where product_Name like ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = DBUtil.getConnection();
			// 파라미터에 쿼리문 넣는다.
			pstmt = conn.prepareStatement(query);
			// 파라미터에 (?위치,어떤 값이 들어갈지) 적어 쿼리문을 준비시킬 수 있다.
			pstmt.setString(1, "%상의_1%");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getString("product_image");
			}
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return null;
	}
}
