create table if not exists participates
(
    id      serial primary key,
    item_id int references items (id),
    user_id int references j_user (id)
);