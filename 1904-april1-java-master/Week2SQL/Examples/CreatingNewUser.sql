CREATE USER user2 IDENTIFIED BY pass; --creates a new user with a specific password
GRANT CREATE SESSION TO user2; --we are allowing user to connect to db
GRANT UNLIMITED TABLESPACE TO user2; --granting unlimited space to the user
GRANT CREATE TABLE to user2; -- allows user to create tables