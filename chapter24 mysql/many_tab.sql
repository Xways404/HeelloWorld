#多数テーブル検査

SELECT ename, sal, dname
			FROM emp, dept
			WHERE emp.deptno = dept.deptno
			
SELECT * FROM emp;
SELECT * FROM dept;

SELECT ename ,sal,dname,emp.deptno
			FROM emp, dept
			WHERE emp.deptno = dept.deptno AND emp.deptno = 10
			
SELECT ename, sal, grade
			FROM emp, salgrade
			WHERE	sal BETWEEN losal AND hisal;
			