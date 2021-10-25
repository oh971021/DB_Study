create table snack(
	s_no number(3) primary key, 
	s_name varchar2(20 char) not null,
	s_maker varchar2(20 char) not null,
	s_weight number(4,1) not null, -- ��ü 4�ڸ����� �Ҽ��� 1�ڸ��� �Ǽ� ����
	s_price number(4) not null,
	s_exp date not null -- ��¥ ���� �� �ڷ���
);

" 
	���� �ڵ����� �ø��� : sequence - ����Ŭ ��� ( ���̺��� ���� )
		����1 :	create sequence ��������;
			�̸� ���� : table��_seq

		����2 : ��������.nextval 
"

create sequence snack_seq;

insert into snack values (snack_seq.nextval, '���ĸ�', '���', 60, 1000, sysdate);
insert into snack values (snack_seq.nextval, '�ɰԶ�', '�Ե�', 50, 1100, sysdate);

insert into snack values (2, '���ĸ�', '���', 60, 1000, sysdate);

insert into snack values (snack_seq.nextval, '������', '������', 50, 1300, sysdate);
insert into snack values (snack_seq.nextval, '������', '����', 50, 1600, sysdate);

select * from snack;

drop table snack cascade constraint purge;