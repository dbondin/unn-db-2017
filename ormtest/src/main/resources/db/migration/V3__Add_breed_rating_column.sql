do
$$
begin
if not exists (select * from information_schema.columns
               where table_schema='public'
               and table_name='breed'
               and column_name='rating')
then
  raise notice 'creating column breed.rating';
  alter table breed
    add column rating integer not null default 0;
else
  raise notice 'column breed.rating already exists';
end if;
end;
$$