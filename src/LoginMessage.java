
public class LoginMessage  implements Message{
	public LoginMessage(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}
	public String name;
	public String pwd; 
}
