package cn.mengmei.dao;

import java.util.Map;

import cn.mengmei.db.MyDb;
import cn.mengmei.domain.Book;

public class BookDao {
	
	public Map<String, Book> getAll(){
		return MyDb.getAll();
	}
	
	public Book find(String id){
		return MyDb.getAll().get(id);
	}
	
}
