package com.js.main;


// Bean, POJO 
// DTO(Data Transfer Object)
public class Member {

	// �� ������ Database Table �� ������� ���� ���� �ȴ�.
	// DB�� �Ⱦ��� ���̶� ����Ѵ�.
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
