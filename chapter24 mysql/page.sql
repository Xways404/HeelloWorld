#行数上限設定
#社員empnoで昇順で取り出す、各ページ３行まで、

SELECT * FROM emp 
				ORDER BY empno
				LIMIT 0,3
SELECT * FROM emp 
				ORDER BY empno
				LIMIT 3,3
SELECT * FROM emp 
				ORDER BY empno
				LIMIT 6,3
--文法
SELECT * FROM emp 
				ORDER BY empno
				LIMIT 各ページが表示するページ数　* (何ページ目ー１),各ページで表示する記録数
				

				