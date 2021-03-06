package cn.mengmei.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mengmei.domain.Cart;
import cn.mengmei.exception.CartNotFoundException;
import cn.mengmei.exception.NumberIllegal;
import cn.mengmei.service.BusinessService;

//修改购物项的数量
public class SetQuantityServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		String bookid = request.getParameter("bookid");
		String quantity = request.getParameter("quantity");
		
		BusinessService service = new BusinessService();
		
		try {
			service.setQuantity(bookid,quantity,cart);
			request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
			
		} catch (NumberIllegal | CartNotFoundException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
