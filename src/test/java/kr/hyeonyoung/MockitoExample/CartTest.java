package kr.hyeonyoung.MockitoExample;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class CartTest {
	@Test
	public void testTotalPrice() {
		Cart ct= new Cart();
		PriceManager pm = mock(PriceManager.class);
		when(pm.getPrice("1234")).thenReturn(1000);
		when(pm.getPrice("3456")).thenReturn(2500);
		when(pm.getPrice("7896")).thenReturn(800);
		ct.setPriceManager(pm);
		ct.put("1234");
		ct.put("1234");
		int total=ct.totalPrice();
		ct.put("7896");
		ct.put("3456");
		ct.put("3456");
		total=ct.totalPrice();
		assertEquals(7800, total);	
	}
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
	
	@Test
	public void testTotalPriceWithOnePlusOne() {
		Cart cart = new Cart();
		PriceManager pm = mock(PriceManager.class);
		when(pm.getPrice("1234")).thenReturn(1000);
		when(pm.getPrice("3456")).thenReturn(2500);
		when(pm.getPrice("7896")).thenReturn(800);
		when(pm.isOnePlusOneApplicable("1234")).thenReturn(false);
		when(pm.isOnePlusOneApplicable("3456")).thenReturn(true);
		when(pm.isOnePlusOneApplicable("7896")).thenReturn(false);
		cart.setPriceManager(pm);
		cart.put("1234");
		cart.put("1234");
		int total = cart.totalPrice();
		cart.put("7896");
		cart.put("3456");
		cart.put("3456");
		total = cart.totalPrice();
		assertEquals(5300, total);
	}

}
