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
		
		// �Ķ���ͷ� ������ ������ ��ȣ�� �޾Ƽ�
		int p = Integer.parseInt(request.getParameter("p"));
		
		// ����¡ ��ɿ� �����������ν� �� �������� �̵���.
		ReviewDAO.getRdao().getAllReivew(request);
		ReviewDAO.getRdao().paging(p, request);
		
		request.setAttribute("contentPage", "jsp/m4.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

}