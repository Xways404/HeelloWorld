CREATE TABLE t24
				(id INT PRIMARY KEY AUTO_INCREMENT,
				email VARCHAR(32) NOT NULL DEFAULT '',
				`name` VARCHAR(32) NOT NULL DEFAULT '')
				
DESC t24

INSERT INTO t24
				VALUES(NULL, 'jack@qq.com', 'jack')
SELECT * FROM t24