-- ANIMAL_INS ���̺��� ���� ��ȣ�ҿ� ���� ������ ������ ���� ���̺��Դϴ�. 
-- ANIMAL_INS ���̺� ������ ������ ������, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE�� ���� ������ ���̵�, ���� ��, ��ȣ ������, ��ȣ ���� �� ����, �̸�, ���� �� �߼�ȭ ���θ� ��Ÿ���ϴ�.

-- ����̿� ���� �� ���� ������?

SELECT ANIMAL_TYPE, COUNT(*) as count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY NAME desc

-- ���� ���� �� ã��

SELECT
    name, 
    COUNT(NAME) AS count
FROM
    ANIMAL_INS
WHERE
# WHERE�� ���� ������ ���� �����ڸ� ����ؾ���.
    NAME IS NOT NULL
HAVING COUNT(NAME) >= 2
GROUP BY NAME

-- �Ծ� �ð� ���ϱ�

SELECT 
    HOUR(DATETIME) AS HOUR, 
    count(*) AS count
FROM 
    ANIMAL_OUTS
WHERE
    HOUR(DATETIME) >= 9
    AND HOUR(DATETIME) < 20
GROUP BY 
    HOUR(DATETIME)
ORDER BY
    HOUR(DATETIME)
    
-- �Ծ� �ð� ���ϱ�2
    
SELECT
    tmp.HOUR AS `HOUR`,
    IF (outs.datetime IS NULL, 0, COUNT(tmp.HOUR)) AS `COUNT`
FROM 
    animal_outs AS outs RIGHT OUTER JOIN ( 
        WITH RECURSIVE hour_generator (n)
          AS (SELECT 1
              UNION ALL
              SELECT n+1
              FROM hour_generator
              WHERE n < 24
             )
        SELECT n-1 AS `HOUR`, 0 AS COUNT
        FROM hour_generator) AS tmp
    ON tmp.HOUR = HOUR(outs.datetime)
GROUP BY tmp.HOUR
ORDER BY tmp.HOUR;