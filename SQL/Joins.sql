use sql_store;

select order_id, o.customer_id, first_name, last_name 
from orders o
inner join customers c
	on o.customer_id = c.customer_id;
-- join order_items with products so thet product_id, name and quantity and unit price from the order_items
select oi.product_id, p.name, quantity, p.unit_price
from order_items oi
join products p
	on oi.product_id = p.product_id;