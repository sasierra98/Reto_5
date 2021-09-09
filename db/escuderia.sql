DROP SCHEMA IF EXISTS Reto5;
CREATE SCHEMA Reto5;
USE Reto5;
DROP TABLE IF EXISTS escuderia;
CREATE TABLE escuderia (
    codigo_escuderia INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    patrocinador VARCHAR(40) NOT NULL,
    carreras_ganadas INT NOT NULL,
    fecha_ingreso DATE NOT NULL
);