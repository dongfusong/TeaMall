
public class AddToShoppingService {
	public String addproduct(AddToShoppingListMsg msg) {
		User user = UserRepository.getInstance().findByName(msg.userName);
		ProductInfo productInfo = ProductRepository.getInstance().findProduct(msg.productId);		
		user.addProduct(productInfo, msg.count);
		return "add produc to " + msg.userName + ":" + msg.count + " " +  msg.productId + " success total fee:" + user.calcFee();
	}
}
