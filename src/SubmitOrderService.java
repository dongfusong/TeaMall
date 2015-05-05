
public class SubmitOrderService {
	public String submitOrder(SubmitOrderMsg msg) {
		User user = UserRepository.getInstance().findByName(msg.userName);
		return user.submitOrder();
	}

}
