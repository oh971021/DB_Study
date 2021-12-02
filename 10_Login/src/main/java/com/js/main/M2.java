package com.js.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class M2 {

	// 로그인 기능
	public static void login(HttpServletRequest request) {

		/*
		 * 로그인 방법 1. 사용자가 id, pw 입력 2. DB의 정보와 일치하는지 확인 (DB값 비교) 3. 다 맞으면 로그인 성공! / 하나라도
		 * 틀리면 로그인 실패!
		 */

		// 1. 값 받기
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");

		// 2. DB와 비교 ( 아직 개발 안됨 ) - 가데이터 처리

		String dbID = "js";
		String dbPW = "1004";

		if (userId.equals(dbID)) {
			// id 가 맞으면 pw 검사를 하자
			if (userPw.equals(dbPW)) {
				request.setAttribute("r", "로그인 성공!");
			} else {
				request.setAttribute("r", "비밀번호 오류입니다.");
			}
		} else {
			request.setAttribute("r", "존재하지 않는 회원입니다.");
		}

	}

}
