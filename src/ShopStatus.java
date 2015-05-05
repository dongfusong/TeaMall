
 
public class ShopStatus {
	private static final int wait_for_approved = 0;
	private static final int approved = 0;
	int status = wait_for_approved;
	
	public boolean validShop() {
		// TODO Auto-generated method stub
		return status == approved;
	}
	void setApproved(){
		this.status = approved;
	}
}
