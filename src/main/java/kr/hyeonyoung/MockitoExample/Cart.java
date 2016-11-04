package kr.hyeonyoung.MockitoExample;

import java.util.HashMap;
import java.util.Iterator;

public class Cart {
	private HashMap<String, Integer> cart = new HashMap<String, Integer>();
	private PriceManager pm;
	
	public void put(String id) {
		if(cart.containsKey(id)) {
			int n = cart.get(id);
			cart.put(id, n+1);
		}
		else
			cart.put(id, 1);	
	}
	
	public int getTotal(String name) {
		if (cart.containsKey(name))
			return cart.get(name);
		return cart.get(name);
	}
	
	public void setPriceManager(PriceManager pm) {
		this.pm = pm;
	}
	
	public int getTotalNumberOfItemsInCart(String id) {
		if(cart.containsKey(id))
			return cart.get(id);
		return cart.get(id);
	}
	/* OnePlusOne을 적용하지 않았을 경우의 totalPrice()
	public int totalPrice() {
		Iterator<String> iterator = cart.keySet().iterator();
		int total = 0;
		while (iterator.hasNext()) {
			String key = iterator.next();
			int num = cart.get(key);
			
			int price = pm.getPrice(key)*num;
			total+=price;
		}
		return total;
	}
	*/
	public int totalPrice() {
		Iterator<String> iterator = cart.keySet().iterator();
		int total = 0;
		while(iterator.hasNext()) {
			String key = iterator.next();
			int num = cart.get(key);
			
			if(pm.isOnePlusOneApplicable(key)) {
				num = num/2+num%2;
			}
			int price = pm.getPrice(key)*num;
			total+=price;
		}
		return total;
	}
	
}

