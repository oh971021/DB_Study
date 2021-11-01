create table db_test (
	d_no number(3) primary key,
	d_name varchar2(20 char) not null,
	d_age varchar2(2) not null
);

create sequence db_test_seq increment by 1 start with 1;

insert into db_test values (db_test_seq.nextval, '�ؼ�', 25);
insert into db_test values (db_test_seq.nextval, '�ָ�', 20);
insert into db_test values (db_test_seq.nextval, '�Ѻ�', 27);

select * from db_test;

drop table db_test cascade constraint purge;
drop sequence db_test_seq;

-- �ع� 2 �̸��� '��' �� �� ����� ���̸� 30���� ����
update db_test set d_age = 30 where d_name like '%��%';	

-- �̸��� '��' �� ���� �� ���
select * from db_test where d_name like '%��%';