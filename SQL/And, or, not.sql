select * from employees;

alter table employees
add column job varchar(25)
after hourly_pay;

select * from employees;

insert into employees
values (6, "Sheldon", "Plankton", 10.00, "janitor", "2023-01-07");

update employees
set job = "janitor"
where employee_id = 6;

select * from employees;

select * 
from employees
where hire_date < "2023-01-05" AND job = "cook";

select * 
from employees
where job = "cook" OR job = "cashier";

select * 
from employees
where not job = "manager";

select * 
from employees
where not job = "manager" AND not job = "assist. manager";

select * 
from employees
where hire_date between "2023-01-04" and "2023-01-27";

select *
from employees
where job in ("cook", "cashier", "janitor")