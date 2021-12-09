package com.js.bmi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.login.loginDAO;
import com.js.unit.Calc;

@WebServlet("/BmiC")
public class BmiC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		loginDAO.loginCheck(request);
		request.setAttribute("contentPage", "bmi/bmi_input.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BmiCalc.bmi(request);
		loginDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "bmi/bmi_output.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);		
		
	}

}
