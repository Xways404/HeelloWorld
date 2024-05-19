SELECT *
			FROM emp
			WHERE deptno = 30
			
SELECT empno, ename, deptno
			FROM emp
			WHERE job = 'CLERK'
			
SELECT * FROM 
				emp
				WHERE IFNULL(comm,0) > sal
				
SELECT * FROM 
emp
WHERE (deptno = 10 and job = 'MANAGER') OR (deptno = 20 AND job = 'CLERK')

SELECT * 
FROM emp
WHERE LAST_DAY(hiredate) - 2 = hiredate

SELECT  *
FROM emp
WHERE DATE_ADD(hiredate, INTERVAL 33 YEAR) < now()

SELECT CONCAT(LCASE(SUBSTRING(ename, 1, 1)), SUBSTRING(ename, 2))
FROM emp
			

