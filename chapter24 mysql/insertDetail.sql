# The detail of insert you should know
#挿入したいデータの型はフィールドと一致しなければならない
#
INSERT INTO `goods` (id, good_name, price)
				VALUES('30', 'redphone', 350);
				
INSERT INTO `goods` (id, good_name, price)
				VALUES('redphone', 30, 350);
INSERT INTO `goods` (id, good_name, price)
				VALUES(30, redphone, 350);
INSERT INTO `goods` (id, good_name, price)
				VALUES('30', 'redphoneredphoneredphoneredphoneredphoneredphone', 350);
INSERT INTO `goods` (id, goods_name, price)
				VALUES(30, 'redphone', NULL);
INSERT INTO `goods` (id, goods_name, price)
				VALUES(40, 'blackphone', 54321),(21, 'pinkphone', 43211);
SELECT * FROM goods;

				
