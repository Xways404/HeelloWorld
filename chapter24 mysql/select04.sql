#ORDER BY ソート昇順降順

#数学の成績を昇順でソートする
SELECT * FROM student
				ORDER BY math ASC;
#総合点数を高いから低くまでの順番で出力する
SELECT `name`, (chinese+english+math) AS total_socre FROM student
				ORDER BY total_socre DESC;
#苗字が韓である生徒に対して点数をソートする昇順で
SELECT `name`, (chinese+english+math) AS total_socre FROM student
				WHERE `name` LIKE '韩%'
				ORDER BY total_socre;