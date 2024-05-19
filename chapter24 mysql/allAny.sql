# all any

SELECT ename, sal, deptno		
				FROM emp
				WHERE sal > ALL(
				SELECT sal 
								FROM emp
								WHERE deptno = 30
								)