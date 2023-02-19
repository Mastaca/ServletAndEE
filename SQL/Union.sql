create table income(
income_name varchar(50),
amount decimal(10,2)
);
insert into income (income_name, amount)
values 
	("orders", 1000000.00),
    ("merchandise", 50000.00),
    ("services", 125000.00);
    
create table expenses(
expense_name varchar(50),
amount decimal(10,2)
);
insert into expenses (expense_name, amount)
values 
	("wages", -250000.00),
    ("tax", -50000.00),
    ("repairs", -15000.00);

select * from income
union
select * from expenses;

drop table income;
drop table expenses;

-- when tables have different number of columns
select first_name, last_name from employees
union
select first_name, last_name from customers;

-- UNION ALL allows duplicates
insert into customers (first_name, last_name)
values ("Sheldon", "Plankton");
select * from customers;
select first_name, last_name from employees
union all
select first_name, last_name from customers;
delete from customers
where customer_id = 8;
select * from customers;