package cn.mengmei.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mengmei.domain.Cart;
import cn.mengmei.service.BusinessService;

public class BuyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bookid = request.getParameter("bookid");
		
		//把用户买的书加到购物车中
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart==null){
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		BusinessService service = new BusinessService();
		service.buyBook(bookid,cart);
		
		//买好书后跳到购物车显示页面
		request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
