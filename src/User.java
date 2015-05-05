import java.util.LinkedList;


public class User {
	private String name;
	private String pwd;
	private String address;
	private LinkedList<String> recordOrders = new LinkedList<String>();//已经支付过的订单记录
	private PayMethod payer;//支付方式
	private Shop shop;
	
	private ProductList shopingList = new ProductList();//购物车
	
	public User(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	public boolean isMatch(String name){
		return this.name == name;
	}
	
	public boolean matchLogIn(String pwd){
		return this.pwd == pwd;
	}
	
	public void addProduct(ProductInfo product, int count){
		shopingList.addProduct(product, count);
	}

	public int calcFee() {
		return shopingList.calcFee();
	}
	
	
	public String submitOrder() {
		Order order = null;
		try {
			order = new Order(shopingList, name, getTime().toString(), address);
		} catch (NotEnoughProductException e) {
			return e.toString();
		}
		OrderRepository.getInstance().addOrder(order);
		clearShoppingList();//成功提交订单之后，需要清空购物车
		return "create order success";
	}
	
	private Time getTime() {
		return new Time();//获取当前时间
	}

	public void setAddress(String address){
		this.address = address;
	}

	public int pay() {
		return payer.pay();
	}

	public void clearShoppingList() {
		shopingList = null;
	}

	public void record(String orderRecord) {
		recordOrders.add(orderRecord);		
	}
	
	public String openShop(String info){
		if (shop != null){
			shop = new Shop(info, name);
			return "start open shop";
		}
		return "already has open shop";
	}
}
