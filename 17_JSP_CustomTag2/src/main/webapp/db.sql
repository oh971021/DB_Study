create table login_jw (
	l_id varchar2(20 char) primary key,
	l_pw varchar2(20 char) not null,
	l_name varchar2(20 char) not null
);

insert into login_jw values ('js', '1004', '¡ÿºÆ');

select * from LOGIN_JW;