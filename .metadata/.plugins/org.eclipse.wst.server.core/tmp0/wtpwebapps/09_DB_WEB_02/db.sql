create table member (
	m_no number(3) primary key,
	m_name varchar2(20 char) not null,
	m_age number(2) not null
);

create sequence member_seq;

insert into member values (member_seq.nextval, 'Å×½ºÆ®', 20);

select * from member;