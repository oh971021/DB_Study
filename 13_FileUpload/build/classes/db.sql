create table fileup (
	fileName varchar2(200 char),
	fileRealName varchar2(200 char),
	downloadCount number(11)
);



select * from fileup;

drop table fileup cascade constraint purge;