package com.hansin.database;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/my3")
public class myexample3 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html);charset=UTF-8");
	req.setCharacterEncoding("UTF-8");
	
	resp.sendRedirect("Calculator2.html");
	
	String v_ = req.getParameter("value");
	int value = Integer.parseInt(v_);
	String op = req.getParameter("operatior");
	
	//ServletContext 이용
//	ServletContext application = req.getServletContext();
//	
//	if(op.equals("=")) {
//		int result =0;
//		//저장되어있는 값과 연산자 가지고 와서 현재값이랑 연산 후 출력 = result
//		int prev = (int) application.getAttribute("value");
//		String prev_op = (String) application.getAttribute("operator");
//	
//		if(prev_op.equals("+")) {
//			result = prev + value ;
//		}
//		
//		resp.getWriter().printf("Result is %d\n", result);
//		
//	}else {
//		//값과 연산자를 저장
//		application.setAttribute("value", value);
//		application.setAttribute("operator",op);
//		}
	
	
	//HttpSession 이용
	HttpSession session = req.getSession();
	
	if(op.equals("=")) {
		int result =0;
		//저장되어있는 값과 연산자 가지고 와서 현재값이랑 연산 후 출력 = result
		int prev = (int) session.getAttribute("value");
		String prev_op = (String) session.getAttribute("operator");
	
		if(prev_op.equals("+")) {
			result = prev + value ;
		}
		
		resp.getWriter().printf("Result is %d\n", result);
		
	}else {
		//값과 연산자를 저장
		session.setAttribute("value", value);
		session.setAttribute("operator",op);
		}
	
	
	//Cookie 이용
//	Cookie[] cookies = req.getCookies();
//	
//		if(op.equals("=")) {
//			int result =0;
//			//저장되어있는 값과 연산자 가지고 와서 현재값이랑 연산 후 출력 = result
//			int prev = 0;
//			String prev_op = "";
//			
//			for(Cookie c: cookies) {
//				if(c.getName().equals("value")) {
//					prev =Integer.parseInt(c.getValue());
//				}
//				if(c.getName().equals("operator")) {
//					prev_op = c.getValue();
//				}
//			}
//		
//			if(prev_op.equals("+"))
//				result = prev + value;
//			else
//				result = prev - value;
//		
//			resp.getWriter().printf("Result is %d\n", result);
//		
//		}else {
//			//값과 연산자를 저장
//			Cookie valueCookie = new Cookie("value",String.valueOf(value));
//			Cookie operatorCookie = new Cookie("operator",op);
//			resp.addCookie(valueCookie);
//			resp.addCookie(operatorCookie);
//		}

	}
}
