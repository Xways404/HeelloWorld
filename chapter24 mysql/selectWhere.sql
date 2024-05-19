#副問合せ

SELECT deptno
				FROM emp
				WHERE ename = 'SMITH'
				
SELECT * 
				FROM emp
				WHERE deptno = (
									SELECT deptno
									FROM emp
									WHERE ename = 'SMITH'
				)
				
SELECT DISTINCT job 
				FROM emp
				WHERE deptno = 10;
				
SELECT ename , job, sal, deptno	
					FROM emp
					WHERE job IN (
									SELECT DISTINCT job 
									FROM emp
									WHERE deptno = 10
									) AND deptno != 10