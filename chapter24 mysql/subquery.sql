SELECT deptno, AVG(sal) AS avg_sal
				FROM emp
				GROUP BY deptno
				
SELECT ename, sal, temp.avg_sal, emp.deptno
       FROM emp, (
							SELECT deptno, AVG(sal) AS avg_sal
							FROM emp
							GROUP BY deptno
			 )temp
			 WHERE emp.deptno = temp.deptno AND emp.sal > temp.avg_sal
			 
SELECT ename, sal, temp.max_sal, emp.deptno
				FROM emp, (
									SELECT deptno, MAX(sal) AS max_sal
									FROM emp
									GROUP BY deptno
				)temp
				WHERE emp.deptno = temp.deptno AND emp.sal = temp.max_sal
				
SELECT * FROM emp;

SELECT COUNT(*), deptno 
				FROM emp
				GROUP BY deptno
				
SELECT	dname, dept.deptno, loc, j8
				FROM dept, (
							SELECT COUNT(*) AS j8, deptno 
							FROM emp
							GROUP BY deptno
				)tmp
				WHERE tmp.deptno = dept.deptno