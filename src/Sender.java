
public class Sender {
	private static final Sender INSTANCE = new Sender();
	public static Sender getInstance(){
		return INSTANCE;
	}
	private Sender(){
	}
	String sendMsg(Message msg){
		return Controller.getInstance().receive(msg);
	}
}
