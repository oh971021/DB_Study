-- RDBMS (Relational, Data, Base, M ,S)
-- 관계형 데이터베이스
	-- 테이블 간의 관계를 중심으로 뭔가... 한다

-- 강남 홍콩반점 1호점 짜장면 5000원 - 호점은 pk
-- 종로 인생설렁탕 2호점 설렁탕 6000원 
-- 역삼동 빽다방 3호점 카페라떼 3000원 
-- 대치동 스타벅스 4호점 돌체라떼 6000원

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

insert into menu values (menu_seq.nextval, '돼지곱창', 10000, 1);
insert into menu values (menu_seq.nextval, '소곱창', 15000, 1);
insert into menu values (menu_seq.nextval, '야채곱창', 9000, 2);
insert into menu values (menu_seq.nextval, '카페라떼', 6000, 3);
insert into menu values (menu_seq.nextval, '아메리카노', 4000, 3);
insert into menu values (menu_seq.nextval, '돌체라떼', 7000, 4);

insert into restaurant values (restaurant_seq.nextval, '황소곱창', '종로');
insert into restaurant values (restaurant_seq.nextval, '동대문곱창', '동대문');
insert into restaurant values (restaurant_seq.nextval, '황소곱창', '동대문');
insert into restaurant values (restaurant_seq.nextval, '스타벅스', '종로');
insert into restaurant values (restaurant_seq.nextval, '스타벅스', '강남');
insert into restaurant values (500, '스타벅스', '동대문');

-- 메뉴 추가
	-- 스타벅스 광화문점 체리블로썸 음료 추가
	-- 딸기스무디 2번 레스토랑에 추가

insert into menu values (menu_seq.nextval, '체리블로썸', 5000, 500);
insert into menu values (menu_seq.nextval, '딸기스무디', 4000, 2);

-- 딸기스무디 곱창집에 잘못 넣은거 스벅 종로점에
update menu set m_place = 4 where m_name = '딸기스무디';

-- 이거 지우기
delete menu where m_name = '체리블로썸';

insert into human values (human_seq.nextval, '김', to_date('1980-05-05', 'YYYY-MM-DD'));
insert into human values (human_seq.nextval, '나', to_date('1985-06-05', 'YYYY-MM-DD'));
insert into human values (human_seq.nextval, '박', to_date('1980-07-05', 'YYYY-MM-DD'));
insert into human values (human_seq.nextval, '이', to_date('1985-08-05', 'YYYY-MM-DD'));
-- insert into human values (200, '최', to_date('1985-08-05', 'YYYY-MM-DD'));

insert into owner values (owner_seq.nextval, 1, 1);
insert into owner values (owner_seq.nextval, 2, 2);
insert into owner values (owner_seq.nextval, 3, 3);
insert into owner values (owner_seq.nextval, 4, 4);
-- insert into owner values (owner_seq.nextval, 200, 4);

-- 이게 무슨 의미
insert into owner values (owner_seq.nextval, 4, 500);

-- 조회하기
select * from menu;
select * from restaurant;
select * from human;
select * from owner;

-- 조건 조회 ( 내가 알고있는 맛집 이름, 위치(매장 조회) - 이름 가나다순
select r_name, r_place from restaurant order by r_name;

-- 조건 조회 ( 메뉴 중 제일 비싼 메뉴의 정보 ) : subQuery
select * from menu where m_price = (
	select max(m_price) from menu
);

-- 최 연장자 정보
select * from human where h_birth = (
	select min(h_birth) from human
);

-- 곱창 시리즈 평균가
select avg(m_price) from menu
where m_name like '%곱창%';

-- 종로 가게 정보
select * from RESTAURANT where r_place = '종로';

-- 제일 싼 메뉴를 파는 식당의 이름과 위치 ( 이름이 다른 테이블을 연결 시키기 )
	-- subQuery 는 하나 이상의 결과가 나오면 안된다.
		-- 그때는 in 키워드를 사용한다.
select r_name, r_place from RESTAURANT where r_no in (
	select m_place from MENU where m_price = (
		select min(m_price) from menu
	)
);

-- 동대문에서 먹을 수 있는 음식의 이름과 가격
select m_name, m_price 
from menu 
where m_place in (
	select r_no 
	from RESTAURANT 
	where r_place = '동대문'
);

-- 곱창 시리즈는 어느 지역에 가면 먹을 수 있나요?
select r_place, r_name 
from RESTAURANT
where r_no in (
	select m_place
	from menu
	where m_name like '%곱창%'
);

-- 제일 싼 커피를 파는 매장의 이름과 지역
select r_place, r_name
from restaurant
where r_no in (
	select m_place
	from menu 
	where m_price = (
		select min(m_price)
		from menu 
		where (m_name like '%라떼%' or m_name like '%카노%')
	)
);

----------------------------------------------------------------

-- JOIN : 서로 다른 테이블 연결하는 거 pk를 통해서

-- 두개 테이블 연결해서 출력하기
select m_name, m_price, r_name, r_place
from MENU, RESTAURANT
where m_place = r_no

-- 스타벅스 종로지점에서 판매하는 메뉴 이름과 가격
	-- 테이블 관계명시가 중요하다
-- 1번 방법
select r_name, r_place, m_name, m_price
from RESTAURANT, menu
where r_name = '스타벅스' and r_place = '종로' and r_no = m_place;

-- 2번 방법
select r_name, r_place, m_name, m_price
from RESTAURANT, MENU
where r_no = m_place and m_place = (
	select r_no
	from RESTAURANT
	where r_name = '스타벅스'
	and r_place = '종로'
);

-- 제일 젊은 사장님의 가게의 매장명, 위치, 사장님 이름, 생일, 메뉴명, 가격
select h_name, h_birth, r_name, r_place, m_name, m_price
from human, restaurant, menu, owner
where r_no = m_place 
	and h_no = o_ceo
	and o_restaurant = r_no
	and h_birth = (
		select max(h_birth)
		from human
		)

-- 최연장자 아저씨네 메뉴명, 메뉴 가격,

-- 1번 방법 ( RDB )
select h_name, m_name, m_price
from human, owner, RESTAURANT, menu
where r_no = m_place 
	and h_no = o_ceo
	and o_restaurant = r_no
	and h_birth = (
		select min(h_birth)
		from human
		);

-- 2번 방법 ( RDB )
select h_name, m_name, m_price
from human, OWNER, menu
where h_no = o_ceo
	and o_restaurant = m_place
	and h_birth = (
		select min(h_birth)
		from human
		)
		
-- 3번 방법 ( subQuery )
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

-- 4번 방법 ( subQuery )
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

-- 황소곱창 가게의 전체 메뉴명, 가격, 매장 위치
select m_name, m_price, r_place
from MENU, restaurant
where m_place = r_no
	and r_name = '황소곱창';
	
-- 제일 싼거 파는 매장명, 위치, 메뉴명, 가격
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
		
-- 돼지곱창 가격 인상 (13000원)
update menu 
set m_price = 13000 
where m_name = '돼지곱창';

-- 젤 싼 메뉴 무료 이벤트
update menu 
set m_price = 0 
where m_price = (
		select min(m_price)
		from menu
	);
		
-- 메뉴 전체의 평균보다 비싼 메뉴를 10% 할인
update menu
set m_price = m_price - (m_price/10)
where m_price > (
	select avg(m_price)
	from menu
	);
		
-- 동대문 지역 메뉴들 1000원 인상
update menu
set m_price = m_price + 1000
where m_place in (
	select r_no
	from restaurant
	where r_place = '동대문'
	);
		
-- 커피 중 '라떼' 종류의 가격 500원 인상
update menu
set m_price = m_price + 500
where m_name like '%라떼%';
		
select * from menu;

----------------------------------------------------

-- CR ( Update, Delete )

delete menu where m_name = '딸기스무디';

-- '라떼' 글자가 들어간 메뉴 다 삭제
delete menu 
where m_name like '%라떼%';

-- 강남 스벅 (메뉴 삭제)
delete menu
where m_place = (
	select r_no
	from restaurant
	where r_name = '스타벅스' and r_place = '강남'
	);

-- 강남 스벅 (폐점)
delete restaurant
where r_name = '스타벅스' and r_place = '강남';

-- '곱창' 들어간 매장의 메뉴 다 삭제
delete menu
where m_place in (
	select r_no
	from restaurant
	where r_name like '%곱창%'
	);

select * from menu;

select * from restaurant;

select m_name, r_name 
from menu, restaurant
where r_no = m_place
	and r_name like '%곱창%';


-------------------------------------------------드랍

drop sequence menu_seq;
drop sequence restaurant_seq;
drop sequence human_seq;
drop sequence owner_seq;

drop table menu cascade constraint purge;
drop table restaurant cascade constraint purge;
drop table human cascade constraint purge;
drop table owner cascade constraint purge;
