create table login_test(
	l_id varchar2(20 char) primary key,
	l_pw varchar2(20 char) not null
);

insert into login_test values ('sr', '1004');

select * from LOGIN_TEST;
