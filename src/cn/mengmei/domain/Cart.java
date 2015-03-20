package cn.mengmei.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

//代表购物车
public class Cart {
	
	private Map<String, CartItem> map = new LinkedHashMap<String, CartItem>();
	private double price;
	
	public void add(Book book){
		CartItem item = map.get(book.getId());
		if(item != null){
			item.setQuantity(item.getQuantity()+1);
		}else{
			item = new CartItem();
			item.setBook(book);
			item.setQuantity(1);
			map.put(book.getId(), item);
		}
	}
	
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	
	public double getPrice() {
		double totalPrice = 0;
		for(Map.Entry<String, CartItem> me : map.entrySet()){
			double itemPrice = me.getValue().getPrice();
			totalPrice += itemPrice;
		}
		this.price = new BigDecimal(totalPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();;
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
}
