import java.util.Set;
import java.util.TreeSet;


public class OrderRepository {
	private static final OrderRepository INSTANCE = new OrderRepository();
	private Set<Order> orderList = new TreeSet<Order>();
	
	static OrderRepository getInstance(){
		return OrderRepository.INSTANCE;
	}
	
	void addOrder(Order order){
		orderList.add(order);
	}
	
	Order findbyName(String userName){
		for (Order item : orderList){
			if (item.isMatch(userName)){
				return item;
			}
		}
		return null;
	}
	
	public void remove(Order order) {
		orderList.remove(order);
	}
}
