
public class PayOrderService {
	public String pay(PayOrderMsg msg) {		
		Order order = OrderRepository.getInstance().findbyName(msg.userName);
		return order.pay();
	}
}