select * from employees;

create view employee_attendance as
select first_name, last_name
from employees;

select * from employee_attendance
order by last_name asc;

drop view employee_attendance;

select * from customers;
alter table customers
add column email varchar(50);

update customers
set email = "PPuff@gmail.com"
where customer_id = 4;
select * from customers;

insert into customers
values (5, "Pearl", "krabs", null, "PKrabs@gmai
l.com");

create view customer_emails as
select email
from customers;

select * from customer_emails;