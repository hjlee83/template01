INSERT INTO TBL_ACCOUNT (id, pw, name) VALUES ('1', '1', '호진');
INSERT INTO TBL_ACCOUNT (id, pw, name) VALUES ('2', '1', '덩미');
INSERT INTO TBL_ACCOUNT (id, pw, name) VALUES ('3', '1', '호석');
INSERT INTO TBL_ACCOUNT (id, pw, name) VALUES ('4', '1', '승희');

INSERT INTO TBL_ROLE (name) values ('ADMIN');
INSERT INTO TBL_ROLE (name) values ('USER');
INSERT INTO TBL_ROLE (name) values ('ETC');

INSERT INTO TBL_ACCOUNT_ROLES (account_id, roles_name) values ('1', 'ADMIN');
INSERT INTO TBL_ACCOUNT_ROLES (account_id, roles_name) values ('1', 'USER');
INSERT INTO TBL_ACCOUNT_ROLES (account_id, roles_name) values ('1', 'ETC');
INSERT INTO TBL_ACCOUNT_ROLES (account_id, roles_name) values ('2', 'USER');
INSERT INTO TBL_ACCOUNT_ROLES (account_id, roles_name) values ('2', 'ETC');
INSERT INTO TBL_ACCOUNT_ROLES (account_id, roles_name) values ('3', 'ETC');
INSERT INTO TBL_ACCOUNT_ROLES (account_id, roles_name) values ('4', 'ETC');