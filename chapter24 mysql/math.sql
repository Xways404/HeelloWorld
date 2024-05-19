-- math関数

-- ABS(num)	絶対値
SELECT ABS(-10) FROM DUAL;
-- BIN (decimal_number )十進数から二進数にする
SELECT BIN(10) FROM DUAL;
-- CEILING (number2 )	上キャストをして整数をとる、num2より大きな最小整数をゲット
SELECT CEILING(-1.1) FROM DUAL;

-- CONV(number2,from_base,to_base)	進数転換
-- 十進数の8を二進数で出力
SELECT CONV(8, 10, 2) FROM DUAL;
-- 十六進数の8を二進数で出力
SELECT CONV(16, 16, 10) FROM DUAL;

-- FLOOR (number2 )	下キャストして整数をとる、num2より小さな最大整数をゲット
SELECT FLOOR(-1.1) FROM DUAL;

-- FORMAT (number,decimal_places )	四捨五入する
SELECT FORMAT(78.125458,2) FROM DUAL;

-- HEX (DecimalNumber )	十六進数に

-- LEAST (number , number2  [,..])	最小値
SELECT LEAST(0,1, -10, 4) FROM DUAL;
-- MOD (numerator ,denominator )	あまりを求める
SELECT MOD(10, 3) FROM DUAL;

-- RAND([seed])	RAND([seed]) ランダムの数値を戻す 範囲は 0 ≤ v ≤ 1.0

SELECT RAND() FROM DUAL;

SELECT CURRENT_TIMESTAMP() FROM DUAL;