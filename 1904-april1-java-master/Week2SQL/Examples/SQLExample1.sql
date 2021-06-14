--This is an SQL Developer comment!
/*
    This is an SQL Block Comment
*/

/*Sub Languages:
DDL
-CREATE
-ALTER
-DROP
-TRUNCATE
DML
-SELECT
-INSERT
-UPDATE
-DELETE
TCL
-COMMIT
-ROLLBACK
-SAVEPOINT
-SET_TRANSACTION
DCL
-GRANT
-REVOKE
DQL
-SELECT
*/

--DDL
--CASCADE CONSTRAINTS will drop any constraints that reference the table being dropped as well
--note that sql commands are case insensitive
DROP TABLE owners CASCADE CONSTRAINTS;
DROP TABLE polkamans CASCADE CONSTRAINTS;
DROP TABLE moves CASCADE CONSTRAINTS;
DROP TABLE types CASCADE CONSTRAINTS;
DROP TABLE polka_types_jt CASCADE CONSTRAINTS;
DROP TABLE polka_moves_jt CASCADE CONSTRAINTS;
DROP TABLE garbage CASCADE CONSTRAINTS;
DROP TABLE other_garbage CASCADE CONSTRAINTS;
DROP TABLE different_garbage CASCADE CONSTRAINTS;

CREATE TABLE owners (
	o_id NUMBER(6) PRIMARY KEY,
	o_name VARCHAR2(200),
	o_money NUMBER(9),
	o_username VARCHAR2(100) UNIQUE NOT NULL,
	o_password VARCHAR2(100) NOT NULL
);

CREATE TABLE polkamans (
  p_id NUMBER(6) PRIMARY KEY,
  p_name VARCHAR2(200),
  p_hp NUMBER(6),
  p_str NUMBER(6),
  p_owner_id NUMBER(6),
  --CONSTRAINT polkamans_pk PRIMARY KEY (p_id)
  --CONSTRAINT constraintName CONSTRAINT TYPE (column name)
  CONSTRAINT p_owner_id FOREIGN KEY (p_owner_id)
        REFERENCES owners(o_id)
);

CREATE TABLE types (
    t_id NUMBER(6) PRIMARY KEY,
    t_name VARCHAR2(50) UNIQUE
);

CREATE TABLE moves(
    m_id NUMBER(6) PRIMARY KEY,
    m_name VARCHAR2(50) UNIQUE,
    m_type_id NUMBER(6),
    CONSTRAINT moves_type_fk FOREIGN KEY (m_type_id)
            REFERENCES types(t_id)
);

CREATE TABLE polka_types_jt(
    p_id NUMBER(6),
    t_id NUMBER(6),
    CONSTRAINT polkatypes_p_id_fk FOREIGN KEY (p_id)
            REFERENCES polkamans(p_id),
    CONSTRAINT polkatypes_t_id_fk FOREIGN KEY (t_id)
            REFERENCES types(t_id)    
);

CREATE TABLE polka_moves_jt(
    p_id NUMBER(6),
    m_id NUMBER(6),
    CONSTRAINT polkamoves_p_id_fk FOREIGN KEY (p_id)
            REFERENCES polkamans(p_id),
    CONSTRAINT polkamoves_m_id_fk FOREIGN KEY (m_id)
            REFERENCES moves(m_id)    
);

--DML
--there are two main ways you can go about inserting data
--ther first is to specify which columns you are adding to, then the values:
INSERT INTO owners(o_id, o_name, o_money, o_username, o_password)
VALUES (1, 'O''Conner',  200, 'conner123', 'password'); --for stirngs, use SINGLE QUOTES: 'string'
-- note that using two single quotes will allow you to add a single quote in a string
INSERT INTO owners
VALUES (2, 'ASHE', 201, 'username', 'password');
INSERT INTO owners
VALUES (3, 'Senor Money Bags', 999, 'username2', 'password');
--Note that if you omit the column names portion of an insert statement, it will
--implicitly assume you are providing data for each column in the order that 
--they appear in the table

INSERT INTO types VALUES (1, 'punching');
INSERT INTO types VALUES (2, 'rain');
INSERT INTO types VALUES (3, 'bird');
INSERT INTO types VALUES (4, 'oracleSQL EXCEPTION');
INSERT INTO types VALUES (5, 'tree');
INSERT INTO types VALUES (6, 'round');


INSERT INTO moves VALUES (1, 'throw throw', 4);
INSERT INTO moves VALUES (2, 'roll', 6);
INSERT INTO moves VALUES (3, 'normal punch', 1);
INSERT INTO moves VALUES (4, 'consecutive normal PUNCHES', 1);
INSERT INTO moves VALUES (5, 'falling with style', 3);
INSERT INTO moves VALUES (6, 'RAGE QUIT', 4);
INSERT INTO moves VALUES (7, 'timber', 5);
INSERT INTO moves VALUES (8, 'money fall', 2);
INSERT INTO moves VALUES (9, 'go away....', 2);


INSERT INTO polkamans VALUES (1,'firemander', 100, 200, 2);
INSERT INTO polkamans VALUES (2,'Blast-Turtle', 200, 100, 2);
INSERT INTO polkamans VALUES (3,'Thicccccachu', 10, 10, 1);
INSERT INTO polkamans VALUES (4,'RubbishTH', 50, 1, 3);
INSERT INTO polkamans VALUES (5,'log', 500, 0, 3);
INSERT INTO polkamans VALUES (6,'shoe...', 2, 2, 1);
INSERT INTO polkamans VALUES (7,'shootmonjordan', 100, 100, 1);

INSERT INTO polka_types_jt VALUES (1,4);
INSERT INTO polka_types_jt VALUES (1,1);
INSERT INTO polka_types_jt VALUES (2,2);
INSERT INTO polka_types_jt VALUES (3,2);
INSERT INTO polka_types_jt VALUES (4,2);
INSERT INTO polka_types_jt VALUES (5,5);
INSERT INTO polka_types_jt VALUES (6,3);
INSERT INTO polka_types_jt VALUES (7,1);

INSERT INTO polka_moves_jt VALUES(1,6);
INSERT INTO polka_moves_jt VALUES(1,4);
INSERT INTO polka_moves_jt VALUES(2,8);
INSERT INTO polka_moves_jt VALUES(2,9);
INSERT INTO polka_moves_jt VALUES(3,2);
INSERT INTO polka_moves_jt VALUES(4,9);
INSERT INTO polka_moves_jt VALUES(5,7);
INSERT INTO polka_moves_jt VALUES(6,5);
INSERT INTO polka_moves_jt VALUES(7,3);

--DQL
--Reads/Selects/Returns the contents of a table
--SELECT * FROM owners;
--SELECT * FROM types;
--SELECT * FROM moves;
--SELECT * FROM polkamans;
--SELECT * FROM polka_types_jt;
--SELECT * FROM polka_moves_jt;

--WHERE CLAUSE
/*
    Use a WHERE clause to apply any conditions to a CRUD operation
    
*/
--SELECT * FROM polkamans WHERE p_id <3; <= returns more specific subset of records
--SELECT p_name FROM polkamans; <= note that if you don't use *, only the columns you specify will be returned
--SELECT p_name FROM polkamans WHERE p_id <3; you can use them together!

--DELETE
--DELETE FROM polka_types_jt; WHERE p_id >6;

--UPDATE (used to change records that already exist)
--changes existing record(s) specified in WHERE clause to have value specified in SET clause
--UPDATE polka_types_jt
--SET t_id = 3 WHERE p_id=5;


--UPDATE owners
--SET o_password = 'hello'; WHERE o_id =1;

-- DDL AGAIN: ALTER
CREATE TABLE garbage(
    stuff NUMBER(9)
);


INSERT INTO garbage VALUES(1);
INSERT INTO garbage VALUES(2);
INSERT INTO garbage VALUES(-3);

ALTER TABLE garbage
RENAME TO other_garbage;
--ALTER TABLE other_garbage
--ADD CONSTRAINT check_con CHECK (stuff>0);
--If you try to add a constraint that attempts to exclude one of the values
--already in the table, you will get an error. Can't do that!

/*
    SQL DEVELOPER does NOT auto-commit data
    YOU MUST use commit to persist data
*/
INSERT INTO other_garbage VALUES (5);
SELECT * FROM other_garbage;
-- due to the fact that DML does not auto commit, if you do not explicitly
--commit, you will lose changes in the event of a rollback.
--NOTE: DDL WILL auto-commit
rollback;
SELECT * FROM other_garbage;

--PERSITING DATA USING COMMIT
INSERT INTO other_garbage VALUES (5);
commit;--Persists all data
rollback; -- note that in this case, 'rollback' does not remove any records
SELECT * FROM other_garbage;

/*
    Truncate vs Delete
    Truncate is DDL
    Delete is DML
    You CAN rollback DELETE
    You CANNOT rollback TRUNCATE
*/
DELETE FROM other_garbage;
SELECT * FROM other_garbage;
rollback;
SELECT * FROM other_garbage;
--you can rollback delete

TRUNCATE TABLE other_garbage;
ROLLBACK; --does not retrieve old data because truncate implicitly commits
SELECT * FROM other_garbage;