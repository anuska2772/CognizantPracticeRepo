INSERT INTO customers VALUES (4, 'Alex', 65, 15000, 'N');
INSERT INTO customers VALUES (5, 'Bobley', 45, 8000, 'N');
INSERT INTO customers VALUES (6, 'Charles', 70, 11000, 'N');

INSERT INTO loans VALUES (104, 4, 8.5, SYSDATE + 10);
INSERT INTO loans VALUES (105, 5, 9.0, SYSDATE + 40);
INSERT INTO loans VALUES (106, 6, 7.5, SYSDATE + 25);

COMMIT;

SELECT customer_id, name, balance, isVIP FROM customers;

