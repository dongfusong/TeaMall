
public class LoginService {
	public String login(LoginMessage msg) {
		
		User user = UserRepository.getInstance().findByName(msg.name);
		if (user != null){ 
			if (user.matchLogIn(msg.pwd)){
				return LoginPromptInfo.LOGIN_SUCCESS;
			}else{
				return LoginPromptInfo.PWD_ERROR;
			}
		}else{
			return LoginPromptInfo.NOT_HAS_THIS_USER;
		}
	}
}
