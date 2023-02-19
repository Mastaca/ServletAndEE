create table customers (
	customer_id int primary key auto_increment,
    first_name varchar(50),
    last_name varchar(50)
);

insert into customers (first_name, last_name)
values 	("Fred", "Fish"), 
		("Larry", "Lobster"), 
		("Bubble", "Bass"), 
		("Amy", "Shoe");

select *
from customers;
-- 

drop table transactions;

-- create table with foreign key
create table transactions (
	transaction_id int primary key auto_increment,
    amount decimal(5, 2),
    customer_id int,
    foreign key(customer_id) references customers(customer_id)
);

-- removing foreign key
alter table transactions
drop foreign key transactions_ibfk_1;

-- add foreign key for existing tables
alter table transactions
add constraint fk_customer_id 		-- add constraint is optional
foreign key(customer_id) references customers(customer_id);

delete from transactions;

select *
from transactions;

alter table transactions
auto_increment = 1000;

insert into transactions (amount, customer_id)
value	(4.99, 3),
		(2.89, 2),
        (3.38, 3),
        (4.99, 1);
        
delete from customers where customer_id = 3; -- fails because of foreign key