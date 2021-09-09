DROP TABLE IF EXISTS piloto;
CREATE TABLE piloto (
    codigoPiloto        INT         NOT NULL PRIMARY KEY,
    nombre              varchar(30) NOT NULL,
    millasRecorridas    decimal(20, 2) default 0,
    combustibleUsado    int         NULL,
    codigo_escuderia_fk int         NULL,
    FOREIGN KEY (codigo_escuderia_fk) REFERENCES escuderia (codigo_escuderia)
)