import java.util.HashMap;
import java.util.Map;

public class ProductList {
	Map<String, ProductCounter> productMap = new HashMap<String, ProductCounter>();
	
	public void addProduct(ProductInfo product, int count) {
		if (productMap.containsKey(product.getProductId())){
			productMap.get(product.getProductId()).increase(count);
		}else{
			productMap.put(product.getProductId(), new ProductCounter(product, count));
		}
	}
	public int calcFee() {
		int totalFee = 0;
		for (ProductCounter item : productMap.values()){
			totalFee += item.calcFee();
		}
		return totalFee;
	}
	
	public void remove(ProductCounter rhs) throws NotEnoughProductException{
		for (ProductCounter item : productMap.values()){
			item.decrease(rhs);
			return;
		}
	}
	
	public void tryPay() throws NotEnoughProductException{
		for (ProductCounter item : productMap.values()){
			item.pay();
		}
	}
	
	public void undoPay() {
		for (ProductCounter item : productMap.values()){
			item.undoPay();
		}
	}
	public void add(ProductCounter rhs) {
		for (ProductCounter item : productMap.values()){
			if (true == item.increase(rhs)){
				return;
			}
		}
	}
}
