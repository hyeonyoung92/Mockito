package kr.hyeonyoung.MockitoExample;

import java.util.HashMap;

public class Cart {
	private HashMap<String, Integer> cart = new HashMap<String, Integer>();
	
	public void put(String id) {
		if(cart.containsKey(id)) {
			int n = cart.get(id);
			cart.put(id, n+1);
		}
		else
			cart.put(id, 1);	
	}
	
	public int getTotalNumberOfItemsInCart(String id) {
		if(cart.containsKey(id))
			return cart.get(id);
		return cart.get(id);
	}
	
	
}

