select * from transactions;

select count(amount) as "today's transactions"
from transactions;

select max(amount) as maximum
from transactions;

select min(amount) as minimum
from transactions;

select avg(amount) as average
from transactions;

select sum(amount) as sum
from transactions;

select concat(first_name, " ", last_name) as full_name from employees;
select * from employees;

