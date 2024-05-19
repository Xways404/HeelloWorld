CREATE VIEW emp_view01
				AS 
				SELECT empno, ename, job, deptno FROM emp
				
DESC emp_view01
SELECT * FROM emp_view01
SELECT empno,job FROM emp_view01

SHOW CREATE VIEW emp_view01
DROP VIEW emp_view01