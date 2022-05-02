create table movie_test (
	m_no number(3) primary key,
	m_title	varchar2(30 char) not null,
	m_actor	varchar2(30 char) not null,
	m_img varchar2(200 char) not null,
	m_story varchar2(100 char) not null
);

create sequence movie_test_seq;

insert into movie_test values (movie_test_seq.nextval, '제목', '배우', '사진', '줄거리');
insert into movie_test values (movie_test_seq.nextval, '제목2', '배우2', '사진2', '줄거리2');

select * from movie_test;

delete from MOVIE_TEST where m_no = '28';

create table review_test(
	r_no number(3) primary key,
	r_title varchar2(50 char) not null,
	r_txt varchar2(200 char) not null,
	r_date date not null
);

create sequence review_test_seq increment by 1;

insert into review_test values(review_test_seq.nextval, '제목', '내용', sysdate);
insert into review_test values(review_test_seq.nextval, '제목2', '내용2', sysdate);

select * from review_test;

delete from review_test where r_no = '5';

drop sequence review_test_seq;
