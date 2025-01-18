CREATE TABLE if not exists audit_events (
    id uuid primary key,
    entity_name varchar(1000) not null,
    entity_id uuid not null,
    change_type varchar(50) not null,
    change_details text,
    timestamp timestamp default current_timestamp
);

CREATE TABLE if not exists notification_conditions (
    id uuid primary key,
    entity_name varchar(255) not null,
    email varchar(255) not null
);

