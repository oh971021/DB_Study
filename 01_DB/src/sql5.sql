create table a (
	a_no number(20) primary key,
	a_price varchar2(20 char) not null
);
create sequence a_seq start with 1 increment by 1;

create table aa (
	aa_no number(20) primary key,
	aa_name varchar2(20 char) not null
);
create sequence aa_seq start with 1 increment by 1;

create table con (
	con_no number(3) primary key,
	con_price number(20) not null,
	con_name number(20) not null
);
create sequence con_seq start with 1 increment by 1;

insert into a values(1, 3000);
insert into a values(2, 4000);
insert into a values(3, 5000);
insert into aa values(1, '에이칩');
insert into con values(1, 1, 1);
insert into con values(2, 2, 1);
insert into con values(3, 3, 1);

select * from a;
select * from aa;
select * from con;

-- a_no 밖에 모름. 그에 해당하는 레스토랑 이름과 가격 출력하기
select c_no 
from a, con, aa
where a_no = 1;





















drop table a cascade constraint purge;
drop table aa cascade constraint purge;