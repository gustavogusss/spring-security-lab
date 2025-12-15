INSERT INTO users (username, password, enabled)
VALUES ('user', '{noop}user', true);

INSERT INTO authorities (username, authority)
VALUES ('user', 'read');

INSERT INTO users (username, password, enabled)
VALUES (
  'admin',
  '{bcrypt}$2a$12$qHWyOOkibtI7lZF6b/BJ1edHfMZQ1wWZyZi2mWawDYVQA.3GdPqGa',
  true
);

INSERT INTO authorities (username, authority)
VALUES ('admin', 'admin');
