

public class Order {
	private static final String FAIL_INFO = "fail";
	private static final String SUCCESS_INFO = "success";
	private static final int SUCCESS = 0;
	ProductList shoppingList = new ProductList();
	OrderTimer timer = new OrderTimer();
	User user = null;
	String time;
	String address;
	
	public Order(ProductList shopingList, String userName,String time, String address) throws NotEnoughProductException {
		this.shoppingList = shopingList;
		this.user = UserRepository.getInstance().findByName(userName);
		this.time = time;
		this.address = address;
		timer.start(45);
		timer.setObj(this, "timesUp");
		shoppingList.tryPay();//创建订单尝试减少卖家的物品数量
	}
	
	void timesUp(){
		shoppingList.undoPay();
		removeSelfFromDb();
	}
	
	void removeSelfFromDb(){
		OrderRepository.getInstance().remove(this);
	}
	
	String pay(){
		if (SUCCESS == user.pay()){//如果支付成功
			user.record(toString());
			removeSelfFromDb();
			return SUCCESS_INFO;
		}else{
			shoppingList.undoPay();//需要恢复商家的数量
			return FAIL_INFO;
		}
	}
	
	@Override
	public String toString(){
		return "order: " + shoppingList.toString() + address; 
	}
	
	boolean isMatch(String userName){
		return user.isMatch(userName);
	}
}
