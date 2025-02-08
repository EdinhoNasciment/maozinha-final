CREATE TABLE permission (
	id BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_permission (
	id_user BIGINT(20) NOT NULL,
	id_permission BIGINT(20) NOT NULL,
	PRIMARY KEY (id_user, id_permission),
	FOREIGN KEY (id_user) REFERENCES user(id),
	FOREIGN KEY (id_permission) REFERENCES permission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- user
INSERT INTO permission (id, description) values (1, 'ROLE_REGISTER_USER');
INSERT INTO permission (id, description) values (2, 'ROLE_REMOVE_USER');
INSERT INTO permission (id, description) values (3, 'ROLE_SEARCH_USER');

-- activity
INSERT INTO permission (id, description) values (4, 'ROLE_REGISTER_MAOZINHA');
INSERT INTO permission (id, description) values (5, 'ROLE_REMOVE_MAOZINHA');
INSERT INTO permission (id, description) values (6, 'ROLE_SEARCH_MAOZINHA');
INSERT INTO permission (id, description) values (7, 'ROLE_DONATE_MAOZINHA');

-- admin
INSERT INTO user_permission (id_user, id_permission) values (1, 1);
INSERT INTO user_permission (id_user, id_permission) values (1, 2);
INSERT INTO user_permission (id_user, id_permission) values (1, 3);
INSERT INTO user_permission (id_user, id_permission) values (1, 4);
INSERT INTO user_permission (id_user, id_permission) values (1, 5);
INSERT INTO user_permission (id_user, id_permission) values (1, 6);
INSERT INTO user_permission (id_user, id_permission) values (1, 7);

-- Fernando
INSERT INTO user_permission (id_user, id_permission) values (2, 1);
INSERT INTO user_permission (id_user, id_permission) values (2, 3);
INSERT INTO user_permission (id_user, id_permission) values (2, 6);
INSERT INTO user_permission (id_user, id_permission) values (2, 7);

-- Gersil
INSERT INTO user_permission (id_user, id_permission) values (3, 1);
INSERT INTO user_permission (id_user, id_permission) values (3, 6);
INSERT INTO user_permission (id_user, id_permission) values (3, 7);