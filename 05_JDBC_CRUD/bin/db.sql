create table db_test (
	d_no number(3) primary key,
	d_name varchar2(20 char) not null,
	d_age varchar2(2) not null
);

create sequence db_test_seq increment by 1 start with 1;

insert into db_test values (db_test_seq.nextval, '준석', 25);
insert into db_test values (db_test_seq.nextval, '솔리', 20);
insert into db_test values (db_test_seq.nextval, '뚜비', 27);

select * from db_test;

drop table db_test cascade constraint purge;
drop sequence db_test_seq;

-- 준발 2 이름이 '발' 이 들어간 사람의 나이를 30으로 수정
update db_test set d_age = 30 where d_name like '%발%';	

-- 이름에 '발' 이 포함 된 사람
select * from db_test where d_name like '%발%';