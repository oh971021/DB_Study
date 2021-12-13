package com.js.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateAccountC")
public class UpdateAccountC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		loginDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "jsp/updateInfo.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 수정 시키기
		loginDAO.updateAccount(request);
		
		loginDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "jsp/info.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
