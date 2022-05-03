-- ANIMAL_INS ���̺��� ���� ��ȣ�ҿ� ���� ������ ������ ���� ���̺��Դϴ�. \
-- ANIMAL_INS ���̺� ������ ������ ������, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE�� ���� ������ ���̵�, ���� ��, ��ȣ ������, ��ȣ ���� �� ����, �̸�, ���� �� �߼�ȭ ���θ� ��Ÿ���ϴ�.

-- �ִ� ���ϱ�

SELECT max(DATETIME) AS �ð� FROM ANIMAL_INS

-- �ּڰ� ���ϱ�

SELECT min(DATETIME) AS �ð� FROM ANIMAL_INS

-- ���� �� ���ϱ�

SELECT count(*) as count FROM ANIMAL_INS

-- �ߺ��� ����

SELECT 
    count(DISTINCT NAME) as count
FROM
    ANIMAL_INS
WHERE
    NAME is not NULL