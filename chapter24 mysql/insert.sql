#insert　練習

CREATE TABLE `goods` (
				id INT, 
				goods_name VARCHAR(10),
				price DOUBLE);
				
--　データを書き込む
INSERT INTO `goods` (id, goods_name, price)
				VALUES(10, 'アップル', 2000);
				
INSERT INTO `goods` (id, goods_name, price)
				VALUES(20, 'j8phone', 10000);
				
DESC goods;
SELECT * FROM goods;

INSERT INTO `employee` (id, user_name, brithday, entry_date, job, salary, resume, image)
				VALUES(321, 'j8BBQ', '2001/02/02', '2023/04/01', 'bonmer', 
								54321, 'study languege at collge by 4years', 'cutty')
SELECT * FROM employee;