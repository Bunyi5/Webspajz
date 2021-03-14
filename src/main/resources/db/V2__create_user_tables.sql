CREATE TABLE "user" (
    id INT PRIMARY KEY,
    username VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE user_ingredient (
    user_id INT,
    ingredient_id INT,
    quantity DOUBLE PRECISION,
    PRIMARY KEY (user_id, ingredient_id)
);