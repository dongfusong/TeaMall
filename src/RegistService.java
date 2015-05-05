
public class RegistService {
	
	public String regist(RegistMessage msg) {
		if (hasUser(msg.getName())){
			return RegistPromptInfo.ALREADY_HAS_REGIST;
		}
		else{
			saveToDb(msg.getPwd(), msg.getName());
			return RegistPromptInfo.SUCCESS_REGIST; 
		}
	}

	private void saveToDb(String pwd, String name) {
		UserRepository.getInstance().addUser(name, pwd);
	}

	boolean hasUser(String name){
		return UserRepository.getInstance().hasUser(name);
	}
}
