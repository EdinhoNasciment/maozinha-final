CREATE TABLE user (
    id bigint(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    password VARCHAR(255)NOT NULL,
    birth_date DATE NOT NULL,
    gender VARCHAR(255) NOT NULL,
    bank VARCHAR(255),
    account VARCHAR(255),
    digit VARCHAR(1),
    admin BOOLEAN,
    active BOOLEAN

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (name, email, password, birth_date, gender, bank, account, digit, admin, active) -- a senha é passwordroot
values('Edson Nascimento', 'edson.nascimento@aluno.ifsp.edu.br','$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji','2000-01-13','MASCULINO', 'BANCO_DO_BRASIL', '12345','1', 1, 1);

INSERT INTO user (name, email, password, birth_date, gender, bank, account, digit, admin, active)
values('Fernando Duarte', 'fernandoduarte@ifsp.edu.br','$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji','1975-01-01','MASCULINO', 'BRADESCO', '54321','2', 1, 1);

INSERT INTO user (name, email, password, birth_date, gender, bank, account, digit, admin, active)
values('Gerson Silva', 'gerson.silva@aluno.ifsp.edu.br','$2a$12$60KfH6yhIbDHaeNS7Uiswu8TGh4OC7UFoWsK4G4/a//eSLwS/s4K2','2003-01-22','MASCULINO', 'BANCO_DO_BRASIL', '65432','1', 0, 1);