#group by の上進使用

#各職種の社員総数、平均給料
SELECT COUNT(*), AVG(sal), job
				FROM emp
				GROUP BY job;

#社員総数、ボーナスをもらってる社員数
SELECT COUNT(*), COUNT(comm)
				FROM emp

#ボーナスをもらえない社員の数
SELECT COUNT(*), COUNT(if(comm IS NULL, 1 ,NULL))
				FROM emp;

#管理者の総人数
SELECT COUNT(DISTINCT mgr) 
				FROM emp;

#社員給料の最大差額
SELECT MAX(sal) - MIN(sal)
				FROM emp;

SELECT * FROM emp;

#順番付が必要である、順番が異なったらエラーが発生する
SELECT deptno, AVG(sal) AS avg_sal
				FROM emp
				GROUP BY deptno
				having avg_sal > 1000
				ORDER BY avg_sal DESC
				LIMIT 0, 2;