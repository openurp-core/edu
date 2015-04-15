create table t_attend_activities${postfix} (id bigint, semester_id bigint not null,lesson_id bigint not null,
course_id integer not null,course_date date,attend_begin_time smallint not null,begin_time smallint not null,end_time smallint not null,
room_id integer not null,course_hours smallint not null);

comment on table t_attend_activities${postfix} is '考勤活动表';
comment on column t_attend_activities${postfix}.id is '非业务主键';
comment on column t_attend_activities${postfix}.semester_id is '学期ID';
comment on column t_attend_activities${postfix}.lesson_id is '考勤教学任务ID';
comment on column t_attend_activities${postfix}.course_id is '课程ID';
comment on column t_attend_activities${postfix}.course_date is '上课日期';
comment on column t_attend_activities${postfix}.attend_begin_time is '考勤开始时间';
comment on column t_attend_activities${postfix}.begin_time is '上课开始时间';
comment on column t_attend_activities${postfix}.end_time is '上课结束时间';
comment on column t_attend_activities${postfix}.room_id is '教室ID';
comment on column t_attend_activities${postfix}.course_hours is '课时';

create index idx_attend_acti_room${postfix} on t_attend_activities${postfix}(room_id);
create index idx_attend_acti_lesson${postfix} on t_attend_activities${postfix}(lesson_id);
create index idx_attend_acti_date${postfix} on t_attend_activities${postfix}(course_date);
create index idx_attend_acti_date_room${postfix} on t_attend_activities${postfix}(course_date,room_id);
