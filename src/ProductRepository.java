import java.util.Set;
import java.util.TreeSet;

public class ProductRepository {
	Set<ProductInfo> products = new TreeSet<ProductInfo>();
	private static final ProductRepository INSTANCE = new ProductRepository();

	public static ProductRepository getInstance() {
		return ProductRepository.INSTANCE;
	}

	public ProductInfo findProduct(String productId) {
		for (ProductInfo item : products){
			if (item.getProductId() == productId){
				return item;
			}
		}
		return null;
	}
	void clear(){
		products.clear();
	}
	public void addProduct(String productId, int fee, String description, String userName){
		products.add(new ProductInfo(productId, fee, description, userName));
	}
}
