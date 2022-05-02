create table login_test2(
	l_id varchar2(20 char) primary key,
	l_pw varchar2(20 char) not null,
	l_name varchar2(20 char) not null
);

insert into login_test2 values ('sr', '1004', '¼Ö¸®');

select * from LOGIN_TEST2;
