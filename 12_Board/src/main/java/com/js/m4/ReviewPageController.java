package com.js.m4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReviewPageController")
public class ReviewPageController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 파라미터로 보내진 페이지 번호를 받아서
		int p = Integer.parseInt(request.getParameter("p"));
		
		// 페이징 기능에 셋팅해줌으로써 그 페이지로 이동함.
		ReviewDAO.getRdao().getAllReivew(request);
		ReviewDAO.getRdao().paging(p, request);
		
		request.setAttribute("contentPage", "jsp/m4.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

}
