do
$$
begin
if not exists (select * from information_schema.columns
               where table_schema='public'
               and table_name='cat'
               and column_name='sex')
then
  raise notice 'creating column cat.sex';
  alter table cat
    add column sex varchar(16);
else
  raise notice 'column cat.sex already exists';
end if;
end;
$$
