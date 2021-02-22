CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;

CREATE TABLE recipe (
    id INT PRIMARY KEY,
    yum_id VARCHAR(250),
    name VARCHAR(250),
    description VARCHAR(1000),
    number_of_servings INT,
    icon_image_url VARCHAR(250),
    resizable_image_url VARCHAR(250),
    total_review_count DECIMAL,
    average_rating DOUBLE PRECISION,
    difficulty_level VARCHAR(250)
);

CREATE TABLE recipe_nutrition_list (
    recipe_id INT,
    nutrition_list VARCHAR(250)
);

CREATE TABLE recipe_technique_list (
    recipe_id INT,
    technique_list VARCHAR(250)
);

CREATE TABLE recipe_preparation_steps (
    recipe_id INT,
    preparation_steps VARCHAR(1000)
);

CREATE TABLE recipe_ingredient (
    id INT PRIMARY KEY,
    recipe_id INT,
    ingredient_id INT,
    quantity DOUBLE PRECISION,
    unit VARCHAR(250)
);

CREATE TABLE ingredient (
    id INT PRIMARY KEY,
    name VARCHAR(250),
    unit VARCHAR(250)
);