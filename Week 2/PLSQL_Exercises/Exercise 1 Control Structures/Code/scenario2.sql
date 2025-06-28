--Promote to VIP if Balance > 10000
BEGIN
    FOR rec IN (
        SELECT customer_id FROM customers WHERE balance > 10000
    ) LOOP
        UPDATE customers
        SET isVIP = 'Y'
        WHERE customer_id = rec.customer_id;
    END LOOP;

    COMMIT;
END;
