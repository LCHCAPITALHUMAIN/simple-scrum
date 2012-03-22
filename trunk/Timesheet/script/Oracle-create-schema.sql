prompt Creating user Timesheet

prompt Check existing connections on Timesheet
SELECT s.MACHINE, s.OSUSER, s.MODULE FROM V$SESSION s WHERE upper(USERNAME) IN (upper('Timesheet'));
WHENEVER SQLERROR EXIT SQL.SQLCODE
DECLARE
  I INTEGER;
BEGIN
  SELECT COUNT(*) INTO I FROM V$SESSION WHERE upper(USERNAME) IN (upper('Timesheet'));
  IF I > 0 THEN
     RAISE_APPLICATION_ERROR(-20101, '==> Please disconnect and Timesheet connections before continuing <==');
  END IF;   
END;
/
WHENEVER SQLERROR CONTINUE

prompt No connection Timesheet users.

prompt Dropping Timesheet user ...
-- Drop users
DECLARE
  I INTEGER;
BEGIN
	SELECT COUNT(*) INTO I FROM ALL_USERS WHERE USERNAME = 'Timesheet';
	IF I = 1 THEN
			-- Drop crds user
			EXECUTE IMMEDIATE 'DROP USER Timesheet CASCADE';
	END IF;	
END;
/
prompt Timesheet user dropped.

prompt Timesheet user creation ...
-- CRDS User creation
CREATE USER Timesheet IDENTIFIED BY Timesheet DEFAULT TABLESPACE CRDSDAT01 TEMPORARY TABLESPACE temp;
ALTER USER Timesheet QUOTA UNLIMITED ON CRDSDAT01;
ALTER USER Timesheet QUOTA UNLIMITED ON CRDSIND01;
prompt Timesheet user created

prompt Grant Timesheet user privileges ...
-- CRDS privileges
GRANT SELECT ON CRDS to Timesheet;
GRANT CONNECT TO Timesheet;
GRANT CREATE SESSION TO Timesheet;
GRANT CREATE PUBLIC SYNONYM TO Timesheet;
GRANT CREATE SYNONYM TO Timesheet;
GRANT DROP PUBLIC SYNONYM TO Timesheet;
GRANT DROP ANY SYNONYM TO Timesheet;
GRANT CREATE PROCEDURE, CREATE TRIGGER TO Timesheet;
GRANT CREATE ANY TABLE, CREATE SEQUENCE TO Timesheet;
GRANT DELETE ANY TABLE TO Timesheet;
GRANT CREATE ROLE TO Timesheet;
GRANT DEBUG CONNECT SESSION TO Timesheet;
GRANT CREATE TYPE TO Timesheet;
GRANT CREATE VIEW TO Timesheet;
GRANT EXECUTE ON SYS.DBMS_AQ TO Timesheet;
GRANT EXECUTE ON SYS.DBMS_AQADM TO Timesheet;
GRANT EXECUTE ON SYS.DBMS_PIPE TO Timesheet;
GRANT CREATE USER TO Timesheet WITH ADMIN OPTION;
GRANT ALTER USER TO Timesheet WITH ADMIN OPTION;
GRANT CREATE SESSION TO Timesheet WITH ADMIN OPTION;
GRANT GRANT ANY ROLE TO Timesheet WITH ADMIN OPTION;
GRANT DROP USER TO Timesheet WITH ADMIN OPTION;
GRANT DROP ANY TABLE TO Timesheet;
GRANT RESOURCE TO Timesheet;
GRANT ROLE_DBA TO Timesheet;
GRANT DEBUG ANY PROCEDURE, DEBUG CONNECT SESSION TO Timesheet;
GRANT EXECUTE ON SYS.UTL_MAIL TO Timesheet;

prompt Timesheet privileges granted

