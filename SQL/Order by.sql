select * from employees
order by last_name;

select * from employees
order by last_name asc; -- ascending is the default, si it's not necessary to write it out

select * from employees
order by last_name desc;

select * 
from transactions
order by amount, customer_id;

select * 
from transactions
order by amount desc, customer_id asc;