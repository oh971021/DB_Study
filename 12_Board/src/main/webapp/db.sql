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