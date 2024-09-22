CREATE TABLE employee (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(45),
    last_name VARCHAR(45)
);



CREATE TABLE employee_details (
    employee_id INT PRIMARY KEY,
    employee_type VARCHAR(10),
    region VARCHAR(20),
    designation VARCHAR(20),
    email VARCHAR(45),
    years_of_service INT
);