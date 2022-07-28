import java.sql.SQLException;

public interface dbDAO {
	int create() throws SQLException;
	int update() throws SQLException;
	int delete() throws SQLException;
	int read() throws SQLException;
//	String readimg(String table) throws SQLException;
	String readimg() throws SQLException;
	String readimg(String what) throws SQLException;
}
