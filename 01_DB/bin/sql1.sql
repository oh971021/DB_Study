-- 주석

-- 여러 블록 지정 : Alt + X
-- 한줄 실행 : Alt + S (그 줄에 커서 놓고)

-- 테이블 생성
create table product (
	p_name varchar2(10 char),
	p_price number(4)
);

-- 데이터 삽입 : Create
insert into product values('볼펜', 1000);

-- 데이터 조회 : Read
select * from PRODUCT;

-------------------------------------------

-- 행, row,  행 하나가 데이터 1개. record라고 함.
-- 열, filed, 속성, colum

-- oracle 대/소문자 구분x 다 대문자

-- DBA : 서버 전원관리, 백업/복구, 계정관리 

-- DBP : CRUD (우리의 목표) (Create Read Update Delete)

-- SQL (Structured Query Language) : DB를 제어하는 언어

-- 문장끝에 세미클론(;)

--------------------------------------------

-- 1) 테이블 만들기
create table student (
	s_name varchar2(30 char),
	s_age number(3),
	s_kor number(3),
	s_eng number(3),
	s_jp number(3)
);

-- 2) 데이터 넣기
insert into student values('준석', 25, 99, 95, 100);

-- 2-1) 원하는 칼럼의 데이터 넣기
insert into student(s_name, s_age) values('솔리', 28);

-- 2-2) 칼럼 순서 섞어서 데이터 넣기 
insert into student(s_kor, s_jp, s_eng, s_age, s_name)
values (95, 85, 93, 25, '기훈');

-- 3) 조회
select * from student;

-- 쓰지않는건 Null로 기입 됨.
-- 필드 순서를 왜 바꾸는지, Null을 둬서 어쩔건지
-- 0점이면 0점이지 Null로 넣지마라. (계산식때 머리가 아프다)
---- 그래서 테이블을 만들때 옵션을 사용해서 Null을 없앤다.

-- 4) 데이터 삭제 
-- drop table student cascade constraint purge;

-------------------------------------------------------------------

create table student2 (
	s_no number(2) primary key, -- 같은 수를 넣을 수 없는 유니크한 제약조건을 건다 : primary key (테이블을 합칠때 이거로 자주 사용) 
	s_name varchar2(30 char) not null,
	s_age number(3) not null,
	s_kor number(3) not null,
	s_eng number(3) not null,
	s_jp number(3) not null
);

-- 옵션 --
-- not null : 사실상 기본, 필수인 옵션
-- primary key : not null + 중복 불가 - 주민번호와 같은 역할 (유니크한 제약조건)
	-- 그 테이블을 대표하는 값 (1table 1pk) 데이터 구분을 위한 고유번호 (identity)

insert into student2 values(1, '준석', 25, 100, 90, 80);
insert into student2 values(10, '솔리', 23, 90, 90, 90);
insert into student2 values(20, '솔리', 23, 100, 100, 90);
insert into student2 values(99, '기훈', 25, 90, 90, 90);

select * from student2;

drop table student2 cascade constraint purge;

-- drop table student2 -- 휴지통까지만 삭제 (찌꺼기가 남는다)
-- cascade constraint purge; -- 완전 삭제 (종속 되어있는 것들도 모두)

---------------------------------------------------------------------

-- 데이터 수정 : Update 
-- 10번 사람의 영어점수를 100점으로
update student2 set s_eng = 100 where s_no = 10;

select * from student2;

----------------------------------------------------------------------

-- 데이터 삭제 : Delete
-- 기훈이 삭제
delete student2 where s_name = '기훈';
delete student2 where s_no = 20;

-- student2 테이블의 학생 이름만
select s_name from student2;

-- student2 테이블의 이름, 나이, 영어점수만
select s_name, s_age, s_eng from student2;

-- 데이터 삽입, 조회, 수정, 삭제 (Create, Read, Update, Delete) --















