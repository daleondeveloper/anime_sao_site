INSERT INTO users(id,email,password,nickname,last_update_date_time,release_date_time) VALUES
(1,'daleon@ukr.net','$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a','Admin1',	now(),	date_trunc('second', timestamp '2020-08-13 20:01:40')),
(2,'mail@ukr.net','$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a','Admin2',	now(),	date_trunc('second', timestamp '2020-08-13 20:01:40')),
(3,'daleon1@ukr.net','$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a','User1',	now(),	date_trunc('second', timestamp '2020-08-13 20:01:40')),
(4,'daleon2@ukr.net','$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a','User2',	now(),	date_trunc('second', timestamp '2020-08-13 20:01:40')),
(5,'daleon3@ukr.net','$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a','User3',	now(),	date_trunc('second', timestamp '2020-08-13 20:01:40')),
(6,'daleon4@ukr.net','$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a','User4',	now(),	date_trunc('second', timestamp '2020-08-13 20:01:40')),
(7,'daleon5@ukr.net','$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a','User5',	now(),	date_trunc('second', timestamp '2020-08-13 20:01:40')),
(8,'daleon6@ukr.net','$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a','User6',	now(),	date_trunc('second', timestamp '2020-08-13 20:01:40')),
(9,'daleon7@ukr.net','$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a','User7',	now(),	date_trunc('second', timestamp '2020-08-13 20:01:40')),
(10,'daleon8@ukr.net','$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a','User8',	now(),	date_trunc('second', timestamp '2020-08-13 20:01:40'));
INSERT INTO roles(id,name) VALUES
(1,'ROLE_ADMIN'),
(2,'ROLE_USER');
INSERT INTO users_roles(user_id,role_id) VALUES
(1,1),
(1,2),
(2,1),
(2,2),
(3,2),
(4,2),
(5,2),
(6,2),
(7,2),
(8,2),
(9,2),
(10,2);
INSERT INTO image_avatar(id,access,content_type,create_date,data,file_name) values
(1,'ROLE_GUEST','image/jpg',now(),lo_import('D://icon.jpg'),'avatar'),
(2,'ROLE_GUEST','image/jpg',now(),lo_import('D://icon.jpg'),'avatar'),
(3,'ROLE_GUEST','image/jpg',now(),lo_import('D://icon.jpg'),'avatar'),
(4,'ROLE_GUEST','image/jpg',now(),lo_import('D://icon.jpg'),'avatar'),
(5,'ROLE_GUEST','image/jpg',now(),lo_import('D://icon.jpg'),'avatar'),
(6,'ROLE_GUEST','image/jpg',now(),lo_import('D://icon.jpg'),'avatar'),
(7,'ROLE_GUEST','image/jpg',now(),lo_import('D://icon.jpg'),'avatar'),
(8,'ROLE_GUEST','image/jpg',now(),lo_import('D://icon.jpg'),'avatar'),
(9,'ROLE_GUEST','image/jpg',now(),lo_import('D://icon.jpg'),'avatar'),
(10,'ROLE_GUEST','image/jpg',now(),lo_import('D://icon.jpg'),'avatar');
UPDATE users SET avatar_img = 1 WHERE id = 1;
UPDATE users SET avatar_img = 2 WHERE id = 2;
UPDATE users SET avatar_img = 3 WHERE id = 3;
UPDATE users SET avatar_img = 4 WHERE id = 4;
UPDATE users SET avatar_img = 5 WHERE id = 5;
UPDATE users SET avatar_img = 6 WHERE id = 6;
UPDATE users SET avatar_img = 7 WHERE id = 7;
UPDATE users SET avatar_img = 8 WHERE id = 8;
UPDATE users SET avatar_img = 9 WHERE id = 9;
UPDATE users SET avatar_img = 10 WHERE id = 10;