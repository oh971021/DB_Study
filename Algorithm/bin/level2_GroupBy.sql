-- ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. 
-- ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

-- 고양이와 개는 몇 마리 있을까?

SELECT ANIMAL_TYPE, COUNT(*) as count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY NAME desc

-- 동명 동물 수 찾기

SELECT
    name, 
    COUNT(NAME) AS count
FROM
    ANIMAL_INS
WHERE
# WHERE에 여러 조건이 들어가면 연산자를 사용해야함.
    NAME IS NOT NULL
HAVING COUNT(NAME) >= 2
GROUP BY NAME

-- 입양 시각 구하기

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
    
-- 입양 시각 구하기2
    
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