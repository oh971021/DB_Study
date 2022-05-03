-- ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. \
-- ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

-- 최댓값 구하기

SELECT max(DATETIME) AS 시간 FROM ANIMAL_INS

-- 최솟값 구하기

SELECT min(DATETIME) AS 시간 FROM ANIMAL_INS

-- 동물 수 구하기

SELECT count(*) as count FROM ANIMAL_INS

-- 중복값 제거

SELECT 
    count(DISTINCT NAME) as count
FROM
    ANIMAL_INS
WHERE
    NAME is not NULL