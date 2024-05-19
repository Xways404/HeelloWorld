#文字列関数
-- CHARSET(str)	文字列の照合
SELECT CHARSET(ename) FROM emp;
-- CONCAT (string2  [,... ])	文字列を連結させる
SELECT CONCAT(ename, ' job is ', job) FROM emp;

-- INSTR (string ,substring )	stringで出現した位置をsubstringで戻す,なければ０で戻す
SELECT INSTR('hanshunping', 'ping') FROM DUAL; 

-- UCASE (string2 )	大文字に変換
SELECT UCASE(ename) FROM emp;

-- LCASE (string2 )	小文字に変換
SELECT LCASE(ename) FROM emp;

-- LEFT (string2 ,length )	string2の中からの左から、length長さの文字列をとる
-- RIGHT (string2 ,length )	string2の中からの右から、length長さも文字列をとる
SELECT LEFT(ename, 2) FROM emp;

-- LENGTH (string )	string長さ[チャーで]
SELECT LENGTH(ename) FROM emp;

-- REPLACE (str ,search_str ,replace_str ) 	
-- strの中でreplace_strをsearch_strに
-- もしmanagerであれば经理に変換
SELECT ename, REPLACE(job,'MANAGER', '经理')  FROM emp;

-- STRCMP (string1 ,string2 )	各チャーの大きさで文字列を比べる
SELECT STRCMP('hsp', 'hsp') FROM DUAL;

-- SUBSTRING (str , position  [,length ])	
-- strのpositionから【1から計算し始める】,length個のチャー
-- enameカラムの一番目の位置からチャーを二つゲット
SELECT SUBSTRING(ename, 1, 2) FROM emp;

-- LTRIM (string2 ) RTRIM (string2 )  TRIM(string)
-- 先端のスペースを後端もスペースを削除
SELECT LTRIM('  韩顺平教育') FROM DUAL;
SELECT RTRIM('韩顺平教育   ') FROM DUAL;
SELECT TRIM('    韩顺平教育   ') FROM DUAL;

-- 練習: アルファベット小文字で社員全員のemp表の名前を表示する

SELECT CONCAT(LCASE(SUBSTRING(ename,1,1)),  SUBSTRING(ename,2)) AS new_name
	FROM emp;  

SELECT CONCAT(LCASE(LEFT(ename,1)),  SUBSTRING(ename,2)) AS new_name
	FROM emp; 
