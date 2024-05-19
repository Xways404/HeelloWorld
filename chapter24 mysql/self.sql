#セルフ

SELECT worker.ename as 'baby', boss.ename as 'boss'
				FROM emp worker, emp boss
				WHERE worker.mgr = boss.empno;
SELECT * FROM emp;