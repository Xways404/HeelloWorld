SELECT ename, sal
FROM emp
WHERE sal > (
SELECT MAX(sal)
					FROM emp
					WHERE deptno = 30)
					
SELECT COUNT(*) AS "部門の社員数", deptno, AVG(sal) AS "部門ごとの平均給料", 
				FORMAT(AVG(DATEDIFF(NOW(),hiredate) / 365), 2) AS "平均在籍年数"
				FROM emp
				GROUP BY deptno

SELECT dept.*, tmp.c
			FROM dept, (
							SELECT COUNT(*) AS c,deptno
							FROM emp
							GROUP BY deptno
			) tmp
			WHERE dept.deptno = tmp.deptno
			
SELECT MIN(sal), job
				FROM emp
				GROUP BY job
				
SELECT MIN(sal), job	
				FROM emp
				WHERE job = 'MANAGER'
				
SELECT ename, (sal + IFNULL(comm,0)) * 12 AS year_sal
				FROM emp
				ORDER BY year_sal
		
				
				

				
