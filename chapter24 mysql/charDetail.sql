#文字列の使用詳細
#cahr(4) varchar(4)この4はチャーであり、バイトではない
CREATE TABLE t11 (
`name` CHAR ( 4 ));

INSERT INTO t11 VALUES('我是浓野');

SELECT	* FROM t11;

CREATE TABLE t12 (
`name` VARCHAR(4));
INSERT INTO t12 VALUES ('里个浪额');
INSERT INTO t12 VALUES ('abhb');
SELECT * FROM t12;

#varcharが足りないのであれば、MEDIUMTEXT,LONGTEXTを使う
CREATE TABLE t13(content TEXT, content2 MEDIUMTEXT,content3 LONGTEXT);
INSERT INTO t13 VALUES('菅純平教育', '菅純平教育100', '菅純平教育1000---');
SELECT * FROM t13;