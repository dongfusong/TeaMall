import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestAddingToShoppingList {
	
	private static final String RED_TEE = "red tee";
	private static final String USER_NAME = "dongfusong";
	private static final String GREEN_TEE = "green tee";
	
	@Before
	public void setUp(){
		
	}
	@After
	public void tearDown(){
		UserRepository.getInstance().clear();
		ProductRepository.getInstance().clear();
	}
	
	public AddToShoppingListMsg makeUpAddProductMsg(int count, String productId){
		AddToShoppingListMsg  msg = new AddToShoppingListMsg();
		msg.count = count;
		msg.productId = productId;
		msg.userName = USER_NAME;
		return msg;
	}
	
	private SubmitOrderMsg makeUpSubmitOrderMsg(String name) {
		return new SubmitOrderMsg(name);
	}
	
	@Test
	public void test_add_toshoplist() {
		ProductRepository.getInstance().addProduct(GREEN_TEE, 40, "good green tee", USER_NAME);
		UserRepository.getInstance().addUser(USER_NAME, "1234");
		String noticeInfo = "add produc to dongfusong:3 green tee success total fee:120";
		assertEquals(noticeInfo, Sender.getInstance().sendMsg(makeUpAddProductMsg(3, GREEN_TEE)));
	}
	
	public void test_submit_order(){
		UserRepository.getInstance().addUser(USER_NAME, "1234");
		ProductRepository.getInstance().addProduct(GREEN_TEE, 40, "good green tee", USER_NAME);
		Sender.getInstance().sendMsg(makeUpAddProductMsg(4, GREEN_TEE));
		Sender.getInstance().sendMsg(makeUpAddProductMsg(2, RED_TEE));
		Sender.getInstance().sendMsg(makeUpSubmitOrderMsg(USER_NAME));
	}
	
}
