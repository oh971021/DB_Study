package com.js.bmi;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BmiCalc {

	public static void bmi(HttpServletRequest request) throws IOException {

		String path = request.getSession().getServletContext().getRealPath("img");
		System.out.println(path);
		
		// 멀티파트 객체 생성
		MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());			
		
		String name = mr.getParameter("name");
		double height = Double.parseDouble(mr.getParameter("height"));
		double weight = Double.parseDouble(mr.getParameter("weight"));
		String profile = mr.getFilesystemName("profile");
		
		// 콘솔에 값 출력해보기
		System.out.println(name);
		System.out.println(height);
		System.out.println(weight);
		
		// 값 계산하고 대입
		double bmi = (weight) / ((height / 100) * (height / 100));
		System.out.println(bmi);	

		// 값에 따른 결과 값
		String result = "비만";
		if (bmi < 18.5) {
			result = "저체중";
		} else if (bmi < 23) {
			result = "정상";
		} else if (bmi >= 23 && bmi < 25) {
			result = "과체중";
		}
		
		String bmi2 = String.format("%.2f", bmi);
		
		BmiResult br = new BmiResult(name, height, weight, bmi2, result, profile);
		
		request.setAttribute("br", br);
		
	}

}
