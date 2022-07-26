create TABLE IF NOT EXISTS post
(
    id          SERIAL PRIMARY KEY,
    name        TEXT,
    description TEXT,
    created     TIMESTAMP,
    visible     BOOL,
    city_id     INT
);
CREATE TABLE IF NOT EXISTS candidate
(
    id          SERIAL PRIMARY KEY,
    name        TEXT,
    description TEXT,
    created     TIMESTAMP,
    photo       BYTEA
);

CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(50),
    email    VARCHAR(50) UNIQUE,
    password TEXT
);