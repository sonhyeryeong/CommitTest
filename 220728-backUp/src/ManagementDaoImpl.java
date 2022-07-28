import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import _TEAMPROJECT_DB_UTIL.DBUtil;


// All_product 테이블  컬럼
// product_Name, product_Size, product_Color, product_Category,
// product_Sub_Category, product_Image, product_Season 

// PK가 int인 table = heart, cart, codiSet

public class ManagementDaoImpl implements ManagementDao {
	// ResultSet mapping method
	private Item resultMapping_S(ResultSet rs) throws SQLException {
		int id = rs.getInt("number");
		Blob imageUrl = rs.getBlob("product_Image");

		return new Item(id, imageUrl);
	}

	// --------------------------------

	@Override
	public List<Item> readByKind(String product_Category) throws SQLException {
		String query = "SELECT number, product_Image FROM all_product WHERE product_Category = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Item> topList = new ArrayList<>();
		List<Item> bottomList = new ArrayList<>();
		List<Item> bagList = new ArrayList<>();
		List<Item> shoesList = new ArrayList<>();
		List<Item> accList = new ArrayList<>();


		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, product_Category);
			rs = pstmt.executeQuery();
			
			if (product_Category.equals("top")) {
				while (rs.next()) {
					topList.add(resultMapping_S(rs));
				}
				return topList;
			} else if (product_Category.equals("bottom")) {
				while (rs.next()) {
					bottomList.add(resultMapping_S(rs));
				}
				return bottomList;
			} else if (product_Category.equals("bag")) {
				while (rs.next()) {
					bagList.add(resultMapping_S(rs));
				} 
				return bagList;
			} else if (product_Category.equals("shoes")) {
				while (rs.next()) {
					shoesList.add(resultMapping_S(rs));
				}
				return shoesList;
			} else if (product_Category.equals("acc")) {
				while (rs.next()) {
					accList.add(resultMapping_S(rs));
				}
				return accList;
			}
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return null;
	}
	
	//신상 3개 보여줘야함. 
//	@Override
//	public List<Item> readByKind(String product_Season) throws SQLException {
//		String query = "SELECT product_Image FROM all_product WHERE product_Season = ?";
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<Item> topList = new ArrayList<>();
//		List<Item> bottomList = new ArrayList<>();
//		List<Item> bagList = new ArrayList<>();
//		List<Item> shoesList = new ArrayList<>();
//		List<Item> accList = new ArrayList<>();
//
//
//		try {
//			conn = DBUtil.getConnection();
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, product_Season);
//			rs = pstmt.executeQuery();
//			
//			if (product_Category.equals("top")) {
//				while (rs.next()) {
//					topList.add(resultMapping_S(rs));
//				}
//				return topList;
//			} else if (product_Category.equals("bottom")) {
//				while (rs.next()) {
//					bottomList.add(resultMapping_S(rs));
//				}
//				return bottomList;
//			} else if (product_Category.equals("bag")) {
//				while (rs.next()) {
//					bagList.add(resultMapping_S(rs));
//				} 
//				return bagList;
//			} else if (product_Category.equals("shoes")) {
//				while (rs.next()) {
//					shoesList.add(resultMapping_S(rs));
//				}
//				return shoesList;
//			} else if (product_Category.equals("acc")) {
//				while (rs.next()) {
//					accList.add(resultMapping_S(rs));
//				}
//				return accList;
//			}
//		} finally {
//			DBUtil.closeRs(rs);
//			DBUtil.closeStmt(pstmt);
//			DBUtil.closeConn(conn);
//		}
//		return null;
//	}
}
