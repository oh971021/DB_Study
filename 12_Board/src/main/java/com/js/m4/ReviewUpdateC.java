package com.js.m4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReviewUpdateC")
public class ReviewUpdateC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 일시키기 ( 넘버를 가지고 있으니까 거기에 해당 된 값들을 가져오기 )
		ReviewDAO.getRdao().getReview(request);
		
		request.setAttribute("contentPage", "jsp/m4_update.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 일 시키기 (update)
		ReviewDAO.getRdao().updateReview(request);
		ReviewDAO.getRdao().getAllReivew(request);
		
		// 목록으로 돌아가기
		request.setAttribute("contentPage", "jsp/m4.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
