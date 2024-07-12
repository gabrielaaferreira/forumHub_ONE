CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    autor VARCHAR(100) NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    mensagem TEXT NOT NULL,
    curso VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);
