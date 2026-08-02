CREATE TABLE employee_account (
    id SERIAL PRIMARY KEY,
    employee_id INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL
);

INSERT INTO employee_account (employee_id, name, password)
VALUES (1, 'admin', '$2a$10$7qY8jYHk3mVn3uJtQqZ8Uu8xJf8GJH8gk8FJH8gk8FJH8gk8FJH8');

INSERT INTO employee_account (employee_id, name, password)
VALUES (2, 'test', '$2a$10$ae/IFfXVZLzoK5eJvFKt4Ovm0oWbMNsj3uvpwmAzfNBJUhnBDoQ7a');
