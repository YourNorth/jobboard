INSERT into users(id, created, status, updated, email, nickname, password, token)
values (100, now(), 'ACTIVE', now(), 'user@gmail.com', 'General_User',
        '$2a$10$8eowpHtDac.AwKlEZYKMKuxOFC2FzQciEY9AvWWYtd3QpzA.M5HNq', 'zxcvbbnmffdfdfdfdfsdffff');
INSERT into users(id, created, status, updated, email, nickname, password, token)
values (101, now(), 'ACTIVE', now(), 'admin@gmail.com', 'General_Admin',
        '$2a$10$8eowpHtDac.AwKlEZYKMKuxOFC2FzQciEY9AvWWYtd3QpzA.M5HNq', 'zxcvbbnmffdfdfdfdfsdfdsffff');
INSERT into users(id, created, status, updated, email, nickname, password, token)
values (102, now(), 'ACTIVE', now(), 'employer@gmail.com', 'General_Employer',
        '$2a$10$8eowpHtDac.AwKlEZYKMKuxOFC2FzQciEY9AvWWYtd3QpzA.M5HNq', 'zxcvbbnmffdfdfdfdfsdfdsfffef');

insert into user_roles(user_id, role_id)
VALUES (100, 1),
       (101, 3),
       (102, 2);

Insert Into comments (created, status, updated, description, first_name, last_name, link_img, user_id) VALUES
(now(), 'ACTIVE', now(), 'I love this site!', 'Bulat', 'Bilalov', '/img/testmonial/author.png', 100),
(now(), 'ACTIVE', now(), 'I love this site!', 'Timur', 'Kalinka', '/img/testmonial/author.png', 101),
(now(), 'ACTIVE', now(), 'I love this site!', 'By', 'Ti', '/img/testmonial/author.png', 102);