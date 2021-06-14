DROP TABLE employees cascade constraints;
CREATE TABLE employees(
    e_id number(6) primary key,
    e_name varchar2(100),
    e_salary number(9),
    e_title varchar2(100)
);

INSERT INTO EMPLOYEES
VALUES(1, 'William', 0, 'TRAINER');
INSERT INTO EMPLOYEES
VALUES(2, 'Will', 1, 'SALES');
INSERT INTO EMPLOYEES
VALUES(3, 'ASHE', 40000, 'TRAINER');
INSERT INTO EMPLOYEES
VALUES(4, 'Trevor', 12000, 'MARKETER');
INSERT INTO EMPLOYEES
VALUES(5, 'Tom', 1000, 'SALES');
INSERT INTO EMPLOYEES
VALUES(6, 'Tim', 1000, 'SALES');
INSERT INTO EMPLOYEES
VALUES(7, 'Jerry', 1000, 'SALES');
INSERT INTO EMPLOYEES
VALUES(8, 'Spike', 1000, 'MARKETING');
INSERT INTO EMPLOYEES
VALUES(9, 'Tyke', 1000, 'MARKETING');
INSERT INTO EMPLOYEES
VALUES(10, 'Edd', 10000, 'TRAINER');

select * from employees;

/*
    AGGREGATE FUNCTIONS
    -An aggregate funciton is a function you apply to a column that will
    process all the data and return a single value back. Examples are:
    SUM()
    AVG()
    MAX()
    MIN()
    STDDEV()
    VARIANCE()
    COUNT() <- we use this one a lot
    LAST()
    FIRST()
*/

SELECT count(*) from employees;

--you can use the keyword 'AS' to rename a column for a query
--you must use quotation marks (double quotes)
SELECT count(*) AS "Number of Employees" from employees;

--In order to show multiple columns of data along side an aggregate funciton,
--we need to tell how we are going to actually group non-matching data
SELECT sum(e_salary), e_title from employees
group by e_title
order by sum(e_salary);--note that this is ascending by default
-- if we want to sort descending, use order by sum(e_salary) desc.

/*
    You must use GROUP BY to signify which column you want to group your data by
    with aggregate funct
*/

/*
    SCALAR FUNCTIONS
    - a scalar function is a function that applies to each cell of a column
    - so it will return one value per record that is affected
    - note that this is different from aggregate funcitons, which only return
    one value per SET of records
    -many string manipulation methods will fall under this category, but
    do not confuse this as what sets the two types of functions appart
    -examples of scalar functions:
    lower() <--change the casing of a string to lowercase
    upper() <--change the casing of a string to uppercase
    ABS() <-- absolute value of a number
    cos,sin,tan() <-- trig function
    ROUND() <-- rounds to nearest whole number
    CONCAT()
    LENGTH()
    TRIM() <-- gets rid of whitespace
    LTRIM() <-- trims on left side
    RTRIM() <-- trims on right side
*/
select e_name, e_title from employees;
select upper(e_name), lower(e_title) from employees;

/*
    HAVING
    -Having is a conditional that can be applied to aggregate data
*/
select sum(e_salary), lower(e_title) from employees
where e_salary < 10000
group by e_title
having sum(e_salary) > 0
order by e_title;

/*
    LIKE
    -we use the LIKE clause to serch for data that matches a sort of regular
    expression criteria
    there are two wildcards you can use:
    _ - ONE of any character
    % - 0 to many of any character
*/
SELECT * from employees
WHERE lower(e_name) like 't%';
--the command above checks for records with a name that starts with t
SELECT * from employees
WHERE lower(e_name) like 't%m%';
--the command above returns all records that have a name with a t proceeded with
--an m
SELECT * from employees
WHERE lower(e_name) like 'w__l_%';
-- the command above returns all records that have a name starting with 'w'
-- followed by any two characters, followed by an 'l' followed by any one character
-- followed by anything or nothing

--JOINS
DROP TABLE TL CASCADE CONSTRAINTS;
DROP TABLE TR CASCADE CONSTRAINTS;
CREATE TABLE TL(
    l_id number(6),
    l_chars VARCHAR2(10)
);
CREATE TABLE TR(
    r_id number(6),
    r_chars VARCHAR2(10)
);

INSERT INTO TL VALUES(1,'a');
INSERT INTO TL VALUES(2,'b');
INSERT INTO TL VALUES(3,'c');
INSERT INTO TL VALUES(4,'d');

INSERT INTO TR VALUES(3,'C');
INSERT INTO TR VALUES(4,'D');
INSERT INTO TR VALUES(5,'E');
INSERT INTO TR VALUES(6,'F');
INSERT INTO TR VALUES(7,'G');

select * from TL;
select * from TR;

SELECT * FROM TL
inner join TR
on tl.l_id = tr.r_id;
--Inner join yeields 2 records
--TL has 4 records, TR has 5 records (they only have 2 in common)

SELECT * FROM TL
left join TR
on tl.l_id = tr.r_id;

SELECT * FROM TL
right join TR
on tl.l_id = tr.r_id;

SELECT * FROM TL
full outer join TR
on tl.l_id = tr.r_id;
--guaranteed every record in table is represented
-- you will get somewhere between 5-9 records since TR has more records than
--TL, you are guaranteed TR's number of records (at least). At most, you will
--have the sum of the two tables' amount of records.

SELECT * FROM TL
cross join TR
order by tl.l_id;
-- you can also do a cross join like so:
select * from TL,TR
order by tl.l_id;

--SELF JOINS
DROP TABLE emps CASCADE CONSTRAINTS;
CREATE TABLE emps(
    emp_id NUMBER(6) primary key,
    e_name VARCHAR2(100),
    super_id number(6),
    CONSTRAINT some_fk FOREIGN KEY (super_id)REFERENCES emps(emp_id)
);

INSERT INTO emps VALUES(1,'Jerimiah',null);
INSERT INTO emps VALUES(2,'Brandon',1);
INSERT INTO emps VALUES(3,'ARNOLD',2);
INSERT INTO emps VALUES(4,'UHHHHH',2);
INSERT INTO emps VALUES(5,'HELGA',2);

select * from emps;
/*
    this employee per supervisor count query would be an example of
    a good time to perform a self join, since we would need information
    pertaining to the supervisor's id's name
*/

select a.e_name, count(a.emp_id) from emps a
inner join emps b
on a.emp_id = b.super_id
group by a.e_name;

--SET OPERATIONS
-- set operatIONS are used to manipulate two result set, or the results of two
--select statements
--UNION is used to show both result sets in one result 
--(does not show duplicates)
select tl.l_id, lower(tl.l_chars) from TL
UNION
select tr.r_id, lower(tr.r_chars) from TR;
--UNION ALL does show duplicates
select tl.l_id, lower(tl.l_chars) from TL
UNION ALL
select tr.r_id, lower(tr.r_chars) from TR;
--INTERSECT will only return records that both queries will have in common
select tl.l_id, lower(tl.l_chars) from TL
INTERSECT
select tr.r_id, lower(tr.r_chars) from TR;
--MINUS will return records from the first query not present in the second query
select tl.l_id, lower(tl.l_chars) from TL
MINUS
select tr.r_id, lower(tr.r_chars) from TR;
--notice that a similar sresult can be obtained with a join
select tl.l_id, tl.l_chars from TL
left join TR
on tl.l_id = tr.r_id
where tr.r_id is null;

/*
    Sub-queries, in sql, you have the ability to nest queries inside of other
    queries.
    
    for example, the following will attempt to select the third highest
    salary from the employees table, using sub queries
*/

select * FROM
(select * from 
(select * from employees
order by e_salary desc, e_id desc)
where rownum != 4)
order by e_salary asc)
where rownum=1;

/*
    NOTE: ROWNUM stops retrieveing records as soon as it equals fals for just
    one record
*/

--BETWEEN
select * from employees where e_salary between 1 AND 10000;

/*
    views are virtual tables that can be created to ease the complexity of
    in depth queires. you can query a database and save the query's results
    in a virtual (or temporary table). This table can be reference or even used
    in other, more complex queries
*/
create view emp_salary as
select e_id, e_name, e_salary from employees;
select * from emp_salary; -- <-- this is a view
select * from employees; -- <-- this is a table

delete from emp_salary;
-- if you delete something from a view, this change is reflected in the
-- original table.