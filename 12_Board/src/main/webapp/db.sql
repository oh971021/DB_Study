create table movie_test (
	m_no number(3) primary key,
	m_title	varchar2(30 char) not null,
	m_actor	varchar2(30 char) not null,
	m_img varchar2(200 char) not null,
	m_story varchar2(100 char) not null
);

create sequence movie_test_seq;

insert into movie_test values (movie_test_seq.nextval, '����', '���', '����', '�ٰŸ�');
insert into movie_test values (movie_test_seq.nextval, '����2', '���2', '����2', '�ٰŸ�2');

select * from movie_test;

delete from MOVIE_TEST where m_no = '28';