package com.js.m3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MoviePageController")
public class MoviePageController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int p = Integer.parseInt(request.getParameter("p"));
		
		MovieDAO.getMdao().getAllmovie(request);
		// = m.getAllmovie(request); 같은 의미
		MovieDAO.getMdao().paging(p, request);
		// = m.paging(p, request); 같은 의미
		
		request.setAttribute("contentPage", "jsp/m3.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
