
//模拟Controller:使用消息模拟输入
public class Controller {
	private final static Controller INSTANCE = new Controller();
	public static Controller getInstance(){
		return Controller.INSTANCE;
	}
	public String receive(Message msg){
		String info = new String();
		if (msg instanceof RegistMessage){
			RegistService registService = new RegistService();
			info = registService.regist((RegistMessage) msg);
		}
		else if (msg instanceof LoginMessage){
			LoginService loginService = new LoginService();
			info = loginService.login((LoginMessage) msg);
		}
		
		else if (msg instanceof AddToShoppingListMsg){
			AddToShoppingService service = new AddToShoppingService();
			info = service.addproduct((AddToShoppingListMsg) msg);
		}
		else if (msg instanceof SubmitOrderMsg){
			SubmitOrderService service = new SubmitOrderService();
			info = service.submitOrder((SubmitOrderMsg)msg);
		}
		else if (msg instanceof PayOrderMsg){
			PayOrderService service = new PayOrderService();
			info = service.pay((PayOrderMsg)msg);
		}
		
		return info;
	}
}
