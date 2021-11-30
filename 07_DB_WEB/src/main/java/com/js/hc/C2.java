package com.js.hc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/C2")
public class C2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("NewFile.html").forward(request, response);
		}

		M.call(request);
		M.reg(request);
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		M.select(request);
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
	}

}
