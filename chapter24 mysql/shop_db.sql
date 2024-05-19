CREATE DATABASE shop_db

CREATE TABLE goods(
				goods_id INT PRIMARY KEY,
				goods_name VARCHAR(64) NOT NULL DEFAULT '',
				unitprice DECIMAL(10, 2) NOT NULL DEFAULT 0
							CHECK (unitprice >= 1.0 AND unitprice <= 9999.99),
				cetegory INT NOT NULL DEFAULT 0,
				provider VARCHAR(64) NOT NULL DEFAULT ''
				);
				
CREATE TABLE customer(
				customer_id CHAR(8) PRIMARY KEY,
				`name` VARCHAR(64) NOT NULL DEFAULT '',
				address VARCHAR(64) NOT NULL DEFAULT '',
				email VARCHAR(64) UNIQUE NOT NULL,
				sex CHAR(5),
				card_id VARCHAR(32)
				)
				
CREATE TABLE purchase(
				order_id INT UNSIGNED PRIMARY KEY,
				customer_id CHAR(8) NOT NULL DEFAULT '',
				goods_id INT NOT NULL DEFAULT 0,
				nums INT NOT NULL DEFAULT 0,
				FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
				FOREIGN KEY (goods_id) REFERENCES goods(goods_id)
				 )