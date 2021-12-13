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

		// ������ ���� �� ��츦 �����ؼ� �α��� Ȯ���ϱ�.
		loginDAO.loginCheck(request);
		
		// select�� DB�� �� ������ ��������
			// ������ ������ �ֱ� ������ �������� ó���ϸ� ��
		
		// ���ɻ� �迭�� ����ְ�, �װ� ���� �ȴٸ� info�� �̵�		
		if(loginDAO.makeInterest(request) == 1) {
			// �������� â���� �̵�~
			request.setAttribute("contentPage", "jsp/info.jsp");
		} else {
			// ������ ���ᰡ �ȴٸ� Ȩ���� ����������
			request.setAttribute("contentPage", "home.jsp");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
