create table db_test (
	d_no number(2) primary key,
	d_name varchar2(20 char) not null,
	d_age varchar2(2) not null
);

create sequence db_test_seq;

insert into db_test values (db_test_seq.nextval, '�ؼ�', 25);
insert into db_test values (db_test_seq.nextval, '�ָ�', 20);
insert into db_test values (db_test_seq.nextval, '�Ѻ�', 27);

select * from db_test;