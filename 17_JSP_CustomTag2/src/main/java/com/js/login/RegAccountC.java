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

		// ȸ������ϴ� �� (DB�� �Է°� ���Խ�Ű��)
		loginDAO.reg(request);
		
		loginDAO.loginCheck(request);
		// ȸ������ ���� �� Ȩ���� �̵�
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);	
	}

}
