package com.js.m3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.RemoteEndpoint.Basic;

@WebServlet("/MovieUpdateC")
public class MovieUpdateC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("num") == null) {
			// 일 해야지 이젠 (입력받은 내용이 있으면)
			MovieDAO.getMdao().updateMovie(request);
			MovieDAO.getMdao().getAllmovie(request);
			MovieDAO.getMdao().paging(1, request);
			
			request.setAttribute("contentPage", "jsp/m3.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} else {

			System.out.println(request.getParameter("basicImg"));
			request.setAttribute("basicImg", request.getParameter("basicImg"));
			
			MovieDAO.getMdao().getMovie(request);
			
			request.setAttribute("contentPage", "jsp/m3_detail.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MovieDAO.getMdao().updateMovie2(request);
		MovieDAO.getMdao().getAllmovie(request);
		MovieDAO.getMdao().paging(1, request);
		
		request.setAttribute("contentPage", "jsp/m3.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
