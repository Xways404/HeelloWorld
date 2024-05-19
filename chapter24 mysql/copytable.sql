#テーブルのコピー
CREATE TABLE my_tab01
					(id INT,
					`name` VARCHAR(32),
					sal DOUBLE,
					job VARCHAR (32),
					deptno INT)
DESC my_tab01
SELECT * FROM my_tab01

#empテーブルの記録をmy_tab01にコピーして
INSERT INTO my_tab01
					(id, `name`, sal, job, deptno)
					SELECT empno, ename, sal, job, deptno FROM emp;
					
#重複を削除
#my_tab02 empテーブルのフィールドを、my＿tab02にコピーする
CREATE TABLE my_tab02 LIKE emp;
DESC my_tab02

INSERT INTO my_tab02
				SELECT * FROM emp
SELECT * FROM my_tab02

#重複を削除
#my_tab02と同様な臨時テーブルを作成my_tmp
CREATE TABLE my_tmp LIKE my_tab02
#my_tmpの記録をdistinctキーワードに通じてmy_tmpにコピーする
INSERT INTO my_tmp
				SELECT DISTINCT * FROM my_tab02
SELECT * FROM my_tmp
#my_tab02の記録を全て削除する
DELETE FROM my_tab02
#my_tmpの記録をmy_tab2にコピーして戻す
INSERT INTO my_tab02
			SELECT * FROM my_tmp;
SELECT * FROM my_tab02
DROP TABLE my_tmp



