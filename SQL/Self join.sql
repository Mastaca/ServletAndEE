alter table customers
add referral_id int;
select * from customers;


update customers
set referral_id = 2
where customer_id = 4;
select * from customers;

select a.customer_id, a.first_name, a.last_name,
	concat (b.first_name, " ", b.last_name) as "referred by"
from customers as a
left join customers as b
	on a.referral_id = b.customer_id;

-- 

alter table employees
add supervisor_id INT;
update employees
set supervisor_id = 1 
where employee_id = 5;
select * from employees;

select a.first_name, a.last_name,
concat(b.first_name, " ", b.last_name) as "reports to"
from employees as a
left join employees b
on a.supervisor_id = b.employee_id;
