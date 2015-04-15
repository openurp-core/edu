create sequence seq_t_attend_details;

create sequence seq_t_attend_activities;

create table t_attend_inits(day varchar2(8) primary key,activity_count number(10),detail_count number(10),updated_at date);