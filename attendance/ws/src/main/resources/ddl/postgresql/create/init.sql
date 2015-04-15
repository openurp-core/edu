create sequence seq_t_attend_details;

create sequence seq_t_attend_activities;

create table t_attend_inits(day varchar(8) primary key,activity_count integer,detail_count integer,updated_at timestamp);

CREATE OR REPLACE FUNCTION to_minutes(integer)
  RETURNS integer AS
$BODY$
DECLARE
timeStr varchar(4);
BEGIN
  timeStr := lpad(CAST($1 as varchar),4,'0');
  RETURN substr(timeStr,1,2)::integer *60+substr(timeStr,3)::integer;
END;
$BODY$
  LANGUAGE plpgsql ;
  
  
create or replace 
FUNCTION to_coursetime(integer) returns smallint as 
$BODY$
DECLARE
BEGIN
  return cast(floor($1/60)::varchar||lpad(($1%60)::varchar,2,'0') as smallint);
END;
$BODY$
  LANGUAGE plpgsql