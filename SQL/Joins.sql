use sql_store;

select order_id, o.customer_id, first_name, last_name 
from orders o
inner join customers c
	on o.customer_id = c.customer_id;
-- join order_items with products so thet product_id, name and quantity and unit price from the order_items
select order_id, oi.product_id, p.name, quantity, oi.unit_price
from order_items oi
join products p
	on oi.product_id = p.product_id;
-- join across databases
select *
from sql_store.order_items oi
join sql_inventory.products p
	on oi.product_id = p.product_id;
-- self join
select 
	e.employee_id,
    e.first_name,
    m.first_name as manager_name
from sql_hr.employees e
join sql_hr.employees m
	on e.reports_to = m.employee_id;
-- joining multiple tables
select 
	o.order_id,
    o.order_date,
    c.first_name,
    c.last_name,
    os.name AS status
from orders o
join customers c
	on o.customer_id = c.customer_id
join order_statuses os
	on o.status = os.order_status_id;
-- report that shows the payments, name of the client, payment method
select 
	p.date, 
    p.invoice_id, 
    p.amount, 
    c.name, 
    pm.name
from sql_invoicing.payments p
join sql_invoicing.clients c
	on p.client_id = c.client_id
join sql_invoicing.payment_methods pm
	on p.payment_id = pm.payment_method_id
-- WHERE pm.payment_method_id = 1;