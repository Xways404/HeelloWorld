CREATE TABLE t17
				(id INT PRIMARY KEY,
				`name` VARCHAR(32),
				email VARCHAR(32))
				
INSERT INTO t17
				VALUES(1, 'jack', 'jack@sohu.com') 
				
INSERT INTO t17
				VALUES(2, 'tom', 'jack@sohu.com') 
INSERT INTO t17
				VALUES(1, 'hep', 'jack@sohu.com') 
				
CREATE TABLE t18 
					(id INT,
					`name` VARCHAR(32),
					email VARCHAR(32),
					PRIMARY KEY(id, `name`) #idとnameがどっちも一緒になった場合には追加不可
					)
DESC t18