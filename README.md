# Cart
Servlet+JSP+JavaBean (MVC) 模式，开发购物车。

1.搭建开发环境
	1.1 建立程序开发包
		cn.mengmei.domain
		cn.mengmei.dao
		cn.mengmei.service
		cn.mengmei.web.UI
		cn.mengmei.web.controller
		cn.mengmei.db
		/WEB-INF/下新建jsp文件夹

2.开发实体
public class Book {
	private String id;
	private String name;
	private String author;
	private double price;
	private String description;
	public Book();
	public Book(String id, String name, String author, double price, String description);
}

3.用java类，模拟数据库。
public class MyDb {
	private static Map<String,Book> map = new LinkedHashMap<String,Book>();
	//为了让程序一起起来就有书。就在静态代码块中put一些。
	static{
		map.put("1", new Book("1", "java就业教程", "老张", 98.8, "一本好书！"));
		map.put("2", new Book("2", "HTML+CSS+JavaScript", "老黎", 68.9, "前端经典！"));
	}
	public static Map<String, Book> getAll();
}

4.开发dao
public class BookDao {
	public Map<String, Book> getAll();
	public Book find(String id);
}
	
5.开发service
public class BusinessService {
	private BookDao dao = new BookDao();
	public Map<String, Book> getAll();  //列出所有书
	public void buyBook(String bookid, Cart cart); //往购物车里添加书
	public void deleteBook(String bookid, Cart cart); //删除购物项
	public void clearCart(Cart cart); //清空购物车
	public void setQuantity(String bookid, String quantity, Cart cart); //修改某个购物项的数量。
}
	
6.在controller包开发ListBookServlet
	6.1 调用service的getAll()方法得到数据库中的所有书的集合map
	6.2 将map存到request域
	6.3 转发到listbook.jsp页面显示书籍列表。
	
7.开发listbook.jsp页面
	7.1 用jstl便利map，列出每一本书的信息。
	7.2 并在每一本书后面挂上购买链接，链接到BuyServlet，并将书的id号作为参数挂在链接后面。
	
8.开发BuyServlet
	8.1 从request的参数里取出书的id号。
	8.2 在开发购买功能前，先开发购物车实体Cart，和购物项实体CartItem。详见9、10。
	8.3 在session里得到用户的购物车，如果为空，那就new一辆，存到session里。
	8.4 在service层开发 buyBook(bookid,cart) 功能。详见5。
	8.5 调用service的方法 buyBook(bookid,cart); 将书添加到购物车里。
	8.6 跳到购物车显示页面。

9.开发Cart购物车实体
public class Cart {
	private Map<String, CartItem> map = new LinkedHashMap<String, CartItem>();
	private double price;
	public void add(Book book)；
｝

10.开发CartItem购物项实体
public class CartItem {
	private Book book;
	private int quantity;
	private double price;
｝
	

11.开发购物车显示页面：	listcart.jsp
	11.1 用jstl便利${cart.map}，列出每一个购物项的信息。
	11.2 并在每一条购物项后面挂上删除链接，链接到DeleteServlet，并将书的id号作为参数挂在链接后面。
	11.3 在最下面放一个清空购物车的链接，链接到 ClearCartServlet 。
	11.4 在表格前后套上jstl+el表达式判断购物车数据是否为空，如果为空则不显示表格，提示一句话。
		<c:if test="${!empty(cart.map)}">
			<table>购物车列表</table>
		</c:if>
		<c:if test="${empty(cart.map)}">
			对不起，您还没有购买任何东西！
		</c:if>
	11.5 提升购物车功能，购物项数量的修改。

12.开发DeleteServlet
	12.1 从request的参数里取出书的id号。
	12.2 从session里得到用户的购物车。
	12.3 在service层开发 deleteBook(String bookid, Cart cart) 方法。先判断传入的cart是否为空，为空则抛自定义异常。详见5。
	12.4 调用service的方法 deleteBook(bookid,cart); 将购物车里的此购物项删除。如果这句抛异常，则跳到全局消息显示页面。
	12.5 跳到购物车显示页面。

13.开发自定义异常类：CartNotFoundException 。

14.开发ClearCartServlet
	 14.1 从session里得到用户的购物车。
	 14.2 在service层开发 clearCart(Cart cart) 方法。先判断传入的cart是否为空，为空则抛自定义异常。详见5。
	 14.3 调用service的方法 clearCart(cart) ,将购物车清空。如果这句抛异常，则跳到全局消息显示页面。
	 14.4 跳到购物车显示页面。
	 
15.开发SetQuantityServlet。
	15.1 从request的参数里获得bookid、quantity。
	15.2 从session里取出用户的购物车cart。
	15.3 在service层开发 setQuantity(String bookid, String quantity, Cart cart) 方法。先判断传入的cart是否为空，为空则抛自定义异常。判断quantity转为Integer是否报异常，判断是否在规定范围内，详见5。
	15.4 调用service层的setQuantity(bookid, quantity, cart)方法，设置购物项的数量。如果这句抛异常，则跳到全局消息显示页面。
	15.5 跳到购物车显示页面。

16.开发NumberIllegal异常类。
		




		
