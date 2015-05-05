import java.util.Set;
import java.util.TreeSet;


public class ShopRepository {
	private static final ShopRepository INSTANCE = new ShopRepository();
	private static Set<Shop> shops = new TreeSet<Shop>();
	static ShopRepository getInstance(){
		return ShopRepository.INSTANCE;
	}
	
	void addShop(Shop shop){
		shops.add(shop);
	}

	public Shop findShop(String userId) {
		for (Shop item : shops){
			if (item.userId == userId){
				return item;
			}
		}
		return null;
	}
}
