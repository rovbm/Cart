package cn.mengmei.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.mengmei.domain.Cart;
import cn.mengmei.exception.CartNotFoundException;
import cn.mengmei.service.BusinessService;

public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bookid = request.getParameter("bookid");
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		BusinessService service = new BusinessService();
		try {
			service.deleteBook(bookid, cart);
			request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
		} catch (CartNotFoundException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
