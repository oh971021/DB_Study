create table snack(
	s_no number(3) primary key, 
	s_name varchar2(20 char) not null,
	s_maker varchar2(20 char) not null,
	s_weight number(4,1) not null, -- 전체 4자릿수의 소수점 1자리의 실수 생성
	s_price number(4) not null,
	s_exp date not null -- 날짜 관련 된 자료형
);

" 
## date 자료형에 넣는 값 ##
	1. sysdate : 현재시각
	2. 	to_date('값', '패턴')
			YYYY MM DD HH : MI : SS
"

insert into SNACK values (1, '양파링', '농심', 60, 1000, sysdate);
insert into SNACK values (50, '꽃게랑', '해태', 70, 1200, sysdate);

select * from snack;

drop table snack cascade constraint purge;

insert into SNACK values (3, '꼬깔콘', '롯데', 70.5, 1300,
						to_date('2020-12-25', 'YYYY-MM-DD')); -- to_date 는 내가 원하는 값과 형식을 적어 줘야한다.
						
select * from snack;