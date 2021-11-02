-- RDBMS (Relational, Data, Base, M ,S)
-- ������ �����ͺ��̽�
	-- ���̺� ���� ���踦 �߽����� ����... �Ѵ�

-- ���� ȫ����� 1ȣ�� ¥��� 5000�� - ȣ���� pk
-- ���� �λ������� 2ȣ�� ������ 6000�� 
-- ���ﵿ ���ٹ� 3ȣ�� ī��� 3000�� 
-- ��ġ�� ��Ÿ���� 4ȣ�� ��ü�� 6000��

create table menu(
	m_no number(3) primary key,
	m_name varchar2(20 char) not null,
	m_price number(10) not null,
	m_place number(3) not null
);

create table restaurant(
	r_no number(3) primary key,
	r_name varchar2(20 char) not null,
	r_place varchar2(20 char) not null
);

create table human(
	h_no number(3) primary key,
	h_name varchar2(20 char) not null,
	h_birth date not null
);

create table owner(
	o_no number(3) primary key,
	o_ceo number(3) not null,
	o_restaurant number(3) not null
);

create sequence menu_seq increment by 1 start with 1;
create sequence restaurant_seq increment by 1 start with 1;
create sequence human_seq increment by 1 start with 1;
create sequence owner_seq increment by 1 start with 1;

insert into menu values (menu_seq.nextval, '������â', 10000, 1);
insert into menu values (menu_seq.nextval, '�Ұ�â', 15000, 1);
insert into menu values (menu_seq.nextval, '��ä��â', 9000, 2);
insert into menu values (menu_seq.nextval, 'ī���', 6000, 3);
insert into menu values (menu_seq.nextval, '�Ƹ޸�ī��', 4000, 3);
insert into menu values (menu_seq.nextval, '��ü��', 7000, 4);

insert into restaurant values (restaurant_seq.nextval, 'Ȳ�Ұ�â', '����');
insert into restaurant values (restaurant_seq.nextval, '���빮��â', '���빮');
insert into restaurant values (restaurant_seq.nextval, 'Ȳ�Ұ�â', '���빮');
insert into restaurant values (restaurant_seq.nextval, '��Ÿ����', '����');
insert into restaurant values (restaurant_seq.nextval, '��Ÿ����', '����');
insert into restaurant values (500, '��Ÿ����', '���빮');

-- �޴� �߰�
	-- ��Ÿ���� ��ȭ���� ü�����ν� ���� �߰�
	-- ���⽺���� 2�� ��������� �߰�

insert into menu values (menu_seq.nextval, 'ü�����ν�', 5000, 500);
insert into menu values (menu_seq.nextval, '���⽺����', 4000, 2);

-- ���⽺���� ��â���� �߸� ������ ���� ��������
update menu set m_place = 4 where m_name = '���⽺����';

-- �̰� �����
delete menu where m_name = 'ü�����ν�';

insert into human values (human_seq.nextval, '��', to_date('1980-05-05', 'YYYY-MM-DD'));
insert into human values (human_seq.nextval, '��', to_date('1985-06-05', 'YYYY-MM-DD'));
insert into human values (human_seq.nextval, '��', to_date('1980-07-05', 'YYYY-MM-DD'));
insert into human values (human_seq.nextval, '��', to_date('1985-08-05', 'YYYY-MM-DD'));
-- insert into human values (200, '��', to_date('1985-08-05', 'YYYY-MM-DD'));

insert into owner values (owner_seq.nextval, 1, 1);
insert into owner values (owner_seq.nextval, 2, 2);
insert into owner values (owner_seq.nextval, 3, 3);
insert into owner values (owner_seq.nextval, 4, 4);
-- insert into owner values (owner_seq.nextval, 200, 4);

-- �̰� ���� �ǹ�
insert into owner values (owner_seq.nextval, 4, 500);

-- ��ȸ�ϱ�
select * from menu;
select * from restaurant;
select * from human;
select * from owner;

-- ���� ��ȸ ( ���� �˰��ִ� ���� �̸�, ��ġ(���� ��ȸ) - �̸� �����ټ�
select r_name, r_place from restaurant order by r_name;

-- ���� ��ȸ ( �޴� �� ���� ��� �޴��� ���� ) : subQuery
select * from menu where m_price = (
	select max(m_price) from menu
);

-- �� ������ ����
select * from human where h_birth = (
	select min(h_birth) from human
);

-- ��â �ø��� ��հ�
select avg(m_price) from menu
where m_name like '%��â%';

-- ���� ���� ����
select * from RESTAURANT where r_place = '����';

-- ���� �� �޴��� �Ĵ� �Ĵ��� �̸��� ��ġ ( �̸��� �ٸ� ���̺��� ���� ��Ű�� )
	-- subQuery �� �ϳ� �̻��� ����� ������ �ȵȴ�.
		-- �׶��� in Ű���带 ����Ѵ�.
select r_name, r_place from RESTAURANT where r_no in (
	select m_place from MENU where m_price = (
		select min(m_price) from menu
	)
);

-- ���빮���� ���� �� �ִ� ������ �̸��� ����
select m_name, m_price 
from menu 
where m_place in (
	select r_no 
	from RESTAURANT 
	where r_place = '���빮'
);

-- ��â �ø���� ��� ������ ���� ���� �� �ֳ���?
select r_place, r_name 
from RESTAURANT
where r_no in (
	select m_place
	from menu
	where m_name like '%��â%'
);

-- ���� �� Ŀ�Ǹ� �Ĵ� ������ �̸��� ����
select r_place, r_name
from restaurant
where r_no in (
	select m_place
	from menu 
	where m_price = (
		select min(m_price)
		from menu 
		where (m_name like '%��%' or m_name like '%ī��%')
	)
);

----------------------------------------------------------------

-- JOIN : ���� �ٸ� ���̺� �����ϴ� �� pk�� ���ؼ�

-- �ΰ� ���̺� �����ؼ� ����ϱ�
select m_name, m_price, r_name, r_place
from MENU, RESTAURANT
where m_place = r_no

-- ��Ÿ���� ������������ �Ǹ��ϴ� �޴� �̸��� ����
	-- ���̺� ������ð� �߿��ϴ�
-- 1�� ���
select r_name, r_place, m_name, m_price
from RESTAURANT, menu
where r_name = '��Ÿ����' and r_place = '����' and r_no = m_place;

-- 2�� ���
select r_name, r_place, m_name, m_price
from RESTAURANT, MENU
where r_no = m_place and m_place = (
	select r_no
	from RESTAURANT
	where r_name = '��Ÿ����'
	and r_place = '����'
);

-- ���� ���� ������� ������ �����, ��ġ, ����� �̸�, ����, �޴���, ����
select h_name, h_birth, r_name, r_place, m_name, m_price
from human, restaurant, menu, owner
where r_no = m_place 
	and h_no = o_ceo
	and o_restaurant = r_no
	and h_birth = (
		select max(h_birth)
		from human
		)

-- �ֿ����� �������� �޴���, �޴� ����,

-- 1�� ��� ( RDB )
select h_name, m_name, m_price
from human, owner, RESTAURANT, menu
where r_no = m_place 
	and h_no = o_ceo
	and o_restaurant = r_no
	and h_birth = (
		select min(h_birth)
		from human
		);

-- 2�� ��� ( RDB )
select h_name, m_name, m_price
from human, OWNER, menu
where h_no = o_ceo
	and o_restaurant = m_place
	and h_birth = (
		select min(h_birth)
		from human
		)
		
-- 3�� ��� ( subQuery )
select m_name, m_price
from menu
where m_place in (
	select r_no
	from RESTAURANT
	where r_no = (
		select o_ceo
		from owner
		where o_ceo = (
			select h_no
			from HUMAN
				where h_birth =(
				select min(h_birth)
				from human
				)
			)
		)
	);

-- 4�� ��� ( subQuery )
select m_name, m_price
from menu
where m_place = (
		select o_restaurant
		from owner
		where o_ceo = (
			select h_num
			from human
			where h_birth = (
				select min(h_birth)
				from human
			)
		)
	);

----------------------- TEST ------------------------

-- Ȳ�Ұ�â ������ ��ü �޴���, ����, ���� ��ġ
select m_name, m_price, r_place
from MENU, restaurant
where m_place = r_no
	and r_name = 'Ȳ�Ұ�â';
	
-- ���� �Ѱ� �Ĵ� �����, ��ġ, �޴���, ����
select r_name, r_place, m_name, m_price
from restaurant, menu
where r_no = m_place; 
	and r_no = (
		select m_place
		from menu
		where m_price = (
			select min(m_price)
			from menu
			)
		)
	
------------------------------------------------------

-- CR ( Update, Delete )
		
-- ������â ���� �λ� (13000��)
update menu 
set m_price = 13000 
where m_name = '������â';

-- �� �� �޴� ���� �̺�Ʈ
update menu 
set m_price = 0 
where m_price = (
		select min(m_price)
		from menu
	);
		
-- �޴� ��ü�� ��պ��� ��� �޴��� 10% ����
update menu
set m_price = m_price - (m_price/10)
where m_price > (
	select avg(m_price)
	from menu
	);
		
-- ���빮 ���� �޴��� 1000�� �λ�
update menu
set m_price = m_price + 1000
where m_place in (
	select r_no
	from restaurant
	where r_place = '���빮'
	);
		
-- Ŀ�� �� '��' ������ ���� 500�� �λ�
update menu
set m_price = m_price + 500
where m_name like '%��%';
		
select * from menu;

----------------------------------------------------

-- CR ( Update, Delete )

delete menu where m_name = '���⽺����';

-- '��' ���ڰ� �� �޴� �� ����
delete menu 
where m_name like '%��%';

-- ���� ���� (�޴� ����)
delete menu
where m_place = (
	select r_no
	from restaurant
	where r_name = '��Ÿ����' and r_place = '����'
	);

-- ���� ���� (����)
delete restaurant
where r_name = '��Ÿ����' and r_place = '����';

-- '��â' �� ������ �޴� �� ����
delete menu
where m_place in (
	select r_no
	from restaurant
	where r_name like '%��â%'
	);

select * from menu;

select * from restaurant;

select m_name, r_name 
from menu, restaurant
where r_no = m_place
	and r_name like '%��â%';


-------------------------------------------------���

drop sequence menu_seq;
drop sequence restaurant_seq;
drop sequence human_seq;
drop sequence owner_seq;

drop table menu cascade constraint purge;
drop table restaurant cascade constraint purge;
drop table human cascade constraint purge;
drop table owner cascade constraint purge;