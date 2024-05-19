#各生徒の総合成績を取得する
SELECT `name`, (chinese+english+math) FROM student;

#全生徒の総合成績に10点分を足す
SELECT `name`, (chinese+english+math+10) FROM student;

#別名を使って、学生の点数を表す、要はフィールド名(chinese+english+math+10)を変える
#(chinese+english+math+10) --> total_score
SELECT `name`, (chinese+english+math+10) AS total_score FROM student;
