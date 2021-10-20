create table products (
    id                              bigserial primary key,
    title                           varchar(255),
    price                           numeric (8, 2),
    category_id                     bigint references categories (id),
    created_at                      timestamp default current_timestamp,
    updated_at                      timestamp default current_timestamp
);

insert into products (title, price, category_id)
values
('Bread', 25.50, 1),
('Milk', 80.40, 1),
('Cheese', 325.00, 1),
('Cheese2', 325.00, 1),
('Cheese3', 325.00, 1),
('Cheese4', 325.00, 1),
('Cheese5', 325.00, 1),
('Cheese6', 325.00, 1),
('Cheese7', 325.00, 1),
('Cheese8', 325.00, 1),
('Cheese9', 325.00, 1),
('Cheese10', 325.00, 1),
('Cheese11', 325.00, 1),
('Cheese12', 325.00, 1);