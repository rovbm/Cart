package cn.mengmei.db;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.mengmei.domain.Book;

//这个类用来模拟数据库，用来保存网站所有书的。
public class MyDb {
	
	private static Map<String,Book> map = new LinkedHashMap<String,Book>();
	
	//为了让程序一起起来就有书。就在静态代码块中put一些。
	static{
		map.put("1", new Book("1", "java就业教程", "老张", 98.8, "一本好书！"));
		map.put("2", new Book("2", "HTML+CSS+JavaScript", "老黎", 68.9, "前端经典！"));
		map.put("3", new Book("3", "structs经典教程", "老方", 128.9, "超赞！"));
		map.put("4", new Book("4", "spring宝典", "老毕", 123.5, "更上一层楼！"));
		map.put("5", new Book("5", "Hibernate开发", "老王", 135.9, "饱眼福！"));
	}
	
	public static Map<String, Book> getAll(){
		return map;
	}
}
