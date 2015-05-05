public class ProductInfo {
	private String productId;
	private int fee = 0;
	private String description;
	private Shop shop = null;

	public ProductInfo(String productId, int fee, String description,
			String userId) {
		this.productId = productId;
		this.fee = fee;
		this.description = description;
		this.setShop(ShopRepository.getInstance().findShop(userId));
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getFee() {
		return this.fee;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return description;
	}
}
