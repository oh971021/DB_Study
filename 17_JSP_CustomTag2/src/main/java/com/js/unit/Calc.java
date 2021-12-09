package com.js.unit;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class Calc {

	public static void calc(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
			double value = Double.parseDouble(request.getParameter("value"));
			int calc = Integer.parseInt(request.getParameter("calc"));
			double result1 = value / 1.609;
			String cn = "c4";
			String color = "gray";
			String unit1 = "km/h";
			String unit2 = "mi/h";
			
			if (calc == 1) {
				result1 = value / 2.54;
				unit1 = "cm";
				unit2 = "inch";
				cn = "c1";
				color = "red";
			} else if (calc == 2) {
				result1 = value / 3.306;
				unit1 = "§³";
				unit2 = "Æò";
				cn = "c2";
				color = "blue";
			} else if (calc == 3) {
				result1 = (value * 1.8) + 32;
				unit1 = "¡É";
				unit2 = "¢µ";
				cn = "c3";
				color = "green";
			}
			
			System.out.println(value);
			System.out.println(calc);
			System.out.println(result1);
			System.out.println(cn);
			System.out.println(color);
			System.out.println(unit1);
			System.out.println(unit2);
			
			String result2 = String.format("%.2f", result1); 
			
			Result R = new Result(value, calc, result2, cn, color, unit1, unit2);
			
			request.setAttribute("re", R);
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
