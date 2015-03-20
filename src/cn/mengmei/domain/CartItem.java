package cn.mengmei.domain;

import java.math.BigDecimal;

public class CartItem {
	
	private Book book;
	private int quantity;
	private double price;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		double itemPrice = this.book.getPrice() * this.quantity;
		this.price = new BigDecimal(itemPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
