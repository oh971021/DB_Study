create table snack(
	s_no number(3) primary key, 
	s_name varchar2(20 char) not null,
	s_maker varchar2(20 char) not null,
	s_weight number(4,1) not null, -- ��ü 4�ڸ����� �Ҽ��� 1�ڸ��� �Ǽ� ����
	s_price number(4) not null,
	s_exp date not null -- ��¥ ���� �� �ڷ���
);

" 
## date �ڷ����� �ִ� �� ##
	1. sysdate : ����ð�
	2. 	to_date('��', '����')
			YYYY MM DD HH : MI : SS
"

insert into SNACK values (1, '���ĸ�', '���', 60, 1000, sysdate);
insert into SNACK values (50, '�ɰԶ�', '����', 70, 1200, sysdate);

select * from snack;

drop table snack cascade constraint purge;

insert into SNACK values (3, '������', '�Ե�', 70.5, 1300,
						to_date('2020-12-25', 'YYYY-MM-DD')); -- to_date �� ���� ���ϴ� ���� ������ ���� ����Ѵ�.
						
select * from snack;