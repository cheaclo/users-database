INSERT INTO address (address_id, street, street_number, city, postal_code, country) VALUES (1, 'Teststreet', 22, 'Testcity', 'POSCOD', 'Poland');
INSERT INTO address (address_id, street, street_number, city, postal_code, country) VALUES (2, 'Teststreet2', 33, 'Testcity2', 'POSCO2', 'France');

INSERT INTO account_info (account_info_id, firstname, lastname, email, password, birthday_date, gender, phone, address_id) VALUES (1, 'Piotr', 'Kalota', 'first@gmail.com', 'passwword', CURRENT_DATE, 0, '999000888', 1);
INSERT INTO account_info (account_info_id, firstname, lastname, email, password, birthday_date, gender, phone, address_id) VALUES (2, 'Asaf', 'Avidan', 'second@gmail.com', 'passwword2', CURRENT_DATE, 1, '111888222', 2);

INSERT INTO cheaclo_user (user_id, create_date, account_info_id) VALUES (1,  CURRENT_DATE, 1);
INSERT INTO cheaclo_user (user_id, create_date, account_info_id) VALUES (2,  CURRENT_DATE, 2);