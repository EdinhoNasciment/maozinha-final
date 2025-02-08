CREATE TABLE maozinha (
    id bigint(20) PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    descr TEXT,
    creation_date DATE,
    img_url VARCHAR(255),
    maozinha_url VARCHAR(255),
    min_value FLOAT(10),
    total_value FLOAT(10),
    up_to_date_value FLOAT(10),
    is_complete BOOLEAN,
    user_id bigint(20), -- Relacionamento com a tabela User

    FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;