create table login_jw (
	l_id varchar2(20 char) primary key,
	l_pw varchar2(20 char) not null,
	l_name varchar2(20 char) not null
);

insert into login_jw values ('js', '1004', '준석');

select * from LOGIN_JW;

create table account(
	a_name varchar2(20 char) not null,
	a_id varchar2(50 char) primary key,
	a_pw varchar2(50 char) not null,
	a_gender char(1 char) not null,
	a_addr varchar2(100 char) not null,
	a_interest varchar2(200 char) not null,
	a_introduce varchar2(200 char) not null,
	a_img varchar2(200 char) not null
);

insert into ACCOUNT values('js', 'id', 'pw', '남', '주소', '관심사', '자기소개', 'asd.jsp');

select * from account;

-- delete ACCOUNT where a_id = 'id';

-- drop table account cascade constraint purge;