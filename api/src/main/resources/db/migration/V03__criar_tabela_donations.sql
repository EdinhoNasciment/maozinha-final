CREATE TABLE donations (
    id bigint(20) PRIMARY KEY,
    donationDate date NOT NULL,
    donationValue FLOAT(10),
    user_id bigint(36), -- Relacionamento com a tabela User
    maozinha_id bigint(20),

    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (maozinha_id) REFERENCES maozinha(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

	
