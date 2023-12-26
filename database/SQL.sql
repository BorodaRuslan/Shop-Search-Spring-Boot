CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


// insertion of 3 categories
INSERT INTO category (name) VALUES ('Протеин'), ('Креатин'), ('Витамины');

// Adding products to protein category
INSERT INTO product (name, description, price, category_id)
VALUES
  ('Whey Gold Standard', 'Описание товара', 20.00, (SELECT id FROM category WHERE name = 'Протеин')),
  ('Pure IsoWhey-GymBeam', 'Описание товара', 22.50, (SELECT id FROM category WHERE name = 'Протеин')),
  ('Syntha 6 Edge-BSN', 'Описание товара', 25.00, (SELECT id FROM category WHERE name = 'Протеин'));

// Adding Products to the Creatine Category
INSERT INTO product(name, description, price, category_id)
VALUES
    ('Креатин Powder - Optimum Nutrition', 'Описание товара', 15.00, (SELECT id FROM category WHERE name = 'Креатин')),
    ('Storm-Universal Nutrition', 'Описание товара', 30.00, (SELECT id FROM category WHERE name = 'Креатин')),
    ('Creatine Powder Super-ActivLab', 'Описание товара', 8.00, (SELECT id FROM category WHERE name = 'Креатин'));

// Adding products to vitamin category
INSERT INTO product(name, description, price, category_id)
VALUES
    ('Opti-Men - Optimum Nutrition', 'Описание товара', 35.00, (SELECT id FROM category WHERE name = 'Витамины')),
    ('Animal Pak - Universal Nutrition', 'Описание товара', 40.00, (SELECT id FROM category WHERE name = 'Витамины')),
    ('Men‘s Essentials - GymBeam', 'Описание товара', 17.00, (SELECT id FROM category WHERE name = 'Витамины'));
