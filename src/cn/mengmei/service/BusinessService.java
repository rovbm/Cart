package cn.mengmei.service;

import java.util.Map;

import cn.mengmei.dao.BookDao;
import cn.mengmei.domain.Book;
import cn.mengmei.domain.Cart;
import cn.mengmei.exception.CartNotFoundException;
import cn.mengmei.exception.NumberIllegal;

public class BusinessService {
	
	private BookDao dao = new BookDao();
	
	//列出所有书
	public Map<String, Book> getAll(){
		return dao.getAll();
	}

	public void buyBook(String bookid, Cart cart) {
		cart.add(dao.find(bookid));
	}
	
	public void deleteBook(String bookid, Cart cart)
			throws CartNotFoundException{
		if(cart==null){
			throw new CartNotFoundException("您还没有购买任何东西!");
		}
		cart.getMap().remove(bookid);
	}
	
	public void clearCart(Cart cart) throws CartNotFoundException{
		if(cart==null){
			throw new CartNotFoundException("您还没有购买任何东西!");
		}
		cart.getMap().clear();
	}

	public void setQuantity(String bookid, String quantity, Cart cart)
			throws NumberIllegal, CartNotFoundException {
		int num = 0;
		try{
			num = Integer.parseInt(quantity);
		}catch(Exception e){
			throw new NumberIllegal("对不起，您输入的数量不合法！");
		}
		
		if(cart==null){
			throw new CartNotFoundException("您还没有购买任何东西!");
		}
		
		if(num<1 || num>100){
			throw new NumberIllegal("对不起，您必须输入1-100之间的整数！");
		}
		cart.getMap().get(bookid).setQuantity(num);
	}
	
	
	
}
