CREATE TABLE respostas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensagem TEXT NOT NULL,
    autor VARCHAR(100) NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    topico_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (topico_id) REFERENCES topicos(id) ON DELETE CASCADE
);
