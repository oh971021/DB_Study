create table BMI (
	b_no number (2) primary key,
	b_name varchar2 (20 char) not null,
	b_weight number (5, 2) not null,
	b_height number (5, 2) not null,
	b_bmi number (4, 2) not null,
	b_result varchar2 (20 char) not null
);

-- create sequence bmi_seq;
create sequence bmi_seq increment by 1 start with 1;

select * from bmi;

-- alter sequence message_id_seq nocache;

drop table bmi cascade constraint purge;
drop sequence bmi_seq;