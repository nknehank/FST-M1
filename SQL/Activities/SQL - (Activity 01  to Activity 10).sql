REM   Script: Session 01 and Session 02 - (Activity 01  to Activity 10)
REM   Session 01 and Session 02 - (Activity 01  to Activity 10)

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

DESCRIBE salesman



Insert into salesman values(5001,'James Hoog','New York',15);

Insert into salesman values(5002,'Nail Knite','Paris',13);

Insert into salesman values(5005,'Pit Alex','London',11);

Insert into salesman values(5006,'McLyon','Paris',14);

Insert into salesman values(5007,'Paul Adam','Rome',13);' 
Insert into salesman values(5003,'Lauson Hen','San Jose',12);

Select * from salesman;



DESC salesman


CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

DESCRIBE salesman


Insert into salesman values(5001,'James Hoog','New York',15);

Insert into salesman values(5002,'Nail Knite','Paris',13);

Insert into salesman values(5005,'Pit Alex','London',11);

Insert into salesman values(5006,'McLyon','Paris',14);

Insert into salesman values(5007,'Paul Adam','Rome',13);' 
Insert into salesman values(5003,'Lauson Hen','San Jose',12);

Insert into salesman values(5007,'Paul Adam','Rome',13);

Select * from salesman;

Insert into salesman values(5003,'Lauson Hen','San Jose',12);

Select * from salesman;

Select selesman_id,salesman_city from salesman;

Select salesman_id,salesman_city from salesman;

Select * from salesman where say='salesman_city='Paris';

Select salesman_id from salesman where salesman_name='Paul Adam';

Select * from salesman where salesman_city='Paris';

Select * from salesman;

Select salesman_id, commission from salesman where salesman_name='Paul Adam';

Alter table salesman add column grade int ;

Select salesman_id,salesman_city from salesman;

Select * from salesman where salesman_city='Paris';

Select salesman_id, commission from salesman where salesman_name='Paul Adam';

Select * from salesman 
 
Alter table salesman add column (grade int) ;

Alter table salesman add column (grade int) ;

Alter table salesman add grade int;

Update salesman set grade=10;

Select * from salesman;

Update salesman set grade=200 where salesman_name='Rome';

Select * from salesman;

Update salesman set grade=200 where salesman_city='Rome';

Update salesman set grade=300 where salesman_name='James Hong';

Select * from salesman;

Update salesman set grade=300 where salesman_name='James Hoog';

Update salesman set salesman_name='Pierre' where salesman_name='McLyon';

Select * from salesman;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

Select Distinct salesman_id from salesman;

Select order_number from orders order by order_date ASC;

Select * from orders;

Select order_no from orders order by order_date ASC;

Select order_number from orders order by purchase_amount DESC;

Select order_no from orders order by purchase_amount DESC;

Select * from orders where purchase_amount<500;

Select * from orders where purchase_amount between 1000 and 2000;

Select sum(purchase_amount) as total_purchase_amount from orders;

Select avg(purchase_amount) as average_purchase_amount from orders;

Select sum(purchase_amount) as total_purchase_amount from orders;

Select max(purchase_amount) as max_purchase_amount from orders;

Select min(purchase_amount) as min_purchase_amount from orders;

Select count(salesman_id) as headcount from salesman;

Select count(distinct salesman_id) as headcount from orders;

Select max(purchase_amount) as highest_purchase_amount order by customer_id,highest_purchase_amount;

Select max(purchase_amount) as highest_purchase_amount from orders order by customer_id,highest_purchase_amount;

Select max(purchase_amount),customer_id as highest_purchase_amount from orders order by customer_id,highest_purchase_amount;

Select max(purchase_amount),customer_id as highest_purchase_amount from orders group by customer_id;

Select max(purchase_amount) as highest_purchase,customer_id from orders group by customer_id;

SELECT salesman_id, order_date, MAX(purchase_amount) AS "highest_purchase" FROM orders  
WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

SELECT salesman_id, order_date, MAX(purchase_amount) AS "highest_purchase" FROM orders group by customer_id,order_date having MAX(purchase_amount) IN (2030, 3450, 5760, 6000);

SELECT salesman_id, order_date, MAX(purchase_amount) AS "highest_purchase" FROM orders group by salesman_id,order_date having MAX(purchase_amount) IN (2030, 3450, 5760, 6000);

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

SELECT a.customer_name AS "Customer Name", a.city, b.salesman_name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

SELECT a.customer_name AS "Customer Name", b.salesman_name AS "Salesman" FROM customers  a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

SELECT A.customer_name AS "Customer Name", B.salesman_name AS "Salesman" FROM customers  A  
INNER JOIN salesman B ON A.salesman_id=B.salesman_id;

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.name AS "Salesman", c.commission FROM orders a  
INNER JOIN customers b ON a.customer_id=b.customer_id  
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.salesman_name AS "Salesman", c.commission FROM orders a  
INNER JOIN customers b ON a.customer_id=b.customer_id  
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;

SELECT a.customer_name AS "Customer Name", a.city, b.salesman_name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id  
WHERE b.commission>12;

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007;

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM orders 
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE city='New York');

SELECT * FROM orders 
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE salesman_city='New York');

SELECT grade, COUNT(*) FROM customers 
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

SELECT order_no, purchase_amount, order_date, salesman_id FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));

