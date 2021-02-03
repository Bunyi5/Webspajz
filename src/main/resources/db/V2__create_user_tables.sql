CREATE TABLE user (
    id INT PRIMARY KEY,
    username VARCHAR(250) UNIQUE NOT NULL,
    password VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL
);

INSERT INTO user (id, username, password, email)
VALUES (200, 'sa', '$2y$04$.qL2la.XU.wtfbY.HvhupOU6BLlROml2qjPQz4P4O5QPI55ZF.Dni', 'sa@as.com')