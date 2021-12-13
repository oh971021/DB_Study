package com.js.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegAccountC")
public class RegAccountC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		loginDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "jsp/reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 회원등록하는 일 (DB에 입력값 대입시키기)
		loginDAO.reg(request);
		
		loginDAO.loginCheck(request);
		// 회원가입 성공 시 홈으로 이동
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);	
	}

}
