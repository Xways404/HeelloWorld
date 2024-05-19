# コントロール

# IF(expr1,expr2,expr3)	もしexpr1がTrue, expr2が戻される、でなければexpr3が戻される
SELECT IF(TRUE, '北京', '上海') FROM DUAL;
# IFNULL(expr1,expr2)	もしexpr1はNULLじゃなければ,expr1が戻される、でなければexpr2が戻される
SELECT IFNULL( NULL, '教育') FROM DUAL;
# SELECT CASE WHEN expr1 THEN expr2 WHEN expr3 THEN expr4 ELSE expr5 END; [類似の多重分岐.]
# もしxpr1がTRUE、expr2が戻される,もしexpr2がtexpr4が戻される、でなければexpr5

SELECT CASE 
	WHEN TRUE THEN 'jack'  -- jack
	WHEN FALSE THEN 'tom' 
	ELSE 'mary' END;

-- 1. empテーブルを検査、もしcommがnull、0.0を表示
--  nullであるかを判断する、is nullを使って判断し。nullでないことに判断するとき、is notを使う
SELECT ename, IF(comm IS NULL , 0.0, comm)
	FROM emp;
SELECT ename, IFNULL(comm, 0.0)
	FROM emp;
	
-- 2. 如果empテーブルのjobはCLERKであれば职员として表示する、　MANAGER 经理
--    SALESMAN　销售人员，その他は通常表示する
SELECT ename, (SELECT CASE 
		WHEN job = 'CLERK' THEN '职员' 
		WHEN job = 'MANAGER' THEN '经理'
		WHEN job = 'SALESMAN' THEN '销售人员' 
		ELSE job END) AS 'job'
		FROM emp; 

SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM salgrade;

	