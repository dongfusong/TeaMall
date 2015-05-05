

public class Shop {
	ProductList productList = new ProductList();
	ShopStatus status;
	String userId;
	String info; 
	
	public Shop(String info, String userId) {
		this.userId = userId;
		this.info = info;
	}

	void addProduct(ProductInfo product, int count){
		productList.addProduct(product, count);
	}

	public void decrease(ProductCounter productCounter) throws NotEnoughProductException {
		productList.remove(productCounter);
	}

	public void increase(ProductCounter productCounter) {
		productList.add(productCounter);
	}
	
	boolean validShop(){
		return status.validShop();
	}
	
	void setApproved(){
		status.setApproved();
	}
}
