CREATE TABLE carreras(
    name VARCHAR(40) NOT NULL PRIMARY KEY ,
    capacity INTEGER NOT NULL,
    capability VARCHAR(40) NOT NULL,
    difficulty FLOAT(1) NOT NULL
);
INSERT INTO carreras(
    name, capacity, capability, difficulty
) VALUES (
    'Zipatocan', 8473, 1, 8.9
);
INSERT INTO carreras(
    name, capacity, capability, difficulty
) VALUES (
    'Quirachiquin', 12332, 1, 7.3
    );
INSERT INTO carreras(
    name, capacity, capability, difficulty
) VALUES (
    'Vitaguata', 0, 0, 1.9
    );