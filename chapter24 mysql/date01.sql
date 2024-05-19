-- 日付時間　　関数

-- CURRENT_DATE (  )	現在日付
SELECT CURRENT_DATE() FROM DUAL;
-- CURRENT_TIME (  )	現在時間
SELECT CURRENT_TIME()  FROM DUAL;
-- CURRENT_TIMESTAMP (  ) 現在日付時間
SELECT CURRENT_TIMESTAMP()  FROM DUAL;

-- テスティングテーブル 情報テーブル
CREATE TABLE mes(
	id INT , 
	content VARCHAR(30), 
	send_time DATETIME);
	
SELECT * FROM mes;
	
	
-- データを増やす
INSERT INTO mes 
	VALUES(1, '北京新闻', CURRENT_TIMESTAMP()); 
INSERT INTO mes VALUES(2, '上海新闻', NOW());
INSERT INTO mes VALUES(3, '广州新闻', NOW());

SELECT * FROM mes;
SELECT NOW() FROM DUAL;

-- 応用　例
-- 新聞情報、発表日付を表示する
SELECT id, content, DATE(send_time) 
	FROM mes;
-- 10分以内に発表されたニュースを調べだす
SELECT * 
	FROM mes
	WHERE DATE_ADD(send_time, INTERVAL 10 MINUTE) >= NOW()

SELECT * 
	FROM mes
	WHERE send_time >= DATE_SUB(NOW(), INTERVAL 10 MINUTE) 

-- 2011-11-11 と 1990-1-1 相何日の差があるのか
SELECT DATEDIFF('2011-11-11', '1990-01-01') FROM DUAL;

-- [練習] 1986-11-11 生まれてから今まで何日間経ったのか
SELECT DATEDIFF(NOW(), '1986-11-11') FROM DUAL;

-- [練習] 1986-11-11 生まれで80歳まで生きれるのであれば、何日間生きれるのか
SELECT DATEDIFF(DATE_ADD('1986-11-11', INTERVAL 80 YEAR), NOW()) 
	FROM DUAL;
	
SELECT TIMEDIFF('10:11:11', '06:10:10') FROM DUAL;

-- YEAR|Month|DAY| DATE (datetime )
SELECT YEAR(NOW()) FROM DUAL;
SELECT MONTH(NOW()) FROM DUAL;
SELECT DAY(NOW()) FROM DUAL;
SELECT MONTH('2013-11-10') FROM DUAL;
-- unix_timestamp() : 戻されるのは1970-1-1から現在までの秒数
SELECT UNIX_TIMESTAMP() FROM DUAL;
-- FROM_UNIXTIME() : unix_timestamp 秒数[タイムスタンプ]を日付に変換できる
-- %Y-%m-%d フォームは決まっている、年月日と示している
-- 意味：開発で，整数を保存して、FROM_UNIXTIMEで転換して、時間として表せる
SELECT FROM_UNIXTIME(1715858849, '%Y-%m-%d') FROM DUAL;
SELECT FROM_UNIXTIME(1715858000, '%Y-%m-%d %H:%i:%s') FROM DUAL;