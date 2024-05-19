#テーブル添削

ALTER TABLE emp
		Add image VARCHAR(32) NOT NULL DEFAULT '' 
		AFTER RESUME
DESC emp

ALTER TABLE emp
			MODIFY job VARCHAR(60) NOT NULL DEFAULT ''
			
ALTER TABLE emp
			DROP sex
			
RENAME TABLE emp TO employee
#名前を変更したから再定義しなければならない
DESC employee

ALTER TABLE employee CHARACTER SET utf8

ALTER TABLE employee CHANGE `name` 'user_name' VARCHAR(32) NOT NULL DEFAULT ''