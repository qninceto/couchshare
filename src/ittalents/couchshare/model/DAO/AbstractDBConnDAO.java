package ittalents.couchshare.model.DAO;
/*
 * this class is to reduce the repetition of code 
 * to easier access the only instance of the connection with the only method of the abstract class!!!!
 * and all the daoclasses now extend that abstract class and have this method
 */
import java.sql.Connection;

public abstract class AbstractDBConnDAO {
	private static final Connection con = DBConnection.getInstance()
			.getCon();

	public static Connection getCon() {
		return con;
	}
}
