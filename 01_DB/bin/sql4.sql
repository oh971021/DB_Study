-- select (조회)

select * from snack;

-- 전체 과자 이름, 가격, 무게
select s_name, s_price, s_weight from snack;

-- 전체 과자 이름, 제조사, 가격, 유통기한
select s_name, s_maker, s_price, s_exp from snack;

-- 필드명이 맘엥 안들면 바꿀 수 있따.
-- as XXX
select s_name, s_maker as s_jejosa, s_price, s_exp from snack;

-- 다시 과자 이름, 가격
select s_name, s_price from SNACK;

-- 이 상태에서 부과세 하고 싶음
select s_name, s_price, s_price * 0.1 as s_vat from SNACK;

-- test
-- 전체 과자 이름, 제조사, 가격, g당 얼마(s_g)
select s_name, s_maker, s_price, round(s_price / s_weight) as s_g from snack;
-- round() : 반올림 처리해서 소수점을 없애준다.

-- 현재까지는 레코드(행) 계산

-- 전체 과자의 평균 가격이 얼마냐?
-- 여기서는 열 계산이 필요하다 ( 통계함수 사용 )
-- 오라클 통계함수 : max, min, sum, avg, count, ...
select avg(s_price) from snack;

-- 전체 과자에서 가장 싼 과자
select min(s_price) from snack;

-- 유통기한이 제일 오래 남은 과자
select max(s_exp) from snack; 

-- 과자가 총 몇개? : count 레코드(행) 세는 특성상 뭘 써도 똑같다.
select count(s_no) from snack;
select count(*) from snack;

-- 전체 과자의 이름, 가격, 제조사인데 과자 이름이 다이제인거 (조건) 
select s_name, s_price, s_maker 
from snack
where s_name = '다이제';



-- ###################### WHERE #############################

select s_name, s_price
from SNACK
where s_maker = '농심';

-- 농심 과자의 평균 가격
select avg(s_price)
from snack
where s_maker = '농심';

-- 먹으면 안되는 과자의 이름, 가격
select * from snack where s_exp < sysdate;

-- '%ㅋ' : ㅋ로 끝나는 거
-- 'ㅋ%' : ㅋ로 시작하는 거
-- '%ㅋ%' : ㅋ가 포함된 거

-- ~깡 으로 끝나는 시리즈 과자 이름, 가격
select s_name, s_price
from SNACK
where s_name like '%깡';


-- test
-- 빼빼로 시리즈 과자 이름, 가격
select s_name, s_price
from snack
where s_name like '%빼빼로%';

-- 깡 시리즈 중 최고가
select avg(s_price)
from snack
where s_name like '%깡';

-- 제일 비싼 과자 (이름, 제조, 가격)
select s_name, s_maker, s_price
from SNACK
where s_price = max(s_price);

-- subQuery ( 쿼리 속 쿼리 )

-- 제일 비싼
select max(s_price)
from SNACK

-- 젤 비싼 과자 (이름, 메이커, 가격)
select s_name, s_maker, s_price
from snack
where s_price = (
	select max(s_price)
	from SNACK
	);


	

-- test 2 ( subQuery )
-- 평균 값보다 비싼 과자의 이름 가격
select s_name, s_price
from snack
where s_price > (
	select avg(s_price)
	from snack
	);

-- 평균 값
select avg(s_price)
from SNACK




-- test3 ( subQuery )
-- 제일 가벼운 과자의 이름과 가격
select s_name, s_price
from snack
where s_weight = (
	select min(s_weight)
	from snack
	);

-- 제일 무거운 과자의 이름과 가격
select s_name, s_price
from snack
where s_weight = (
	select max(s_weight)
	from snack
	);

-- 농심 해태 과자 정보 전체

select * from snack
where s_maker = '농심' or s_maker = '해태';

-- 1000원 < 가격 < 1500원 인 과자 정보 정체
select * from snack
where s_price > 1000 and s_price < 1500;

---------------------------------------------------

-- 정렬 order by 칼럼        desc (역순)

-- 오름차순 (점점 올라감) / 내림차순 (점점 내려감)

-- 롯데 과자 전체 이름순으로 정렬
select * from snack
where s_maker = '롯데'
order by s_name;

-- 과자 전체 정보 가격순으로
select * from SNACK
order by s_price, s_name;

-- 1500원 전재산
	-- 내가 사먹을 수 있는 과자
select * from SNACK
where s_price <= 1500
order by s_exp;








