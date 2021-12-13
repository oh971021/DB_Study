package com.js.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoAccountC")
public class InfoAccountC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 세션이 만료 될 경우를 생각해서 로그인 확인하기.
		loginDAO.loginCheck(request);
		
		// select로 DB의 내 정보를 가져오기
			// 하지만 세션이 있기 떄문에 세션으로 처리하면 됨
		
		// 관심사 배열로 담아주고, 그게 실행 된다면 info로 이동		
		if(loginDAO.makeInterest(request) == 1) {
			// 정보보는 창으로 이동~
			request.setAttribute("contentPage", "jsp/info.jsp");
		} else {
			// 세션이 만료가 된다면 홈으로 보내버리기
			request.setAttribute("contentPage", "home.jsp");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
