class ProductCounter
{
	private ProductInfo info = null;	
	private int count = 0;
	
	public ProductCounter() {}
	
	public ProductCounter(ProductInfo product, int count ){
		this.info = product;
		this.count = count; 
	}
	public void increase(int count){
		this.count += count;
	}
	
	public boolean increase(ProductCounter rhs){
		if (info.getProductId() == rhs.info.getProductId()){
			increase(rhs.count);
			return true;
		}
		return false;
	}
	
	//如果商品数量不够，抛出异常
	public void decrease(int count) throws NotEnoughProductException{
		if (this.count < count){
			throw new NotEnoughProductException();
		}
		this.count -= count;
	}
	
	public int calcFee() {
		return this.count * info.getFee();
	}
	
	public boolean decrease(ProductCounter rhs) throws NotEnoughProductException{
		if (info.getProductId() == rhs.info.getProductId()){
			decrease(rhs.count);
			return true;
		}
		return false;
	}
	
	public void pay() throws NotEnoughProductException{
		info.getShop().decrease(this);//减去对应商家的商品数量
	}
	
	public void undoPay(){
		info.getShop().increase(this);
	}
}

