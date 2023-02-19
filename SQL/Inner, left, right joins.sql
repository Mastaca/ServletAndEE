insert into transactions (amount, transaction_id)
values (1.00, null);
select * from transactions;

insert into customers (first_name, last_name)
values ("Poppy", "Puff");
select * from customers;

-- INNER JOIN
select transaction_id, amount, first_name, last_name
from transactions
inner join customers
	on transactions.customer_id = customers.customer_id;
    
-- LEFT JOIN
select *
from transactions
left join customers
	on transactions.customer_id = customers.customer_id;
    
-- right JOIN
select *
from transactions
right join customers
	on transactions.customer_id = customers.customer_id;