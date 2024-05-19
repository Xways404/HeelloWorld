#updateの使い方

UPDATE employee SET salary = 5000;

UPDATE employee 
				SET salary = 3000
				WHERE user_name = 'j8BBQ';
				
UPDATE employee 
				SET salary = salary + 1000
				WHERE user_name = 'j8BBQ';


SELECT  * FROM employee;