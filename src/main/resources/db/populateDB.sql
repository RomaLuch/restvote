DELETE FROM user_roles;
DELETE FROM menu;
DELETE FROM restaurants;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO restaurants (name, adress, rating) VALUES
  ('Токио', 'Солнечное', 0),
  ('Евразия', 'Сестрорецк', 0),
  ('Улыбка', 'Зеленогорск', 0);

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', '{noop}password'),
  ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100003),
  ('ROLE_ADMIN', 100004),
  ('ROLE_USER', 100004);


INSERT INTO menu (name, price, rest_id) VALUES
  ('Филадельфия', 300, 100000),
  ('Калифорния', 350, 100000),
  ('Минри', 320, 100000),

  ('Филадельфия', 350, 100001),
  ('Калифорния', 400, 100001),
  ('Минри', 370, 100001),

  ('Солянка', 70, 100002),
  ('Греча', 30, 100002),
  ('Говядина', 70, 100002);

INSERT INTO votes (USER_ID, REST_ID) VALUES
  (100003,100002),
  (100004,100002);




