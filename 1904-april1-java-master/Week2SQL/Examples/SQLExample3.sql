/*
    Oracle has an extention called PL/SQL. (Procedural language/ Structural
    Query Language)
    -It provides tools that we can use with SQL
    -Such as: functions, stored procedures, sequences, and triggers.
    -Also provides a way to handle exceptions
    -In other words, it provides a means to write actual code in SQL.
    -more reminiscent of programming-type language
*/

--SEQUENCE
/*
    A sequence is an object that will maintain a counter for you
*/
DROP SEQUENCE emp_seq;
CREATE SEQUENCE emp_seq
    start with 150
    increment by 1;
    --This sequence will be used to handle the id field for employees
    --In order to actually utilize it, we will need to build something that
    --reacts to situations where an employee is inserted. So... a TRIGGER
/
--TRIGGERS
/*
    A trigger is an object that we can create that waits for actions to occur
    on a specific table that the trigger was made for.
    A trigger can be coded to react to most CRUD operations. (SO NOT SELECT)
*/

--A TRIGGER can react via 'BEFORE' or 'AFTER' something
CREATE OR REPLACE TRIGGER emp_seq_trigger--this will be used to auto increment
--the primary key
BEFORE INSERT ON employees
FOR EACH ROW
BEGIN -- this keyword signfies a block for a transaction
    IF :new.e_id is null THEN
    SELECT emp_seq.nextval INTO :new.e_id from dual;
    END IF;
END;
/

--STORED PROCEDURES
/*
    note that in this descitption anything in [] are optional
    
    A named transaction that can be invoked when called
    SYNTAX:
    
    CREATE [OR REPLACE] proc_name
    IS
        This section is where you can DECLARE variables
    BEGIN
        This section is hwere you can write the execution, or utilize other
        transactions
    [EXCEPTION]
        Perform exception handling here
    END;
    
    You can invoke a stored procedure in two ways:
    BEGIN
        proc_name();
    END
    
    ----or
    
    call proc_name();
*/

CREATE OR REPLACE PROCEDURE hello_world_procedure
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello World!'); -- this is the SQL DEVELOPER equivalent
--    to SYSO in Java
END;
/

BEGIN
    hello_world_procedure();
END;
/
/*
    In order to access the dbms_output console, go to VIEW > DBMS_OUTPUT
    -This brings up the dbms_outpu window where you will click the '+' icon.
    -Select the schema you are currently using and it will open a console
    connection to it. Here, you can see the console output
*/

--Procedures can allow us to define exectutions (transactions) that can change
--data. Most actions can be taken against a table using procudures

/*
    Things of note:
        Parameters in stored procedures are a bit unique
        You have the following keywords to use with parameters:
            -IN
            -OUT
            -IN OUT
        IN parameters: whatever is passed as input during the procedure call
        OUT parameters: whever is returned from the procedure
        IN OUT parameters: a variable that is used as input then transformed
        as output
*/
--SYNTAX
-- varname IN/OUT/IN OUT DATATYPE

CREATE OR REPLACE PROCEDURE insertIntoEmployee(empName IN varchar2, 
empSal IN NUMBER, empTitle varchar2)
IS
BEGIN
    INSERT INTO employees (e_name,e_salary, e_title)
    VALUES(empName, empSal, empTitle);
    commit;
END;
/

call insertinToEmployee('Sal', 99999, 'Make Money');
select * from employees;
/

CREATE OR REPLACE PROCEDURE get_name(
emp_id IN NUMBER, emp_name OUT VARCHAR2)
IS
BEGIN
    select e_name into emp_name from employees where e_id =emp_id;
END;
/

--Calling the procedure in SQL
DECLARE -- note you must provide datatype sizes in the declaration block
    input number(6); --creates a variable of type number with 6 bytes
    result varchar2(200); --creates a variable of type varchar2 with 200 bytes
BEGIN
    input := 170; -- sets the variable input equal to 5
    get_name(input,result);
    DBMS_OUTPUT.PUT_LINE(result);
END;
/

/*
    CURSORS
    -A cursor is essentially like a pointer (in more traditional programming
    languages). It points to a table or a view
    -We can use them to iterate through entire queries from the database
    -When we want to pass entire tables or queries, we need to use cursors
    
    NOTE: PL/SQL offers a CURSOR and a SYS_REFCURSOR
    The SYS_REFCURSOR is a stronger cursor (therefore more costly) that is
    allowed to be passed outside of the scope of the procedure it is in. A
    normal CURSOR must be created and die within the scope of the procedure
    that it was created in
*/
CREATE OR REPLACE PROCEDURE get_all_employees(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursorParam FOR --note that cursors is like a stream, you OPEN
    --it for some query
    SELECT * FROM employees;
END;
/
DECLARE
    my_cursor SYS_REFCURSOR;
    emp_id employees.e_id%TYPE; --Make the datatype match THAT of the 
--    employees.column's datatypes
    emp_name employees.e_name%TYPE;
    emp_sal employees.e_salary%TYPE;
    emp_title employees.e_title%TYPE;
BEGIN
    get_all_employees(my_cursor); -- have our cursor represent the cursor for
--    employees
    LOOP
        FETCH my_cursor INTO emp_id, emp_name, emp_sal, emp_title;
        EXIT WHEN my_cursor%NOTFOUND; --NOTFOUND does not exist until there are
        --no records left
        DBMS_OUTPUT.PUT_LINE(emp_id || ' ' || emp_name || ' ' || emp_sal || ' '
        || emp_title);
    END LOOP;
END;

/*
    These were examples of EXPLICIT CURSORS where we manually defined a cursor
    and fetched and iterated through it.
    IMPLICIT CURSOR are created in the event of any DQL perfomred by a user on
    the database. We get access to the entire table's contents without having
    to create a cursor ourselves.
*/
--USER-DEFINED FUNCTIONS
/*
    functions =/= stored procedures
    KEY DIFFERENCES:
    STORED PROCEDURES
        -does not have to return anything
        -CAN have as many IN/OUT parameters it wants
        -can alter the database using most DML statements
        -can NOT be called mid query.
        -can call other stored procedures with it
        -can call funcitons
        
    FUNCTIONS
        -MUST return ONE and only ONE resource
        -CAN use OUT parameters, but it is highly frowned upon.
        -can NOT perform DML
        -can be called mid query
        -can call other funcitons
*/

CREATE OR REPLACE FUNCTION get_max_id -- if no paramters, then no ()
RETURN NUMBER
IS
    max_id number(6);
BEGIN
    SELECT max(e_id) into max_id FROM employees;
    RETURN max_id;
END;
/
DECLARE
    max_id number;
BEGIN
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('Max employee id: ' || max_id);
END;

--EXCEPTION HANDLE
CREATE OR REPLACE PROCEDURE exceptionExample
IS
    CURSOR badCURSE is
        select * from employees;
    emp_id number(6);
    emp_name varchar2(200);
    emp_salary number(6);
    emp_title varchar2(200);
BEGIN
    emp_id := 1/0; -- causes division by zero exception
    --fail to OPEN badCurse
    LOOP
        FETCH badCURSE into emp_id, emp_name, emp_salary, emp_title;
        EXIT WHEN badCURSE%NOTFOUND;
    END LOOP;
    CLOSE badCURSE;
    
    EXCEPTION
        WHEN invalid_cursor THEN
            dbms_output.put_line('CURSOR ERROR');
        WHEN zero_divide THEN
            dbms_output.put_line('Division by 0');
END;
/
BEGIN
    exceptionexample();
END;
/

--INDICES
/*
    In Oracle SQL your tables typically have an index.
    Indices come in two flavors: Clustered INDICES and UNCLUSTERED INDICIES.
    The point of any index is to speed up data retrieval. However this comes
    at the cost of slowing down data inserting/removing. So if you have a large
    table (2,000,000+ records) that is frequently accessed, consider indeces.
    Otherwise they are not needed. It is slowere becasue with every insert or
    removal your database needs to reindex the table
    
    An exception to this is CLUSTERED INDICES. a clustered index is one that can
    use the actaual values of the table to identify each record. It uses the
    actual data, instead of some index in the backend. In ohter words, an
    index is implicitly created any time your table has a primary or unique key
*/

CREATE TABLE indexTable (
    nums number(6)
);
/

INSERT INTO indexTable VALUES(1);
INSERT INTO indexTable VALUES(2);
INSERT INTO indexTable VALUES(3);
INSERT INTO indexTable VALUES(4);
INSERT INTO indexTable VALUES(5);
INSERT INTO indexTable VALUES(6);
INSERT INTO indexTable VALUES(7);
INSERT INTO indexTable VALUES(8);
INSERT INTO indexTable VALUES(9);
select * from indexTable;

INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);
INSERT INTO indexTable (select * from indexTable);

drop index numsindex;
create index numsindex on indexTable(nums);
delete from indexTable;
truncate table indexTable;

--IN and EXISTS
CREATE table C(
    c_num number(6) primary key
);
CREATE table B(
    b_num number(6) primary key,
    b_c_num number(6),
    CONSTRAINT b_c_fk FOREIGN KEY (b_c_num) REFERENCES c(c_num)
);
CREATE table A(
    a_num number(6) primary key,
    a_b_num number(6),
    CONSTRAINT a_b_fk FOREIGN KEY (a_b_num) REFERENCES b(b_num)
);

INSERT INTO C VALUES(1);
INSERT INTO C VALUES(2);
INSERT INTO C VALUES(3);
INSERT INTO C VALUES(4);
INSERT INTO C VALUES(5);
INSERT INTO C VALUES(6);
select * from C;

INSERT INTO B VALUES(3,3);
INSERT INTO B VALUES(4,4);
INSERT INTO B VALUES(5,5);
INSERT INTO B VALUES(6,6);
select * from B;

INSERT INTO A VALUES(3,3);
INSERT INTO A VALUES(4,4);
select * from A;

/*
    IN
    -The IN clause is used to confirm that a value is inside a column.
    -Sort of works like a comma-separated OR statement
*/

select * from C where c_num in(1,2,3);
--HOWEVER, the IN clause is very powerful in that it lets us utilize
--nested select statements
select * from C;
select b_num from B;
select * from C where c_num in(select b_num from B);
select * from C where c_num in(select b_num from B where b_num in
(select a_num from A));

/*
    Exists works like In, except as opposed to seeing if a specific value
    is in a collection like IN does, EXISTS only aims to succeed if at least
    one record is returned to it    
*/
select * from C where exists(select b_num from B where b_num =7);
-- the contents of the parenthesis is evaluated as true or false, and will return
-- the outer query if it is true

/*
    EXISTS vs IN
    The EXISTS keyword evaluates ture or false, but the IN keyword will compare
    all values in the corresponding subquery column. If you are using the IN
    operator, the SQL engine will scan all records fetched from the inner query.
    On the other hand, if we are using EXISTS, the SQL engine will stop the
    scanning process as soon as it found a match
    
    The EXISTS subquery is used when we want to display all rows where we have
    a matching column in both tables.
    
    Note that they have different performance levels depending on the situation.
    The EXISTS clause is much faster than the IN when the subquery results is
    very large. Conversely, the IN clause is faster than EXISTS when the subquery
    is very small.
    
    ALSO, the IN clause can't compare anything with NULL values, but the EXISTS
    clause can compare everything with null values.
*/