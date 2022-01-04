package com.js.m3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MovieDelController")
public class MovieDelController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 삭제하는 일
//		MovieDAO.delMovie(request);
		
		MovieDAO.getMdao().delMovie(request);
		MovieDAO.getMdao().getAllmovie(request);
		MovieDAO.getMdao().paging(1, request);
//		m.delMovie(request);
//		m.getAllmovie(request);
//		m.paging(1, request);
		
		request.setAttribute("contentPage", "jsp/m3.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
