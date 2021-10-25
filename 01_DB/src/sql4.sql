-- select (��ȸ)

select * from snack;

-- ��ü ���� �̸�, ����, ����
select s_name, s_price, s_weight from snack;

-- ��ü ���� �̸�, ������, ����, �������
select s_name, s_maker, s_price, s_exp from snack;

-- �ʵ���� ���� �ȵ�� �ٲ� �� �ֵ�.
-- as XXX
select s_name, s_maker as s_jejosa, s_price, s_exp from snack;

-- �ٽ� ���� �̸�, ����
select s_name, s_price from SNACK;

-- �� ���¿��� �ΰ��� �ϰ� ����
select s_name, s_price, s_price * 0.1 as s_vat from SNACK;

-- test
-- ��ü ���� �̸�, ������, ����, g�� ��(s_g)
select s_name, s_maker, s_price, round(s_price / s_weight) as s_g from snack;
-- round() : �ݿø� ó���ؼ� �Ҽ����� �����ش�.

-- ��������� ���ڵ�(��) ���

-- ��ü ������ ��� ������ �󸶳�?
-- ���⼭�� �� ����� �ʿ��ϴ� ( ����Լ� ��� )
-- ����Ŭ ����Լ� : max, min, sum, avg, count, ...
select avg(s_price) from snack;

-- ��ü ���ڿ��� ���� �� ����
select min(s_price) from snack;

-- ��������� ���� ���� ���� ����
select max(s_exp) from snack; 

-- ���ڰ� �� �? : count ���ڵ�(��) ���� Ư���� �� �ᵵ �Ȱ���.
select count(s_no) from snack;
select count(*) from snack;

-- ��ü ������ �̸�, ����, �������ε� ���� �̸��� �������ΰ� (����) 
select s_name, s_price, s_maker 
from snack
where s_name = '������';



-- ###################### WHERE #############################

select s_name, s_price
from SNACK
where s_maker = '���';

-- ��� ������ ��� ����
select avg(s_price)
from snack
where s_maker = '���';

-- ������ �ȵǴ� ������ �̸�, ����
select * from snack where s_exp < sysdate;

-- '%��' : ���� ������ ��
-- '��%' : ���� �����ϴ� ��
-- '%��%' : ���� ���Ե� ��

-- ~�� ���� ������ �ø��� ���� �̸�, ����
select s_name, s_price
from SNACK
where s_name like '%��';


-- test
-- ������ �ø��� ���� �̸�, ����
select s_name, s_price
from snack
where s_name like '%������%';

-- �� �ø��� �� �ְ�
select avg(s_price)
from snack
where s_name like '%��';

-- ���� ��� ���� (�̸�, ����, ����)
select s_name, s_maker, s_price
from SNACK
where s_price = max(s_price);

-- subQuery ( ���� �� ���� )

-- ���� ���
select max(s_price)
from SNACK

-- �� ��� ���� (�̸�, ����Ŀ, ����)
select s_name, s_maker, s_price
from snack
where s_price = (
	select max(s_price)
	from SNACK
	);


	

-- test 2 ( subQuery )
-- ��� ������ ��� ������ �̸� ����
select s_name, s_price
from snack
where s_price > (
	select avg(s_price)
	from snack
	);

-- ��� ��
select avg(s_price)
from SNACK




-- test3 ( subQuery )
-- ���� ������ ������ �̸��� ����
select s_name, s_price
from snack
where s_weight = (
	select min(s_weight)
	from snack
	);

-- ���� ���ſ� ������ �̸��� ����
select s_name, s_price
from snack
where s_weight = (
	select max(s_weight)
	from snack
	);






