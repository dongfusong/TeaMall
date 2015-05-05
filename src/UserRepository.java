import java.util.Collection;
import java.util.LinkedList;


public class UserRepository {
	private static UserRepository instance = new UserRepository();
	private Collection<User> users;
	
	static UserRepository getInstance(){
		return instance;
	}
	private UserRepository() {
		users = new LinkedList<User>();
	}
	
	void addUser(String name, String pwd){
		users.add(new User(name, pwd));
	}
	
	boolean hasUser(String name){
		return findByName(name) != null;
	}
	
	User findByName(String name){
		for (User user: users){
			if (user.isMatch(name)){
				return user;
			}
		}
		return null;
	}
	public void clear() {
		users.clear();
	}
	
	
}
