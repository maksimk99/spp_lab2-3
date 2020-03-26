INSERT INTO city (city_id, city_name) VALUES (1, 'Brest');
INSERT INTO city (city_id, city_name) VALUES (2, 'Gomel');

INSERT INTO work_type (work_type_id, work_type_name) VALUES (1, 'excavation');
INSERT INTO work_type (work_type_id, work_type_name) VALUES (2, 'painting');

INSERT INTO customer (customer_id, first_name, last_name, phone_number) VALUES (1, 'Ivan', 'Ivanovich', '+375336648714');
INSERT INTO customer (customer_id, first_name, last_name, phone_number) VALUES (2, 'Pasha', 'Vasilievich', '+375297584215');

INSERT INTO job (job_id, description, position_count, price, city_id, customer_id, work_type_id, occupied_count)
VALUES (1, 'dig a trench', 3, '20.00', 1, 1, 1, 2);
INSERT INTO job (job_id, description, position_count, price, city_id, customer_id, work_type_id, occupied_count)
VALUES (2, 'paint the fence', 4, '20.00', 2, 2, 2, 0);

INSERT INTO user_role (role_id, role) VALUES (1, 'USER');
INSERT INTO user_role (role_id, role) VALUES (2, 'ADMIN');

INSERT INTO user (user_id, age, first_name, last_name, user_name, password, job_id)
VALUES (1, 23, 'Roma', 'Kurtsin', 'user', '$2a$10$hTJizVa8y8LWY7mc5yAWcOx.kCTT80en3dSDymaxHvWzuAUw1Lc7S', 1);
INSERT INTO user (user_id, age, first_name, last_name, user_name, password)
VALUES (2, 22, 'Sasha', 'Krivikov', 'maksimk99', '$2a$10$hTJizVa8y8LWY7mc5yAWcOx.kCTT80en3dSDymaxHvWzuAUw1Lc7S');
INSERT INTO user (user_id, age, first_name, last_name, user_name, password)
VALUES (3, 22, 'Pasha', 'Silakov', 'root', '$2a$10$hTJizVa8y8LWY7mc5yAWcOx.kCTT80en3dSDymaxHvWzuAUw1Lc7S');

INSERT INTO user_has_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_has_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_has_role (user_id, role_id) VALUES (3, 2);