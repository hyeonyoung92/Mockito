package kr.hyeonyoung.MockitoExample;

import static org.junit.Assert.*;

import org.junit.Test;

public class CartTest {

	@Test
	public void testTotalNumberOfItemsInCart() {
		Cart cart = new Cart();
		cart.put("1234");
		cart.put("1234");
		cart.put("3456");
		cart.put("3456");
		cart.put("3456");
		cart.put("7891");
		int totalNum1 = cart.getTotalNumberOfItemsInCart("1234");
		assertEquals(2,totalNum1);
		int totalNum2 = cart.getTotalNumberOfItemsInCart("3456");
		assertEquals(3,totalNum2);
		int totalNum3 = cart.getTotalNumberOfItemsInCart("7891");
		assertEquals(1,totalNum3);
	}

}
