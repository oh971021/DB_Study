package com.js.unit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.login.loginDAO;

@WebServlet("/UnitC")
public class UnitC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		loginDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "unit/unit.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Calc.calc(request);
		loginDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "unit/NewFile.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
