use mydb;

create table transactions (
	transaction_id int primary key,
    amount decimal(5, 2)    
);

alter table transactions
add constraint
primary key(transaction_id);

insert into transactions
value(1003, 4.99);

select amount
from transactions
where transaction_id = 1003;

drop table transactions;

create table transactions (
	transaction_id int primary key auto_increment,
    amount decimal(5, 2)    
);

insert into transactions(amount)
values (4.99);

alter table transactions
auto_increment = 1000;

delete from transactions;

select *
from transactions;
