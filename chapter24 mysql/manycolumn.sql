#多数フィールド副問合せ

SELECT deptno, job
				FROM emp
				WHERE ename = 'ALLEN'
				
SELECT*
			FROM emp
			WHERE (deptno, job) = (
							SELECT deptno, job
							FROM emp
							WHERE ename = 'ALLEN'
			)AND ename != 'ALLEN';