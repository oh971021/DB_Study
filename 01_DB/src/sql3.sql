create table snack(
	s_no number(3) primary key, 
	s_name varchar2(20 char) not null,
	s_maker varchar2(20 char) not null,
	s_weight number(4,1) not null, -- 전체 4자릿수의 소수점 1자리의 실수 생성
	s_price number(4) not null,
	s_exp date not null -- 날짜 관련 된 자료형
);

" 
	숫자 자동으로 올리기 : sequence - 오라클 기능 ( 테이블과 무관 )
		사용법1 :	create sequence 시퀀스명;
			이름 지정 : table명_seq

		사용법2 : 시퀀스명.nextval 
"

create sequence snack_seq;

insert into snack values (snack_seq.nextval, '양파링', '농심', 60, 1000, sysdate);
insert into snack values (snack_seq.nextval, '꽃게랑', '롯데', 50, 1100, sysdate);

insert into snack values (2, '양파링', '농심', 60, 1000, sysdate);

insert into snack values (snack_seq.nextval, '다이제', '오리온', 50, 1300, sysdate);
insert into snack values (snack_seq.nextval, '고래밥', '해태', 50, 1600, sysdate);

select * from snack;

drop table snack cascade constraint purge;
