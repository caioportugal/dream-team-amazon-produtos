INSERT INTO subcategory (name) VALUES ('Smartphone');
INSERT INTO subcategory (name) VALUES ('Notebooks');
INSERT INTO subcategory (name) VALUES ('Tablets');
INSERT INTO subcategory (name) VALUES ('Sucos');
INSERT INTO subcategory (name) VALUES ('Alcoólica');
INSERT INTO subcategory (name) VALUES ('Peças');
INSERT INTO subcategory (name) VALUES ('Acessórios');

INSERT INTO category (name) VALUES ('Eletrodomésticos');
INSERT INTO category (name) VALUES ('Bebidas');
INSERT INTO category (name) VALUES ('Auto');

INSERT INTO product (name, value, views, category_id, subcategory_id) VALUES ('Moto G', 800, 0, 1, 1);
INSERT INTO product (name, value, views, category_id, subcategory_id) VALUES ('Ideapad', 3000, 0, 1, 2);
INSERT INTO product (name, value, views, category_id, subcategory_id) VALUES ('Tab S6', 2000, 0, 1, 3);
INSERT INTO product (name, value, views, category_id, subcategory_id) VALUES ('Del Valle Laranja', 0, 0, 2, 4);
INSERT INTO product (name, value, views, category_id, subcategory_id) VALUES ('Wisky Jack Daniels', 150, 0, 2, 5);
INSERT INTO product (name, value, views, category_id, subcategory_id) VALUES ('Abafador de escapamento', 400, 0, 3, 6);
INSERT INTO product (name, value, views, category_id, subcategory_id) VALUES ('Suporte para celular', 70, 0, 3, 7);

INSERT INTO keyword (description, product_id) VALUES ('Celular barato', 1);
INSERT INTO keyword (description, product_id) VALUES ('Em bom estado', 1);
INSERT INTO keyword (description, product_id) VALUES ('Notebook gamer', 2);
INSERT INTO keyword (description, product_id) VALUES ('SSD', 2);
INSERT INTO keyword (description, product_id) VALUES ('Placa de vídeo', 2);
INSERT INTO keyword (description, product_id) VALUES ('Bom para jogos', 2);
INSERT INTO keyword (description, product_id) VALUES ('Para estudar', 3);
INSERT INTO keyword (description, product_id) VALUES ('Tela grande', 3);
INSERT INTO keyword (description, product_id) VALUES ('Laranja', 4);
INSERT INTO keyword (description, product_id) VALUES ('Saudável', 4);
INSERT INTO keyword (description, product_id) VALUES ('Saboroso', 4);
INSERT INTO keyword (description, product_id) VALUES ('Uísque', 5);
INSERT INTO keyword (description, product_id) VALUES ('Bom e barato', 5);
INSERT INTO keyword (description, product_id) VALUES ('Escapamento', 6);
INSERT INTO keyword (description, product_id) VALUES ('Peça de carro', 6);
INSERT INTO keyword (description, product_id) VALUES ('Acessório para carros', 7);
INSERT INTO keyword (description, product_id) VALUES ('Suporte para celular', 7);


