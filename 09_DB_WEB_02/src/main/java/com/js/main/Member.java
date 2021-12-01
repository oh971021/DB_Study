package com.js.main;


// Bean, POJO 
// DTO(Data Transfer Object)
public class Member {

	// 빈 구성은 Database Table 의 구성대로 맞춰 쓰면 된다.
	// DB는 안쓰는 값이라도 사용한다.
	private int no;
	private String name;
	private int age;
	
	public Member() {}

	public Member(int no, String name, int age) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
