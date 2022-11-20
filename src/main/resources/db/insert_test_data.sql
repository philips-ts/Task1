INSERT INTO mydb.products (product_id, manufacture_date, name, price) VALUES (1, '2023-03-09', 'Apple', 50);
INSERT INTO mydb.products (product_id, manufacture_date, name, price) VALUES (2, '2023-02-20', 'Cookie', 80);
INSERT INTO mydb.products (product_id, manufacture_date, name, price) VALUES (3, '2023-02-20', 'Milk', 30);
INSERT INTO mydb.products (product_id, manufacture_date, name, price) VALUES (4, '2024-02-02', 'Tea', 200);
INSERT INTO mydb.products (product_id, manufacture_date, name, price) VALUES (5, '2023-01-04', 'Bread', 35);
INSERT INTO mydb.products (product_id, manufacture_date, name, price) VALUES (6, '2020-12-02', 'Pencil', 80);
INSERT INTO mydb.products (product_id, manufacture_date, name, price) VALUES (7, '2020-01-05', 'Laptop', 2180);
INSERT INTO mydb.products (product_id, manufacture_date, name, price) VALUES (8, '2020-07-05', 'Mobile phone', 1530);
INSERT INTO mydb.products (product_id, manufacture_date, name, price) VALUES (9, '2021-01-30', 'Razor', 280);

INSERT INTO mydb.food (max_storage_temperature, shelf_life_months, product_id) VALUES (25, 1, 1);
INSERT INTO mydb.food (max_storage_temperature, shelf_life_months, product_id) VALUES (30, 12, 2);
INSERT INTO mydb.food (max_storage_temperature, shelf_life_months, product_id) VALUES (5, 2, 3);
INSERT INTO mydb.food (max_storage_temperature, shelf_life_months, product_id) VALUES (30, 24, 4);
INSERT INTO mydb.food (max_storage_temperature, shelf_life_months, product_id) VALUES (25, 0, 5);


INSERT INTO mydb.not_food (is_breakable, product_id) VALUES (false, 6);
INSERT INTO mydb.not_food (is_breakable, product_id) VALUES (true, 7);
INSERT INTO mydb.not_food (is_breakable, product_id) VALUES (true, 8);
INSERT INTO mydb.not_food (is_breakable, product_id) VALUES (false, 9);

INSERT INTO mydb.users (user_id, name, is_active) VALUES (1, 'admin', true);
