create table t_attend_details${postfix}(id bigint primary key,std_id bigint not null,
activity_id bigint not null,dev_id smallint,signin_at date,attend_type_id integer not null,
updated_at date ,operator varchar(80),remark varchar(40));

comment on table t_attend_details${postfix} is '${postfix}考勤明细表';
comment on column t_attend_details${postfix}.id is '非业务主键';
comment on column t_attend_details${postfix}.std_id is '学生ID';
comment on column t_attend_details${postfix}.activity_id is '考勤活动ID';
comment on column t_attend_details${postfix}.dev_id is '设备终端编号';
comment on column t_attend_details${postfix}.signin_at is '签到日期和时间';
comment on column t_attend_details${postfix}.attend_type_id is '出勤类型ID';
comment on column t_attend_details${postfix}.updated_at is '更新日期和时间';
comment on column t_attend_details${postfix}.operator is '操作人';
comment on column t_attend_details${postfix}.remark is '备注';

create index idx_attend_detail${postfix}_ac on t_attend_details${postfix}(activity_id);
create index idx_attend_detail${postfix}_std on t_attend_details${postfix}(std_id);