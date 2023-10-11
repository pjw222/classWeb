package c231011;

public class UserDAOTest {
	public static void main(String[] args) throws Exception
	{
		
		UserDAO dao = new DAOFactory().userDAO();
		
		UserBean user = new UserBean();
		user.setName("아무개");
		user.setUserId("gkstkddbs");
		user.setPassword("486");
		dao.add(user);
		
		System.out.println("추가성공");
		
		UserBean createdUser = dao.get("rlahWL");
		System.out.println(createdUser.getId());
		System.out.println(createdUser.getName());
		System.out.println(createdUser.getUserId());
		System.out.println(createdUser.getPassword());
	}
}
