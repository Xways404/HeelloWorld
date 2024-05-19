-- 暗号化関数システム関数

-- USER()	ユーザー検索
-- MySQLのユーザーとログインのIPアドレス
SELECT USER() FROM DUAL;
-- DATABASE()	現在使用しているデータベースの名称を検索
SELECT DATABASE();

-- MD5(str)	文字列に MD5 32文字列，ユーザーパスワード暗号化するために
-- root　パスワードは timerring -> md5に暗号化 -> データベースに保存されているのは暗号化されたパスワード
SELECT MD5('superlover') FROM DUAL;
SELECT LENGTH(MD5('superlover')) FROM DUAL;

-- ユーザーテーブル
CREATE TABLE hsp_user
	(id INT, 
	`name` VARCHAR(32) NOT NULL DEFAULT '', 
	pwd CHAR(32) NOT NULL DEFAULT '');
	
INSERT INTO hsp_user 
	VALUES(100, '韩顺平', MD5('superlover'));
	
SELECT * FROM hsp_user;

SELECT * FROM hsp_user
	WHERE `name`='韩顺平' AND pwd = MD5('superlover')  


-- PASSWORD(str) -- 暗号化関数, MySQLデータベースのユーザーパスワードはPASSWORD関数暗号化

SELECT PASSWORD('sup') FROM DUAL; -- データベースでは 


-- select * from mysql.user \G 	
SELECT * FROM mysql.user


