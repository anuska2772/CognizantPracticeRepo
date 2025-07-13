CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept_id IN NUMBER,
    bonus_pct IN NUMBER
) IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * bonus_pct / 100)
    WHERE department_id = dept_id;

    COMMIT;
END;
/
BEGIN
    UpdateEmployeeBonus(10, 10); -- 10% bonus to dept 10
END;
/
