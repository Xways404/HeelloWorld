#count
#統計関数の使用クラスに学生の数
SELECT COUNT(*) FROM student;

#数学の成績が90点以上の学生
SELECT COUNT(*) FROM student
				WHERE math > 90;

#総合得点が250の人数統計
SELECT COUNT(*) FROM student
				WHERE (chinese+english+math)>250

#count(*)count(フィールド)の区別条件を
#count(*)満たした記録のフィールドの数
#count(列)満たした記録の列の数 、NULLを除く
CREATE TABLE t15 (
        `name` VARCHAR(20));
INSERT INTO t15 VALUES('tom');
INSERT INTO t15 VALUES('jack');
INSERT INTO t15 VALUES('mary');
INSERT INTO t15 VALUES(NULL);
SELECT * FROM t15;
SELECT COUNT(*) FROM t15;
SELECT COUNT(`name`) FROM t15;

#SUM関数の使い方
#クラスの数学成績統計
SELECT SUM(math) FROM student;
#国語英語数学各教科の成績を統計
SELECT SUM(chinese), SUM(english), SUM(math) FROM student;
#国語英語数学成績を統計
SELECT SUM(chinese+english+math) FROM student;
#国語の平均点
SELECT SUM(chinese) / COUNT(*) FROM	student;

SELECT AVG(math) FROM student;
SELECT AVG(chinese+english+math) FROM student;

SELECT MAX(chinese+english+math), MIN(chinese+english+math) FROM student;
SELECT MAX(math) AS math_high, MIN(math) AS math_loser FROM student;

