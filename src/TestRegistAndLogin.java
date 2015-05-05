

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TestRegistAndLogin {
	RegistMessage msgReg = new RegistMessage("dongfusong", "1234");
	LoginMessage msglogin  = new LoginMessage("dongfusong","1234");
	@After
	public void tearDown(){
		UserRepository.getInstance().clear();
	}
	
	@Test
	public void test_regist_sucess() {
		assertEquals(RegistPromptInfo.SUCCESS_REGIST, Sender.getInstance().sendMsg(msgReg));
	}

	@Test
	public void test_regist_fail(){
		UserRepository.getInstance().addUser("dongfusong", "1234");
		assertEquals(RegistPromptInfo.ALREADY_HAS_REGIST, Sender.getInstance().sendMsg(msgReg));
	}
	
	@Test
	public void test_login(){
		UserRepository.getInstance().addUser("dongfusong", "1234");
		assertEquals(LoginPromptInfo.LOGIN_SUCCESS, Sender.getInstance().sendMsg(msglogin));
	}
	
	@Test
	public void test_login_fail_for_no_user(){
		assertEquals(LoginPromptInfo.NOT_HAS_THIS_USER, Sender.getInstance().sendMsg(msglogin));
	}
	
	@Test
	public void test_login_fail_for_wrong_pwd(){
		LoginMessage msglogin  = new LoginMessage("dongfusong","12345");
		UserRepository.getInstance().addUser("dongfusong", "1234");
		assertEquals(LoginPromptInfo.PWD_ERROR, Sender.getInstance().sendMsg(msglogin));
	}
}
