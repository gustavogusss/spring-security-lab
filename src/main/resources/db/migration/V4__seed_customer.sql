INSERT INTO customer (email, password, role)
VALUES ('user@example.com', '{noop}user', 'read');

INSERT INTO customer (email, password, role)
VALUES ('admin@example.com', '{bcrypt}$2a$12$qHWyOOkibtI7lZF6b/BJ1edHfMZQ1wWZyZi2mWawDYVQA.3GdPqGa', 'admin');