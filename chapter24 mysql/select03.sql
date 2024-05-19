#フィールド名を指定して、調べる
SELECT * FROM student
				WHERE `name` = '赵云';
				
#英語成績が90点以上の生徒を引き出す
SELECT * FROM student
				WHERE english>90;
				
#総合点数が200点以上の生徒を引き出す
SELECT * FROM student
				WHERE (chinese+english+math)>250
				
SELECT * FROM student
				WHERE (id<90)AND(math>60);
SELECT * FROM student
				WHERE english>chinese;
SELECT * FROM student
				WHERE (chinese+english+math)>200 AND math<chinese
SELECT * FROM student
				WHERE english BETWEEN 80 AND 90;
SELECT * FROM student
				WHERE math = 89 OR math = 90 OR math = 91;
SELECT * FROM student
				WHERE math IN(89,90,91);
SELECT * FROM student
				WHERE `name` LIKE '韩%';

				
				