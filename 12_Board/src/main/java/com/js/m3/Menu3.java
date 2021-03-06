package com.js.m3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Menu3")
public class Menu3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieDAO m = MovieDAO.getMdao();
		
		// 일 하기 (SELECT)
		m.getAllmovie(request);
		
		// static 영역에 안 넣으면 객체를 만들어서 사용해야 함
			// 게시판 들어가면 1페이지를 봐야하기 때문에 현재페이지 세팅을 1로 써준다.
		m.paging(1, request);
		
		request.setAttribute("contentPage", "jsp/m3.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		MovieDAO.setMovie(request);
		
		MovieDAO m = MovieDAO.getMdao();
		m.setMovie(request);
		m.getAllmovie(request);
		m.paging(1, request);
		
		request.setAttribute("contentPage", "jsp/m3.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
