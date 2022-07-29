import java.net.MalformedURLException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import _TEAMPROJECT_DB_UTIL.DBUtil;

public class DAO_codiset {
	// 코디셋 아이디를 받으면 -> 코디셋 이미지 불러오기
	// 코디셋 아이디를 받으면 -> 구성요소 받아서 ,구성요소 사진 불러오기
	// 코디셋 아이디를 받아서 -> 유저가

	// 코디셋 아이디를 받아서 사진 blob으로 불러오기.
	public List<Blob> codiImg(int codiId) throws SQLException, MalformedURLException {
		String query = "select codiset_image from codiset_new where id = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Blob> codiImg = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, codiId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Blob Image = rs.getBlob("codiset_image");
				codiImg.add(Image);
			}
			return codiImg;
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}

	}

	// 코디셋 아이디 받으면 -> 코디셋을 만든 사람의 아이디 찾기.
	public String madeBy(int codiId) throws SQLException {
		String query = "select user_id from codiset_new where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, codiId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getString("user_id");
			}
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return null;
	}

	// 코디셋의 아이디를 받아서,구성요소를 스트링으로 리스트에 넣자!!!!.
	public List<String> codisetproname(int codiId) throws SQLException, MalformedURLException {
		String query = "select product1,product2,product3,product4,product5,product6,product7 "
				+ "from codiset_new where id = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> product = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, codiId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				for (int i = 1; i < 8; i++) {
					String what = rs.getString("product" + i);
					product.add(what);
				
				}
			}
			while(product.contains(null)) {
				product.remove(product.indexOf(null));
			}
//			System.out.println("구성요소 리스트로 반환:"+product);
			return product;
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
	}
	
	//그 위의 리스트를 받아서,이미지로 출력!!
	public List<Blob> productImg(String productname) throws SQLException, MalformedURLException {
		String query = "select product_Image from all_product where product_Name = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Blob> productImg = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Blob Image = rs.getBlob("product_Image");
				productImg.add(Image);
			}
			return productImg;
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		DAO_codiset dao= new DAO_codiset();
//		try {
//			
//			System.out.println(dao.codisetproname(2));
//		} catch (MalformedURLException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
	

}
