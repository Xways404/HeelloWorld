SELECT *
FROM　emp
WHERE ename NOT LIKE '%R%'

SELECT SUBSTRING(ename, 1, 3)
FROM emp

SELECT REPLACE(ename,'A','!"#')
FROM emp

