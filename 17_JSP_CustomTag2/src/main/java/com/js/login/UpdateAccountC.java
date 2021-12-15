package com.js.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateAccountC")
public class UpdateAccountC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		loginDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "jsp/updateInfo.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 수정 시키기
		loginDAO.updateAccount(request);
		// 수정 후 다시 로그인해서 업데이트 된 정보 확인하기
		loginDAO.login(request);
		loginDAO.loginCheck(request);
		
		// 관심사를 나눠서 표시하기 위해서 작업 시키기 (어트리뷰트 불러오기)
		loginDAO.makeInterest(request);
		
		request.setAttribute("contentPage", "jsp/info.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
