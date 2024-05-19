SELECT * FROM dept
SELECT * FROM emp
SELECT dname
				FROM dept
SELECT ename, (sal + IFNULL(comm, 0)) * 13 AS "year income"
				FROM emp
				
SELECT ename, sal
				FROM emp
				WHERE sal > 2850
				
SELECT ename, sal
				FROM emp
				WHERE sal < 1500 OR sal > 2850
				

				