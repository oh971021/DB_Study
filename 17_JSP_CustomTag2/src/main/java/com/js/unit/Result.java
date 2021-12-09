package com.js.unit;

public class Result {

	private double value; 
	private int calc;
	private String result;
	private String cn;
	private String color;
	private String unit1;
	private String unit2;

	public Result() {}

	public Result(double value, int calc, String result, String cn, String color, String unit1, String unit2) {
		super();
		this.value = value;
		this.calc = calc;
		this.result = result;
		this.cn = cn;
		this.color = color;
		this.unit1 = unit1;
		this.unit2 = unit2;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getCalc() {
		return calc;
	}

	public void setCalc(int calc) {
		this.calc = calc;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUnit1() {
		return unit1;
	}

	public void setUnit1(String unit1) {
		this.unit1 = unit1;
	}

	public String getUnit2() {
		return unit2;
	}

	public void setUnit2(String unit2) {
		this.unit2 = unit2;
	}	
	
}
