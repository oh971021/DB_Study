package com.js.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HC")
public class HC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("index.html").forward(request, response);			
		} else {
			// 등록하는 일 시키기
			request.setAttribute("r", DAO_Member.regMember(M.getVal(request))); 
			request.getRequestDispatcher("index.jsp").forward(request, response);			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}





