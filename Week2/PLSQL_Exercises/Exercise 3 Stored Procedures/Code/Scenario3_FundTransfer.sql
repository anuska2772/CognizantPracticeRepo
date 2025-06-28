CREATE OR REPLACE PROCEDURE TransferFunds(
    from_acc IN NUMBER,
    to_acc IN NUMBER,
    amount IN NUMBER
) IS
    insufficient_balance EXCEPTION;
    current_balance NUMBER;
BEGIN
    SELECT balance INTO current_balance
    FROM accounts
    WHERE account_id = from_acc
    FOR UPDATE;

    IF current_balance < amount THEN
        RAISE insufficient_balance;
    END IF;

    UPDATE accounts
    SET balance = balance - amount
    WHERE account_id = from_acc;

    UPDATE accounts
    SET balance = balance + amount
    WHERE account_id = to_acc;

    COMMIT;

EXCEPTION
    WHEN insufficient_balance THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in the source account');
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/
BEGIN
    TransferFunds(201, 202, 1000); -- Transfer ₹1000 from acc 201 to 202
END;
/
