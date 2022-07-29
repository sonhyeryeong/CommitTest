import java.sql.SQLException;
import java.util.List;

public interface ManagementDao {
	List<Item> readByKind(String product_Category) throws SQLException;
//	List<Item> readBottom(String product_Category) throws SQLException;
//	List<Item> readBag(String product_Category) throws SQLException;
//	List<Item> readShoes(String product_Category) throws SQLException;
//	List<Item> readAcc(String product_Category) throws SQLException;
}
