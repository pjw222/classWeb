package c231011;

public class DAOFactory {
	public UserDAO userDAO() {
//		OracleConnectionMaker maker = new OracleConnectionMaker();		
		return new UserDAO(connectionMaker());
	}
	public UserDAO boardDAO() {	
		return new UserDAO(connectionMaker());
	}
	public UserDAO productDAO() {	
		return new UserDAO(connectionMaker());
	}
	public ConnectionMaker connectionMaker() {
		return new OracleConnectionMaker();
	}
}
